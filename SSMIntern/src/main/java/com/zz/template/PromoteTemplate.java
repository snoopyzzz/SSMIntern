package com.zz.template;

import java.util.List;

import com.zz.entity.Employee;

public abstract class PromoteTemplate {
	
	/**
	 * 具体的整个过程	-	全部员工
	 * @param employeeList
	 * @return
	 */
	protected List<Employee> promotion(List<Employee> employeeList){
		return promote(employeeList);
	}
	
	/**
	 * 查找符合升职条件的员工
	 * @param employeeList		-	全部员工	
	 * @return
	 */
	public abstract List<Employee> promote(List<Employee> employeeList);
}
