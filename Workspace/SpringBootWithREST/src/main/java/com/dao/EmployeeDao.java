package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	DataSource ds;
	public Employee getEmployeeInfo(int id) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = 
			con.prepareStatement("select * from employee where id =?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				return emp;
			}
		} catch (Exception e) {	
			
			System.out.println(e);
		}
		return null;
	}
	
	public int storeEmployeeInfo(Employee emp) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = 
		con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2,emp.getName());
			pstmt.setFloat(3,emp.getSalary());
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {	}
		return 0;
	}
	
	public int updateEmployeeInfo(Employee emp) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = 
		con.prepareStatement("update employee set salary = salary +? where id = ?");
			pstmt.setFloat(1, emp.getSalary());
			pstmt.setInt(2,emp.getId());
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {	}
		return 0;
	}
	
	public int deleteEmployeeInfo(int id) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = 
		con.prepareStatement("delete from employee where id = ?");
			pstmt.setInt(1,id);
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {	}
		return 0;
	}
}
