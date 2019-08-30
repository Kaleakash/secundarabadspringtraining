package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="empInfoById/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
		public Employee getEmployeeById(@PathVariable("id") int id) {
		System.out.println(" I Cam Here "+id);
		return employeeService.getEmployeeInfo(id);
	}

	@RequestMapping(value="storeEmpInfo",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method =RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeEmployeeInfo(@RequestBody Employee emp ) {
	System.out.println(" Post method");
		return employeeService.storeEmployeeInfo(emp);
	}
	
	@RequestMapping(value="updateEmpInfo",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method =RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateEmployeeInfo(@RequestBody Employee emp ) {
	System.out.println(" put method");
		return employeeService.updateEmployeeInfo(emp);
	}
	
	@RequestMapping(value="deleteEmpInfo/{id}",
			produces = MediaType.TEXT_PLAIN_VALUE,
			method =RequestMethod.DELETE)
	public String deleteEmployeeInfo(@PathVariable("id") int id) {
	System.out.println(" delete method");
		return employeeService.deleteEmployeeInfo(id);
	}
}