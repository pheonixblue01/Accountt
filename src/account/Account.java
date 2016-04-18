package account;

public class Account {
	// Instance variables

	protected static double balance;
	protected static int accountID;

	// Constructors

	public Account() {
		Account.balance = 0;
		Account.accountID = 0;
	}
	
	public Account(double balance, int accountNum) {
		Account.balance = balance;
		Account.accountID = accountNum;
	}
	

	// Instance methods

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		Account.accountID = accountID;
	}

	public void setBalance(double amount) {
		balance = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public void close() {
		balance = 0.0;
	}
}

