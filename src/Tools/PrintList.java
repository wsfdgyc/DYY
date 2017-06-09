package Tools;

import Control.FilmControl;
import Dao.FilmDao;
import Model.Film;
import Model.FilmComment;
import Model.Ticket;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.ArrayList;
import java.util.List;

//打印功能
public class PrintList
{
    FilmDao filmDao = new FilmDao();
    public  void printFilmComment(int filmID)
    {

        for (FilmComment tmp : filmDao.getAllFilmComment(filmID))
        {
            System.out.println(tmp.toString());
        }
    }

    public void printTicket(List<Ticket> tickets)
    {
        for (Ticket tmp:tickets)
        {
            System.out.println(tmp.toString());
        }
    }
    public void printUserComment(List<FilmComment> filmComments)
    {
        for (FilmComment tmp:filmComments)
        {
            System.out.println(tmp.toString());
        }
    }
}
