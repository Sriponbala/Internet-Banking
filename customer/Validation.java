package customer;

import bank.Bank;

public class Validation
{
    Bank bank = new Bank();
    
	public boolean validateAccount(Bank bank, String emailId)
	{
	   if(emailId.equals(bank.getAccounts().get(emailId).getEmail()))
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }	
	}
}









//public boolean validateAccount(String emailId, String password)
//{
//   Customer customer = new Customer();
//	
//   if(emailId.equals(customer.getEmailId()) && (password.equals(customer.getPassword())))
//   {
//	   return true;
//   }
//   else
//   {
//	   return false;
//   }	
//}