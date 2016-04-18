package account;
import java.util.Scanner;

public class Bank {

	private static Account[] arrayAcc = new Account[0];
	public static void commandPrompt (){
		System.out.println("Welcome to Victor's Bank & Company!");
		System.out.println("\n-------------------------------------------------");
		System.out.println("|Commands: o - Open Account    c - Close Account|");
		System.out.println("|          d - Deposit         w - Withdraw     |");
		System.out.println("|          s - Select Account  r - Write Check  |");
		System.out.println("|          i - Credit Interest q - Quit         |");
		System.out.println("-------------------------------------------------");	
		
	}

	public static void main(String[] args) {

		Scanner command = new Scanner(System.in);
		
		commandPrompt();

		String c = "c";
		String d = "d";
		String w = "w";
		String r = "r";
		String i = "i";
		String s = "s";
		String q = "q";
		String o = "o";
		String l = "l";
		String m = "m";

		
		System.out.println("Current accont: None selected");
		System.out.println("The total number of accounts in the bank is: 0");

		System.out.print("\nEnter command: ");
		String commandB = command.nextLine();
		
		while (l != q) {

			// CHECKS IF COMMAND ENTER IS Q
			if (commandB.equalsIgnoreCase(q)) {
				break;
			}
			// OPEN ACCOUNT
			if (commandB.equalsIgnoreCase(o)) {

				System.out.print("Enter new account number: ");
				int accountNum = command.nextInt();
				System.out.print("Enter initial balance: ");
				double initialBal = command.nextDouble();

				//LOOPS UNTIL AN S OR C IS CORRECTLY ENTERED
				System.out.println("Will this be a checking or savings account?");
				System.out.print("Enter c (checking) or s (savings): ");
				String cORs = command.next();
				// OPENS A NEW SAVINGS ACCOUNT AND STORES ACCOUNTID AND SETS
				// BALANCE ALSO SETS INTEREST RATE
					if (cORs.equalsIgnoreCase(s)) {
				
					System.out.print("What is the annual interest rate?: ");
					double interestR = command.nextDouble();
					SavingsAccount newSavings = new SavingsAccount(initialBal,accountNum, interestR);
					arrayCopy(newSavings);
					
					commandPrompt();
					System.out.println("Current account: " + newSavings.getAccountID() + " Balance: " + newSavings.getBalance());
					System.out.println("Interest Rate: " + newSavings.getInterestR());
					System.out.println("The total number of accounts in this bank is: " + (arrayAcc.length));
				
				}
				
				// OPENS A NEW CHEKING ACCOUNT AND STORES ACCOUNTID AND SETS BALANCE
				else if (cORs.equalsIgnoreCase(c)) {
					CheckingAccount newChecking = new CheckingAccount(initialBal, accountNum);
					arrayCopy(newChecking);
					
					commandPrompt();
					System.out.println("Current account: " + newChecking.getAccountID() + " Balance: " + newChecking.getBalance());
					System.out.println("Number of checks written: " + newChecking.getChecks());
					System.out.println("The total number of accounts in this bank is: " + (arrayAcc.length));
				
				}
					break;
				}
					
			
			
			//SELECTS AN ACCOUNT
			if (commandB.equalsIgnoreCase(s)){
				System.out.print("Please enter an account number: ");
				int accNum = command.nextInt();
				int cast = 0;
				for(int selectedAcc = 0; selectedAcc < arrayAcc.length; selectedAcc++){
					if(accNum == arrayAcc[selectedAcc].getAccountID()){
						cast = selectedAcc;
					}
				}
				System.out.println("Enter command: ");
				String selectedCom = command.nextLine();
				
				if(selectedCom.equalsIgnoreCase(r)){
					if(arrayAcc[cast] instanceof SavingsAccount){
						while(arrayAcc[cast] instanceof SavingsAccount){
							System.out.println("Please select a checking account. ");
							System.out.print("Select account: ");
							int accNum1 = command.nextInt();
							for(int selectedAcc = 0; selectedAcc < arrayAcc.length; selectedAcc++){
								if(accNum1 == arrayAcc[selectedAcc].getAccountID()){
									cast = selectedAcc;
									break;
								}
							}
						}
						CheckingAccount writecheck = (CheckingAccount) arrayAcc[cast];
						writecheck.setCheck();
						System.out.println("Current account: " + writecheck.getAccountID() + " Balance: " + writecheck.getBalance());
						System.out.println("Number of checks written: " + writecheck.getChecks());
					} else {
						CheckingAccount writecheck = (CheckingAccount) arrayAcc[cast];
						writecheck.setCheck();
						System.out.println("Current account: " + writecheck.getAccountID() + " Balance: " + writecheck.getBalance());
						System.out.println("Number of checks written: " + writecheck.getChecks());
					}
				}
				
				if(selectedCom.equalsIgnoreCase(i)){
					if(arrayAcc[cast] instanceof CheckingAccount){
						while(arrayAcc[cast] instanceof CheckingAccount){
							System.out.println("Please select a savings account. ");
							System.out.print("Select account: ");
							int accNum1 = command.nextInt();
							for(int selectedAcc = 0; selectedAcc < arrayAcc.length; selectedAcc++){
								if(accNum1 == arrayAcc[selectedAcc].getAccountID()){
									cast = selectedAcc;
									break;
								}
							}
						}
						SavingsAccount creditI = (SavingsAccount) arrayAcc[cast];
						creditI.setBalance((creditI.getInterestR()/100)*creditI.getBalance());
						System.out.println("Current account: " + creditI.getAccountID() + " Balance: " + creditI.getBalance());
						System.out.println("Interest Rate: " + creditI.getInterestR());
					} else {
						SavingsAccount creditI = (SavingsAccount) arrayAcc[cast];
						creditI.setBalance((creditI.getInterestR()/100)*creditI.getBalance());
						System.out.println("Current account: " + creditI.getAccountID() + " Balance: " + creditI.getBalance());
						System.out.println("Interest Rate: " + creditI.getInterestR());
					}
				}
				//CLOSES SELECTED ACCOUNT
				if(selectedCom.equalsIgnoreCase(c)){
					arrayAcc[accNum].close();
					System.out.println("Account has been closed!");
				}		
			}
			// CLOSE ACCOUNT
			if (commandB.equalsIgnoreCase(c)) {
				System.out.print("Please select account to close: ");
				int close = command.nextInt();
				closeID(close);
			}
		}
		
}

	// This method resizes and array and increases the size of the array by 1.
	public static void arrayCopy(Account account) {
		Account[] arrayCopy = new Account[arrayAcc.length + 1];
		for (int z = 0; z < arrayAcc.length; z++) {
			arrayCopy[z] = arrayAcc[z];
		}
		arrayCopy[arrayCopy.length - 1] = account;
		arrayAcc = arrayCopy;
	}
	// This method takes in an int (accountID) and searches through the array of
	// accounts to find the account with the matching account ID and closes
	// (sets the balance to 0) that account.
	public static void closeID(int close) {
		int closeID = 0;
		if (close == arrayAcc[closeID].getAccountID()) {
			arrayAcc[closeID].close();
			System.out.println("Account has been closed!");
		}
		while (close != arrayAcc[closeID].getAccountID()) {
			if (close == arrayAcc[closeID].getAccountID()) {
				arrayAcc[closeID].close();
				System.out.println("Account has been closed!");
			}
			closeID++;
		}
	}
}
