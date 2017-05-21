package Control;

import Dao.FilmDao;
import Model.Film;
import Model.FilmListing;
import Tools.tools;

public class FilmControl
{
    FilmDao fd = new FilmDao();
    public void printFlimList(String str)
    {
        System.out.println(str);
        for (Film tmp : fd.getAllFilms())
        {
            System.out.println(tmp);
        }
    }

    public void buyFilmTicket()
    {
        printFlimList("当前上映的电影如下：");
        int j = tools.getInt("请选择您要购买的影票(输入filmID):");
        for (FilmListing tmp : fd.getAllFilmListing(j))
        {
            System.out.println(tmp.toString());


        }


    }
}
