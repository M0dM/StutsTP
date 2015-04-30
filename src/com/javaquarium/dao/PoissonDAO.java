package com.javaquarium.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.util.HibernateUtils;

public class PoissonDAO implements IPoissonDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.dao.IPoissonDAO#getAllPoisson()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PoissonDO> getAllPoisson() {
		Session s = HibernateUtils.getSession();
		try {
			Query q = s.createQuery("from PoissonDO");
			return (List<PoissonDO>) q.list();
		} finally {
			s.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.dao.IPoissonDAO#getPoisson(java.lang.String)
	 */
	@Override
	public PoissonDO getPoisson(String name) {
		Session s = HibernateUtils.getSession();
		PoissonDO p = null;
		try {
			Query q = s.createQuery("from PoissonDO where nom= :myName");
			q.setString("myName", name);
			p = (PoissonDO) q.uniqueResult();
		} finally {
			s.close();
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.dao.IPoissonDAO#addPoisson(com.javaquarium.beans.data
	 * .PoissonDO)
	 */
	@Override
	public void addPoisson(PoissonDO p) {
		Session s = HibernateUtils.getSession();
		try {
			Transaction t = s.beginTransaction();
			s.save(p);
			t.commit();
		} finally {
			s.close();
		}
	}

}
