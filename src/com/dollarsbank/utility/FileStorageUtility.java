package com.dollarsbank.utility;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import com.dollarsbank.model.Customer;

public class FileStorageUtility
{
	private int fileCount = 0;
	public boolean saveFile(String userId, String text)
	{
		++fileCount;
		try {
			String fileName = "BankStub-"+ userId + "-" + fileCount +".txt" ;
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				if(!writeFile(fileName,text))
					System.out.println("failed to write to file");
				
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		}
		
	}
	public boolean writeFile(String fileName, String text)
	{
		 try {
		      FileWriter myWriter = new FileWriter(fileName);
		      myWriter.write(text);
		      myWriter.close();
		      return true;
		    } catch (IOException e) {
		    	 return false;
		    }
		
	
	}
}
