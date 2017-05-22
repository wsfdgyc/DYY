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
        //根据场次编号，按照i,j的顺序，循环打印座位售出状态sellstatus，1为已售出，0为未售出，
        int rows=10;
        int columns=9;
        int SellStatus=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

            }
            System.out.println();

        }


    }
}
