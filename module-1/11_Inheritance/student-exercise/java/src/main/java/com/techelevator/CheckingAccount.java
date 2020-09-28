package com.techelevator;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
	}
	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}
	@Override
	public int withdraw(int amountToWithdraw) {
		if((getBalance() - amountToWithdraw < 0)&&(getBalance() - amountToWithdraw <= -100)) {
			return getBalance();
		}
		if((getBalance() - amountToWithdraw < 0)&&(getBalance() - amountToWithdraw >= -100)) {
			 return super.withdraw(amountToWithdraw + 10);
		}
		
		return super.withdraw(amountToWithdraw);

	}
	

}
