package com.zz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zz.entity.Employee;

public class PromoteFactory {
	
	public List<Employee> Promote(List<Employee> empList) {
		List<Employee> proList = new ArrayList<>();
		proList.addAll(new PromotionDepA().Promote(empList));
		proList.addAll(new PromotionDepB().Promote(empList));
		proList.addAll(new PromotionDepC().Promote(empList));
		proList.addAll(new PromotionDepD().Promote(empList));
		proList.addAll(new PromotionDepE().Promote(empList));
		return proList;
	}
}
