package Control;

import java.util.List;

import Dao.UserDao;
import Model.User;

public class UserControl {
	static List<User> users;
	public static int judgeLogin(String username,String pwd)
	{
		int index=0;
		
		users=new UserDao().getAllUser();
		for (int i = 0; i < users.size(); i++) {
			if(users!=null)
			{
				if(users.get(i).getUserName().equals(username))
				{
					if(users.get(i).getPwd().equals(pwd))
					{
						if(users.get(i).getStatus()==1)
						{
							index=1;
						}
					}
				}
			}
			
		}
		return index;
	}

}
