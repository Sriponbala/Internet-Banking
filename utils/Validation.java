package utils;

import bank.Bank;
import bank.NewAccount;

public class Validation {

	public boolean verifyPassword(String password, long accountNumber, Bank bank) {
		
		if(password.equals(bank.getAccounts().get(accountNumber).getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
