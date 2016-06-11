package com.us.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bs.entity.User;
import com.us.dao.UserRepository;

@Repository
@EnableTransactionManagement
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public int createUser(User user) {
		if(entityManager == null)
			System.out.println("EntityManager is not created");
		else
			System.out.println("EntityManager is created");
		return 0;
	}

	@Override
	public User getUserByUserId(int userId) {
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		return false;
	}

}
