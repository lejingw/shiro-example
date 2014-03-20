package com.github.lejingw.myshiro.service;

import java.util.List;
import java.util.Set;

import com.github.lejingw.myshiro.entity.User;

public interface UserService {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long userId);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	User findOne(Long userId);

	List<User> findAll();

	User findByUsername(String username);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);

}
