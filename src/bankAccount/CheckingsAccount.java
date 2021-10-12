package bankAccount;

public class CheckingsAccount extends BankAccount {

	private boolean status;

	// Constructor
	public CheckingsAccount(double balance, double transferFee) {

		super(balance, 0, transferFee);

		if (super.getBalance() > 25)

			status = true;

		else

			status = false;

	}

	public void withdrawals(double amntWithdraw) {

		if (status == true && super.getBalance() >= amntWithdraw) {
			super.withdrawals(amntWithdraw);

			if (super.getBalance() < 25) {

				System.out.println("Your balance is now less than minimum balance ($25). Your account is now INACTIVE! ");
				status = false;

			}

		} else {

			System.out.println("Debit amount exceeded account balance.");

		}

	}

	public void deposits(double amntDeposit) {

		super.deposits(amntDeposit);
		if (status == false && super.getBalance() > 25) {
			status = true;
			System.out.println("Your account is now ACTIVE\n");

		}

	}


	// Getter
	public boolean getStatus() {

		return status;

	}

	// Error exceptions for the inputs
	public static class NegativeInput extends Exception {
		public NegativeInput() {
			super("Error: A positive value must be enter\n");
		}

		public NegativeInput(boolean act) {
			super("Error: Your account is INACTIVE\n");
		}
	}

	// Output Menu to gather the desired information
	public static void displayMenu() {
		System.out.println("\nEnter 'D' to make a deposit");
		System.out.println("Enter 'W' to make Withdraw");
		System.out.println("Enter 'B' for Balance");
		System.out.println("Enter 'E' to Exit");

	}

	@Override
	public void monthlyProcess() {
		// TODO Auto-generated method stub
		
	}
}