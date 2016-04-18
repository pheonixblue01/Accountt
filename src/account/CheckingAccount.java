package account;

public class CheckingAccount extends Account{

	private static int checks;
	
	public CheckingAccount(double balance, int accountNum) {
		super(balance, accountNum);
		checks = 0;
	}

	public int getChecks() {
		return checks;
	}
	
	public void setCheck(){
		checks++;
	}
	
}
