package View;

import Control.MD5;
import Control.UserControl;
import Dao.UserDao;
import Tools.tools;
public class Login {
	public static void main(){
		System.out.println("欢迎来到Adog影城！请选择您需要的操作：");
		System.out.println("1.会员注册");
		System.out.println("2.会员登陆");
		int j=tools.getInt(null);
		switch(j)
		{
		case 1:Login.reg();
			break;
		case 2:Login.start();
			break;
		default:
			break;
		}
	}
	public static void start(){
		String username=tools.getString("请输入用户名：");
		String pwd=MD5.getMD5(tools.getString("请输入密码："));
		int judgeLogin=UserControl.judgeLogin(username, pwd);
		if(judgeLogin==1)
		{
			System.out.println("登陆成功！");
			Menu menu=new Menu();
			menu.userMenu(username);
		}
		else
		{
			System.out.println("用户名或密码错误！");
		}
	}
	public static void reg()
	{
		System.out.println("欢迎新会员注册！");
		String username=tools.getString("请输入用户名：");
		String pwd=MD5.getMD5(tools.getString("请输入密码："));
		String pwd2=MD5.getMD5(tools.getString("请再次输入密码："));
		UserDao ud=new UserDao();
		try
		{
		if(pwd.equals(pwd2))
		{
			if(ud.regist(username, pwd)==1)
			{
				System.out.println("注册成功！");
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
