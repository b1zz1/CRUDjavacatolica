package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountSELECT {

	private Connection conn;
	private static int viewNumber;

	public static int getViewNumber() {
		return viewNumber;
	}
	public static void setViewNumber(int viewNumber) {
		AccountSELECT.viewNumber = viewNumber;
	}
	
	public AccountSELECT(){
		this.conn = DbConnection.getConnection();
	}
	//this function will print the choosen account when invoked
	public static void accountSELECT() {
	
		String SQLinput = "SELECT * FROM account WHERE account_number = ?";
		
		try {
		PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
		ResultSet rs = null;
		
		stmt.setInt(1, viewNumber);
		
		rs = stmt.executeQuery();
		while(rs.next()) {
			String accountHolder = rs.getString("account_holder");
			int accountNumber = rs.getInt("account_number");
			String accountType = rs.getString("account_type");
			
			System.out.println("Name: "+accountHolder+"\n");
			System.out.println("Account Number: "+accountNumber+"\n");
			System.out.println("Account Type: "+accountType+"\n");
		}
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}

		public static void balanceVIEW() {
			
			String SQLinput = "SELECT account_moneyIn FROM account WHERE account_number = ?";
			
			try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			ResultSet rs = null;
			
			stmt.setInt(1, viewNumber);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				double moneyIn = rs.getDouble("account_moneyIn");

				System.out.println("Balance:" +moneyIn+"\n");
			}
			stmt.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
			
			}
		}
}
