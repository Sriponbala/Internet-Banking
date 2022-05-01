package bank;

public class NewAccount {

	private String firstName = "", lastName = "", email = "", address = "", password = "", confirmPassword = "";
	private long mobileNumber = 0, accountNumber = 0;
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public boolean setPassword(String password, boolean passwordLoop) throws Exception {
		if(password.length() >= 3) {
			this.password = password;
			passwordLoop = false;
		}
		else {
			passwordLoop = true;
			throw new Exception("PASSWORD MUST CONSISTS OF ATLEAST 3 CHARACTERS");
		}
		return passwordLoop;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
