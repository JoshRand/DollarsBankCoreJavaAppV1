package com.dollarsbank.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account
{
	private LocalDateTime ldt = LocalDateTime.now();
	private double balance;
	private String userId;
	private String password;


	private List<String> transactionHistory = new ArrayList<String>();
	
	public SavingsAccount()
	{
		super();
		
	}

	public List<String> getTransactionHistory()
	{
		return transactionHistory;
	}
	
	public void setTransactionHistory(List<String> transactionHistory)
	{
		this.transactionHistory = transactionHistory;
	}
	@Override
	public void deposit(double amount)
	{
		if(transactionHistory.size()==0)
		{

		}
		else
		{
			addToHistory("Deposited " + amount + " into account ["+userId+"]\n"
				+ "Balance - " + balance + " as of " +ldt.getDayOfWeek()+" "
				+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
				+" " +" "+ldt.getYear());
		}
		balance += amount;
		
	}

	@Override
	public void withdraw(double amount)
	{
		addToHistory("Withdrawn " + amount + " out of account ["+userId+"]\n"
				+ "Balance - " + balance + " as of " +ldt.getDayOfWeek()+" "
				+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
				+" " +" "+ldt.getYear());
		balance -= amount;
		
	}
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public String getUserId()
	{
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

//	@Override
//	public String toString()
//	{
//		return "SavingsAccount [balance=" + balance + ", userId=" + userId + ", password=" + password + "]";
//	}

	@Override
	public double transfer(double amount, String receiverId)
	{
		
		addToHistory("Transfered " + amount + " into account ["+receiverId+"]\n"
				+ "as of" +ldt.getDayOfWeek()+" "
				+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
				+" " +" "+ldt.getYear());
		balance -= amount;
		return amount;
	}

	@Override
	public void printHistory()
	{
		for (String string : transactionHistory)
		{
			System.out.println(string);
		}
	}
	

	@Override
	public void addToHistory(String text)
	{
		
		
		if(transactionHistory.size() == 5)
		{
			transactionHistory.remove(0);
			transactionHistory.add(text+" as of " + ldt);
		}
		else
		{
			transactionHistory.add(text);
		}
		
		
	}

	
	
}
