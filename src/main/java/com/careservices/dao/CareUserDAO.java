package com.careservices.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CareUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.careservices.dao.CareUser
 * @author MyEclipse Persistence Tools
 */
public class CareUserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CareUserDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String USER_TYPE = "userType";

	public void save(CareUser transientInstance) {
		log.debug("saving CareUser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CareUser persistentInstance) {
		log.debug("deleting CareUser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CareUser findById(java.lang.Integer id) {
		log.debug("getting CareUser instance with id: " + id);
		try {
			CareUser instance = (CareUser) getSession().get("com.careservices.dao.CareUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CareUser> findByExample(CareUser instance) {
		log.debug("finding CareUser instance by example");
		try {
			List<CareUser> results = (List<CareUser>) getSession().createCriteria("com.careservices.dao.CareUser")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CareUser instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CareUser as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CareUser> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<CareUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<CareUser> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<CareUser> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<CareUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<CareUser> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List<CareUser> findAll() {
		log.debug("finding all CareUser instances");
		try {
			String queryString = "from CareUser";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CareUser merge(CareUser detachedInstance) {
		log.debug("merging CareUser instance");
		try {
			CareUser result = (CareUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CareUser instance) {
		log.debug("attaching dirty CareUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CareUser instance) {
		log.debug("attaching clean CareUser instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}