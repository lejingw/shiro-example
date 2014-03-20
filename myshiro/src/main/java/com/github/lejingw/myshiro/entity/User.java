package com.github.lejingw.myshiro.entity;

import java.util.List;


public class User {
    private Long id; //编号
    private Long organizationId; //所属公司
	private String username;
	private String password;
	private String salt;
    private List<Long> roleIds; //拥有的角色列表
	private boolean locked;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}