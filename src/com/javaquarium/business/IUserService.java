package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;

/**
 * Interface of PoissonService.
 * 
 * @author Benoit
 */
public interface IUserService {

	/**
	 * @return the list of all registred user
	 */
	List<UserVO> getAllUser();

	/**
	 * @param user
	 * @return the logindo object corresponding to the loginvo object
	 */
	UserDO map(UserVO user);

	/**
	 * @param user
	 * @return the loginvo object corresponding to the logindo object
	 */
	UserVO map(UserDO user);

	/**
	 * @param user
	 *            the user needed to be registred into the database
	 */
	void addUser(UserVO user);

	/**
	 * @param login
	 *            the loginDO login name
	 * @return the corresponding loginVO object
	 */
	UserVO getUser(String login);

	/**
	 * @param login
	 *            the login from loginvo
	 * @param password
	 *            the password from loginvo
	 * @return true if a user with this login exist and its password hash match
	 *         this password
	 */
	boolean validateLogin(String login, String password);
}
