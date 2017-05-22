package Dao;

import DaoInfo.SeatDaoInf;
import Model.Seat;

import java.util.List;

public class SeatDao implements SeatDaoInf {
    @Override
    public List<Seat> getAllSeats() {
        //数据库端根据listingID生成座位表视图
        String sqlstr = "select * from Seats";

        return null;
    }
}
