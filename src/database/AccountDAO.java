package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Account;

public class AccountDAO {

	private Connection conn;
	
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
		    	System.out.println("New account succesfully created!");
		    }
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}
}
