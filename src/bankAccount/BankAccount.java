package bankAccount;

public abstract class BankAccount {

	// declare class methods

	double balance;
	double annualRate;
	double transferFee;

	// constructor
	public BankAccount(double bal, double rate, double fee) {

		// initialize class fields
		balance = bal;
		annualRate = rate;
		transferFee = fee;

	}
	// class methods

	public void deposits(double amntDeposit) {

		balance = balance + amntDeposit;
		calcFee();


	}

	public void withdrawals(double amntWithdraw) {

		balance = balance - amntWithdraw;
		calcFee();


	}

	// The Interest Calculation
	public void calcInterest() {

		double monthlyRate = ((annualRate / 120));
		double monthlyInterest = balance * monthlyRate;

		balance += monthlyInterest;
	}

	// The Trasanction Fee Calculation
	public void calcFee() {

		double fee = transferFee;
		balance -= fee;

	}

	public abstract void monthlyProcess();


	// Setter and Getters
	public void setBalance(double bal) {

		balance += bal;

	}

	public double getBalance() {

		return balance;

	}

	public double getAnnualRate() {

		return annualRate;

	}

	public double getTransactionFee() {

		return transferFee;

	}

}