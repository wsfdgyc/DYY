package DaoInf;

import Model.Film;
import Model.FilmComment;
import Model.FilmListing;
import Model.Ticket;

import java.util.List;


public interface FilmDaoInf
{

    List<Film> getAllFilms();
    List<FilmComment> getAllFilmComment(int filmID);
    List<FilmListing> getAllFilmListing(int filmID);
    List<Ticket> getAllTicket();
    public  void viewFilmList(String userName);
    public void viewFilmComment(String userName);

}
