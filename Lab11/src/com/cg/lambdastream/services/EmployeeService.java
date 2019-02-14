package com.cg.lambdastream.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cg.lambdastream.beans.Employee;
import com.cg.lambdastream.util.EmployeeRepository;

public class EmployeeService {
	EmployeeRepository repository = new EmployeeRepository();

	public double totalSal() {
		double total = 0;
		for (Employee employee : EmployeeRepository.employees.values())
			total += employee.getSalary();
		return total;
	}

	public void departmentInfo() {
		Set<String> deps = new HashSet<>();
		List<String> depList = new ArrayList<>();
		// dep names
		for (Employee employee : EmployeeRepository.employees.values())
			deps.add(employee.getDepartment().getDepartmentName());
		// count
		for (Employee employee : EmployeeRepository.employees.values()) {
			depList.add(employee.getDepartment().getDepartmentName());
		}
		int temp = 0;
		for (String string : deps) {
			for (String str : depList)
				if (string.equals(str))
					temp++;
			System.out.println("Department " + string + ": " + temp);
			temp = 0;
		}
	}

	public void empWithoutDep() {
		for (Employee employee : EmployeeRepository.employees.values())
			if (employee.getDepartment().getDepartmentId() == 0)
				System.out.println(employee.toString());
	}

	public void depWithoutEmp() {
		for (Employee employee : EmployeeRepository.employees.values())
			if (employee.getDepartment().getDepartmentId() != 0 && employee.getEmployeeId() == 0)
				System.out.println(employee.getDepartment().toString());
	}

	public void highestEmpDep() {
		Set<String> deps = new HashSet<>();
		List<String> depList = new ArrayList<>();
		// dep names
		for (Employee employee : EmployeeRepository.employees.values())
			deps.add(employee.getDepartment().getDepartmentName());
		// count
		for (Employee employee : EmployeeRepository.employees.values()) {
			if(employee.getEmployeeId()!=0)
				depList.add(employee.getDepartment().getDepartmentName());
		}
		int temp = 0,big=0;String dep = "";
		for (String string : deps) {
			for (String str : depList)
				if (string.equals(str))
					temp++;
			if(temp>big) {
				big=temp;
				dep=string;
			}
			temp = 0;
		}
		System.out.println(dep+" Department with "+big+" employees");
	}
}