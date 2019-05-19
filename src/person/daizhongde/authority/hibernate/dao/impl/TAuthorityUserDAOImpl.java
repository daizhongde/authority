package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityUserDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityUser entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.pojo.TAuthorityUser
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityUserDAOImpl extends SpringHibernateDaoSupport implements TAuthorityUserDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityUserDAOImpl.class);
	protected void initDao() {
		// do nothing
	}


	public List<TAuthorityUser> findAllBoss(){
		try {
			String queryString = "from TAuthorityUser WHERE SupervisorId IS NULL ORDER BY CDname,CUname";
			return (List<TAuthorityUser>)getHibernateTemplate().find(queryString);
//			return this.NamedQuery("findCompanyAllBoss");
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findChildrenNoRecursive( Long parentId )
	{
		log.debug("findChildren......");
		String queryString = "from TAuthorityUser m " +
							"where m.SupervisorId = :parentId " +
							"ORDER BY CDname,CUname ";  // CIcode CIname
		Map condition = new HashMap();
		condition.put( "parentId", parentId );
//		return this.NamedQuery("findFollowerNoRecursive", condition);
		return this.listAllByMap( queryString, condition );	
	}
	
	public long getOnlineCount(){
		String queryString = "select count(*) from TAuthorityUser as model where model.CLogins = ?";
		return new Long(getHibernateTemplate().find(queryString, "1" ).get(0).toString()).longValue();
	}
	public void updateLogState( String state, Long N_UID ){
		this.sqlQueryExeU( "update t_authority_user set C_LOGINS= '"+state+"' where N_UID="+N_UID );
	};
	public void updateLogState20( String state, Long N_UID ){
		this.sqlQueryExeU( "update t_authority_user set C_LOGINS= '"+state+"', C_LOGOUTT=now() where N_UID="+N_UID );
	};
	public void updateLogState21( String state, Long N_UID, String ip ){
		this.sqlQueryExeU( "update t_authority_user set C_LOGINS= '"+state+"', C_LOGINIP ='"+ip+"',C_LOGINT=now() where N_UID="+N_UID );
	};
	public void save(TAuthorityUser transientInstance) {
		log.debug("saving TAuthorityUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAuthorityUser persistentInstance) {
		log.debug("deleting TAuthorityUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAuthorityUser findById(java.lang.Long id) {
		log.debug("getting TAuthorityUser instance with id: " + id);
		try {
			TAuthorityUser instance = (TAuthorityUser) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityUser",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAuthorityUser instance) {
		log.debug("finding TAuthorityUser instance by example");
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
		log.debug("finding TAuthorityUser instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCUlogname(Object CUlogname) {
		return findByProperty(_CULOGNAME, CUlogname);
	}

	public List findByCUname(Object CUname) {
		return findByProperty(_CUNAME, CUname);
	}

	public List findByCUpassword(Object CUpassword) {
		return findByProperty(_CUPASSWORD, CUpassword);
	}

	public List findByCUsex(Object CUsex) {
		return findByProperty(_CUSEX, CUsex);
	}

	public List findByCUphone(Object CUphone) {
		return findByProperty(_CUPHONE, CUphone);
	}

	public List findByCUemail(Object CUemail) {
		return findByProperty(_CUEMAIL, CUemail);
	}

	public List findByCUqq(Object CUqq) {
		return findByProperty(_CUQQ, CUqq);
	}

	public List findByCUaddr(Object CUaddr) {
		return findByProperty(_CUADDR, CUaddr);
	}

	public List findByCUtel(Object CUtel) {
		return findByProperty(_CUTEL, CUtel);
	}

	public List findByCUfax(Object CUfax) {
		return findByProperty(_CUFAX, CUfax);
	}

	public List findByNDid(Object NDid) {
		return findByProperty(_NDID, NDid);
	}

	public List findByCUcip(Object CUcip) {
		return findByProperty(_CUCIP, CUcip);
	}

	public List findByCUcreator(Object CUcreator) {
		return findByProperty(_CUCREATOR, CUcreator);
	}

	public List findByCUmip(Object CUmip) {
		return findByProperty(_CUMIP, CUmip);
	}

	public List findByCUmodifier(Object CUmodifier) {
		return findByProperty(_CUMODIFIER, CUmodifier);
	}
	@Override
	public List findByCUons(Object CUons) {
		return findByProperty(_CUONS, CUons);
	}
	
	public List findAll() {
		log.debug("finding all TAuthorityUser instances");
		try {
			String queryString = "from TAuthorityUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAuthorityUser merge(TAuthorityUser detachedInstance) {
		log.debug("merging TAuthorityUser instance");
		try {
			TAuthorityUser result = (TAuthorityUser) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAuthorityUser instance) {
		log.debug("attaching dirty TAuthorityUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAuthorityUser instance) {
		log.debug("attaching clean TAuthorityUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityUserDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityUserDAO) ctx.getBean("tAuthorityUserDAO");
	}
}