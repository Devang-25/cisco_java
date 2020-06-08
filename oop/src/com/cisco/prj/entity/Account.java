package com.cisco.prj.entity;

public class Account {
	private String accNo; // instance variable == > heap
	private double balance; // instance variable == > heap
	
	private static int count; // class variable ==> class data
	
	// default
	public Account() {
		this.accNo = "NA";
		count++;
	}
	
	// parametrized constructor
	public Account(String no) {
		this();
		this.accNo = no;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	@Override
	public boolean equals(Object obj) {
		 Account other = (Account) obj;
		 if(this.accNo.equals(other.accNo)) {
			 return true;
		 }
		 return false;
	}
	
	
	public static int getCount() {
		return count;
	}
}
