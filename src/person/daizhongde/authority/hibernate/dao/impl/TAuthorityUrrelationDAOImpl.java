package person.daizhongde.authority.hibernate.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityUrrelationDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation;

import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityUrrelation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelation
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityUrrelationDAOImpl extends SpringHibernateDaoSupport implements TAuthorityUrrelationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityUrrelationDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public void save(TAuthorityUrrelation transientInstance) {
		log.debug("saving TAuthorityUrrelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public void delete(TAuthorityUrrelation persistentInstance) {
		log.debug("deleting TAuthorityUrrelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findById(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelationId)
	 */
	public TAuthorityUrrelation findById(
			person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelationId id) {
		log.debug("getting TAuthorityUrrelation instance with id: " + id);
		try {
			TAuthorityUrrelation instance = (TAuthorityUrrelation) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public List findByExample(TAuthorityUrrelation instance) {
		log.debug("finding TAuthorityUrrelation instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityUrrelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityUrrelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findByCCip(java.lang.Object)
	 */
	public List findByCCip(Object CCip) {
		return findByProperty(_CCIP, CCip);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findByCCreator(java.lang.Object)
	 */
	public List findByCCreator(Object CCreator) {
		return findByProperty(_CCREATOR, CCreator);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TAuthorityUrrelation instances");
		try {
			String queryString = "from TAuthorityUrrelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public TAuthorityUrrelation merge(TAuthorityUrrelation detachedInstance) {
		log.debug("merging TAuthorityUrrelation instance");
		try {
			TAuthorityUrrelation result = (TAuthorityUrrelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public void attachDirty(TAuthorityUrrelation instance) {
		log.debug("attaching dirty TAuthorityUrrelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityUrrelationDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation)
	 */
	public void attachClean(TAuthorityUrrelation instance) {
		log.debug("attaching clean TAuthorityUrrelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityUrrelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityUrrelationDAO) ctx.getBean("tAuthorityUrrelationDAO");
	}
}