package account;


public class SavingsAccount extends Account {

	private static double interestR;

	public SavingsAccount(double initialBal, int accountNum, double interestR2) {
		super(balance, accountNum);
		SavingsAccount.interestR = interestR2;
	}

	public double getInterestR() {
		return interestR;
	}

	public void setInterestR(double interestR) {
		SavingsAccount.interestR = interestR;
	}
	
}

