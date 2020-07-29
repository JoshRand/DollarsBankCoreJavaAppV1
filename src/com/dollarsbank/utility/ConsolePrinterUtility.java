package com.dollarsbank.utility;

import com.dollarsbank.model.Customer;

public class ConsolePrinterUtility
{
	ColorsUtility cu = new ColorsUtility();
	public void welcome()
	{
		System.out.println(cu.BLUE_BRIGHT + "+----------------------------+");
		System.out.println("|  DOLLARSBANK Welcomes You! |");
		System.out.println("+----------------------------+" + cu.RESET);
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit.");
		System.out.println();
		enterChoice(3);
		//System.out.println("Enter Choice (1,2, or 3) :");
		
	}
	public void login()
	{
		
		System.out.println(cu.BLUE_BRIGHT + "+----------------------+");
		System.out.println("|  Enter Login Details |");
		System.out.println("+----------------------+" + cu.RESET);
		
	}
	public void welcomeCust()
	{
		System.out.println(cu.BLUE_BRIGHT + "+----------------------+");
		System.out.println("|  WELCOME Customer!!! |");
		System.out.println("+----------------------+" + cu.RESET);
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer.");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Generate Bank Account Stub");
		System.out.println("7. Sign Out");
		System.out.println();
		enterChoice(7);
		//System.out.println("Enter Choice (1,2,3,4,5 or 6) :");
		
	}
	public void recentTrans()
	{
		System.out.println(cu.BLUE_BRIGHT + "+------------------------+");
		System.out.println("| 5 Recent Transactions: |");
		System.out.println("+------------------------+" + cu.RESET);
	}
	public void invalidCreds()
	{
		System.out.println(cu.RED_BRIGHT +  "Invalid Credentials. Try Again!"  + cu.RESET);
	}
	public void invalidOption()
	{
		System.out.println(cu.RED_BRIGHT + "Invalid Option, please choose from the list..." + cu.RESET);
	}
	public void enterChoice(int num)
	{
		System.out.print(cu.GREEN_BRIGHT + "Enter Choice (");
		for(int i = 0; i <= num - 2 ; i++)
		{
			if(i <= num - 3) 
			{
				System.out.printf("%d,",i + 1);
			}
			else
			{
				System.out.printf("%d or %d", i+1, i+2);
			}
		}
		
		System.out.print(") :" + cu.RESET);
		System.out.println();
	}
	public void displayCustomerInfo(Customer cust)
	{
		System.out.println(cu.YELLOW_BRIGHT + "+----------------------+");
		System.out.println("|   Customer Details   |");
		System.out.println("+----------------------+" );
		System.out.println("+-----  ACCOUNT   -----+ ");
		System.out.println("     ID: " + cust.getUserId());
		System.out.println("   PASS: " + cust.getPassword());
		System.out.println("BALANCE: " + cust.getBalance());
		System.out.println("+-----  CUSTOMER  -----+");
		System.out.println("   NAME: " + cust.getCustName());
		System.out.println("ADDRESS: " + cust.getCustAddress());
		System.out.println("CONTACT: " + cust.getContactNumber() + cu.RESET);
		System.out.println();
		//System.out.println("Enter Choice (1,2,3,4,5 or 6) :");
		
	}
}

