package com.zz.template;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zz.entity.Employee;

public class PromoteDepC extends PromoteTemplate {

	@Override
	public List<Employee> promote(List<Employee> employeeList) {
		Date currDate = new Date();
		List<Employee> proList = new ArrayList<>();
		for(Employee e : employeeList) {
			if(e.getDepartmentId().equals("C")) {
				int day = (int) ((currDate.getTime()-e.getPromoteTime().getTime()) / (1000*60*60*24));
				if(day > 730) {
					proList.add(e);
				}
			}			
		}
		return proList;
	}

}
