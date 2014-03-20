package com.github.lejingw.myshiro.service;

import java.util.List;

import com.github.lejingw.myshiro.entity.User;

public interface UserService {

	User findByUsername(String username);

	List<String> findRoles(String username);

	List<String> findPermissions(String username);

}
