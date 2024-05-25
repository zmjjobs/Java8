package com.zmj.interfaces;

import com.zmj.bean.Employee;

public class FilterEmpBySalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getSalary() >= 3000;
	}

}
