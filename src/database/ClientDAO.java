package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Client;


public class ClientDAO {

	private Connection conn;
	
	public ClientDAO() {
		this.conn = DbConnection.getConnection();
	}
	//clientAdd() will create a new client when invoked
	public void clientAdd() {
		String SQLinput = "insert into client(client_name, client_birth, client_address, client_CPF, client_profession, client_monthlyIncome)"
				+ "values"
				+ "(?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			
			stmt.setString(1, Client.getName());
			stmt.setString(2, Client.getBirth());
			stmt.setString(3, Client.getAddress());
			stmt.setInt(4, Client.getCPF());
			stmt.setString(5, Client.getProfession());
			stmt.setDouble(6, Client.getMonthlyIncome());

			stmt.execute();
			
		    int rowsInserted = stmt.executeUpdate();
		    if(rowsInserted > 0) {
		    	System.out.println("New client succesfully registered!");
		    }
		stmt.close();
	}
	catch(SQLException e) {
		throw new RuntimeException(e);
		
		}
	}
}
