package com.dollarsbank.model;

import java.time.LocalDateTime;

public class Customer extends SavingsAccount
{
	private String custName;
	private String custAddress;
	private String contactNumber;
	LocalDateTime ldt = LocalDateTime.now();
	public Customer(String custName, String custAddress, String contactNumber, String userId, String password, double amount)
	{
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.contactNumber = contactNumber;
		setUserId(userId);
		setPassword(password);
		deposit(amount);
		addToHistory("Initial Deposit Amount in account ["+userId+"]\n"
				+ "Balance - " + amount + " as of " + ldt);
	}
	public Customer()
	{
		super(); 
	}
	
	//TODO: Fix toString
//	public String toString()
//	{
//		
//		return "Customer [custName=" + custName + ", custAddress=" + custAddress + ", contactNumber=" + contactNumber
//				+ "]"+ "{Account info [[ UserId= "+getUserId()+" " +"UserPass= " +getPassword()+ "]]  }";
//	}
	public String accountDetails()
	{
		return "Customer [custName=" + custName ;// ", custAddress=" + custAddress + ", contactNumber=" + contactNumber
			//+ "]"+ "{Account info [[ UserId= "+getUserId()+" " +"UserPass= " +getPassword()+ "]]  }";
	}
	public String getCustName()
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	public String getCustAddress()
	{
		return custAddress;
	}
	public void setCustAddress(String custAddress)
	{
		this.custAddress = custAddress;
	}
	public String getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}
	
	
	
	
}
