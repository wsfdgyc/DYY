package Dao;

import Control.GetDate;
import DaoInfo.FilmDaoInfo;
import Model.Film;
import Model.FilmComment;
import Model.FilmListing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class FilmDao implements FilmDaoInfo
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
    public List<FilmComment> getAllFilmComment()
    {
        return null;
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
    public void viewFilmList()
    {

    }
}
