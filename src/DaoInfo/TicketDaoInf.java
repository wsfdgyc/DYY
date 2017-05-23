package DaoInfo;

import Model.Ticket;

import java.util.List;

public interface TicketDaoInf
{
    List<Ticket> getAllTickets(int filmID,int listingID);
}
