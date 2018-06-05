package com.zz.service;

import java.util.List;

import com.zz.entity.Employee;

public interface Promotion {
	
	/**
	 * 查找符合升职条件的员工
	 * @param employeeList - 所有员工
	 * @return
	 */
	List<Employee> Promote(List<Employee> employeeList);
}
