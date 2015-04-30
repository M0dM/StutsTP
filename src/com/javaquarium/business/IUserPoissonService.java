package com.javaquarium.business;

import java.util.Map;

import com.javaquarium.beans.data.UserPoissonDO;

/**
 * Interface of UserPoissonService.
 * 
 * @author Benoit
 */
public interface IUserPoissonService {

	/**
	 * @return the list of user poissons
	 */
	Map<String, Integer> getUserAllUserPoisson(String login);

	/**
	 * @param login
	 *            the user login
	 * @param espece
	 *            the poisson espece
	 * @return a UserPoissonDO object retreived from database or null if
	 *         UserPoisson does not exist
	 */
	UserPoissonDO getUserPoisson(String login, String espece);

	/**
	 * @param login
	 *            the user login
	 * @param espece
	 *            the poisson espece
	 * @param count
	 *            the number of poisson of this espece own by the user
	 */
	void addUserPoisson(String login, String espece, int count);

	/**
	 * @param sessionUsername
	 *            the user login of the user needed to empty his aquarium
	 */
	void removeAllUserPoisson(String sessionUsername);

}
