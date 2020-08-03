package com.dollarsbank.model;

import java.time.LocalDateTime;

import com.dollarsbank.dao.CustomerDao;
import com.dollarsbank.dao.CustomerDaoImpl;

public class Customer extends SavingsAccount
{
	private String custName;
	private String custAddress;
	private String contactNumber;
	CustomerDaoImpl customerDao = new CustomerDaoImpl();
	LocalDateTime ldt = LocalDateTime.now();
	public Customer(String custName, String custAddress, String contactNumber, String userId, String password, double amount)
	{
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.contactNumber = contactNumber;
		setUserId(userId);
		setPassword(password);
		setBalance(amount);
		ldt = LocalDateTime.now();
		if(customerDao.getHistory(getUserId()).size() == 0) {
			addToHistory("Initial Deposit Amount in account ["+userId+"]\n"
					+ "Balance - " + amount + " as of "  +ldt.getDayOfWeek()+" "
					+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
					+" " +" "+ldt.getYear());
		}
			
	}
	public Customer()
	{
		super(); 
	}
	
	//TODO: Fix toString
	public String toString()
	{
		
		return "Customer [custName=" + custName + ", custAddress=" + custAddress + ", contactNumber=" + contactNumber
				+ "]"+ "{Account info [[ UserId= "+getUserId()+" " +"UserPass= " +getPassword()+ "]]  }";
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
