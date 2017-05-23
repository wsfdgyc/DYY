package Control;

import Dao.FilmDao;
import Dao.SqlClose;
import Dao.SqlConnect;
import Model.Film;
import Model.FilmListing;
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

    public void buyFilmTicket()
    {
        printFlimList("当前上映的电影如下：");
        int judge1 = tools.getInt("请选择您要购买的影票(输入filmID):");
        for (FilmListing tmp : fd.getAllFilmListing(judge1))
        {
            System.out.println(tmp.toString());


        }
        int judge2 = tools.getInt("请选择您要购买的场次(输入ListingID):");
        //根据FilmListing表和Cinema表做视图，得到每次场次的行列信息，
        //rows表示该场次有多少排，columns表示该场次有多少列。
        //根据场次编号，按照i,j的顺序，循环打印座位售出状态sellstatus，1为已售出，0为未售出
        String sqlRowColumn="select distinct rows,columns from tickets where listingID = "+judge2 ;
        int rows=0;
        int columns=0;
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
        for (int i = 1; i < rows+1; i++) {
            System.out.print("第"+i+"行");
            for (int j = 1; j < columns+1; j++) {
                String sqlSellStatus = "select  sellStatus from tickets where listingID = "+judge2+" and rowid = "+i+" and columnid = "+j ;
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


    }
}
