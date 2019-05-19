package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityRoleDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;

import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityRole entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityRole
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityRoleDAOImpl extends SpringHibernateDaoSupport implements TAuthorityRoleDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityRoleDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	public List<TAuthorityRole> findByUserId(Long userId){
		log.debug("findByUserId, find special user's TAuthorityRole instances");
		
		Map map = new HashMap(1);
		map.put("userId", userId);
		return this.NamedQuery("findRoleByUserId_SQLQuery", map);
	}
	
	@Override
	public List findAllWithOrder(){
		
		log.debug("finding all TAuthorityRole instances");
		try {
			String queryString = "from TAuthorityRole m order by m.CRno ";//CMleaf,
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@Override
	public List findAllWithOrder_ExceptDev(){
		
		log.debug("finding all TAuthorityRole instances except developer ");
		try {
			String queryString = "from TAuthorityRole m where m.NRid != 98 order by m.CRno ";//CMleaf,
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TAuthorityRole transientInstance) {
		log.debug("saving TAuthorityRole instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAuthorityRole persistentInstance) {
		log.debug("deleting TAuthorityRole instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAuthorityRole findById(java.lang.Short id) {
		log.debug("getting TAuthorityRole instance with id: " + id);
		try {
			TAuthorityRole instance = (TAuthorityRole) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityRole",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAuthorityRole instance) {
		log.debug("finding TAuthorityRole instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityRole instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityRole as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCRno(Object CRno) {
		return findByProperty(_CRNO, CRno);
	}

	public List findByCRname(Object CRname) {
		return findByProperty(_CRNAME, CRname);
	}

	public List findByCRnote(Object CRnote) {
		return findByProperty(_CRNOTE, CRnote);
	}

	public List findByCRcip(Object CRcip) {
		return findByProperty(_CRCIP, CRcip);
	}

	public List findByCRcreator(Object CRcreator) {
		return findByProperty(_CRCREATOR, CRcreator);
	}

	public List findByCRons(Object CRons) {
		return findByProperty(_CRONS, CRons);
	}
	
	public List findAll() {
		log.debug("finding all TAuthorityRole instances");
		try {
			String queryString = "from TAuthorityRole";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAuthorityRole merge(TAuthorityRole detachedInstance) {
		log.debug("merging TAuthorityRole instance");
		try {
			TAuthorityRole result = (TAuthorityRole) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAuthorityRole instance) {
		log.debug("attaching dirty TAuthorityRole instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAuthorityRole instance) {
		log.debug("attaching clean TAuthorityRole instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public static TAuthorityRoleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityRoleDAO) ctx.getBean("tAuthorityRoleDAO");
	}
}