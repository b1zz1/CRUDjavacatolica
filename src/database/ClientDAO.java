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
	//clientAdd will insert a new client when invoked
	public void clientAdd() {
		String SQLinput = "insert into Client(client_name, client_CPF)"
				+ "values"
				+ "(?, ?);";
		
		try {
			PreparedStatement stmt = DbConnection.getConnection().prepareStatement(SQLinput);
			
			stmt.setString(1, Client.getName());
			stmt.setInt(2, Client.getCPF());

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
