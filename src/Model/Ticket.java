package Model;

public class Ticket
{

    public int getTicketID()
    {
        return ticketID;
    }

    public void setTicketID(int ticketID)
    {
        this.ticketID = ticketID;
    }

    public int getListingID()
    {
        return listingID;
    }

    public void setListingID(int listingID)
    {
        this.listingID = listingID;
    }

    public int getFilmID()
    {
        return filmID;
    }

    public void setFilmID(int filmID)
    {
        this.filmID = filmID;
    }

    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
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

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public int getRowID()
    {
        return rowID;
    }

    public void setRowID(int rowID)
    {
        this.rowID = rowID;
    }

    public int getColumnID()
    {
        return columnID;
    }

    public void setColumnID(int columnID)
    {
        this.columnID = columnID;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getSellStatus()
    {
        return sellStatus;
    }

    public void setSellStatus(int sellStatus)
    {
        this.sellStatus = sellStatus;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Ticket(int ticketID, int listingID, int filmID, String filmName, int hallID, String date, String startTime, String endTime, int rows, int columns, int rowID, int columnID, double price, int sellStatus, String userName)
    {
        this.ticketID = ticketID;
        this.listingID = listingID;
        this.filmID = filmID;
        this.filmName = filmName;
        this.hallID = hallID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rows = rows;
        this.columns = columns;
        this.rowID = rowID;
        this.columnID = columnID;
        this.price = price;
        this.sellStatus = sellStatus;
        this.userName = userName;
    }

    private int ticketID;
    private int listingID;
    private int filmID;
    private String filmName;
    private int hallID;
    private String date;
    private String startTime;
    private String endTime;
    private int rows;
    private int columns;
    private int rowID;
    private int columnID;
    private double price;
    private int sellStatus;
    private String userName;

    @Override
    public String toString()
    {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", listingID=" + listingID +
                ", filmID=" + filmID +
                ", filmName='" + filmName + '\'' +
                ", hallID=" + hallID +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rows=" + rows +
                ", columns=" + columns +
                ", rowID=" + rowID +
                ", columnID=" + columnID +
                ", price=" + price +
                ", sellStatus=" + sellStatus +
                ", userName='" + userName + '\'' +
                '}';
    }
}
