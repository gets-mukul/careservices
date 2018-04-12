
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
 * Trade entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.careservices.dao.Trade
 * @author MyEclipse Persistence Tools
 */
public class TradeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TradeDAO.class);
	// property constants


	public void save(Trade transientInstance) {
		log.debug("saving Trade instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Trade persistentInstance) {
		log.debug("deleting Trade instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Trade findById(java.lang.Integer id) {
		log.debug("getting Trade instance with id: " + id);
		try {
			Trade instance = (Trade) getSession().get("com.careservices.dao.Trade", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Trade> findByExample(Trade instance) {
		log.debug("finding Trade instance by example");
		try {
			List<Trade> results = (List<Trade>) getSession().createCriteria("com.careservices.dao.Trade")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Trade instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Trade as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Trade instances");
		try {
			String queryString = "from Trade";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Trade merge(Trade detachedInstance) {
		log.debug("merging Trade instance");
		try {
			Trade result = (Trade) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Trade instance) {
		log.debug("attaching dirty Trade instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Trade instance) {
		log.debug("attaching clean Trade instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}