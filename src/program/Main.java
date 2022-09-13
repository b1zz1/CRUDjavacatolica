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

		int menuInput, viewInput, typeInput, numberDel, altNum; 
		
		
		System.out.print("=What do you want to do?=\n"
				+ "|| 1 - Sign in        ||\n"
				+ "|| 2 - Register       ||\n"
				+ "|| 3 - View data      ||\n"
				+ "|| 4 - Delete account ||\n"
				+ "|| 5 - Edit account   ||\n"
				+ "Input: ");
		menuInput = sc.nextInt();
		sc.nextLine();
		
		switch(menuInput) {
			case 1:

				break;
			case 2:
				System.out.println("Account holder's name: ");
				nameInput = sc.nextLine();
				account.setAccountHolder(nameInput);
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
				AccountDAO.accountADD();
				break;
			case 3:
				System.out.println("Choose an account by inserting its account number: ");
				viewInput = sc.nextInt();
				AccountSELECT.setViewNumber(viewInput);
				
				AccountSELECT.accountSELECT();
				break;
			case 4:
				System.out.println("Please insert the account number for deletion: ");
				numberDel = sc.nextInt();
				AccountDELETE.setNumberDel(numberDel);
				
				AccountDELETE.accountDEL();
				break;
			case 5:
				System.out.println("Insert the account number for alteration: ");
				altNum = sc.nextInt();
				AccountALTER.setAltNum(altNum);
				sc.nextLine();
				System.out.println("Account holder's name: ");
				nameInput = sc.nextLine();
				account.setAccountHolder(nameInput);
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
				AccountALTER.accountEdit();
				break;
			default:
				System.out.println("Please insert a value between 1 and 5");
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
