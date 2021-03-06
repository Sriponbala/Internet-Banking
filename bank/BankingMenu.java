package bank;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import utils.Validation;

public class BankingMenu {
    
	int outlineWidth = 39;
	public static final int NEWACCOUNT = 1;
	public static final int LOGIN = 2;
	public static final int EXIT = 3;
	public static final char YES = 'y';
	public static final char NO = 'n';
	public static final int BALANCE = 1;
	public static final int DEPOSIT = 2;
	public static final int WITHDRAWAL = 3;
	public static final int TRANSFER_FUND = 4;
	public static final int STATEMENT = 5;
	public static final int PROFILE = 6;
	public static final int SIGNOUT = 7;
	
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
	
	public void showLoginScreen(Bank bank) {
			boolean open = true;
			while(open) {
				int option = 0;
				drawOutline();
				System.out.println("| 1. New Account                        |");
				System.out.println("| 2. Login                              |");
				System.out.println("| 3. Exit                               |");
				drawOutline();
				System.out.print("Enter your choice : ");
				try {
				option = scanner.nextInt();
				} catch(Exception exception) {
					scanner.nextLine();
					option = 0;
				}
				switch(option) {

				  case NEWACCOUNT: 
					  newAccount(bank, bank.getValidation());
					  break;
				  case LOGIN:
					  login(bank);
					  break;
				  case EXIT:
					  
					  displayMessage("THANK YOU!");
					  open = false;
					  break;
				  default : 
					   displayMessage("INVALID OPTION!");
					   displayHeader(bank);
					   break;
				}
			}
	}
	
	public void newAccount(Bank bank, Validation validation) {
		
		try {
			
			displayMessage("NEW ACCOUNT");
			NewAccount newAccount = new NewAccount();
			
			scanner.nextLine();
			System.out.print("First Name : ");
			newAccount.setFirstName(scanner.nextLine().trim());
			System.out.print("Last Name : ");
			newAccount.setLastName(scanner.nextLine().trim());
			System.out.print("Email : ");
			newAccount.setEmail(scanner.nextLine().trim());
			System.out.print("Address : ");
			newAccount.setAddress(scanner.nextLine());
			boolean passwordLoop = true;
			while(passwordLoop) {
				try {
					System.out.print("Password(Length should atleast be 3) : ");
					passwordLoop = newAccount.setPassword(scanner.nextLine(), passwordLoop);
					
				} catch(Exception exception) {
					System.out.println(exception.getMessage());
				}
			}
			
			System.out.print("Confirm Password : ");
			newAccount.setConfirmPassword(scanner.nextLine());
			boolean open  = true;
			while(open) {
				try {
					System.out.print("Mobile Number : ");
					newAccount.setMobileNumber(scanner.nextLong());
					open = false;
				} catch(Exception exception) {
					displayMessage("INPUT MISMATCH EXCEPTION");
					scanner.nextLine();
				}
			}
			
			boolean option = true;
			while(option) {
				System.out.print("Confirm(y/n) ? : ");
				switch(scanner.next().charAt(0)) {
				     case YES:
				    	 if(validation.verifyPassword(newAccount.getPassword(), newAccount.getConfirmPassword(), newAccount) && validation.duplicateAccount(newAccount.getMobileNumber(), bank)) {
				    		   bank.createAccount(newAccount);
					    	   displayMessage("NEW ACCOUNT CREATED!");
					    	   displayMessage("ACCOUNT NUMBER:"+bank.getAccountNumber());
							   displayHeader(bank);
							   option = false;
				    	 } 
				    	 break;
				     case NO:
				    	   displayHeader(bank);
				    	   option = false;
				    	   break;
				     default : 
				    	   displayMessage("INVALID OPTION!");
						   break;
				}
			}	
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : newAccount(Bank bank) : \n" + exception.getMessage());
			displayHeader(bank);
		}	
	}
	
	public void login(Bank bank) {
		try {
			displayMessage("LOGIN");
			Login login = new Login();
			boolean open  = true;
			while(open) {
				try {
					System.out.print("Enter the Account Number : ");
					login.setAccountNumber(scanner.nextLong());
					open = false;
				} catch (Exception exception) {
					displayMessage("INPUT MISMATCH EXCEPTION");
					scanner.nextLine();
				}
			}
			scanner.nextLine();
			System.out.print("Password : ");
			login.setPassword(scanner.nextLine());
			
			bank.verifyAccount(login);
			
			if(login.isIsValid()) {
				displayMessage("SUCCESSFUL LOGIN!");
				displayHeader(bank);
				showHomePage(bank, login.getCustomer());
			}
			else {
				displayMessage("VERIFICATION FAILED");
				displayHeader(bank);
			}
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : login(Bank bank) : \n" + exception.getMessage());
		}	
	}
	
	public void showHomePage(Bank bank, Customer customer) {
        try {
        	boolean open = true;
			while(open) {
				int option = 0;
			    drawOutline();
			    System.out.println("| 1. Balance                            |");
			    System.out.println("| 2. Deposit                            |");
			    System.out.println("| 3. Withdraw                           |");
			    System.out.println("| 4. Transfer Fund                      |");
			    System.out.println("| 5. Statement                          |");
			    System.out.println("| 6. Profile                            |");
			    System.out.println("| 7. Signout                            |");
			    drawOutline();
			    System.out.print("Enter your choice : ");
			    try {
					option = scanner.nextInt();
				} catch(Exception exception) {
					scanner.nextLine();
					option = 0;
			    }
			    switch(option) {

			        case BALANCE: 
				           viewBalance(bank, customer);
				           break;
			        case DEPOSIT:
	                       transaction(bank, customer, "DEPOSIT");
				           break;
			        case WITHDRAWAL:
		                   transaction(bank, customer, "WITHDRAWAL");
					       break;
			        case TRANSFER_FUND:
			        	   transaction(bank, customer, "TRANSFER FUND");
					       break;
			        case STATEMENT:
			        	   showTransactionHistory(bank, customer);
			        	   break;
			        case PROFILE:
			        	   viewProfile(bank, customer);
			        	   break;
			        case SIGNOUT:
			        	   displayHeader(bank);
			        	   open = false;
				    	   break; 
			        default:
			        	displayMessage("INVALID OPTION!");
			        	displayHeader(bank);
						break;
		     }
		  }
	   } catch(Exception exception) {
		      System.out.println("Error : BankingMenu : showHomePage(Bank bank, Customer customer) : \n" + exception);
	   }
	}
	
	public void viewBalance(Bank bank, Customer customer) {
		try {
			
			displayMessage("BALANCE");
			System.out.println("Balance Amount  : Rs. " + customer.getBalance());
			displayHeader(bank);
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : viewBalance(Bank bank, Customer customer) : \n" + exception.getMessage());
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
			boolean open = true;
			while(open) {
				System.out.print("Amount : ");
				double amount = scanner.nextDouble();
				if(amount >= 0) {
					transaction.setAmount(amount);
					open = false;
				}
				else {
					System.out.println("Enter positive value!");
				}
			}
			scanner.nextLine();
			transaction.setTransactionDate(new Date());
			transaction.setTransactionType(transactionType);
			if(transactionType.equals("TRANSFER FUND")) {
				System.out.println("Transfer to Account Number : ");
				transaction.setToAccountNumber(scanner.nextLong());
				scanner.nextLine();
			}
			
            if(!(bank.handleTransaction(customer, transaction))) {
            	System.out.println("Current Balance in " + customer.getFirstName() + " " + customer.getLastName() + " : " + customer.getBalance());
            	displayHeader(bank);
            }
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : transaction(Bank bank, Customer customer) : \n" + exception.getMessage());
			displayHeader(bank);
		}
	}

	public void showTransactionHistory(Bank bank, Customer customer) {
		try {
			displayMessage("TRANSACTION HISTORY");
			for(int i = 0; i < customer.getTransactions().size(); i++) {
				HashMap transactionMap = (HashMap)customer.getTransactions().get(i); //downcasting : Object to HashMap
				for(Object key : transactionMap.keySet()) {
					String transactionKey = (String) key; //downcasting Object to String 
					System.out.println(transactionMap.get(transactionKey));
				}
				System.out.println();
			}
			displayHeader(bank);
		} catch(Exception exception) {
			System.out.println("Error : BankingMenu : showTransactionHistory(Bank bank, Customer customer) : \n" + exception);
		}
	}
	
	public void viewProfile(Bank bank, Customer customer) {
		try {
			displayMessage("CUSTOMER PROFILE");
			System.out.println("NAME    : " + customer.getFirstName() + " " + customer.getLastName());
			System.out.println("EMAIL   : " + customer.getEmail());
			System.out.println("ADDRESS : " + customer.getAddress());
			System.out.println("PH.NO.  : " + customer.getMobileNumber());
			displayHeader(bank);
		} catch (Exception exception) {
			System.out.println("Error : BankingMenu : viewProfile(Customer customer) : \n" + exception.getMessage());
		}
	}
}
