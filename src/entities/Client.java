package entities;

public class Client {

	private static String name;
	private String address;
	private static int CPF;
	private String profession;
	private double monthlyIncome;
	
	//constructor for Client
	public Client(String name, String address, int CPF, String profession, double monthlyIncome) {
		this.name = name;
		this.address = address;
		this.CPF = CPF;
		this.profession = profession;
		this.monthlyIncome = monthlyIncome;
	}
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Client.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static int getCPF() {
		return CPF;
	}
	public void setCPF(int CPF) {
		this.CPF = CPF;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
}
