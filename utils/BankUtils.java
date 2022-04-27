package utils;

import java.util.Random;

public class BankUtils {

	Random random = new Random();
	
	public long generateAccountNumber() {
	
		long accountNumber = 0;
		try {
			accountNumber = (long)(100000000000000l * random.nextDouble());	
		} catch(Exception exception) {
			System.out.println("Error : BankUtils : generateAccountNumber() : "+exception);
		}
		return accountNumber;
	}
	
	public int generateTransactionId() {
		
		int transactionId = 0;
		try {
			transactionId = (int)(100000 * random.nextDouble());;
		} catch(Exception exception) {
			System.out.println("Error : BankUtils : generateTransactionId() : "+exception);
		}
		return transactionId;
	}
}
