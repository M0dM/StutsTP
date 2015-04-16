package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.UserDO;

public interface IUserDAO {

	/**
	 * @return all the registred poisson
	 */
	List<UserDO> getAllUser();

	/**
	 * @param name
	 *            the name of the desired poisson object
	 * @return the corresponding PoissonDO object
	 */
	UserDO getUser(String login);

	/**
	 * @param p
	 *            the PoissonDO object needed to be insert inside the database
	 */
	void addUser(UserDO u);

}
