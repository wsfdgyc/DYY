package Model;

public class Seat
{
    private int seatID;
    private int rowID;
    private int columnID;
    private int sellStatus;
    private int listingID;

    public int getSeatID()
    {
        return seatID;
    }

    public void setSeatID(int seatID)
    {
        this.seatID = seatID;
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

    public int getSellStatus()
    {
        return sellStatus;
    }

    public void setSellStatus(int sellStatus)
    {
        this.sellStatus = sellStatus;
    }

    public int getListingID()
    {
        return listingID;
    }

    public void setListingID(int listingID)
    {
        this.listingID = listingID;
    }

    @Override
    public String toString()
    {
        return "Seats{" +
                "seatID=" + seatID +
                ", rowID=" + rowID +
                ", columnID=" + columnID +
                ", sellStatus=" + sellStatus +
                ", listingID=" + listingID +
                '}';
    }

    public Seat(int seatID, int rowID, int columnID, int sellStatus, int listingID)
    {
        this.seatID = seatID;
        this.rowID = rowID;
        this.columnID = columnID;
        this.sellStatus = sellStatus;
        this.listingID = listingID;
    }
}
