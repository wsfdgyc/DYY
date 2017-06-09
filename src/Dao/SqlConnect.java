package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlConnect {
	    public static Connection Connect() {
	    	Connection con=null;
	      String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//SQL数据库引擎
	      String connectDB="jdbc:sqlserver://localhost:1433;DatabaseName=DYY";
		//数据源  ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
			//加载数据库引擎，返回给定字符串名的类
	      try {
			  //加载数据库引擎，返回给定字符串名的类
	          Class.forName(JDriver);
	      }catch(ClassNotFoundException e)
	      {
			  e.printStackTrace();
	         // System.out.println("加载数据库引擎失败");
	          System.exit(0);
	      }     
	   //   System.out.println("数据库驱动成功");
	      
	      try {
	          String user="sa";                                    
	          String password="wsfdgyc520";
	          con=DriverManager.getConnection(connectDB,user,password);

	   //       System.out.println("连接数据库成功");
	      }catch(SQLException e){
	       e.printStackTrace();
	       System.out.print(e.getErrorCode());
	      }
	      return con;
	}

}
