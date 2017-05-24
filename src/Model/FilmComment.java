package Model;

public class FilmComment
{
    public FilmComment(int commentID, int filmID, String filmName, String commentTime, String userName, int commentLev, String commentContent)
    {
        this.commentID = commentID;
        this.filmID = filmID;
        this.filmName = filmName;
        this.commentTime = commentTime;
        this.userName = userName;
        this.commentLev = commentLev;
        this.commentContent = commentContent;
    }

    private int commentID;
    private int filmID;
    private String filmName;
    private String commentTime;
    private String userName;
    private int commentLev;
    private String commentContent;

    @Override
    public String toString()
    {
        return "FilmComment{" +
                "commentID=" + commentID +
                ", filmID=" + filmID +
                ", filmName='" + filmName + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", userName='" + userName + '\'' +
                ", commentLev=" + commentLev +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }

    public int getCommentID()
    {
        return commentID;
    }

    public void setCommentID(int commentID)
    {
        this.commentID = commentID;
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

    public String getCommentTime()
    {
        return commentTime;
    }

    public void setCommentTime(String commentTime)
    {
        this.commentTime = commentTime;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getCommentLev()
    {
        return commentLev;
    }

    public void setCommentLev(int commentLev)
    {
        this.commentLev = commentLev;
    }

    public String getCommentContent()
    {
        return commentContent;
    }

    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent;
    }
}
