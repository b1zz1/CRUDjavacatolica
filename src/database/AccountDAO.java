package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import entities.Account;

public class AccountDAO {

	private Connection conn;
	static Scanner sc = new Scanner(System.in);
	private static int accountSelect;
		
	public static int getAccountSelect() {
		return accountSelect;
	}
	public static void setAccountSelect(int accountSelect) {
		AccountDAO.accountSelect = accountSelect;
	}
	
	public AccountDAO() {
		this.conn = DbConnection.getConnection();
	}
	//accountAdd() will create a new account when invoked
	public static void accountADD() {
		String SQLinput = "insert into account(account_holder, account_password, account_type)"
				+ "values"
				+ "(?, ?, ?);";
		try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			
			stmt.setString(1, Account.getAccountHolder());
			stmt.setString(2, Account.getPassword());
			stmt.setString(3, Account.getAccountType());
			
		    int rowsInserted = stmt.executeUpdate();
		    if(rowsInserted > 0) {
		    	System.out.println("Account succesfully Created!");
		    }
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}
	
	public static void balanceADD() {

		String SQLinput = "UPDATE account SET account_moneyIn = ? WHERE account_number = ?";
		
		try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			
			stmt.setDouble(1, Account.getMoneyIn());
			stmt.setInt(2, accountSelect);
			
		    int rowsInserted = stmt.executeUpdate();
		    if(rowsInserted > 0) {
		    	System.out.println("Money inserted into account!");
		    }
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);	
		}	
	}
}
