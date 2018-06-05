package com.zz.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1670388485821760137L;

	private Integer id;

    private String name;

    private String phone;

    private Date entryTime;

    private Date promoteTime;

    private Integer level;

    private String departmentId;
    
    private Department department;
        
    
    
    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", entryTime=" + entryTime
				+ ", promoteTime=" + promoteTime + ", level=" + level + ", departmentId=" + departmentId
				+ ", department=" + department + "]";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getPromoteTime() {
        return promoteTime;
    }

    public void setPromoteTime(Date promoteTime) {
        this.promoteTime = promoteTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }
}