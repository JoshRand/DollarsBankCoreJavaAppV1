package com.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollarsbank.model.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	public static Connection getConnection() 
	{
		Connection conn = null;
		
		try 
		{
			//System.out.println("trying to connect");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bankdatabase?autoReconnect=true&useSSL=false","root","root" );//
			//System.out.println("Connection working");
			return conn;
		}
		catch(Exception e) 
		{
			
		}
		return conn;
		
		
	}

	@Override
	public int updateBalance(String userId, double balance) 
	{

		try {
			Connection conn = getConnection();

			PreparedStatement pst = conn.prepareStatement("update account_details set balance=? where user_name=" +"'"+ userId+"'");
			//System.out.println(balance);
			pst.setDouble(1, balance);
			pst.executeUpdate();
			//System.out.println("updated to database");
		} catch (SQLException e1) {
	
			e1.printStackTrace();
			
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("delete from usercrud where id=?");
			pst.setInt(1, id);
			status = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int save(Customer cust) {
		//create prepared statement
		try {
			Connection conn = getConnection();
			List<Customer> list = getAllAccounts();
			for (Customer customer : list)
			{
				if(cust.getUserId().equals(customer.getUserId()))
				{
					return 0;
				}
			}
			
			PreparedStatement pst = conn.prepareStatement("insert into account_details(name,address,number,user_name,password,balance)values(?,?,?,?,?,?)");
			pst.setString(1, cust.getCustName());	
			pst.setString(2, cust.getCustAddress());	
			pst.setString(3, cust.getContactNumber());
			pst.setString(4, cust.getUserId());
			pst.setString(5, cust.getPassword());
			pst.setDouble(6, cust.getBalance());
			
			pst.executeUpdate();
			//System.out.println("saved to database");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		return 0;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer e = new Customer();
		 try{  
	            Connection con = CustomerDaoImpl.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
//	                e.setEmpId(rs.getInt(1));  
//	                e.seteName(rs.getString(2));  
//	                e.setPassword(rs.getString(3));  
//	                e.setEmail(rs.getString(4));  
//	                e.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
		
	}

	@Override
	public List<Customer> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from account_details");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{	
				//System.out.println("adding employee to list");
				list.add(new Customer(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7)));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void saveHistory(String userId, String historyMessage)
	{
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("insert into accounthistory(userid,history)values(?,?)");
			pst.setString(1, userId);	
			pst.setString(2, historyMessage);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}

	@Override
	public List<String> getHistory(String userId)
	{
		List<String> list = new ArrayList<>();
		try {
		
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from accounthistory where userid='"+userId+"'");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			list.add(rs.getString(3));
		}
		//System.out.println("TestinglistHistory: "+list.toString());
		
		
		}catch (SQLException e) {
		
		}
		return list;
	}
}
