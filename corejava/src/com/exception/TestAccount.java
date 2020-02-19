package com.exception;


class InsufficientBalanceException extends Exception
{
	private String message;
	public InsufficientBalanceException() {
		this.message="";
	}
	public InsufficientBalanceException(String message) {
		this.message=message;
	}
	public String toString() {
		return "INSUFFICIENT BALANCE OOPS :"+this.message;
	}
}
class Account {
	private int balance;
	public Account(int balance) {
		this.balance=balance;
	}
	public void withdraw(int amount) throws InsufficientBalanceException {
		if (amount > this.balance) 
			throw new InsufficientBalanceException("balance nill");
		this.balance-=amount;
		System.out.println(this.balance);
		

	}

}

public class TestAccount {

	public static void main(String[] args) {
		Account a= new Account(50);
		try {
		a.withdraw(500);
		}
		catch(InsufficientBalanceException e) 
		{ 
			e.printStackTrace(); 
		}

	}

}
