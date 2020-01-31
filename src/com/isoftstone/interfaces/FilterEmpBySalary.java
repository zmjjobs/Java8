package com.isoftstone.interfaces;

import com.isoftstone.bean.Employee;

public class FilterEmpBySalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getSalary() >= 3000;
	}

}
