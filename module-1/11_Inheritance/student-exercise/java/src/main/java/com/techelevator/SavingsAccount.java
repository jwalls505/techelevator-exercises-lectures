package com.techelevator;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}

	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}

	@Override
	public int withdraw(int amountToWithdraw) {
		if (amountToWithdraw > getBalance()) {
			return getBalance();
		}
		if (getBalance() - amountToWithdraw < 150) {
			return super.withdraw(amountToWithdraw + 2);

		}
		return super.withdraw(amountToWithdraw);
	}

}
