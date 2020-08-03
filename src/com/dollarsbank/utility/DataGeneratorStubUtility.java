package com.dollarsbank.utility;

import java.util.List;

import com.dollarsbank.model.Customer;

public class DataGeneratorStubUtility
{
	public static FileStorageUtility fsu = new FileStorageUtility();
	
	public boolean generateStub(Customer cust)
	{
		String stubMessageHeader = "|_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_|\n|_|\n"
				+ "|_| Bank Stub\n"
				+ "|_|          ID: " + cust.getUserId()+"\n"
				+ "|_|        Name: " + cust.getCustName() + "\n"
				+ "|_|     Balance: " + cust.getBalance() + "\n"
				+ "|_|     Address: " + cust.getCustAddress()+ "\n"
			    + "|_|     Contact: " + cust.getContactNumber()+ "\n|_|\n"
				+ "|_|--------------------------------------------------------------------------------------\n|_|\n"
				+ "|_| Recent Transactions\n";
		
		String stubMessageBody = transHistoryBody(cust.getHistory());
		
		String stubMessageFooter = "|_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_|\n";
		fsu.saveFile(cust.getUserId(),stubMessageHeader+stubMessageBody+stubMessageFooter);
		
		
		return false;
	}
	public String transHistoryBody(List<String> history)
	{
		String transHistoryBodyMessage = "";
		for (String string : history)
		{
			transHistoryBodyMessage += "|_| " + string.replace("\n", "") + "\n"; 
		}
		transHistoryBodyMessage+="|_|\n";
		return transHistoryBodyMessage;
	}
}
