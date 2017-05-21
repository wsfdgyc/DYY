package Model;

public class User {
	private  String userName;
	private  String pwd;
	private  int status;
	private  int power;

	public User(String userName, String pwd, int status, int power) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.status = status;
		this.power = power;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "User [ userName=" + userName + ", pwd=" + pwd + ", status=" + status + ", power="
				+ power + "]";
	}
	
	
}
