package entities;

public class Account {

	private static String accountHolder;
	private static String password;
	private double moneyIn = 0;
	private double debt = 0;
	private int accountNumber;
	//1 - Conta corrente | 2 - Poupança | 3 - Conta salario
	private static int accountType;
	
	public Account(String accountHolder, String password) {
		this.accountHolder = accountHolder;
		this.password = password;
	}

	public static String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}
	
	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

}


