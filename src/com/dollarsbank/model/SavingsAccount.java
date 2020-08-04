package com.dollarsbank.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.dao.CustomerDao;
import com.dollarsbank.dao.CustomerDaoImpl;

public class SavingsAccount extends Account
{
	private LocalDateTime ldt = LocalDateTime.now();
	private double balance;
	private String userId;
	private String password;
	CustomerDaoImpl customerDao = new CustomerDaoImpl();

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
		ldt = LocalDateTime.now();
		//with collecitons
		if(customerDao.getHistory(getUserId()).size() == 0)
		{
			balance += amount;
		}
		else
		{
		balance += amount;
		addToHistory("Deposited " + amount + " into account ["+userId+"]\n"
			+ "Balance - " + balance + " as of " +ldt.getDayOfWeek()+" "
			+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
			+" " +" "+ldt.getYear());
		
		}
		
		
	}

	@Override
	public void withdraw(double amount)
	{
		ldt = LocalDateTime.now();
		balance -= amount;
		addToHistory("Withdrawn " + amount + " out of account ["+userId+"]\n"
				+ "Balance - " + balance + " as of " +ldt.getDayOfWeek()+" "
				+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
				+" " +" "+ldt.getYear());
		
	}
	@Override
	public double transfer(double amount, String receiverId)
	{
		ldt = LocalDateTime.now();
		balance -= amount;
		addToHistory("Transfered " + amount + " into account ["+receiverId+"]\n"
				+ "as of " +ldt.getDayOfWeek()+" "
				+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
				+" " +" "+ldt.getYear());
		return amount;
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


	@Override
	public List<String> getHistory()
	{
		List<String> list = customerDao.getHistory(userId);
		List<String> transactionHistory = new ArrayList<String>();
		
		int count = list.size();
		int skipCount = 0;
		if(count >= 5)
		{
			skipCount = count - 5;
		}
		for (String string : list)
		{
			if(skipCount > 0)
			{
				
				skipCount--;
				continue;
			}
			transactionHistory.add(string);
			
		}
		return transactionHistory;
	}
	
	@Override
	public void printHistory()
	{
		List<String> list = customerDao.getHistory(userId);
		List<String> transactionHistory = new ArrayList<String>();
		//System.out.println(list.toString());
		int count = list.size();
		int skipCount = 0;
		if(count >= 5)
		{
			skipCount = count - 5;
		}
		for (String string : list)
		{
			if(skipCount > 0)
			{
				skipCount--;
				continue;
			}
			System.out.println(string);
		}
	}
	

	@Override
	public void addToHistory(String historyMessage)
	{
		
		
		if(transactionHistory.size() == 5)
		{
			//transactionHistory.remove(0);
			//Without Database
			//transactionHistory.add(historyMessage);
			customerDao.saveHistory(userId,historyMessage);
			
		}
		else
		{
			//transactionHistory.add(historyMessage);
			customerDao.saveHistory(userId,historyMessage);
		}
		
		
	}

	
	
}
