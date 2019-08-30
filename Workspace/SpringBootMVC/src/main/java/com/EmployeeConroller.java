package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployeeConroller {

	@RequestMapping(value = "sayHello",
	produces = MediaType.TEXT_PLAIN_VALUE,
	method = RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return "Welcome to Spring boot MVC with Rest";
	}
	@RequestMapping(value = "emp",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmpInfo() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Ravi");
		emp.setSalary(12000);
		return emp;
	}
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "empDb",
			produces = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getEmployeeDetails() {
			return employeeService.getEmployeeDetails();
	}
}
