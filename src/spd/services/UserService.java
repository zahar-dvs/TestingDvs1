package spd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import spd.dao.UserDao;
import spd.domain.ResultTest;
import spd.domain.Test;
import spd.domain.User;

import java.util.LinkedList;
import java.util.List;

public class UserService {
	public static UserService instance;

	/**
	 * @return the instance
	 */
	public static UserService getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(UserService instance) {
		UserService.instance = instance;
	}


	private UserDao userDao;
	
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void saveUser(String username, String password, String userrole){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserRole(userrole);
		userDao.saveUser(user);
	}
	@Transactional
	public boolean loginUser(String username, String password){
		if (null == userDao.getUser(username, password)){
			return false;
		} else {
			return true;
		}
	}
	@Transactional
	public Integer getUserId(String username, String password){
		User user = userDao.getUser(username, password); 
		return (Integer) user.getId();
	}
	@Transactional
	public String getUserRole(String username, String password){
		User user = userDao.getUser(username, password);
		return (String) user.getUserRole();
	}

	@Transactional
	public List<User> getUsers(){
		List<User> list = userDao.getUsers();
		return list;
	}

	@Transactional
	public boolean isUserConsist(String username){
		if (null == userDao.isUserConsist(username)){
			return true;
		} else {
			return false;
		}
	}

}
