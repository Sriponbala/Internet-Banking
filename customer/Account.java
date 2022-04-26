package customer;

public class Account {

	private long accountNumber, mobile;
	private String userId, password, email;
	private double currentBalance;
	
	Account(long accountNumber, long mobile, String userId, String password, String email, double currentBalance)
	{
		this.accountNumber = accountNumber;
		this.mobile = mobile;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.currentBalance = currentBalance;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
}
