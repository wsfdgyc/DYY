package Dao;

import DaoInfo.TicketDaoInf;
import Model.Ticket;

import java.util.List;

public class TicketDao implements TicketDaoInf
{
    @Override
    public List<Ticket> getAllTickets(int filmID, int listingID)
    {
        //数据库端根据listingID生成座位表视图
        String sqlstr = "select * from tickets where filmID = "+filmID+" and listingID = "+listingID ;
        return null;
    }
}
