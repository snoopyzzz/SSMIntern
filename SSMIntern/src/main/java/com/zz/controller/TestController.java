package com.zz.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.entity.Employee;
import com.zz.entity.EmployeeExample;
import com.zz.service.DepartmentService;
import com.zz.service.EmployeeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class TestController {
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
    	
	//定时更新升职人员
//    @Scheduled(cron = "0 25 12 * * ?")		
//    public void PromoteTask() throws IOException {  
//        System.out.println("定时任务开启啦================================");
//    	List<Employee> promoteList = employeeService.selectAllPromoteEmployee();
//    	if(!promoteList.isEmpty()) {
//    		employeeService.updateLevel(promoteList);
//    		System.out.println("今天有人升职哦");
//    		//把升职的人员写进E:employee.dat
//    	      try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:employee.dat"))) 
//    	      {
//    	         out.writeObject(promoteList);
//    	      }
//    	}else {
//    		System.out.println("今天没人升职");
//    	}
//    }  
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/promote")
    @ResponseBody
    public Map<String,Object> promote() throws ClassNotFoundException, IOException{ 	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:employee.dat"))){
//			List<Employee> aemps = (List<Employee>) in.readObject();
//	        for (Employee e : aemps) {
//	        	System.out.println(e); 
//	        }
        	       	
			List<Employee> emps = new ArrayList<>();
			emps.addAll((List<Employee>) in.readObject());	//取出全部的升职过的人员的信息
	    	if(!emps.isEmpty()) {
	    		System.out.println("今天有人升职哦");  		
	    		map.put("promoteList", emps);
	    	}else {
	    		System.out.println("目前为止还没人升职");
	    		map.put("promoteList", "null");
	    	}
        }
		return map;
    }
    
    @RequestMapping(value = "/allEmp")
    @ResponseBody
    public String goToEmpByDepId(@RequestBody String id) {
    	System.out.println("您要查找的部门id是："+id);
    	return "employee/dep_id/"+id;
    }
    
    @RequestMapping(value = "/employee/dep_id/{id}", produces="application/json")
    public ModelAndView getAllEmp(@PathVariable String id) {
    	ModelAndView view = new ModelAndView();
    	EmployeeExample employeeExample = new EmployeeExample();
    	employeeExample.createCriteria().andDepartmentIdEqualTo(id);
    	employeeExample.setOrderByClause("level desc");
    	List<Employee> employeeList = employeeService.selectByExample(employeeExample);
    	//System.out.println(employeeList.get(0).getPromoteTime());
    	JSONArray jsonArray = JSONArray.fromObject(employeeList);
    	JSONObject obj = new JSONObject();
        obj.put("部门名称", departmentService.selectDepNameById(id));
        obj.put("部门编号", id);
        obj.put("员工", jsonArray);
    	System.out.println(obj);
    	view.addObject("emp", obj);
    	view.setViewName("employee");
    	return view;
     }

}
