package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.UserControl;
import DaoInfo.UserDaoInfo;
import Model.Bal;
import Model.User;

public class UserDao implements UserDaoInfo{
	
	@Override
	public int regist(String UserName, String Pwd) {
		// TODO Auto-generated method stub
		String sqlstr="insert into UserInfo(UserName,Pwd,Status,Power) values(?,?,?,?)";
		PreparedStatement ps=null;
		ResultSet rs=null;
		int status=1;
		int power=0;
		int num=0;
		try {
			ps=SqlConnect.Connect().prepareStatement(sqlstr);
			ps.setString(1, UserName);
			ps.setString(2, Pwd);
			ps.setInt(3, status);
			ps.setInt(4, power);
			num=ps.executeUpdate();			
		}
		catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			SqlClose.Close(ps, rs);
		}
		return num;
	}

	@Override
	
	public boolean login(String UserName, String Pwd) {
		
		if(UserControl.judgeLogin(UserName, Pwd)==1){
			return true;
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SaveMoney(String UserName,Double Money) {
		// TODO Auto-generated method stub	
		String sqlstr="update UserBal set Bal=Bal+"+Money+"where UserName="+UserName;
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserDao ud=new UserDao();
		int num=0;
		try{
			ps=SqlConnect.Connect().prepareStatement(sqlstr);
			num=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			SqlClose.Close(ps, rs);
			
		}
		if(num==1)
		{
			System.out.println("充值成功，您当前账户的余额为："+ud.WatchBal(UserName));
			return true;
		}
		else
		{
			System.out.println("充值失败！");
			return false;
		}

	}

	@Override
	public double WatchBal(String UserName) {
		// TODO Auto-generated method stub
		String sqlstr="select Bal from UserBal where UserName="+UserName;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Bal> bals=new ArrayList<>();
		double userbal=0;
		try{
			ps=SqlConnect.Connect().prepareStatement(sqlstr);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String username=rs.getString("UserName");
				int ubal=rs.getInt("Bal");
				Bal bal=new Bal(username,ubal);
				bals.add(bal);
			}
			userbal=bals.get(0).getBal();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			SqlClose.Close(ps, rs);
		}
		return userbal;
	}

	@Override
	public  List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sqlstr="select * from userinfo";
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> users=new ArrayList<>();
		try{
			ps=SqlConnect.Connect().prepareStatement(sqlstr);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				String username=rs.getString("UserName");
				String pwd=rs.getString("Pwd");
				int status=rs.getInt("Status");
				int power=rs.getInt("Power");
				User user=new User(username,pwd,status,power);
				users.add(user);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			
			SqlClose.Close(ps, rs);
			
		}
		return users;
	}

}
