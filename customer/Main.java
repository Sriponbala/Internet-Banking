package customer;

import bank.*;
import java.util.*;

import netbankingapp.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int option;
		Bank bank = new Bank();
		
		Accounts accountsClass = new Accounts();
		accountsClass.addAccount(bank);
		
//		System.out.println(bank.getAccounts().get("sri@gmail.com").getCurrentBalance());//60000.00
		
		Validation validation = new Validation();
		
	    SignUp createaccount = new SignUp();
	    createaccount.signUp(bank,validation);
		
		System.out.println("Email");
		String email = scanner.nextLine();
		System.out.println("Password:");
		String p = scanner.nextLine();
		
		System.out.println(bank.getCustomers().get(email).getPassword());
		
		if(p.equals(bank.getCustomers().get(email).getPassword()))
		{
			System.out.println("True");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Validation validation = new Validation();
//		
//	    AccountCreation createaccount ;
//	    AccountActions accountActions = new AccountActions();
//	    
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Welcome to Virtual Bank!\n");
//		System.out.println(" 1. Create Account\n"
//				+ " 2. Login\n"
//				+ " 3. Exit");
//        System.out.println("Enter your option : ");
//        option = scanner.nextInt();
//        
//        switch(option)
//        {
//            case 1 : 
//            {
//            	createaccount = new AccountCreation();
//            	createaccount.createAccount(accountActions,validation);
//            	break;
//            }
//            case 2 :
//            {
//            	accountActions = new AccountActions();
//            	accountActions.login(validation);
//            	break;
//            }
//            case 3 : System.exit(0); break;
//           
//        }
	}

}
