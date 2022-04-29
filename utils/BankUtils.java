package utils;

import java.util.Random;

public class BankUtils {

	Random random = new Random();
	
	public long generateAccountNumber() {
	
		long accountNumber = 0;
		try {
			long randomNumber = (long)(100000000000000l * random.nextDouble());
			if(String.valueOf(randomNumber).length() != 14) {
				randomNumber += 100000000000000l;
			}
			accountNumber = randomNumber;	
		} catch(Exception exception) {
			System.out.println("Error : BankUtils : generateAccountNumber() : "+exception);
		}
		return accountNumber;
	}
	
	public int generateTransactionId() {
		
		int transactionId = 0;
		try {
			int randomNumber = (int)(100000 * random.nextDouble());
			if(String.valueOf(randomNumber).length() != 6) {
				randomNumber += 100000;
			}
			transactionId = randomNumber;	
		} catch(Exception exception) {
			System.out.println("Error : BankUtils : generateTransactionId() : "+exception);
		}
		return transactionId;
	}
}
