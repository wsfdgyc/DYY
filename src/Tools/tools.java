package Tools;

import Control.FilmControl;
import Dao.FilmDao;
import Model.Film;
import Model.FilmComment;

import java.util.ArrayList;
import java.util.Scanner;

public class tools extends FilmDao{
	static Scanner input=new Scanner(System.in);
	public static String getString(String str){
		System.out.println(str);
		return input.next();
	}
	public static double getDouble(String str){
		System.out.println(str);
		return input.nextDouble();
	}
	public static int getInt(String str){
		System.out.println(str);
		return input.nextInt();
	}
	public static void exit(){
		System.out.println("系统关闭！");
		System.exit(0);
	}

}
