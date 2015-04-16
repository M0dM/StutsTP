package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.util.HibernateUtils;

public class UserDAO implements IUserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.dao.IUserDAO#getAllUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDO> getAllUser() {
		Session s = HibernateUtils.getSession();
		try {
			Query q = s.createQuery("from UserDO");
			return (List<UserDO>) q.list();
		} finally {
			s.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.dao.IUserDAO#getUser(java.lang.String)
	 */
	@Override
	public UserDO getUser(String login) {
		Session s = HibernateUtils.getSession();
		UserDO u = null;
		try {
			Query q = s.createQuery("from UserDO where login= :myLogin");
			q.setString("myLogin", login);
			u = (UserDO) q.uniqueResult();
		} finally {
			s.close();
		}
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.dao.IUserDAO#addUser(com.javaquarium.beans.data.UserDO)
	 */
	@Override
	public void addUser(UserDO u) {
		Session s = HibernateUtils.getSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(u);
			t.commit();
		} finally {
			s.close();
		}
	}

}
