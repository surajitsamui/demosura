/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.service;
import com.javainuse.model.Employee;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
/**
 *
 * @author surajit.samui
 */
@Component
public class EmployeeServiceMockImpl implements EmployeeService {

	private List<Employee> testEmployees = new ArrayList<Employee>();

	// populate the Employee List
	public EmployeeServiceMockImpl() {
		testEmployees.add(new Employee("1", "emp1", "M1", 10000));
		testEmployees.add(new Employee("2", "emp2", "M2", 20000));
		testEmployees.add(new Employee("3", "emp3", "M3", 30000));
		testEmployees.add(new Employee("4", "emp4", "M4", 40000));
		testEmployees.add(new Employee("5", "emp5", "M5", 50000));
		testEmployees.add(new Employee("6", "emp6", "M6", 60000));
	}

	// Return the Mocked Employee List
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(testEmployees);
	}
}