package com.us.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bs.entity.User;
import com.us.dao.UserRepository;

@Repository
@EnableTransactionManagement
@SuppressWarnings("unchecked")
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public int createUser(User user) {
		if(entityManager != null && user != null) {
			entityManager.persist(user);
			entityManager.flush();
		}
		return 0;
	}

	@Override
	public User getUserByUserId(int userId) {
		List<User> list = entityManager.createQuery("from User u where u.userId = :userIdParam and u.isDeleted = false").setParameter("userIdParam", userId).getResultList();
		if(list.size() > 0)
			return list.get(0);
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

	@Override
	public User getUserByUserName(String userName) {
		List<User> list = entityManager.createQuery("from User u where u.userName = :userNameParam and u.isDeleted = false").setParameter("userNameParam", userName).getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		List<User> list = entityManager.createQuery("from User u where u.email = :emailParam and u.isDeleted = false").setParameter("emailParam", email).getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}

	public User getUserByUsernameAndPassword(String userName, String password) {
		List<User> list = entityManager
				.createQuery(
						"from User u where u.userName = :userNameParam and u.pwd = :pwdParam and u.isDeleted = false")
				.setParameter("userNameParam", userName)
				.setParameter("pwdParam", password).getResultList();
		if(list.size() > 0)
			return list.get(0);
		return null;
	}
}
