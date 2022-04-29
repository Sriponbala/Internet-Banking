package utils;

import bank.Bank;
import bank.NewAccount;

public class Validation {
	
    boolean verified;
	public boolean verifyPassword(String password, String confirmPassword, NewAccount newAccount) throws Exception {
		    verified = false;
//			confirmPassword = null;
			if(confirmPassword.equals(newAccount.getPassword())) {
				verified = true;
			}
			else {
				verified = false;
				throw new Exception("Incorrect Password");
			}

		return verified;
	}

	public boolean duplicateAccount(long mobileNumber, Bank bank) throws Exception {
		    verified = false;
			if(bank.getAccounts().size() != 0) {
				for(int i = 0; i < bank.getAccounts().size(); i++) {
					for(Long key : bank.getAccounts().keySet()) { 
					    if(mobileNumber != bank.getAccounts().get(key).getMobileNumber()) {
						       verified = true;
					    }
					    else {
						       verified = false;
						       throw new Exception("Customer already exists"); 
					    }
					}
				}
			}
			else {
				verified = true;
			}	
		return verified;
	}
}
