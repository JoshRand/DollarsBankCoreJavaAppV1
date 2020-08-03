package com.dollarsbank.dao;

import java.util.List;

import com.dollarsbank.model.Customer;

public interface CustomerDao
{
	public int updateBalance(String userId, double balance) ;
	public int delete(int id);
	public int save(Customer e);
	public void saveHistory(String userId, String historyMessage);
	public Customer getCustomerById(int id);
	public List<String> getHistory(String userId);
	public List<Customer> getAllAccounts();
}
