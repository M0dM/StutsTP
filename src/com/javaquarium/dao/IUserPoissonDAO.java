package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserPoissonDO;

/**
 * 
 * @author Benoit Brayer
 *
 */
public interface IUserPoissonDAO {

	/**
	 * @param up the userPoissonDo object needed to be persisted in database
	 */
	void addUserPoisson(final UserPoissonDO up);

	/**
	 * @return all the userPoisson values for the specified user
	 */
	List<UserPoissonDO> getUserAllUserPoisson(final String login);

	/**
	 * @param login the user login
	 * @param espece the poisson espece
	 * @return the number of poisson of this espece owned by the user
	 */
	UserPoissonDO getUserPoisson(final String login, final String espece);

	/**
	 * @param login the user login
	 */
	void removeAllUserPoisson(final String login);
}
