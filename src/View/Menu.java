package View;

import Control.FilmControl;
import Dao.UserDao;
import Tools.tools;

public class Menu {

	public  void userMenu(String userName)
	{
		FilmControl filmControl=new FilmControl();
		System.out.println("尊敬的会员--"+ userName +"请选择您要使用的功能：");
		System.out.println("1.查看余额");
		System.out.println("2.充值金额");
		System.out.println("3.浏览影片信息");
		System.out.println("4.购买影票");
		System.out.println("5.影评区");
		System.out.println("6.更多精彩，敬请期待！");
		UserDao ud=new UserDao();
		int j=tools.getInt("请输入编号：");
		switch(j)
		{
			case 1:
				System.out.println("您当前账户的余额为："+ud.WatchBal(userName)+"。");
				break;
			case 2:
				ud.SaveMoney(userName, tools.getDouble("请输入您要充值的金额："));
				break;
			case 3:

				break;
			case 4:
				filmControl.buyFilmTicket(userName);
				break;
			default:
				break;
		}
	}
	public static void adminMenu()
	{

	}
}
