
package bank;

import java.util.Scanner;

import utils.Validation;

public class BankingMenu {
    
	Scanner scanner = new Scanner(System.in);
	
	public void showMenu1(Bank bank) {
		
		try {
			int option;
			System.out.println("Enter your choice : 1.New Account 2.Login 3.Exit");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {

			  case 1: 
				  newAccount(bank);
				  break;
			  case 2:
				  login(bank);
				  break;
			  case 3:
				  System.exit(0);
			}
		}
		catch(Exception exception) {
			System.out.println();
		}
	}
	
	public void newAccount(Bank bank) {
		
		try {
			NewAccount newAccount = new NewAccount();
			
			System.out.println("First name :");
			newAccount.setFirstName(scanner.nextLine());
			System.out.println("Last name :");
			newAccount.setLastName(scanner.nextLine());
			System.out.println("Email :");
			newAccount.setEmail(scanner.nextLine());
			System.out.println("Address :");
			newAccount.setAddress(scanner.nextLine());
			System.out.println("Password :");
			newAccount.setPassword(scanner.nextLine());
			System.out.println("Confirm Password :");
			newAccount.setConfirmPassword(scanner.nextLine());
			System.out.println("Mobile Number :");
			newAccount.setMobileNumber(scanner.nextLong());
			scanner.nextLine();
			
			bank.createAccount(newAccount);
			System.out.println("New account created!");
			showMenu1(bank);
		}
		catch(Exception exception) {
			
		}
		
	}
	
	public void login(Bank bank) {
		try {
			Login login = new Login();
			if(login.verifylogin(bank)) {
				System.out.println("Successful login");
				menu2();
			}
			else {
				System.out.println("Failed!");
			}
			
		}
		catch(Exception exception) {
			
		}	
	}
	
	public void menu2() {
		
		System.out.println("Menu2");
	}
}




























//package bank;
//
//import java.util.Scanner;
//
//import utils.Validation;
//
//public class BankingMenu {
//  
//	Scanner scanner = new Scanner(System.in);
//
//	public void drawOutline() {
//		try {
//			System.out.println("+");
//			for(int x = 0; x < 25; x++) {
//				System.out.print("=");
//			}
//			System.out.print("+");
//		} catch(Exception ex) {
//			System.out.println("ERROR : BankingMenu : drawOutline() : " + ex);
//		}
//	}
//
//	public void displayMessage(String message) {
//		try {
//			drawOutline();
//			System.out.println("| " + message.toUpperCase() + " |");
//			drawOutline();
//	} catch(Exception ex) {
//			System.out.println("ERROR : BankingMenu : displayMessage(String message) : " + ex);
//		}
//	}
//
//	
//	public void showMenu1(Bank bank) {
//		
//		try {
//			int option;
//			drawOutline();
//			System.out.println("| 1) New Account |");
//			System.out.println("| 2) Login |");
//			System.out.println("| 3) Exit |");
//			drawOutline();
//
//			System.out.print("Enter your choice : ");
//			option = scanner.nextInt();
//			scanner.nextLine();
//			
//			switch(option) {
//
//			  case 1: 
//				  newAccount(bank);
//				  break;
//			  case 2:
//				  login(bank);
//				  break;
//			  case 3:
//				  System.exit(0);
//			default:
//				displayMessage("ENTER VALID OPTION");
//				showMenu1(bank);
//			}
//		} catch(Exception exception) {
//			System.out.println();
//		}
//	}
//	
//	public void newAccount(Bank bank) {
//		
//		try {
//			NewAccount newAccount = new NewAccount();
//			
//			System.out.println("First name :");
//			newAccount.setFirstName(scanner.nextLine());
//			System.out.println("Last name :");
//			newAccount.setLastName(scanner.nextLine());
//			System.out.println("Email :");
//			newAccount.setEmail(scanner.nextLine());
//			System.out.println("Address :");
//			newAccount.setAddress(scanner.nextLine());
//			System.out.println("Password :");
//			newAccount.setPassword(scanner.nextLine());
//			System.out.println("Confirm Password :");
//			newAccount.setConfirmPassword(scanner.nextLine());
//			System.out.println("Mobile Number :");
//			newAccount.setMobileNumber(scanner.nextLong());
//			scanner.nextLine();
//			
//			bank.createAccount(newAccount);
//			System.out.println("New account created!");
//			showMenu1(bank);
//		}
//		catch(Exception exception) {
//			
//		}
//		
//	}
//	
//	public void login(Bank bank) {
//		try {
//			Login login = new Login();
//			if(login.verifylogin(bank)) {
//				System.out.println("Successful login");
//				menu2();
//			}
//			else {
//				System.out.println("Failed!");
//			}
//			
//		}
//		catch(Exception exception) {
//			
//		}	
//	}
//	
//	public void menu2() {
//		
//		System.out.println("Menu2");
//	}
//}


