package bank;

import java.util.*;
import customer.Customer;
import utils.BankUtils;

public class Bank {

	private long accountNumber;
	private String bankName = "SBI";
	private String ifsc = "SBI0AMBATT";
	private String bankAddress = "No.7,Ambattur, Chennai-600053";
	private String bankEmail = "sbiambattur@sbi.co.in";
	private long phoneNo = 044_2625_3301;
	private long faxNo = 022222742431;
	
	private HashMap<Long, NewAccount> accounts = new HashMap<>();
	
	public HashMap<Long, NewAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashMap<Long, NewAccount> accounts) {
		this.accounts = accounts;
	}

	public void createAccount(NewAccount newAccount) {
		
		BankUtils bankUtils = new BankUtils();
		accountNumber = bankUtils.generateAccountNumber();
        System.out.println("Account Number : "+accountNumber);
		newAccount.setAccountNumber(accountNumber);
		accounts.put(accountNumber, newAccount);
	}
}
