package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlClose {
	public static void Close(PreparedStatement ps,ResultSet rs){
		try{
			if(ps !=null){
				ps.close();
			}
			if(rs !=null){
				rs.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
