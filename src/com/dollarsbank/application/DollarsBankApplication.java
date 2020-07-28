package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;

public class DollarsBankApplication
{

	
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DollarsBankController dollarsBankController = new DollarsBankController();
		Boolean run = true;
		while(run)
		{
			run = dollarsBankController.run();
			
		}
			
	}

}
