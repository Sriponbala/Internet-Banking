package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import utils.Validation;

public class BankingMenu {
    
	int outlineWidth = 39;
	Scanner scanner = new Scanner(System.in);

	public void drawOutline() {
		try {
			System.out.print("+");
			for(int x = 0; x < outlineWidth; x++) {
				System.out.print("=");
			}
			System.out.println("+");
		} catch(Exception exception) {
			System.out.println("ERROR : BankingMenu : drawOutline() : " + exception);
		}
	}

	public void displayHeader(Bank bank) {
		try {
			drawOutline();
			String bankName = bank.getBankName();
			System.out.print("|");

			String displayText = "";
			for(int x = 0; x < 10; x++) {
				displayText += " ";
			}
			displayText += bankName;    
            int length = displayText.length();
            
			for(int x = 0; x < 39-length; x++) {
				displayText += " ";
			}
			System.out.print(displayText);
			System.out.println("|");
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : displayHeader(Bank bank) : " + exception);
		}
	}

	public void displayMessage(String message) {
		try {
			drawOutline();
			System.out.print("|");

			String displayText = "";
			for(int x = 0; x < 10; x++) {
				displayText += " ";
			}
			displayText += message;    
            int length = displayText.length();
            
			for(int x = 0; x < 39-length; x++) {
				displayText += " ";
			}
			System.out.print(displayText);
			System.out.println("|");
		    drawOutline();
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu :  " + exception);
		}
	}
	
	public void showMenu1(Bank bank) {
		
		try {
			int option;
			drawOutline();
			System.out.println("| 1. New Account                        |");
			System.out.println("| 2. Login                              |");
			System.out.println("| 3. Exit                               |");
			drawOutline();
			System.out.print("Enter your choice : ");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {

			  case 1: 
				  newAccount(bank, bank.getValidation());
				  break;
			  case 2:
				  login(bank);
				  break;
			  case 3:
				  System.out.println();
				  displayMessage("THANK YOU!");
			}
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : showMenu1(Bank bank) : " + exception);
		}
	}
	
	public void newAccount(Bank bank, Validation validation) {
		
		try {
			displayMessage("NEW ACCOUNT");
			NewAccount newAccount = new NewAccount();
			
			System.out.print("First Name : ");
			newAccount.setFirstName(scanner.nextLine());
			System.out.print("Last Name : ");
			newAccount.setLastName(scanner.nextLine());
			System.out.print("Email : ");
			newAccount.setEmail(scanner.nextLine());
			System.out.print("Address : ");
			newAccount.setAddress(scanner.nextLine());
			System.out.print("Password : ");
			newAccount.setPassword(scanner.nextLine());
			System.out.print("Confirm Password : ");
			newAccount.setConfirmPassword(scanner.nextLine());
			System.out.print("Mobile Number : ");
			newAccount.setMobileNumber(scanner.nextLong());
			scanner.nextLine();
			System.out.print("Confirm(y/n) ? : ");
			switch(scanner.next().charAt(0)) {
			     case 'y':
			    	 if(validation.verifyPassword(newAccount.getPassword(), newAccount.getConfirmPassword(), newAccount) && validation.duplicateAccount(newAccount.getMobileNumber(), bank)) {
			    		   bank.createAccount(newAccount);
				    	   displayMessage("NEW ACCOUNT CREATED!");
				    	   displayMessage("ACCOUNT NUMBER:"+bank.getAccountNumber());
						   displayHeader(bank);
						   showMenu1(bank);  
			    	 } 
			    	 break;
			     case 'n':
			    	   displayHeader(bank);
			    	   showMenu1(bank);
			    	   break;
			}
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : newAccount(Bank bank) : \n" + exception);
			displayHeader(bank);
			showMenu1(bank);
		}	
	}
	
	public void login(Bank bank) {
		try {
			displayMessage("LOGIN");
			Login login = new Login();
			
			System.out.print("Enter the Account Number : ");
			login.setAccountNumber(scanner.nextLong());
			scanner.nextLine();
			System.out.print("Password : ");
			login.setPassword(scanner.nextLine());
			
			bank.verifyAccount(login);
			
			if(login.isIsValid()) {
				displayMessage("SUCCESSFUL LOGIN!");
				displayHeader(bank);
				showMenu2(bank, login.getCustomer());
			}
			else {
				displayMessage("VERIFICATION FAILED");
				displayHeader(bank);
		    	showMenu1(bank);
			}
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : login(Bank bank) : \n" + exception);
		}	
	}
	
	public void showMenu2(Bank bank, Customer customer) {
        try {
		    int option;
		    drawOutline();
		    System.out.println("| 1. Balance                            |");
		    System.out.println("| 2. Deposit                            |");
		    System.out.println("| 3. Withdraw                           |");
		    System.out.println("| 4. Transfer Fund                      |");
		    System.out.println("| 5. Statement                |");
		    System.out.println("| 6. Signout                            |");
		    drawOutline();
		    System.out.print("Enter your choice : ");
		    option = scanner.nextInt();
		    scanner.nextLine();
		
		    switch(option) {

		        case 1: 
			           viewBalance(bank, customer);
			           break;
		        case 2:
                       transaction(bank, customer, "DEPOSIT");
			           break;
		        case 3:
	                   transaction(bank, customer, "WITHDRAWAL");
				       break;
		        case 4:
		        	   transaction(bank, customer, "TRANSFER FUND");
				       break;
		        case 5:
		        	   showTransactionHistory(bank, customer);
		        	   break;
		        case 6:
		        	   displayHeader(bank);
			    	   showMenu1(bank);
			    	   break;    
		    }
	   } catch(Exception exception) {
		      System.out.println("Error : BankingMenu : showMenu1(Bank bank) : \n" + exception);
	   }
	}
	
	public void viewBalance(Bank bank, Customer customer) {
		try {
			
			displayMessage("BALANCE");
			System.out.println("Balance Amount  : Rs. " + customer.getBalance());
			displayHeader(bank);
			showMenu2(bank, customer);
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : viewBalance(Bank bank, Customer customer) : \n" + exception);
		}	
	}
	
	public void transaction(Bank bank, Customer customer, String transactionType) {
		try {
			if(transactionType.equals("DEPOSIT")) {
				displayMessage("DEPOSIT");
			}
			else if(transactionType.equals("WITHDRAWAL")) {
				displayMessage("WITHDRAW");
			}
			else {
				displayMessage("FUND TRANSFER");
			}
			
			Transaction transaction = new Transaction();
			if(transactionType.equals("TRANSFER FUND")) {
				System.out.println("Transfer to Account Number : ");
				transaction.setToAccountNumber(scanner.nextLong());
			}
			System.out.print("Amount : ");
			transaction.setAmount(scanner.nextDouble());
			scanner.nextLine();
			transaction.setTransactionDate(new Date());
			transaction.setTransactionType(transactionType);
            if(!(bank.handleTransaction(customer, transaction))) {
            	System.out.println("Current Balance : " + customer.getBalance());
//            	System.out.println(customer.getTransactions().toString());
            	displayHeader(bank);
    			showMenu2(bank, customer);
            }
            else {
            	throw new Exception("Insufficient Balance!");
            }
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : transaction(Bank bank, Customer customer) : \n" + exception);
			displayHeader(bank);
			showMenu2(bank, customer);
		}
	}

	public void showTransactionHistory(Bank bank, Customer customer) {
		try {
			displayMessage("TRANSACTION HISTORY");
			for(int i = 0; i < customer.getTransactions().size(); i++) {
				HashMap l = (HashMap)customer.getTransactions().get(i); //downcasting : Object to HashMap
				for(Object key : l.keySet()) {
					String stringkey = (String) key; //downcasting Object to String 
					System.out.println(l.get(stringkey));
				}
				System.out.println();
			}
			displayHeader(bank);
			showMenu2(bank, customer);
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : showTransactionHistory(Bank bank, Customer customer) : \n" + exception);
		}
	}
}

