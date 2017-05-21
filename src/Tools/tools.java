package Tools;

import java.util.Scanner;

public class tools {
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
