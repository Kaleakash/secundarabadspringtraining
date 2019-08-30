package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	DataSource ds;
	
	public List<Employee> getEmployeeDetails() {
		List<Employee> listOfRec = new ArrayList<Employee>();
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				listOfRec.add(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfRec;
	}
	
}
