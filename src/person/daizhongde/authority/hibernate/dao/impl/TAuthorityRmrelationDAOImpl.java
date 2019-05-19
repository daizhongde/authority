package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityRmrelation;
import person.daizhongde.authority.hibernate.dao.TAuthorityRmrelationDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation;

import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityRmrelation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelation
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityRmrelationDAOImpl extends SpringHibernateDaoSupport implements TAuthorityRmrelationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityRmrelationDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public void save(TAuthorityRmrelation transientInstance) {
		log.debug("saving TAuthorityRmrelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public void delete(TAuthorityRmrelation persistentInstance) {
		log.debug("deleting TAuthorityRmrelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * @deprecated
	 */
	public List findUserButton4tb(Integer moduleId, Long userId  ){
		Map condition = new HashMap();
		condition.put("n_mid", moduleId);
		condition.put("n_uid", userId);
		

		AbstractConstant absConstant = new AuthorityRmrelation();
		String query_userButton4tb = ((SQLNode)absConstant.getSQLDOC().getQuery().get("query_userButton4tb")).getSQL();
		List list = this.sqlQuerylistAllByMap(query_userButton4tb, condition);
//		Printer.printJSON(list);
		return list;
	}

	public TAuthorityRmrelation findById(
			person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelationId id) {
		log.debug("getting TAuthorityRmrelation instance with id: " + id);
		try {
			TAuthorityRmrelation instance = (TAuthorityRmrelation) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public List findByExample(TAuthorityRmrelation instance) {
		log.debug("finding TAuthorityRmrelation instance by example");
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
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityRmrelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityRmrelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#findByCCip(java.lang.Object)
	 */
	public List findByCCip(Object CCip) {
		return findByProperty(_CCIP, CCip);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#findByCCreator(java.lang.Object)
	 */
	public List findByCCreator(Object CCreator) {
		return findByProperty(_CCREATOR, CCreator);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all TAuthorityRmrelation instances");
		try {
			String queryString = "from TAuthorityRmrelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public TAuthorityRmrelation merge(TAuthorityRmrelation detachedInstance) {
		log.debug("merging TAuthorityRmrelation instance");
		try {
			TAuthorityRmrelation result = (TAuthorityRmrelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public void attachDirty(TAuthorityRmrelation instance) {
		log.debug("attaching dirty TAuthorityRmrelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRmrelationDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation)
	 */
	public void attachClean(TAuthorityRmrelation instance) {
		log.debug("attaching clean TAuthorityRmrelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityRmrelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityRmrelationDAO) ctx.getBean("tAuthorityRmrelationDAO");
	}
}