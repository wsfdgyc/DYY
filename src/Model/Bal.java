package Model;

public class Bal {
	private String userName;
	private double bal;
	public Bal(String userName, double bal) {
		super();
		this.userName = userName;
		this.bal = bal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Bal [userName=" + userName + ", bal=" + bal + "]";
	}
}
