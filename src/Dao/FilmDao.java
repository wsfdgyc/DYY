package Dao;

import Control.FilmControl;
import Control.GetDate;
import DaoInf.FilmDaoInf;
import Model.Film;
import Model.FilmComment;
import Model.FilmListing;
import Model.Ticket;
import Tools.PrintList;
import Tools.tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class FilmDao implements FilmDaoInf
{
    @Override
    public List<Film> getAllFilms()
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
        String  dateNow = df.format(new Date());
        String sqlstr="select * from Film where ReleaseDate <="+dateNow+"and CloseDate >="+dateNow;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Film> films=new ArrayList<>();
        try
        {
            ps=SqlConnect.Connect().prepareStatement(sqlstr);
            rs=ps.executeQuery();
            while (rs.next())
            {
                 int filmID=rs.getInt("FilmID");
                 String filmName=rs.getString("FilmName");
                 String releaseDate=rs.getString("ReleaseDate");
                 String closeDate=rs.getString("CloseDate");
                 String star=rs.getString("Star");
                 String director=rs.getString("Director");
                 String content=rs.getString("Content");
                 String length=rs.getString("Length");
                Film film=new Film(filmID,filmName,releaseDate, closeDate, star, director, content, length);
                films.add(film);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SqlClose.Close(ps,rs);
        }
        return films;
    }

    @Override
    public  List<FilmComment> getAllFilmComment(int filmID)
    {
        String sqlstr = "select * from filmComment where FilmID = "+filmID;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<FilmComment> filmComments = new ArrayList<>();
        try
        {
            ps = SqlConnect.Connect().prepareStatement(sqlstr);
            rs=ps.executeQuery();
            while (rs.next())
            {
                int commentID = rs.getInt("commentID");
                int filmIDOut = rs.getInt("filmID");
                String filmName = rs.getString("filmName");
                String commentTime = rs.getString("commentTime");
                String userName = rs.getString("userName");
                int commentLev = rs.getInt("commentLev");
                String commentContent = rs.getString("commentContent");
                FilmComment filmComment = new FilmComment(commentID, filmIDOut, filmName, commentTime, userName, commentLev, commentContent);
                filmComments.add(filmComment);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SqlClose.Close(ps,rs);
        }
        return filmComments;
    }

    @Override
    public List<FilmListing> getAllFilmListing(int filmID)
    {
        String dateNow=GetDate.getDay(0);
        String dateEnd=GetDate.getDay(2);
        GetDate.getDay(2);
        String sqlstr="select *  from ViewFilmListing where Date between '"+dateNow+"' and '"+dateEnd+"'";
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<FilmListing> filmListings = new ArrayList<>();
        try
        {
            ps = SqlConnect.Connect().prepareStatement(sqlstr);
            rs=ps.executeQuery();
            while (rs.next())
            {
                 String filmName=rs.getString("FilmName");
                 int listingID=rs.getInt("ListingID");
                 int hallID=rs.getInt("HallID");
                 String date=rs.getString("Date");
                 int number=rs.getInt("Number");
                 String startTime=rs.getString("StratTime");
                 String endTime=rs.getString("EndTime");
                 double price=rs.getDouble("Price");
                 FilmListing filmListing = new FilmListing(filmName,listingID,hallID, date, number, filmID, startTime, endTime, price);
                filmListings.add(filmListing);
            }
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            SqlClose.Close(ps,rs);
        }
        return filmListings;
    }

    @Override
    public List<Ticket> getAllTicket()
    {
        String sqlstr = "select * from tickets";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Ticket> tickets = new ArrayList<>();
        try
        {
            ps = SqlConnect.Connect().prepareStatement(sqlstr);
            rs = ps.executeQuery();
            while (rs.next())
            {
                 int ticketID=rs.getInt("TicketID");
                 int listingID = rs.getInt("ListingID");
                int filmID = rs.getInt("FilmID");
                 String filmName=rs.getString("FilmName");
                 int hallID=rs.getInt("HallID");
                 String date=rs.getString("Date");
                 String startTime=rs.getString("StartTime");
                 String endTime=rs.getString("EndTime");
                 int rows=rs.getInt("Rows");
                 int columns=rs.getInt("Columns");
                 int rowID=rs.getInt("RowID");
                 int columnID=rs.getInt("ColumnID");
                 double price=rs.getDouble("Price");
                 int sellStatus=rs.getInt("SellStatus");
                String userName = rs.getString("UserName");
                 Ticket ticket = new Ticket(ticketID, listingID, filmID, filmName, hallID, date, startTime, endTime, rows, columns, rowID, columnID, price, sellStatus, userName);
                 tickets.add(ticket);
            }
        } 
        catch (SQLException e)
        {
            e.printStackTrace();   
        }
        finally
        {
            SqlClose.Close(ps,rs);
        }
        return tickets;
    }

    @Override
    public void viewFilmList(String  userName)
    {
 //       UserDao userDao = new UserDao();
        FilmControl filmControl = new FilmControl();
        filmControl.printFlimList("近期的电影列表如下:");
        int filmID = tools.getInt("查看电影详细信息（输入FilmID）:");
        filmControl.viewFilmComment(filmID);
        tools.returnMenu(userName);

    }

    @Override
    public void viewFilmComment(String userName)
    {
        FilmControl filmControl = new FilmControl();

        filmControl.printFlimList("近期的电影列表如下:");
        int filmID = tools.getInt("输入FilmID进入对应影评区:");
        //根据filmID获取filmName
        List<Film> films = getAllFilms();
        String filmName=null;
        for (Film film:films)
        {
            if (film.getfilmID() == filmID)
            {
                filmName = film.getfilmName();
            }
        }
        //打印该电影评论列表
        System.out.println(filmName+"的评论如下：");
        filmControl.viewFilmComment(filmID);
        PrintList printList = new PrintList();
        //做个评论区
        List<Ticket> tickets = getAllTicket();
        List<Ticket> userTickets = new ArrayList<>();

        //获取评论时间
        String timeNow = GetDate.getTime("yyyy-MM-dd HH:mm:ss");
        //获取用户评论列表
        List<FilmComment> filmComments = getAllFilmComment(filmID);
        List<FilmComment> userFilmComments = new ArrayList<>();
        String commentContent;
        int commentLev;
        int watchingCounts=0;
        for (int i = 0; i <tickets.size() ; i++)
        {
            if ( tickets.get(i).getUserName() != null)
            {


                if (tickets.get(i).getFilmID() == filmID && tickets.get(i).getUserName().equals(userName))
                {
                    watchingCounts++;
                    Ticket userTicket = tickets.get(i);
                    userTickets.add(userTicket);
                }
            }
        }
        //判断用户是否有购票记录
        if (watchingCounts > 0)
        {
            //如有购票记录，则打印用户购票记录
            System.out.println("您的影票信息如下：");
            printList.printTicket(userTickets);
            //获取用户评论列表
            for (int i = 0; i <filmComments.size() ; i++)
            {
                if (filmComments.get(i).getUserName().equals(userName))
                {
                    //展示用户评论
                    FilmComment filmComment = filmComments.get(i);
                    userFilmComments.add(filmComment);
                }
            }
            //判断用户评论是否为空，不为空则打印评论，空的话要求输入评论
            if (userFilmComments !=null)
            {
                System.out.println("您的评论信息如下:");
                printList.printUserComment(userFilmComments);
            }
            else
            {
                System.out.println("请您对该电影进行评论:");
                commentLev = tools.getInt("最高五星，请您选择本片星级:");
                commentContent = tools.getString("请输入您的评论内容:");
                String sqlstr = "insert into FilmComment (FilmID,FilmName,CommentTime,UserName,CommentLev,CommentContent) values ( '"
                                +filmID+"',"+filmName+"',"+timeNow+"',"+userName+"',"+commentLev+"',"+commentContent+"')";
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try
                {
                    preparedStatement = SqlConnect.Connect().prepareStatement(sqlstr);
                    preparedStatement.executeUpdate();
                }
                catch (SQLException e)
                {
                     e.printStackTrace();
                }
                finally
                {
                    SqlClose.Close(preparedStatement,resultSet);
                }
                System.out.println("感谢您的评论");

            }
        }
        else
        {
            System.out.println("您还未购买过影票哦！");
        }
        tools.returnMenu(userName);
    }

}
