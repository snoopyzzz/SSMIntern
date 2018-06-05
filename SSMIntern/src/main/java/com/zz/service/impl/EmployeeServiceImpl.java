package com.zz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zz.dao.EmployeeMapper;
import com.zz.entity.Employee;
import com.zz.entity.EmployeeExample;
import com.zz.service.EmployeeService;
import com.zz.template.MyTemplate;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> selectAll() {
		return employeeMapper.selectAll();
	}

	@Override
	public List<Employee> selectByExample(EmployeeExample example) {
		return employeeMapper.selectByExample(example);
	}

	@Override
	public List<Employee> selectAllPromoteEmployee() {	
		return employeeMapper.selectPro();
	}
	
	@Override
	public List<Employee> selectAllPromoteEmployeeByFactory() {
		PromoteFactory promoteFactory = new PromoteFactory();
		return promoteFactory.Promote(selectAll());
	}
	
	@Override
	public List<Employee> selectAllPromoteEmployeeByTemplate() {
		MyTemplate template = new MyTemplate();
		return template.Promote(selectAll());
	}
	
	@Override
	public int updateLevel(List<Employee> list) {
		return employeeMapper.updateLevel(list);
	}

	@Scheduled(cron = "0 0 1 * * ?")		//每天早上01:00执行一次
	@Override
	public void scheduledUpdateEmpLevel() {
		if(!selectAllPromoteEmployee().isEmpty()) {		//一条sql
			updateLevel(selectAllPromoteEmployee());
		}
//		if(!selectAllPromoteEmployeeByFactory().isEmpty()) {		//工厂模式
//			updateLevel(selectAllPromoteEmployeeByFactory());
//		}
//		
//		if(!selectAllPromoteEmployeeByTemplate().isEmpty()) {		//模板模式
//			updateLevel(selectAllPromoteEmployeeByTemplate());
//		}
	}



}
