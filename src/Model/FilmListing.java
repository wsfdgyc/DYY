package Model;

public class FilmListing
{
    private String filmName;
    private int listingID;
    private int hallID;
    private String date;
    private int number;
    private  int filmID;
    private  String startTime;
    private  String endTime;
    private  double price;


    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public int getListingID()
    {
        return listingID;
    }

    public void setListingID(int listingID)
    {
        this.listingID = listingID;
    }

    public int getHallID()
    {
        return hallID;
    }

    public void setHallID(int hallID)
    {
        this.hallID = hallID;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public int getFilmID()
    {
        return filmID;
    }

    public void setFilmID(int filmID)
    {
        this.filmID = filmID;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "场次信息:{" +
                "电影名称:'" + filmName + '\'' +
                ", 场次编号:" + listingID +
                ", 放映厅编号:" + hallID +
                ", 日期:'" + date + '\'' +
                ", 今日场次:" + number +
                ", 影片编号:" + filmID +
                ", 开始时间:'" + startTime + '\'' +
                ", 结束时间:'" + endTime + '\'' +
                ", 售价:" + price +
                '}';
    }

    public FilmListing(String filmName, int listingID, int hallID, String date, int number, int filmID, String startTime, String endTime, double price)
    {
        this.filmName = filmName;
        this.listingID = listingID;
        this.hallID = hallID;
        this.date = date;
        this.number = number;
        this.filmID = filmID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

}
