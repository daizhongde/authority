package person.daizhongde.authority.hibernate.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityFuncDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityFunc;

import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for TAuthorityFunc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see person.daizhongde.migration.hibernate.dao.impl.TAuthorityFunc
  * @author MyEclipse Persistence Tools 
 */
public class TAuthorityFuncDAOImpl extends SpringHibernateDaoSupport implements TAuthorityFuncDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TAuthorityFuncDAOImpl.class);
		protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
    @Override
	public void save(TAuthorityFunc transientInstance) {
        log.debug("saving TAuthorityFunc instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
	@Override
	public void delete(TAuthorityFunc persistentInstance) {
        log.debug("deleting TAuthorityFunc instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findById(java.lang.Short)
	 */
    @Override
	public TAuthorityFunc findById( java.lang.Short id) {
        log.debug("getting TAuthorityFunc instance with id: " + id);
        try {
            TAuthorityFunc instance = (TAuthorityFunc) getHibernateTemplate()
                    .get("person.daizhongde.migration.hibernate.pojo.TAuthorityFunc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
    @Override
	public List findByExample(TAuthorityFunc instance) {
        log.debug("finding TAuthorityFunc instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding TAuthorityFunc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TAuthorityFunc as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByCFcode(java.lang.Object)
	 */
	@Override
	public List findByCFcode(Object CFcode
	) {
		return findByProperty(_CFCODE, CFcode
		);
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByCFname(java.lang.Object)
	 */
	@Override
	public List findByCFname(Object CFname
	) {
		return findByProperty(_CFNAME, CFname
		);
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByCCip(java.lang.Object)
	 */
	@Override
	public List findByCCip(Object CCip
	) {
		return findByProperty(_CCIP, CCip
		);
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findByCCreator(java.lang.Object)
	 */
	@Override
	public List findByCCreator(Object CCreator
	) {
		return findByProperty(_CCREATOR, CCreator
		);
	}
	

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TAuthorityFunc instances");
		try {
			String queryString = "from TAuthorityFunc";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
    @Override
	public TAuthorityFunc merge(TAuthorityFunc detachedInstance) {
        log.debug("merging TAuthorityFunc instance");
        try {
            TAuthorityFunc result = (TAuthorityFunc) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
    @Override
	public void attachDirty(TAuthorityFunc instance) {
        log.debug("attaching dirty TAuthorityFunc instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityFuncDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityFunc)
	 */
    @Override
	public void attachClean(TAuthorityFunc instance) {
        log.debug("attaching clean TAuthorityFunc instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static TAuthorityFuncDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (TAuthorityFuncDAO) ctx.getBean("TAuthorityFuncDAO");
	}
}