package program;

import java.sql.Connection;
import java.util.Scanner;
import database.*;
import entities.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = DbConnection.getConnection();
		
		Account account = new Account(null, null);
		
		String nameInput, passwordInput;

		int menuInput, viewInput, typeInput; 
		
		
		System.out.print("====== What do you want to do? ======"
				+ "|| 1 - Sign in        ||\n"
				+ "|| 2 - Register       ||\n"
				+ "|| 3 - View data      || \n"
				+ "|| 4 - Delete account || \n "
				+ "Input: ");
		menuInput = sc.nextInt();
		
		switch(menuInput) {
			case 1:

				break;
			case 2:
				System.out.println("Account holder's name: ");
				nameInput = sc.nextLine();
				account.setAccountHolder(nameInput);
				sc.nextLine();
				System.out.println("Set your password: ");
				passwordInput = sc.nextLine();
				account.setPassword(passwordInput);
				
				System.out.println("Set your account type\n"
						+ "1 - Checking Account\n"
						+ "2 - Money Market Account(MMA)\n"
						+ "3 - Certificate of Deposit (CD)\n: ");
		        typeInput = sc.nextInt();
		   
				switch(typeInput) {
					case 1:
						account.setAccountType("Checking Account");
						break;
					case 2:
						account.setAccountType("MMA");
						break;
					case 3:
						account.setAccountType("CD");
						break;
				}
				AccountDAO.accountAdd();
				break;
			case 3:
				System.out.println("Choose an account by inserting its account number, leave blank to see all accounts : ");
				viewInput = sc.nextInt();
				AccountVIEW.setViewNumber(viewInput);
				
				AccountVIEW.accountVIEW();
				break;
			case 4:
				
				break;
		}
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
		DbConnection.closeConnection();
		sc.close();
	}
	
}
