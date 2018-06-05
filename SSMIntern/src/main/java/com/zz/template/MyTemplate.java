package com.zz.template;

import java.util.ArrayList;
import java.util.List;

import com.zz.entity.Employee;

public class MyTemplate {
	PromoteTemplate templateDepA = new PromoteDepA();
	PromoteTemplate templateDepB = new PromoteDepB();
	PromoteTemplate templateDepC = new PromoteDepC();
	PromoteTemplate templateDepD = new PromoteDepD();
	PromoteTemplate templateDepE = new PromoteDepE();
	
	public List<Employee> Promote(List<Employee> empList) {
		List<Employee> proList = new ArrayList<>();
		proList.addAll(templateDepA.promotion(empList));
		proList.addAll(templateDepB.promotion(empList));
		proList.addAll(templateDepC.promotion(empList));
		proList.addAll(templateDepD.promotion(empList));
		proList.addAll(templateDepE.promotion(empList));
		return proList;
	}
}
