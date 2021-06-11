package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Employee;

public class EmpDao {
	
	public Connection getCon() {
		String url = "jdbc:mysql://localhost:3306/cestar";
		String user  = "root";
		String password ="";
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection works!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public int insert(Employee emp) {
		Connection con = getCon();
		String sql = "insert into employees values(?,?,?,?,?)";
		int status = 0;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setString(3, emp.getCity());
			pstm.setString(4, emp.getContact());
			pstm.setString(5, emp.getEmail());
			status = pstm.executeUpdate();
			if (status > 0) {
				System.out.println("Record inserted!!");
				pstm.close();
				con.close();						
			}
			else
				System.out.println("Try again!");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	
	}
	
	public int insertRec(Employee e) {
		Connection con = getCon();
		String sql="insert into employees(id,name,city,contact,email) values (?,?,?,?,?)";
		int status =0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getName());
			pstmt.setString(3, e.getCity());
			pstmt.setString(4, e.getContact());
			pstmt.setString(5, e.getEmail());
			status = pstmt.executeUpdate();
			if (status >0) {
				System.out.println("Record inserted: "+status);
			}
			else
				System.out.println("Failed to insert!");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
		
	}
	
	
	public int deleteRec(int id) {
		Connection con = getCon();
		String sql = "delete from employees where id=?";
		int status = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
			if (status>0) {
				System.out.println("Record deleted: "+status);
			}
			else
				System.out.println("Delete Failed!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	public Employee getRecById(int id) {
		Connection con = getCon();
		String sql = "select * from employees where id=?";
//		int status = 0;
		Employee emp = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
//			status = pstmt.executeUpdate(); //for posting data
			ResultSet rs = pstmt.executeQuery(); //for getting data
			while(rs.next()) {
				emp = new Employee(rs.getInt(1), //id
						rs.getString(2), //name
						rs.getString(3), //city
						rs.getString(4), //contact
						rs.getString(5)); //email				
			}
			System.out.println(emp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}
	
	public int updateRec(int old_id, Employee new_emp) {
		Connection con = getCon();
		String sql = "update employees set id=?, name=?, city=?, contact=?, email=? where id=?";
		int status = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, new_emp.getId());
			pstmt.setNString(2, new_emp.getName());
			pstmt.setNString(3, new_emp.getCity());
			pstmt.setNString(4, new_emp.getContact());
			pstmt.setNString(5, new_emp.getEmail());
			pstmt.setInt(6,old_id);
			status = pstmt.executeUpdate();
			
			if (status>0) {
				System.out.println("Record updated: "+status);
			}
			else
				System.out.println("Update failed!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public List<Employee> displayAllRec(){
		Connection con = getCon();
		String sql ="select * from employees";
		
		List<Employee> emps = new ArrayList<Employee>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), //id
						rs.getString(2), //name
						rs.getString(3), //city
						rs.getString(4), //contact
						rs.getString(5)); //email
				emps.add(emp);
			}
			System.out.println(emps);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}
}
