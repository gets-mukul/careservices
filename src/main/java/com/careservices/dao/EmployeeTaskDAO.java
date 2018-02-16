package com.careservices.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * EmployeeTask entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see careinvestmentservices.dao.EmployeeTask
 * @author MyEclipse Persistence Tools
 */
public class EmployeeTaskDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(EmployeeTaskDAO.class);
	// property constants
	public static final String PAYMENT_AMOUNT = "paymentAmount";
	public static final String PAYMENT_ID = "paymentId";
	public static final String PAYMENT_TYPE = "paymentType";
	public static final String STATUS = "status";

	public void save(EmployeeTask transientInstance) {
		log.debug("saving EmployeeTask instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EmployeeTask persistentInstance) {
		log.debug("deleting EmployeeTask instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EmployeeTask findById(java.lang.Integer id) {
		log.debug("getting EmployeeTask instance with id: " + id);
		try {
			EmployeeTask instance = (EmployeeTask) getSession().get("careinvestmentservices.dao.EmployeeTask", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<EmployeeTask> findByExample(EmployeeTask instance) {
		log.debug("finding EmployeeTask instance by example");
		try {
			List<EmployeeTask> results = (List<EmployeeTask>) getSession()
					.createCriteria("careinvestmentservices.dao.EmployeeTask").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<EmployeeTask> findByProperty(String propertyName, Object value) {
		log.debug("finding EmployeeTask instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from EmployeeTask as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<EmployeeTask> findByPaymentAmount(Object paymentAmount) {
		return findByProperty(PAYMENT_AMOUNT, paymentAmount);
	}

	public List<EmployeeTask> findByPaymentId(Object paymentId) {
		return findByProperty(PAYMENT_ID, paymentId);
	}

	public List<EmployeeTask> findByPaymentType(Object paymentType) {
		return findByProperty(PAYMENT_TYPE, paymentType);
	}

	public List<EmployeeTask> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<EmployeeTask> findAll() {
		log.debug("finding all EmployeeTask instances");
		try {
			String queryString = "from EmployeeTask";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EmployeeTask merge(EmployeeTask detachedInstance) {
		log.debug("merging EmployeeTask instance");
		try {
			EmployeeTask result = (EmployeeTask) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EmployeeTask instance) {
		log.debug("attaching dirty EmployeeTask instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EmployeeTask instance) {
		log.debug("attaching clean EmployeeTask instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}