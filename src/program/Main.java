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

		int menuInput, viewInput, typeInput, numberDel, altNum, x = 0; 
		
	while(x == 0) {	
		System.out.print("===== What do you want to do? =====\n"
				+ " ||                              ||\n"
				+ " || 1 - Sign in[NOT IMPLEMENTED] ||\n"
				+ " || 2 - Register                 ||\n"
				+ " || 3 - View data                ||\n"
				+ " || 4 - Delete account           ||\n"
				+ " || 5 - Edit account             ||\n"
				+ " || 6 - Add balance              ||\n"
				+ " || 7 - Transfer[NOT IMPLEMENTED]||\n"
				+ " || 8 - View balance             ||\n"
				+ " || 9 - Exit program             ||\n"
				+ " =================================\n"
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
			case 6:
				System.out.println("Please insert the account number to receive the money: ");
				altNum = sc.nextInt();
				AccountDAO.setAccountSelect(altNum);
				System.out.println("How much do you want to add?: ");
				double balanceAdd = sc.nextDouble();
				account.setMoneyIn(balanceAdd);
				AccountDAO.balanceADD();
				break;
			case 7:
				
				break;
			case 8:
				System.out.println("Insert the account number for balance check: ");
				int numberCheck = sc.nextInt();
				AccountSELECT.setViewNumber(numberCheck);
				
				AccountSELECT.balanceVIEW();
				break;
			case 9:
				x = 1;
				break;
			default:
				System.out.println("Please insert a value between 1 and 5\n");
			}
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
		System.out.println("System off. Goodbye!");
		DbConnection.closeConnection();
		sc.close();
	}
	
}
