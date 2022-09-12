package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountVIEW {

	private Connection conn;
	private static int viewNumber;

	public static int getViewNumber() {
		return viewNumber;
	}
	public static void setViewNumber(int viewNumber) {
		AccountVIEW.viewNumber = viewNumber;
	}
	
	public AccountVIEW(){
		this.conn = DbConnection.getConnection();
	}
	
	public static void accountVIEW() {
	
	String SQLinput;
	
		if(viewNumber > 1) {
			SQLinput = "SELECT * FROM account WHERE account_number = ?";
		}else {
			SQLinput = "SELECT * FROM account";
		}
		try {
		PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
		ResultSet rs = null;
		
		stmt.setInt(1, viewNumber);
		
		rs = stmt.executeQuery();
		while(rs.next()) {
			String accountHolder = rs.getString("account_holder");
			int accountNumber = rs.getInt("account_number");
			
			System.out.println("Name: "+accountHolder+"\n");
			System.out.println("Account Number: "+accountNumber+"\n");
		}
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}

}
