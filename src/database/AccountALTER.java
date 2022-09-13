package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Account;

public class AccountALTER {

	private Connection conn;
	private static int altNum;
	
	public int getAltNum() {
		return altNum;
	}
	public static void setAltNum(int altNum) {
		AccountALTER.altNum = altNum;
	}
	
	public AccountALTER() {
		this.conn = DbConnection.getConnection();
	}
	public static void accountEdit() {
		String SQLinput = "UPDATE account SET account_holder= ?, account_password= ?, account_type= ? WHERE account_number = ?";
		try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			
			stmt.setString(1, Account.getAccountHolder());
			stmt.setString(2, Account.getPassword());
			stmt.setString(3, Account.getAccountType());
			stmt.setInt(4, altNum);
		    int rowsAltered = stmt.executeUpdate();
		    if(rowsAltered > 0) {
		    	System.out.println("Account succesfully altered!");
		    }
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}
}

