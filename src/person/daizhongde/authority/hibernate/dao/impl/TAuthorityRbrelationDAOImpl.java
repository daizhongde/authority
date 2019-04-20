package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityRbrelation;
import person.daizhongde.authority.hibernate.dao.TAuthorityRbrelationDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation;

import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityRbrelation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.migration.hibernate.dao.impl.TAuthorityRbrelation
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityRbrelationDAOImpl extends SpringHibernateDaoSupport implements TAuthorityRbrelationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityRbrelationDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	/**
	 */
	public List findUserButton4tb(Integer moduleId, Integer userId  ){
		List list = null;
		Map condition = new HashMap();
		condition.put("n_mid", moduleId);
		condition.put("n_uid", userId);
		
		AbstractConstant absConstant = new AuthorityRbrelation();
		
		String query_userButton4tb = ((SQLNode)absConstant.getSQLDOC().getQuery().get("query_userButton4tb")).getSQL();
		
		list = this.sqlQuerylistAllByMap(query_userButton4tb, condition);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public void save(TAuthorityRbrelation transientInstance) {
		log.debug("saving TAuthorityRbrelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public void delete(TAuthorityRbrelation persistentInstance) {
		log.debug("deleting TAuthorityRbrelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findById(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelationId)
	 */
	@Override
	public TAuthorityRbrelation findById(
			person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelationId id) {
		log.debug("getting TAuthorityRbrelation instance with id: " + id);
		try {
			TAuthorityRbrelation instance = (TAuthorityRbrelation) getHibernateTemplate()
					.get("person.daizhongde.migration.hibernate.pojo.TAuthorityRbrelation",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public List findByExample(TAuthorityRbrelation instance) {
		log.debug("finding TAuthorityRbrelation instance by example");
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
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityRbrelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityRbrelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findByCCip(java.lang.Object)
	 */
	@Override
	public List findByCCip(Object CCip) {
		return findByProperty(_CCIP, CCip);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findByCCreator(java.lang.Object)
	 */
	@Override
	public List findByCCreator(Object CCreator) {
		return findByProperty(_CCREATOR, CCreator);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TAuthorityRbrelation instances");
		try {
			String queryString = "from TAuthorityRbrelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public TAuthorityRbrelation merge(TAuthorityRbrelation detachedInstance) {
		log.debug("merging TAuthorityRbrelation instance");
		try {
			TAuthorityRbrelation result = (TAuthorityRbrelation) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public void attachDirty(TAuthorityRbrelation instance) {
		log.debug("attaching dirty TAuthorityRbrelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRbrelationDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityRbrelation)
	 */
	@Override
	public void attachClean(TAuthorityRbrelation instance) {
		log.debug("attaching clean TAuthorityRbrelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityRbrelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityRbrelationDAO) ctx.getBean("TAuthorityRbrelationDAO");
	}
}