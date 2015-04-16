package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.beans.web.UserPoissonVO;

/**
 * Interface of UserPoissonService.
 * 
 * @author Benoit
 */
public interface IUserPoissonService {

	/**
	 * 
	 * @return
	 */
	List<UserPoissonVO> getUserAllUserPoisson(String login);

	/**
	 * 
	 * @param up
	 * @return
	 */
	UserPoissonDO map(UserPoissonVO up);

	/**
	 * 
	 * @param up
	 * @return
	 */
	UserPoissonVO map(UserPoissonDO up);

	/**
	 * 
	 * @param up
	 */
	void addUserPoisson(UserPoissonVO up);

	/**
	 * 
	 * @param login
	 * @param espece
	 * @return
	 */
	UserPoissonVO getUserPoisson(String login, String espece);

}
