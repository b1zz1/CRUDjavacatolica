package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDELETE {
	
		private Connection conn;
		private static int numberDel;
		
		public static int getNumberDel() {
			return numberDel;
		}

		public static void setNumberDel(int numberDel) {
			AccountDELETE.numberDel = numberDel;
		}
		//this function will delete the choosen account when invoked
		public AccountDELETE(){
			this.conn = DbConnection.getConnection();
		}
		
		public static void accountDEL() {
			String SQLinput = "DELETE FROM account WHERE account_number = ?";
			
			try {
				PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
				
				stmt.setInt(1, numberDel);
				
			    int rowsAltered = stmt.executeUpdate();
			    if(rowsAltered > 0) {
			    	System.out.println("Account succesfully removed!");
			    }
			stmt.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);	
		}
	}
}



