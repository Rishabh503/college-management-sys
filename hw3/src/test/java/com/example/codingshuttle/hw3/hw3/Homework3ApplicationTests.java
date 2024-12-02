package com.example.codingshuttle.hw3.hw3;

import com.example.codingshuttle.hw3.hw3.clients.EmployeeClient;
import com.example.codingshuttle.hw3.hw3.entity.EmployeeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutorService;

@SpringBootTest
class Homework3ApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {
		List<EmployeeEntity> employeeServiceslist=employeeClient.getAllEmployees();
		System.out.println(employeeServiceslist);
//EmployeeEntity@48388dfb
	}
	@Test
	void getemp(){
		EmployeeEntity employee=employeeClient.getEmployeeById(2L);
		System.out.println(employee);
	}
}
