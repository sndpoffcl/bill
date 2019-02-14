package com.cg.lambdastream.util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cg.lambdastream.beans.*;

public class EmployeeRepository {
	public static HashMap<Integer, Employee> employees = new HashMap<>();

	public EmployeeRepository() {
		EmployeeRepository.employees.put(101, new Employee(101, 901, "Omkar", "L", "vl@gmail.com", "9875423525","Developer", LocalDate.of(2017, 11, 6), 20000, new Department(900, 901, "DFS")));
		EmployeeRepository.employees.put(102, new Employee(102, 901, "Ramesh", "H", "rh@gmail.com", "9034525431","Developer", LocalDate.of(2017, 10, 9), 20000, new Department(900, 901, "DFS")));
		EmployeeRepository.employees.put(103, new Employee(103, 901, "Kaustubh", "K", "kk@gmail.com", "9875433525","Developer", LocalDate.of(2017, 12, 9), 20000, new Department(900, 901, "DFS")));
		EmployeeRepository.employees.put(201, new Employee(201, 801, "Mahesh", "C", "mc@gmail.com", "989223525","Senior", LocalDate.of(2017, 5, 8), 15000, new Department(800, 801, "UTD")));
		EmployeeRepository.employees.put(501, new Employee(501, 0, "Amar", "T", "at@gmail.com", "90323521","Tester", LocalDate.of(2017, 3, 1), 20000, new Department(0, 0, "")));
		EmployeeRepository.employees.put(503, new Employee(503, 0, "Kaustubh", "P", "kp@gmail.com", "987549821","Developer", LocalDate.of(2017, 2, 17), 20000, new Department(0, 0, "")));
		EmployeeRepository.employees.put(504, new Employee(504, 0, "Vishal", "D", "bc@gmail.com", "989223525","Senior", LocalDate.of(2017, 5, 8), 15000, new Department(0, 0, "")));
		EmployeeRepository.employees.put(1, new Employee(0, 901, "", "", "", "","", LocalDate.of(1,1,1), 0, new Department(900, 901, "DFS")));
		EmployeeRepository.employees.put(2, new Employee(0, 901, "", "", "", "","", LocalDate.of(1, 1, 1), 0, new Department(900, 901, "DFS")));
		EmployeeRepository.employees.put(3, new Employee(0, 801, "", "", "", "","", LocalDate.of(1, 1, 1), 0, new Department(800, 801, "UTD")));
	}

	public static HashMap<Integer, Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(HashMap<Integer, Employee> employees) {
		EmployeeRepository.employees = employees;
	}
}