package customer;

import java.util.HashMap;

import bank.Bank;

public class Accounts {

	HashMap<String, Account> hashmap = new HashMap<>();
	
	public void addAccount(Bank bank) {
		
		hashmap.put("lanashd@gmail.com", new Account(1l, 9876543219l, "Lanash_D", "@lanash01", "lanashd@gmail.com", 60_000));
		hashmap.put("bhargav@gmail.com", new Account(2l, 9123456789l, "Bhargav_T", "@bhargav01", "bhargav@gmail.com", 50_000));
		hashmap.put("@rahulskgmail.com", new Account(3l, 9234567890l, "Rahul_SK", "@rahulsk01", "@rahulskgmail.com", 50_000));
		hashmap.put("sri@gmail.com", new Account(4l, 9345678901l, "Sri", "@sri01", "sri@gmail.com", 70_000));	
		
		bank.setAccounts(hashmap);
	}
}
