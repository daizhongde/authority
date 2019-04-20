package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityRmrelation;
import person.daizhongde.authority.hibernate.dao.TAuthorityButtonDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityButton;

import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityButton entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.migration.hibernate.dao.impl.TAuthorityButton
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityButtonDAOImpl extends SpringHibernateDaoSupport implements TAuthorityButtonDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityButtonDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	public List findUserButton4tb(Integer moduleId, Integer userId  ){
		Map condition = new HashMap();
		condition.put("n_mid", moduleId);
		condition.put("n_uid", userId);
		

		AbstractConstant absConstant = new AuthorityRmrelation();
		String query_userButton4tb = ((SQLNode)absConstant.getSQLDOC().getQuery().get("query_userButton4tb")).getSQL();
		List list = this.sqlQuerylistAllByMap(query_userButton4tb, condition);
//		Printer.printJSON(list);
		return list;
	}
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public void save(TAuthorityButton transientInstance) {
		log.debug("saving TAuthorityButton instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public void delete(TAuthorityButton persistentInstance) {
		log.debug("deleting TAuthorityButton instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findById(java.lang.Integer)
	 */
	@Override
	public TAuthorityButton findById(java.lang.Integer id) {
		log.debug("getting TAuthorityButton instance with id: " + id);
		try {
			TAuthorityButton instance = (TAuthorityButton) getHibernateTemplate()
					.get("person.daizhongde.migration.hibernate.pojo.TAuthorityButton",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public List findByExample(TAuthorityButton instance) {
		log.debug("finding TAuthorityButton instance by example");
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
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityButton instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityButton as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByCBcode(java.lang.Object)
	 */
	@Override
	public List findByCBcode(Object CBcode) {
		return findByProperty(_CBCODE, CBcode);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByCBname(java.lang.Object)
	 */
	@Override
	public List findByCBname(Object CBname) {
		return findByProperty(_CBNAME, CBname);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByUrl(java.lang.Object)
	 */
	@Override
	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByRemark(java.lang.Object)
	 */
	@Override
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findByNMid(java.lang.Object)
	 */
	@Override
	public List findByNMid(Object NMid) {
		return findByProperty(_NMID, NMid);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TAuthorityButton instances");
		try {
			String queryString = "from TAuthorityButton";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public TAuthorityButton merge(TAuthorityButton detachedInstance) {
		log.debug("merging TAuthorityButton instance");
		try {
			TAuthorityButton result = (TAuthorityButton) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public void attachDirty(TAuthorityButton instance) {
		log.debug("attaching dirty TAuthorityButton instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityButtonDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityButton)
	 */
	@Override
	public void attachClean(TAuthorityButton instance) {
		log.debug("attaching clean TAuthorityButton instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityButtonDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityButtonDAO) ctx.getBean("tAuthorityButtonDAO");
	}
}