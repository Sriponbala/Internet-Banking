
import bank.Bank;
import bank.BankingMenu;
import utils.Validation;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			Bank bank = new Bank();
			BankingMenu bankingMenu = new BankingMenu();
			bankingMenu.showMenu1(bank);
		}
		catch(Exception exception) {
			System.out.println("Error : Main : main(String arg[]) : "+exception);
		}
			
	}

}
