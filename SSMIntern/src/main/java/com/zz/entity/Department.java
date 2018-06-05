package com.zz.entity;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8604607393930935043L;

	private String id;

    private String address;

    private String name;
    
    private List<Employee> userList;
    
    public List<Employee> getUserList() {
		return userList;
	}

	public void setUserList(List<Employee> userList) {
		this.userList = userList;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}