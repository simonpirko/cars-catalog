package com.carscatalog.service;

import com.carscatalog.entity.User;

public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user);
}
