package com.isoftstone.interfaces;

import com.isoftstone.bean.Employee;

public class FilterEmpByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() >= 30;
	}

}
