package Dao;

import Control.FilmControl;
import Control.GetDate;
import Control.UserControl;
import DaoInfo.FilmDaoInf;
import Model.Film;
import Model.FilmComment;
import Model.FilmListing;
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
        String sqlstr = "select * from filmComment";
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
//                int filmID = rs.getInt("filmID");
                String filmName = rs.getString("filmName");
                String commentTime = rs.getString("commentTime");
                String userName = rs.getString("userName");
                int commentLev = rs.getInt("commentLev");
                String commentContent = rs.getString("commentContent");
                FilmComment filmComment = new FilmComment(commentID, filmID, filmName, commentTime, userName, commentLev, commentContent);
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
        filmControl.viewFilmComment(filmID);
        //做个评论区
    }

}
