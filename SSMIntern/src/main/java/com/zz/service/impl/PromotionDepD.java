package com.zz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zz.entity.Employee;
import com.zz.service.Promotion;

public class PromotionDepD implements Promotion  {

	@Override
	public List<Employee> Promote(List<Employee> employeeList) {
		Date currDate = new Date();
		List<Employee> proList = new ArrayList<>();
		for(Employee e : employeeList) {
			if(e.getDepartmentId().equals("D")) {
				int day = (int) ((currDate.getTime()-e.getPromoteTime().getTime()) / (1000*60*60*24));
				if(day > 1095) {
					proList.add(e);
				}
			}			
		}
		return proList;
	}

}
