package com.cisco.prj.client;

import com.cisco.prj.entity.Account;

public class AccountClient {
		
	public static void main(String[] args) {
		Account rahulAcc = new Account(); // instance of Account, Object
		Account swethaAcc = new Account("SB120"); // instance of Account
		
		System.out.println(Account.getCount());
		
		rahulAcc.deposit(4500);
		swethaAcc.deposit(3000);
		
		rahulAcc.deposit(1500);
		
		System.out.println("Rahul Account Balance: " + rahulAcc.getBalance());
		System.out.println("Swetha Account Balance: " + swethaAcc.getBalance());
		
		Account a = new Account("SB123");
		Account b = new Account("SB123");
		Account c = a;
		
		if(a == b) {
			System.out.println("a and b are same");
		}
		if(a == c) {
			System.out.println("a and c are same");
		}
		
		if(a.equals(b)) {
			System.out.println("a and b have same content!!!");
		}
		
		System.out.println(Account.getCount());
		
		 
	}

}
