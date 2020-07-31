package com.dollarsbank.dao;

import java.util.List;

import com.dollarsbank.model.Customer;

public interface CustomerDao
{
	public int update(Customer e);
	public int delete(int id);
	public int save(Customer e);
	
	public Customer getCustomerById(int id);
	
	public List<Customer> getAllCustomers();
}
