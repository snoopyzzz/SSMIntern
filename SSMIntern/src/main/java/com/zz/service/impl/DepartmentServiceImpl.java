package com.zz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zz.dao.DepartmentMapper;
import com.zz.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Resource(name="departmentMapper")
	private DepartmentMapper departmentMapper;
	
	@Override
	public String selectDepNameById(String id) {	
		return departmentMapper.selectDepNameById(id);
	}

}
