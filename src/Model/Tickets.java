package Model;

public class Tickets
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

    public int getSeatID()
    {
        return seatID;
    }

    public void setSeatID(int seatID)
    {
        this.seatID = seatID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Tickets(int ticketID, int listingID, int seatID, String userName)
    {
        this.ticketID = ticketID;
        this.listingID = listingID;
        this.seatID = seatID;
        this.userName = userName;
    }

    @Override
    public String toString()
    {
        return "Tickets{" +
                "ticketID=" + ticketID +
                ", listingID=" + listingID +
                ", seatID=" + seatID +
                ", userName='" + userName + '\'' +
                '}';
    }

    private int ticketID;
    private int listingID;
    private  int seatID;
    private  String userName;
}
