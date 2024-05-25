package com.zmj.interfaces;

import com.zmj.bean.Employee;

public class FilterEmpByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() >= 30;
	}

}
