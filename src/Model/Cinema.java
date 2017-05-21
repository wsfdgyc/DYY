package Model;

public class Cinema
{
    private int video;
    private int rows;
    private int columns;
    private String openTime;
    private String closeTime;

    public Cinema(int video, int rows, int columns, String openTime, String closeTime)
    {
        super();
        this.video = video;
        this.rows = rows;
        this.columns = columns;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    @Override
    public String toString()
    {
        return "Cinema{" +
                "video=" + video +
                ", rows=" + rows +
                ", columns=" + columns +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                '}';
    }

    public int getVideo()
    {
        return video;
    }

    public void setVideo(int video)
    {
        this.video = video;
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

    public String getOpenTime()
    {
        return openTime;
    }

    public void setOpenTime(String openTime)
    {
        this.openTime = openTime;
    }

    public String getCloseTime()
    {
        return closeTime;
    }

    public void setCloseTime(String closeTime)
    {
        this.closeTime = closeTime;
    }
}
