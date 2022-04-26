package bank;

import java.util.Scanner;

import utils.Validation;

public class Login {

	Scanner scanner = new Scanner(System.in);
	
	public boolean verifylogin(Bank bank) {
		
		Validation validation = new Validation();
		System.out.println("Enter the password and account number  : ");
		if(validation.verifyPassword(scanner.nextLine(), scanner.nextLong(), bank)) {
			System.out.println(bank.getAccounts().toString());
			return true;
		}
		else
			return false;
	}
}
