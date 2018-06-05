package com.zz.dao;

import com.zz.entity.Employee;
import com.zz.entity.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("employeeMapper")
public interface EmployeeMapper {

	/**
	 * 查找所有符合升职条件的员工
	 * @return
	 */
	List<Employee> selectPro();
	
	/**
	 * 更新员工级别
	 * @param list	-	符合升职条件的员工列表
	 * @return
	 */
	int updateLevel(@Param("list") List<Employee> list);
	
	/**
	 * 查找所有员工
	 * @return
	 */
	List<Employee> selectAll();
	
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}