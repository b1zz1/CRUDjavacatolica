package entities;

public class Client {

	private static String name;
	private static String birth;
	private static String address;
	private static int CPF;
	private static String profession;
	private static double monthlyIncome;
	
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
	
	public static String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public static String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static int getCPF() {
		return CPF;
	}
	
	public static void setCPF(int CPF) {
		Client.CPF = CPF;
	}
	
	public static String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public static double getMonthlyIncome() {
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

}
