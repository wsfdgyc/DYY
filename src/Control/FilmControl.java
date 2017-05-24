package Control;

import Dao.FilmDao;
import Dao.SqlClose;
import Dao.SqlConnect;
import Dao.UserDao;
import Model.Film;
import Model.FilmListing;
import Tools.PrintList;
import Tools.tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmControl
{
    FilmDao fd = new FilmDao();
    public void printFlimList(String str)
    {
        System.out.println(str);
        for (Film tmp : fd.getAllFilms())
        {
            System.out.println(tmp);
            //
        }
    }

    public void buyFilmTicket(String userName)
    {
        printFlimList("当前上映的电影如下：");
        int filmID = tools.getInt("请选择您要购买的影票(输入filmID):");
        for (FilmListing tmp : fd.getAllFilmListing(filmID))
        {
            System.out.println(tmp.toString());


        }
        int listingID = tools.getInt("请选择您要购买的场次(输入ListingID):");
        //根据FilmListing表和Cinema表拼接，插入到tickets表，得到每个场次的座位信息，
        //rows表示该场次有多少排，columns表示该场次有多少列。
        //根据场次编号，按照i,j的顺序，循环打印座位售出状态sellstatus，1为已售出，0为未售出
        String sqlRowColumn="select distinct rows,columns,price from tickets where listingID = "+ listingID;
        int rows=0;
        int columns=0;
        double price=0;
        PreparedStatement psRowColumn=null;
        ResultSet rsRowColumn=null;
        try
        {

            psRowColumn=SqlConnect.Connect().prepareStatement(sqlRowColumn);
            rsRowColumn = psRowColumn.executeQuery();
            while (rsRowColumn.next())
            {
                rows = rsRowColumn.getInt("rows");
                columns = rsRowColumn.getInt("columns");
                price = rsRowColumn.getDouble("price");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SqlClose.Close(psRowColumn,rsRowColumn);
        }
        System.out.print("列编号： ");
        for (int i = 0; i <columns ; i++)
        {
            System.out.print(i+1+" ");
        }
        System.out.println();
        System.out.println("------------------------------------------");

        for (int i = 1; i < rows+1; i++) {
            System.out.print("第"+i+"行:  ");
            for (int j = 1; j < columns+1; j++) {
                String sqlSellStatus = "select  sellStatus from tickets where listingID = "+ listingID +" and rowid = "+i+" and columnid = "+j ;
                PreparedStatement ps=null;
                ResultSet rs = null;
                int sellStatus=0;
                try
                {
                    ps = SqlConnect.Connect().prepareStatement(sqlSellStatus);
                    rs = ps.executeQuery();
                    while (rs.next())
                    {
                        sellStatus = rs.getInt("sellStatus");
                    }
                    System.out.print(sellStatus+" ");
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    SqlClose.Close(ps,rs);
                }

            }
            System.out.println();
            System.out.println("------------------------------------------");

        }
        System.out.println("请输入您要购买的座位号：");
        int rowid = tools.getInt("行:");
        int columnid = tools.getInt("列:");
//        int num=0;
        UserDao ud = new UserDao();
        PreparedStatement psRowColumnID=null;
        ResultSet rsRowColumnID=null;
        String sqlRowColumnID="update tickets set sellstatus=1,UserName = '"+userName+"' where listingID = "+listingID+" and rowid = "+rowid+" and  columnid = "+columnid+" and sellstatus = 0";
        try
        {

            if (ud.WatchBal(userName)>=price)
            {
                psRowColumnID=SqlConnect.Connect().prepareStatement(sqlRowColumnID);
                ud.takeMoney(userName, -price);
                psRowColumnID.executeUpdate();
            }
            else
            {
                System.out.println("余额不足，请充值后再购票！");
            }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SqlClose.Close(psRowColumnID,rsRowColumnID);
        }

        MenuControl menuControl = new MenuControl();
        menuControl.returnMenu(userName);


    }
    public void viewFilmComment(int filmID)
    {
        //打印评论清单
        PrintList printList = new PrintList();
        printList.printFilmComment(filmID);
    }
}
