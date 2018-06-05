package com.zz.service;

import java.util.List;

import com.zz.entity.Employee;
import com.zz.entity.EmployeeExample;

public interface EmployeeService {
	
	/**
	 * 查找所有员工
	 * @return
	 */
	List<Employee> selectAll();
	
	/**
	 * 根据example条件复杂查找
	 * @param example
	 * @return
	 */
	List<Employee> selectByExample(EmployeeExample example);
	
	/**
	 * 查找全部部门符合升职条件的人-by SQL
	 * @return	
	 */
	List<Employee> selectAllPromoteEmployee();		
	
	/**
	 * 查找全部部门符合升职条件的人-by Factory
	 * @return
	 */
	List<Employee> selectAllPromoteEmployeeByFactory();	
	
	/**
	 * 查找全部部门符合升职条件的人-by Template
	 * @return
	 */
	List<Employee> selectAllPromoteEmployeeByTemplate();
	
	/**
	 * 更新符合升职条件的员工的级别
	 * @param list	-	员工列表
	 * @return
	 */
	int updateLevel(List<Employee> list);
	
	/**
	 * 定时检查更新员工级别
	 */
	void scheduledUpdateEmpLevel();
}
