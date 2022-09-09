package program;

import java.sql.Connection;
import java.util.Scanner;
import database.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = DbConnection.getConnection();

		DbConnection.closeConnection();
	}

}
