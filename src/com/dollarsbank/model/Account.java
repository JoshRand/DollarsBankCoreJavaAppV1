package com.dollarsbank.model;



public abstract class Account
{
	
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract double transfer(double amount, String receiverId);
	public abstract void printHistory();
	public abstract void addToHistory(String text);
	
	
	
}
