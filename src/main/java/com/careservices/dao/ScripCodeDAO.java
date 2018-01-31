package com.careservices.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ScripCode entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.careservices.dao.ScripCode
 * @author MyEclipse Persistence Tools
 */
public class ScripCodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ScripCodeDAO.class);
	// property constants
	public static final String SYMBOL = "symbol";
	public static final String MKT_LOT = "mktLot";

	public void save(ScripCode transientInstance) {
		log.debug("saving ScripCode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ScripCode persistentInstance) {
		log.debug("deleting ScripCode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ScripCode findById(java.lang.Integer id) {
		log.debug("getting ScripCode instance with id: " + id);
		try {
			ScripCode instance = (ScripCode) getSession().get("com.careservices.dao.ScripCode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ScripCode> findByExample(ScripCode instance) {
		log.debug("finding ScripCode instance by example");
		try {
			List<ScripCode> results = (List<ScripCode>) getSession().createCriteria("com.careservices.dao.ScripCode")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ScripCode instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ScripCode as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ScripCode> findBySymbol(Object symbol) {
		return findByProperty(SYMBOL, symbol);
	}

	public List<ScripCode> findByMktLot(Object mktLot) {
		return findByProperty(MKT_LOT, mktLot);
	}

	public List findAll() {
		log.debug("finding all ScripCode instances");
		try {
			String queryString = "from ScripCode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ScripCode merge(ScripCode detachedInstance) {
		log.debug("merging ScripCode instance");
		try {
			ScripCode result = (ScripCode) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ScripCode instance) {
		log.debug("attaching dirty ScripCode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ScripCode instance) {
		log.debug("attaching clean ScripCode instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}