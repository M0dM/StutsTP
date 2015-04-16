package com.javaquarium.business;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.web.UserVO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.UserDAO;
import com.javaquarium.util.PasswordHashUtils;

/**
 * User Service.
 * 
 * @author Benoit
 * 
 */
public class UserService implements IUserService {

	private IUserDAO dao;

	/**
	 * User service constructor. Initialization of the dao.
	 */
	public UserService() {
		dao = new UserDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.business.ILoginService#getAllUser()
	 */
	@Override
	public List<UserVO> getAllUser() {
		final List<UserDO> listUser = dao.getAllUser();
		List<UserVO> users = new ArrayList<UserVO>(listUser.size());
		for (final UserDO user : listUser) {
			users.add(map(user));
		}
		return users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.ILoginService#addUser(com.javaquarium.beans.
	 * web.UserVO)
	 */
	@Override
	public void addUser(UserVO user) {
		UserDO u = this.map(user);
		dao.addUser(u);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.ILoginService#map(com.javaquarium.beans.data
	 * .LoginDO)
	 */
	@Override
	public UserVO map(final UserDO user) {
		UserVO u = null;
		if (user != null) {
			u = new UserVO();
			u.setLogin(user.getLogin());
			u.setPassword(null);
			u.setRepeatPassword(null);
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.ILoginService#map(com.javaquarium.beans.web.
	 * UserVO)
	 */
	@Override
	public UserDO map(UserVO user) {
		UserDO u = null;
		if (user != null) {
			u = new UserDO();
			u.setLogin(user.getLogin());
			try {
				u.setPasswordHash(PasswordHashUtils.createHash(user.getPassword()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.business.ILoginService#getUser(java.lang.String)
	 */
	@Override
	public UserVO getUser(String login) {
		return map(dao.getUser(login));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IUserService#validateLogin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean validateLogin(String login, String password) {
		boolean returnVal = false;
		UserDO databaseUser = dao.getUser(login);
		if (databaseUser != null) {
			try {
				returnVal = PasswordHashUtils.validatePassword(password, databaseUser.getPasswordHash());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return returnVal;
	}

}
