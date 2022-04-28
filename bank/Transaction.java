package bank;

import java.util.Date;

public class Transaction {

	 private String transactionType = "", remarks = "";
	 private long toAccountNumber = 0;
	 private double amount = 0;
	 
	 public long getToAccountNumber() {
		return toAccountNumber;
	 }
	 public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	 }
	 private Date transactionDate;
	 
	 public String getTransactionType() {
		return transactionType;
	 }
	 public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	 }
	 public String getRemarks() {
		return remarks;
	 }
	 public void setRemarks(String remarks) {
		this.remarks = remarks;
	 }
	 public double getAmount() {
		return amount;
	 }
	 public void setAmount(double amount) {
		this.amount = amount;
	 }
	  public Date getTransactionDate() {
		return transactionDate;
	 }
	 public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	 }

}
