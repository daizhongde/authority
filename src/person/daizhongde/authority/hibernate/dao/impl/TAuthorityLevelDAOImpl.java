package person.daizhongde.authority.hibernate.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityLevelDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityLevel;

import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityLevel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.pojo.TAuthorityLevel
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityLevelDAOImpl extends SpringHibernateDaoSupport implements TAuthorityLevelDAO { 
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityLevelDAOImpl.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List findAllWithOrder(){
		
		log.debug("finding all TAuthorityLevel instances");
		try {
			String queryString = "from TAuthorityLevel m order by m.NLid ";//CMleaf,
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public void save(TAuthorityLevel transientInstance) {
		log.debug("saving TAuthorityLevel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public void delete(TAuthorityLevel persistentInstance) {
		log.debug("deleting TAuthorityLevel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#findById(java.lang.Short)
	 */
	@Override
	public TAuthorityLevel findById(java.lang.Short id) {
		log.debug("getting TAuthorityLevel instance with id: " + id);
		try {
			TAuthorityLevel instance = (TAuthorityLevel) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityLevel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public List findByExample(TAuthorityLevel instance) {
		log.debug("finding TAuthorityLevel instance by example");
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
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityLevel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityLevel as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#findByCLname(java.lang.Object)
	 */
	@Override
	public List findByCLname(Object CLname) {
		return findByProperty(_CLNAME, CLname);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TAuthorityLevel instances");
		try {
			String queryString = "from TAuthorityLevel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public TAuthorityLevel merge(TAuthorityLevel detachedInstance) {
		log.debug("merging TAuthorityLevel instance");
		try {
			TAuthorityLevel result = (TAuthorityLevel) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public void attachDirty(TAuthorityLevel instance) {
		log.debug("attaching dirty TAuthorityLevel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityLevelDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityLevel)
	 */
	@Override
	public void attachClean(TAuthorityLevel instance) {
		log.debug("attaching clean TAuthorityLevel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityLevelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityLevelDAO) ctx.getBean("tAuthorityLevelDAO");
	}
}