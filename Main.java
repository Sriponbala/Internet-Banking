import java.util.HashMap;
import bank.Bank;
import bank.BankingMenu;
import utils.Validation;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			HashMap bankDetails = new HashMap();
			bankDetails.put("name", "STATE BANK OF INDIA");
            bankDetails.put("phoneNo", 044_2625_3301l);
            bankDetails.put("ifsc", "SBI0AMBATT");
            bankDetails.put("address", "No.7,Ambattur, Chennai-600053");
            bankDetails.put("faxNo", 022222742431l);
    
			Bank bank = new Bank(bankDetails);

			BankingMenu bankingMenu = new BankingMenu();
			Validation validation = new Validation();
			bank.setValidation(validation);
			
			bankingMenu.displayHeader(bank);
			bankingMenu.showMenu1(bank);
		} catch(Exception exception) {
			System.out.println("Error : Main : main(String[] args) : " + exception);
		}
			
	}

}

