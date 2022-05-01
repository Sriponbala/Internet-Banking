import bank.Bank;
import bank.BankingMenu;
import utils.Validation;

public class Main {

	public static void main(String[] args) {
		
		try {

			Bank bank = new Bank();
			bank.setBankName("STATE BANK OF INDIA");
			bank.setPhoneNo(044_2625_3301l);
			bank.setIfsc("SBI0AMBATT");
			bank.setBankAddress("No.7,Ambattur, Chennai-600053");
			bank.setFaxNo(022222742431l);

			BankingMenu bankingMenu = new BankingMenu();
			Validation validation = new Validation();
			bank.setValidation(validation);
			
			bankingMenu.displayHeader(bank);
			bankingMenu.showLoginScreen(bank);
		} catch(Exception exception) {
			System.out.println("Error : Main : main(String[] args) : " + exception);
		}
			System.out.println();
	}
}

