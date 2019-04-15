package com.joole.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joole.dao.UserDAO;
import com.joole.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User getUser(int id) {
		// TODO Auto-generated method stub
		User user = userDAO.getUser(id);
		return user;
	}
	
	

}
