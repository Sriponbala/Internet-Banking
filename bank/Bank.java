package bank;

import java.util.*;
import bank.Customer;
import utils.BankUtils;
import utils.Validation;

public class Bank {

	private long accountNumber = 0;
	private String bankName = "";
	private String ifsc = "";
	private String bankAddress = "";
	private String bankEmail = "";
	private long phoneNo = 0;
	private long faxNo = 0;
	private HashMap<Long, Customer> accounts = new HashMap<Long, Customer>();
	
	private Validation validation = null;
	
	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	public Bank(HashMap bankDetails) {
		
		this.bankName = (String) bankDetails.get("name");
		this.ifsc = (String) bankDetails.get("ifsc");
		this.bankAddress = (String) bankDetails.get("address");
		this.bankEmail = (String) bankDetails.get("email");
		this.phoneNo = (long) bankDetails.get("phoneNo");
		this.faxNo = (long) bankDetails.get("faxNo");
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankEmail() {
		return bankEmail;
	}

	public void setBankEmail(String bankEmail) {
		this.bankEmail = bankEmail;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(long faxNo) {
		this.faxNo = faxNo;
	}

	public HashMap<Long, Customer> getAccounts() {
		return accounts;
	}

	public void createAccount(NewAccount newAccount) {
		try {
			
			BankUtils bankUtils = new BankUtils();
			accountNumber = bankUtils.generateAccountNumber();
			newAccount.setAccountNumber(accountNumber);
			Customer customer = new Customer(); // composition
			customer.setFirstName(newAccount.getFirstName());
			customer.setLastName(newAccount.getLastName());
			customer.setEmail(newAccount.getEmail());
			customer.setAddress(newAccount.getAddress());
			customer.setPassword(newAccount.getPassword());
			customer.setMobileNumber(newAccount.getMobileNumber());
			customer.setAccountNumber(newAccount.getAccountNumber());
			
			accounts.put(accountNumber, customer);
			
		} catch(Exception exception) {
			
			System.out.println("Error : Bank : createAccount(NewAccount newAccount) : " + exception);
		}
	}
	
	public Login verifyAccount(Login login) {
		try {
			long accountNumber = login.getAccountNumber();
			String currentPassword = login.getPassword();
			boolean isValid = false;
			if(accounts.containsKey(accountNumber)) {
				Customer customer = accounts.get(accountNumber);
				String customerPassword = customer.getPassword();
				if(customerPassword.equals(currentPassword)) {
					login.setCustomer(customer);
					isValid = true;
				} else {
					isValid = false;
				}
			} else {
				isValid = false;
			}
          	login.setIsValid(isValid);
				
		} catch(Exception exception) {
			System.out.println("Error : Bank : verifyAccount(Login login) : " + exception);
		}
		 return login;
	}

	public boolean handleTransaction(Customer customer, Transaction transaction) {
		boolean insufficientBalance = false;
		HashMap hashmap = new HashMap();
		try {
			if(transaction.getTransactionType().equals("DEPOSIT")) {
				customer.setBalance(customer.getBalance() + transaction.getAmount());
				accounts.put(customer.getAccountNumber(), customer);
			}
			else if(transaction.getTransactionType().equals("WITHDRAWAL")) {
				if(customer.getBalance() > transaction.getAmount()) {
					customer.setBalance(customer.getBalance() - transaction.getAmount());
					accounts.put(customer.getAccountNumber(), customer);
					insufficientBalance = false;
				}
				else {
					insufficientBalance = true;
				}
			}
//			else {
//				if(customer.getBalance() > transaction.getAmount()) {
//				  //     acc
//				}
//			}
			
			if(insufficientBalance == false) {
				
				hashmap.put("TRANSACTION TYPE ", transaction.getTransactionType());
				hashmap.put("AMOUNT ", transaction.getAmount());
				hashmap.put("DATE ", transaction.getTransactionDate());
				hashmap.put("REMARKS ", transaction.getRemarks());
				customer.setTransactions(hashmap);
				accounts.put(customer.getAccountNumber(), customer);
			}
		} catch(Exception exception) {
			System.out.println("Error : Bank : handleTransaction(Customer customer, Transaction transaction) : " + exception);
		}
		return insufficientBalance;
	}
}

