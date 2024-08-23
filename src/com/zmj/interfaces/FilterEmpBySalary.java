package com.zmj.interfaces;

import com.zmj.bean.Employee;
import com.zmj.interfaces.base.BaseCompare;

public class FilterEmpBySalary implements BaseCompare<Employee> {

	@Override
	public boolean compare(Employee t) {
		return t.getSalary() >= 3000;
	}

}
