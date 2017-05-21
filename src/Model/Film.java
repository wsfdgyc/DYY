package Model;

public class Film
{
    private int filmID;
    private String filmName;
    private String releaseDate;
    private String closeDate;
    private String star;
    private String director;
    private String content;
    private String length;

    public Film(int filmID, String filmName, String releaseDate, String closeDate, String star, String director, String content, String length)
    {
    //    super();
        this.filmID = filmID;
        this.filmName = filmName;
        this.releaseDate = releaseDate;
        this.closeDate = closeDate;
        this.star = star;
        this.director = director;
        this.content = content;
        this.length = length;
    }

    @Override
    public String toString()
    {
        return "Film{" +
                "filmID=" + filmID +
                ", filmName='" + filmName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", star='" + star + '\'' +
                ", director='" + director + '\'' +
                ", content='" + content + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    public int getfilmID()
    {
        return filmID;
    }

    public void setfilmID(int filmID)
    {
        this.filmID = filmID;
    }

    public String getfilmName()
    {
        return filmName;
    }

    public void setfilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getCloseDate()
    {
        return closeDate;
    }

    public void setCloseDate(String closeDate)
    {
        this.closeDate = closeDate;
    }

    public String getStar()
    {
        return star;
    }

    public void setStar(String star)
    {
        this.star = star;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getLength()
    {
        return length;
    }

    public void setLength(String length)
    {
        this.length = length;
    }
}
