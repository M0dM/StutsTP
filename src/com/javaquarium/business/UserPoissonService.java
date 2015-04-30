package com.javaquarium.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.dao.IPoissonDAO;
import com.javaquarium.dao.IUserDAO;
import com.javaquarium.dao.IUserPoissonDAO;
import com.javaquarium.dao.PoissonDAO;
import com.javaquarium.dao.UserDAO;
import com.javaquarium.dao.UserPoissonDAO;

public class UserPoissonService implements IUserPoissonService {

	private IUserPoissonDAO dao;

	public UserPoissonService() {
		dao = new UserPoissonDAO();
	}

	@Override
	public Map<String, Integer> getUserAllUserPoisson(String login) {
		final List<UserPoissonDO> listUserPoisson = dao.getUserAllUserPoisson(login);
		Map<String, Integer> poissons = new HashMap<String, Integer>();
		if (listUserPoisson != null) {
			for (UserPoissonDO up : listUserPoisson) {
				poissons.put(up.getPoisson().getNom(), up.getCount());
			}
		}
		return poissons;
	}

	@Override
	public UserPoissonDO getUserPoisson(String login, String espece) {
		return dao.getUserPoisson(login, espece);
	}

	@Override
	public void addUserPoisson(String login, String espece, int count) {
		UserPoissonDO up = dao.getUserPoisson(login, espece);

		if (up == null) {
			up = new UserPoissonDO();
			IPoissonDAO poissonDAO = new PoissonDAO();
			PoissonDO poisson = poissonDAO.getPoisson(espece);

			IUserDAO userDAO = new UserDAO();
			UserDO user = userDAO.getUser(login);

			up.setPoisson(poisson);
			up.setUser(user);
		}

		up.setCount(count);

		dao.addUserPoisson(up);
	}

	@Override
	public void removeAllUserPoisson(String login) {
		dao.removeAllUserPoisson(login);
	}

}
