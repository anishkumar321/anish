package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Account {
	int id;
	String name;
	int balance;
	public Account(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}
public class TestStream {

	public static void main(String[] args) {
		List<Account> list=new ArrayList<Account>();
		list.add(new Account(52,"Anish",60000));
		list.add(new Account(35,"Rajesh",35000));
		list.add(new Account(51,"Rahul",50000));
		list.add(new Account(42,"Manish",45000));
		list.stream().filter((Account a)->
		{if (a.getBalance()>48000)
			return true;
		else
			return false;}).sorted(Comparator.comparing(Account::getBalance)).forEach(System.out::println);
	}

}
