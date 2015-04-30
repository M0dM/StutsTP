package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.util.HibernateUtils;

public class UserPoissonDAO implements IUserPoissonDAO {

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserPoissonDAO#getUserAllUserPoisson(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserPoissonDO> getUserAllUserPoisson(final String login) {
		Session s = HibernateUtils.getSession();
		try {
			Query q = s.createQuery("from UserPoissonDO where user= :myLogin");

			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);

			q.setString("myLogin", user.getId().toString());

			return (List<UserPoissonDO>) q.list();
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserPoissonDAO#getUserPoisson(java.lang.String, java.lang.String)
	 */
	@Override
	public UserPoissonDO getUserPoisson(final String login, final String espece) {
		Session s = HibernateUtils.getSession();
		UserPoissonDO up = null;
		try {
			Query q = s.createQuery("from UserPoissonDO where user= :myLogin and poisson= :myEspece");

			final IPoissonDAO poissonDAO = new PoissonDAO();
			final PoissonDO poisson = poissonDAO.getPoisson(espece);

			final IUserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);

			q.setString("myLogin", user.getId().toString());
			q.setString("myEspece", poisson.getId().toString());
			up = (UserPoissonDO) q.uniqueResult();
		} finally {
			s.close();
		}
		return up;
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserPoissonDAO#addUserPoisson(com.javaquarium.beans.data.UserPoissonDO)
	 */
	@Override
	public void addUserPoisson(final UserPoissonDO up) {
		Session s = HibernateUtils.getSession();
		try {
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(up);
			t.commit();
		} finally {
			s.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.javaquarium.dao.IUserPoissonDAO#removeAllUserPoisson(java.lang.String)
	 */
	@Override
	public void removeAllUserPoisson(final String login) {
		Session s = HibernateUtils.getSession();
		try {
			final UserDAO userDAO = new UserDAO();
			final UserDO user = userDAO.getUser(login);

			Query query = s.createQuery("delete UserPoissonDO where user= :user_id");
			query.setString("user_id", user.getId().toString());
			query.executeUpdate();

		} finally {
			s.close();
		}
	}

}
