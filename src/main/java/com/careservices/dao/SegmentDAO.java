package com.careservices.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Segment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.careservices.dao.Segment
 * @author MyEclipse Persistence Tools
 */
public class SegmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SegmentDAO.class);
	// property constants
	

	public void save(Segment transientInstance) {
		log.debug("saving Segment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Segment persistentInstance) {
		log.debug("deleting Segment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Segment findById(java.lang.Integer id) {
		log.debug("getting Segment instance with id: " + id);
		try {
			Segment instance = (Segment) getSession().get("com.careservices.dao.Segment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Segment> findByExample(Segment instance) {
		log.debug("finding Segment instance by example");
		try {
			List<Segment> results = (List<Segment>) getSession().createCriteria("com.careservices.dao.Segment")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Segment instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Segment as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	public List findAll() {
		log.debug("finding all Segment instances");
		try {
			String queryString = "from Segment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Segment merge(Segment detachedInstance) {
		log.debug("merging Segment instance");
		try {
			Segment result = (Segment) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Segment instance) {
		log.debug("attaching dirty Segment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Segment instance) {
		log.debug("attaching clean Segment instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}