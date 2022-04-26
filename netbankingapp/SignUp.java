package netbankingapp;

import java.util.HashMap;
import java.util.Scanner;

import bank.Bank;
import customer.Account;
import customer.Customer;
import customer.Validation;

public class SignUp {

	String emailId;
	Scanner scanner = new Scanner(System.in);
	Customer customer = new Customer();
	HashMap<String, Customer> customerhashmap = new HashMap<>();
	
	public void signUp(Bank bank,Validation validation)
	{
		boolean flag = false;
		
		while(flag == false)
		{

			System.out.println("Enter email id : ");
			emailId = scanner.nextLine();

			if(validation.validateAccount(bank, emailId) == true)
			{
				
				new Customer().setEmailId(emailId);
				
				System.out.println("Enter customer id : ");
				new Customer().setCustomerId(scanner.nextLine());
				
				System.out.println("Enter the password : ");
				customer.setPassword(scanner.nextLine());
				
				System.out.println("Enter first name : ");
				customer.setFirstName(scanner.nextLine());
				
				System.out.println("Enter last name : ");
				customer.setLastName(scanner.nextLine());
				
				System.out.println("Enter address : ");
				customer.setAddress(scanner.nextLine());
				
				System.out.println("Enter date of birth : ");
				customer.setDateOfBirth(scanner.nextLine());
				
				System.out.println("Enter mobile number : ");
				new Customer().setMobile(scanner.nextLong());
				
				System.out.println("Successfully signed up to SBI Net banking application!");
			
				customerhashmap.put(emailId, new Customer());
				bank.setCustomers(customerhashmap);
				
				flag = true;
				
			}
			else
			{
				System.out.println("Account verification failed! Try again..");
			}
		}
		
		
	}
	
}
