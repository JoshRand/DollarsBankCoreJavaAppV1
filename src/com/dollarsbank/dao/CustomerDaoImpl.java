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
			System.out.println("trying to connect");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");//
			System.out.println("Connection working");
			return conn;
		}
		catch(Exception e) 
		{
			
		}
		return conn;
		
		
	}

	@Override
	public int update(Customer cust) 
	{

		//int id = e.getCustomerId();
		List<Customer> list = new ArrayList<Customer>();
		//list = getAllCustomer();
		//try {
			Connection conn = getConnection();

			//PreparedStatement pst = conn.prepareStatement("update usercrud set name=?, email=?, pass=?, cou=? where id="+id);
//
//			pst.setString(1, e.geteName());
//			pst.setString(3, e.getPassword());	
//			pst.setString(2, e.getEmail());
//			pst.setString(4, e.getCountry());

			//pst.executeUpdate();

			System.out.println("updated to database");
//		} catch (SQLException e1) {
//	
//			e1.printStackTrace();
//			
//		}
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
			PreparedStatement pst = conn.prepareStatement("insert into usercrud(id,name,email,pass,cou)values(?,?,?,?,?)");
//			pst.setInt(1, e.getEmpId());	
//			pst.setString(2, e.geteName());	
//			pst.setString(3, e.getPassword());
//			pst.setString(4, e.getEmail());
//			pst.setString(5, e.getCountry());
			
			pst.executeUpdate();
			System.out.println("saved to database");
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
	            Connection con= CustomerDaoImpl.getConnection();  
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
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from usercrud");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{	
				System.out.println("adding employee to list");
				//list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
