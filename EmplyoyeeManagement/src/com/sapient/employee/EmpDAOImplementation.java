package com.sapient.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class EmpDAOImplementation implements EmpDAO {

	private Connection con ;
	
	public void initconfig()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Sapient123");
		} 
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	@Override
	public Emp getEmp(String emp_id)
	{
		try
		{
			int id = Integer.parseInt(emp_id);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee where emp_id = "+id);
			Emp e = new Emp();
			while(rs.next())
			{
				System.out.println("Hahaha");
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setProject(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setPsw(rs.getString(5));
				e.setRole(rs.getString(6));
				return e;
			}
			return e;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public boolean loginCheck(int emp_id,String password)
	{
		try
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String dpass = rs.getString(5);
				if(id == emp_id && dpass.equals(password))
				{
					if(rs.getString(6).equals("admin"))
					{		
						return true;
					}
					return false;
				}
			}
			return false;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public boolean initEmp(Emp e) {
		try
		{
			
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee where emp_id ="+e.getId());
			if(rs.next())
			{
				int emp_id = rs.getInt(1);
				if(emp_id == e.getId() )
					return false;
			}
			PreparedStatement pstmt= con.prepareStatement("Insert into Employee values(?,?,?,?,?,?)");
			pstmt.setInt(1,e.getId());
			pstmt.setString(2,e.getName());
			pstmt.setString(3,e.getProject());
			pstmt.setInt(4,e.getAge());
			pstmt.setString(5,e.getPsw());
			pstmt.setString(6,e.getRole());
			pstmt.execute();
			System.out.println("Done "+e.getName());
			pstmt.close();
			return true;

		}
		catch (Exception exception)
		{
			System.out.println(exception);
		}
		return false;
	}

	@Override
	public boolean updateEmp(Emp e) {
		try {
			
			PreparedStatement stmt = con.prepareStatement("Update Employee set emp_name=? where emp_id=?");
			stmt.setString(1,e.getName());
			stmt.setInt(2,e.getId());
			stmt.executeUpdate();
			stmt = con.prepareStatement("Update Employee set emp_age=? where emp_id=?");
			stmt.setInt(1,e.getAge());
			stmt.setInt(2,e.getId());
			stmt.executeUpdate();
			stmt = con.prepareStatement("Update Employee set emp_project=? where emp_id=?");
			stmt.setString(1,e.getProject());
			stmt.setInt(2,e.getId());
			stmt.executeUpdate();
			stmt = con.prepareStatement("Update Employee set role=? where emp_id=?");
			stmt.setString(1,e.getRole());
			stmt.setInt(2,e.getId());
			stmt.executeUpdate();
			
			
			return true;
		} 
		catch (Exception ex) {
			System.out.println(ex);
		}
		
		return false;
		
	}

	@Override
	public ArrayList<Emp> getEmp() {
		ArrayList<Emp> list = new ArrayList<Emp>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Employee ");
			
			while(rs.next())
			{
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setProject(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setPsw(rs.getString(5));
				e.setRole(rs.getString(6));
				list.add(e);
			}
		} 
		catch (Exception ex) {
			System.out.println(ex);
		}
		return list;
	}

	@Override
	public void deleteEmp(String id) {
		try {
			int emp_id = Integer.parseInt(id);
			Statement stmt = con.createStatement();
			stmt.execute("Delete from Employee where emp_id="+emp_id);
		} 
		catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}
	
	
	

}
