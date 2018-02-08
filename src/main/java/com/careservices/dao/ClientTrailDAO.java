package com.careservices.dao;


import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ClientTrail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.careservices.dao.ClientTrail
 * @author MyEclipse Persistence Tools
 */
public class ClientTrailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClientTrailDAO.class);
	// property constants
	public static final String CLIENT_NAME = "clientName";
	public static final String MOBILE = "mobile";
	public static final String SECRIP = "secrip";
	public static final String LONG_SHORT = "longShort";
	public static final String SEGMENT = "segment";
	public static final String STRIKE_PRICE = "strikePrice";
	public static final String LOT_SIZE_QTY = "lotSizeQty";
	public static final String BUY_SELL = "buySell";
	public static final String FIRST_TARGET = "firstTarget";
	public static final String SECOND_TARGET = "secondTarget";
	public static final String STOP_LOSS = "stopLoss";
	public static final String STATUS = "status";

	public void save(ClientTrail transientInstance) {
		log.debug("saving ClientTrail instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ClientTrail persistentInstance) {
		log.debug("deleting ClientTrail instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClientTrail findById(java.lang.Integer id) {
		log.debug("getting ClientTrail instance with id: " + id);
		try {
			ClientTrail instance = (ClientTrail) getSession().get("com.careservices.dao.ClientTrail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ClientTrail> findByExample(ClientTrail instance) {
		log.debug("finding ClientTrail instance by example");
		try {
			List<ClientTrail> results = (List<ClientTrail>) getSession()
					.createCriteria("com.careservices.dao.ClientTrail").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ClientTrail instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from ClientTrail as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ClientTrail> findByClientName(Object clientName) {
		return findByProperty(CLIENT_NAME, clientName);
	}

	public List<ClientTrail> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<ClientTrail> findBySecrip(Object secrip) {
		return findByProperty(SECRIP, secrip);
	}

	public List<ClientTrail> findByLongShort(Object longShort) {
		return findByProperty(LONG_SHORT, longShort);
	}

	public List<ClientTrail> findBySegment(Object segment) {
		return findByProperty(SEGMENT, segment);
	}

	public List<ClientTrail> findByStrikePrice(Object strikePrice) {
		return findByProperty(STRIKE_PRICE, strikePrice);
	}

	public List<ClientTrail> findByLotSizeQty(Object lotSizeQty) {
		return findByProperty(LOT_SIZE_QTY, lotSizeQty);
	}

	public List<ClientTrail> findByBuySell(Object buySell) {
		return findByProperty(BUY_SELL, buySell);
	}

	public List<ClientTrail> findByFirstTarget(Object firstTarget) {
		return findByProperty(FIRST_TARGET, firstTarget);
	}

	public List<ClientTrail> findBySecondTarget(Object secondTarget) {
		return findByProperty(SECOND_TARGET, secondTarget);
	}

	public List<ClientTrail> findByStopLoss(Object stopLoss) {
		return findByProperty(STOP_LOSS, stopLoss);
	}

	public List<ClientTrail> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all ClientTrail instances");
		try {
			String queryString = "from ClientTrail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClientTrail merge(ClientTrail detachedInstance) {
		log.debug("merging ClientTrail instance");
		try {
			ClientTrail result = (ClientTrail) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClientTrail instance) {
		log.debug("attaching dirty ClientTrail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClientTrail instance) {
		log.debug("attaching clean ClientTrail instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}