package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserPoissonDO;

public interface IUserPoissonDAO {

	/**
	 * 
	 * @param up
	 */
	void addUserPoisson(UserPoissonDO up);
	
	/**
	 * 
	 * @return
	 */
	List<UserPoissonDO> getUserAllUserPoisson(String login);
	
	/**
	 * 
	 * @param login
	 * @param espece
	 * @return
	 */
	UserPoissonDO getUserPoisson(String login, String espece);
}
