package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
import com.bean.TrainerStudent;

@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager manager;
	
	public List<Employee> getEmployeeInfo(){
			Query qry = manager.createQuery("select e from Employee e");
			List<Employee> listOfEmp = qry.getResultList();
			return listOfEmp;
	}
	
	public List<TrainerStudent> getTrainerStudentInfo() {
		List<TrainerStudent> list = new ArrayList<TrainerStudent>();
		Query qry = 
manager.createNativeQuery("select t.tname,s.sname,s.age from trainer t, student s where t.tid = s.tsid");
		List<?> listOfRec = qry.getResultList();
		ListIterator<?> ll = listOfRec.listIterator();
		while(ll.hasNext()) {
			Object obj[]= (Object[])ll.next();
			TrainerStudent ts = new TrainerStudent();
			ts.setTname(String.valueOf(obj[0]));
			ts.setSname(String.valueOf(obj[1]));
			ts.setAge(Integer.parseInt(String.valueOf(obj[2])));
			list.add(ts);
		}
		return list;
	}
	
	/*@Autowired
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
	}*/
}
