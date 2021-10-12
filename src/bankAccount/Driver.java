package bankAccount;

import java.util.Scanner;
import java.text.DecimalFormat;

import bankAccount.SavingsAccount.NegativeInput;

public class Driver {

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void main(String[] args) throws Exception {

		double balance;
		double amountDeposit;
		double amountWithdraw;
		double annualRate;
		double transferFee;
		String accType;
		String input;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Press 1 to access your Checkings Account\nPress 2 to access your Savings Account\nPress 3 to Exit\n");
		do {
			do {

				accType = keyboard.nextLine();
				if (accType.charAt(0) != '1' && accType.charAt(0) != '2' && accType.charAt(0) != '3')

					System.out.println("Invalid input. Try again\n");
			} while (accType.charAt(0) != '1' && accType.charAt(0) != '2' && accType.charAt(0) != '3');
			switch (accType) {
			case "1":

				System.out.print("Enter your balance: $");

				balance = keyboard.nextDouble();

				System.out.print("Transaction fee: $");

				transferFee = keyboard.nextDouble();
				keyboard.nextLine();

				CheckingsAccount acc1 = new CheckingsAccount(balance, transferFee);

				do {
					do {
						CheckingsAccount.displayMenu();
						input = keyboard.nextLine().toUpperCase();
						if (input.charAt(0) != 'D' && input.charAt(0) != 'W' && input.charAt(0) != 'B'
								&& input.charAt(0) != 'F' && input.charAt(0) != 'E')

							System.out.println("Invalid input. Try again\n");

					} while (input.charAt(0) != 'D' && input.charAt(0) != 'W' && input.charAt(0) != 'B'
							&& input.charAt(0) != 'F' && input.charAt(0) != 'E');

					switch (input) {
					case "D":

						System.out.print("Enter the amount you want to Deposit: $");
						amountDeposit = keyboard.nextDouble();
						keyboard.nextLine();

						try {
							if (amountDeposit <= 0)
								throw new Exception();
							acc1.deposits(amountDeposit);
							System.out.println("Your Balance is: $" + df2.format(acc1.getBalance()));

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());

						}

						break;

					case "W":

						try {

							if (acc1.getStatus() == false)
								throw new NegativeInput(false);

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());
							break;

						}

						System.out.print("Enter the amount you want to withdraw: $");
						amountWithdraw = keyboard.nextDouble();
						keyboard.nextLine();

						try

						{

							if (amountWithdraw <= 0)
								throw new NegativeInput();
							acc1.withdrawals(amountWithdraw);
							System.out.println("Your Balance is: $" + df2.format(acc1.getBalance()));

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());

						}
						break;

					case "B":

						System.out.println("Your Balance is: $" + df2.format(acc1.getBalance()));

						break;

					case "E":

						System.out.printf("Balance : $%.2f", acc1.getBalance());
						System.out.println("\nGoodbye!");

						break;

					default:

						break;
					}

				} while (input.charAt(0) != 'E');

				break;

			case "2":

				transferFee = 0;

				System.out.print("Enter your balance: $");

				balance = keyboard.nextDouble();

				System.out.print("Annual interest rate percent: %");

				annualRate = keyboard.nextDouble();
				keyboard.nextLine();

				SavingsAccount acc2 = new SavingsAccount(balance, annualRate);

				do {
					do {
						SavingsAccount.displayMenu();
						input = keyboard.nextLine().toUpperCase();
						if (input.charAt(0) != 'D' && input.charAt(0) != 'W' && input.charAt(0) != 'B'
								&& input.charAt(0) != 'M' && input.charAt(0) != 'E')

							System.out.println("Invalid input. Try again\n");

					} while (input.charAt(0) != 'D' && input.charAt(0) != 'W' && input.charAt(0) != 'B'
							&& input.charAt(0) != 'M' && input.charAt(0) != 'E');

					switch (input) {
					case "D":

						System.out.print("Enter the amount you want to Deposit: $");
						amountDeposit = keyboard.nextDouble();
						keyboard.nextLine();

						try {
							if (amountDeposit <= 0)
								throw new Exception();
							acc2.deposits(amountDeposit);
							System.out.println("Your Balance is: $" + df2.format(acc2.getBalance()));

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());

						}

						break;

					case "W":

						try {

							if (acc2.getStatus() == false)
								throw new NegativeInput(false);

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());
							break;

						}

						System.out.print("Enter the amount you want to withdraw: $");
						amountWithdraw = keyboard.nextDouble();
						keyboard.nextLine();

						try

						{

							if (amountWithdraw <= 0)
								throw new NegativeInput();
							acc2.withdrawals(amountWithdraw);
							System.out.println("Your Balance is: $" + df2.format(acc2.getBalance()));

						}

						catch (NegativeInput e)

						{

							System.out.println(e.getMessage());

						}
						break;

					case "B":

						System.out.println("Your Balance is: $" + df2.format(acc2.getBalance()));

						break;

					case "M":

						acc2.monthlyProcess();

						break;

					case "E":

						System.out.printf("Balance : $%.2f", acc2.getBalance());
						System.out.println("\nGoodbye!");

						break;

					default:

						break;
					}

				} while (input.charAt(0) != 'E');

				break;
			case "3":
				System.out.println("Goodbye!");
				break;
			default:
				break;

			}

		} while (accType.charAt(0) != '3');
	}
}