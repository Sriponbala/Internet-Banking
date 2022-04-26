package utils;

import java.util.Random;

public class BankUtils {

	public long generateAccountNumber() {
	
		long accountNumber = 0;
		try {
			Random random = new Random();
			accountNumber = (long)(100000000000000l * random.nextDouble());	
		}
		catch(Exception exception) {
			System.out.println("Error : BankUtils : generateAccountNumber() : "+exception);
		}
		return accountNumber;
	}
}
