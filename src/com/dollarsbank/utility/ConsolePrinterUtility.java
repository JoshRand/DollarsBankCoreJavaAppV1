package com.dollarsbank.utility;

public class ConsolePrinterUtility
{
	ColorsUtility cu = new ColorsUtility();
	public void welcome()
	{
		System.out.println("+----------------------------+");
		System.out.println("|  DOLLARSBANK Welcomes You! |");
		System.out.println("+----------------------------+");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit.");
		System.out.println();
		System.out.println("Enter Choice (1,2, or 3) :");
		
	}
	public void login()
	{
		System.out.println("+----------------------+");
		System.out.println("|  Enter Login Details |");
		System.out.println("+----------------------+");
		
	}
	public void welcomeCust()
	{
		System.out.println("+----------------------+");
		System.out.println("|  WELCOME Customer!!! |");
		System.out.println("+----------------------+");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer.");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
		System.out.println();
		System.out.println("Enter Choice (1,2,3,4,5 or 6) :");
		
	}
	public void recentTrans()
	{
		System.out.println("+------------------------+");
		System.out.println("| 5 Recent Transactions: |");
		System.out.println("+------------------------+");
	}
	public void invalidCreds()
	{
		System.out.println( "Invalid Credentials. Try Again!" );
	}
	public void invalidOption()
	{
		System.out.println("Invalid Option, please choose from the list...");
	}
	public void createAccount()
	{
		
	}
}

