package program;

import java.sql.Connection;
import java.util.Scanner;
import database.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = DbConnection.getConnection();
		
		Account testAcc = new Account(null, null);
		
		String nameInput, passwordInput;
		int typeInput;
		
		System.out.print("Account holder's name: ");
		nameInput = sc.nextLine();
		testAcc.setAccountHolder(nameInput);
		/*
		System.out.print("CPF: ");
		int CPFInput = 0;
		try {
			 CPFInput = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		Client.setCPF(CPFInput);
		*/
		System.out.print("Set your password: ");
		passwordInput = sc.nextLine();
		testAcc.setPassword(passwordInput);

		System.out.println("Set your account type\n"
				+ "1 - Checking Account\n"
				+ "2 - Money Market Account(MMA)\n"
				+ "Certificate of Deposit (CD)\n: ");
		typeInput = sc.nextInt();
		
		AccountDAO.accountAdd();
		
		DbConnection.closeConnection();
	}

}
