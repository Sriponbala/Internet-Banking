package netbankingapp;

import java.util.Scanner;

import customer.Validation;

public class AccountActions {

	Scanner scanner = new Scanner(System.in);
	
	public void login(Validation validation)
	{
		boolean flag = false;
		while(flag == false)
		{
			System.out.println("Enter email id : ");
			String email = scanner.nextLine();
			System.out.println("Enter password :");
			String password = scanner.nextLine();
			if(validation.validateAccount(email, password))
			{
				BankMenu menu = new BankMenu();
				menu.displayMenu();
				flag = true;
			}
			else
			{
				System.out.println("Invalid email or password");
			}
		}
		
	}
	
	public void addBeneficiary()
	{
		
	}
	
	public void withdraw()
	{
		
	}
	
	public void deposit()
	{
		
	}
	
	public void changePassword()
	{
		
	}
	
}
