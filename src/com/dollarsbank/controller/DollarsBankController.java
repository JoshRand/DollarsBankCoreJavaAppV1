package com.dollarsbank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InitialDirContext;

import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankController
{
	//Without a database using Static list/block to instantiate some users and init deposits
	public static List<Customer> list = new ArrayList<Customer>();
	static {
		list.add(new Customer("Josh", "4003 Valley Green ct"
				, "832-409-9637", "a", "a", 30.2));
		list.add(new Customer("mark", "Somewhere in AZ"
				, "832-222-5555", "b", "b", 302222.2));
	}
	int option = 0;
	//Helps display Sysout console prompts
	public static ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	Scanner scan = new Scanner(System.in);

	public Boolean run()
	{

		cpu.welcome();
		option = 0;
		try 
		{
			//Use scan.nextLine after int to eat up leftover data
			option = scan.nextInt();
			scan.nextLine();
			
		}catch(InputMismatchException mis)
		{
			scan.nextLine();
			cpu.invalidOption();
		}
		
		switch (option)
		{
			case 1:
				createAccount();
				scan.reset();
				break;
			case 2:
				login();
				scan.reset();
				break;
			case 3:
				exit();
				
				break;
			default:
	
				break;
		}

		System.out.flush();

		return true;
	}

	public void createAccount()
	{

		String name = "";
		String address = "";
		String contactNumber = "";
		String userId = "";
		String password = "";
		double initalDeposit = 0;

		cpu.createAccount();
		try
		{
			//TODO: prevent creating multiple customers with same user id
			
			System.out.println("Customer Name: ");

			scan.hasNextLine();
			name = scan.nextLine();
			System.out.println("Customer Addresss: ");

			address = scan.nextLine();
			System.out.println("Customer Contact Number: ");
			contactNumber = scan.nextLine();
			System.out.println("User Id: ");
			userId = scan.nextLine();
			System.out.println("Password: 8 Characters with Lower, Upper & special");
			password = scan.nextLine();
			System.out.println("Initial Deposit Amount: ");
			initalDeposit = scan.nextDouble();
			scan.nextLine();
			// Database
			// custDao.addCustomer(new
			// Customer(name,address,contactNumber,userId,password,initalDeposit));
			// ArrayList Collection
			list.add(new Customer(name, address, contactNumber, userId, password, initalDeposit));
			// list..toString();
			System.out.println(list.toString());
		} catch (InputMismatchException ime)
		{

		}
		System.out.println(list.get(0).getCustName());

	}

	public void login()
	{
		String userId = "";
		String password = "";
		boolean logout=false;
		int iterator = 0;
		cpu.login();
		System.out.println("User Id: ");
		userId = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();

		for (Customer customer : list)
		{
			if (customer.getUserId().equalsIgnoreCase(userId) && customer.getPassword().equalsIgnoreCase(password))
			{
				loginSuccess(iterator);
				logout = true;
				break;
			}
			iterator++;
		}
		if(logout)
		{
			
		}
		else
		{
			cpu.invalidCreds();
			System.out.println();
			login();
		}
		
	}

	public void loginSuccess(int iterator)
	{
		boolean signOut = false;
		double amount = 0;
		int loginOption = 0;
		list.get(iterator).toString();
		while(!signOut)
		{
			
			cpu.welcomeCust();
			try {
				loginOption = scan.nextInt();
				scan.nextLine();
				//System.out.println(loginOption);
			}catch (InputMismatchException e) {
				scan.nextLine();
				loginOption = 0;
				cpu.invalidOption();
				
			}
			switch (loginOption)
			{
				case 1:
					//Deposit
					System.out.println("How much would you like to deposit? :");
					try {
						amount = scan.nextDouble();
						scan.nextLine();
						if(amount >= 0)
						{
							list.get(iterator).deposit(amount);
							System.out.println("Deposit successful, your current balance is: " + list.get(iterator).getBalance());
							
						}
						else
						{
							System.out.println("Invalid input, please insert 0-> (Big Number)");
						}
					}catch (InputMismatchException inMisExcDepo) {
						scan.nextLine();
					}
				
					break;
				case 2:
					//withdraw
					System.out.println("How much would you like to withdraw? :");
					try {
						amount = scan.nextDouble();
						scan.nextLine();
						if(amount >= 0 && amount <= list.get(iterator).getBalance())
						{
							list.get(iterator).withdraw(amount);
							System.out.println("Withdraw successful, your current balance is: " + list.get(iterator).getBalance());
							
						}
						else
						{
							System.out.println("Invalid input, please insert 0-> (Funds you have)\n"
									+ "your total funds =["+list.get(iterator).getBalance());
						}
					}catch (InputMismatchException inMisExcWithdrawl) {
						scan.nextLine();
					}
					break;
				case 3:
					int transferCount = 0;
					int listPos = 0;
					boolean transferable = false;
					String userId = "";
					//funds transfer  EX: from a to b, or b to a
					System.out.println("Who are you wanting to transfer with? User Id: ");
					try {
						userId = scan.nextLine().toLowerCase();
						for (Customer customer : list)
						{
							if(customer.getUserId().contentEquals(userId))
							{
								transferable = true;
								listPos = transferCount ;
							}
							transferCount++;
						}
						if(!transferable)
						{
	
							System.out.println("User doesn't exist! ");
							break;
							
						}
						System.out.println("How much are you transfering to " + userId);
						amount = scan.nextDouble();
						scan.nextLine();
						if(amount >= 0 && amount <= list.get(iterator).getBalance())
						{
							list.get(listPos).deposit(list.get(iterator).transfer(amount,list.get(listPos).getUserId()));
							System.out.println("Transfer successful, your current balance is: " + list.get(iterator).getBalance());
							
						}
						else
						{
							System.out.println("Invalid input, please insert 0-> (Funds you have)\n"
									+ "your total funds =["+list.get(iterator).getBalance());
						}
					}catch(InputMismatchException inMisExc)
					{
						scan.nextLine();
					}
					
					break;
				case 4:
					list.get(iterator).printHistory();
					break;
				case 5:
					list.get(iterator).accountDetails();
					System.out.println("HI");
					break;
				case 6:
					signOut=true;
					break;
					
				default:
					
					break;
			}
		}
	}

	public void exit()
	{
		System.exit(0);
	}

}
