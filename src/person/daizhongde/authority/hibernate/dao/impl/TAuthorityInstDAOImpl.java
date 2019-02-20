package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityInstDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;

import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityInst entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityInst
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityInstDAOImpl extends SpringHibernateDaoSupport implements TAuthorityInstDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityInstDAOImpl.class);
	protected void initDao() {
		// do nothing
	}


	@Override
	public List findAllWithOrder(){
		
		log.debug("finding all TAuthorityInst instances");
		try {//by m.NIlevel,m.CIcode,  CIname
			String queryString = "from TAuthorityInst m order by m.NIlevel, m.CIname ";//CIcode CIname CMleaf,
			return getHibernateTemplate().find(queryString);  
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findChildrenRecursive( Integer parentId )
	{
		log.debug("findChildren......");
		////my id is other's parent, search downward
		String queryString = "select * " +
							   "from "+ INIT.AUTH_schema +".t_authority_inst " +
							  "where FIND_IN_SET( N_Iid, f_getChildInstList( :parentId ) ) " +
							  "order by N_Ilevel, C_Iname";// C_Icode C_Iname
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.sqlQuerylistAllByMap( queryString, map, TAuthorityInst.class );
	}
	public List findChildrenRecursive( Integer parentId, Integer maxLevel )
	{
		log.debug("findChildren......");
		////my id is other's parent, search downward
		String queryString = "select * " +
							   "from "+ INIT.AUTH_schema +".t_authority_inst " +
							  "where FIND_IN_SET( N_Iid, f_getChildInstList( :parentId ) ) and N_ILEVEL <= "+maxLevel+" " +
							  "order by N_Ilevel, C_Iname";// C_Icode C_Iname
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.sqlQuerylistAllByMap( queryString, map, TAuthorityInst.class );
	}

	public List findChildrenNoRecursive( Integer parentId )
	{
		log.debug("findChildren......");
		String queryString = "from TAuthorityInst m " +
							"where m.NIsuperior = :parentId " +
							"order by m.NIlevel, m.CIname ";  // CIcode CIname
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.listAllByMap( queryString, map );	
	}
	@Override
	public List findChildren( Integer parentId, boolean recursive, Integer maxLevel )
	{
		log.debug("findChildren......");
		String queryString = "";
		if(recursive)
		{
			return this.findChildrenRecursive(parentId, maxLevel);
		}
		else
		{
			return this.findChildrenNoRecursive(parentId);
		}		
	}
	
	public void save(TAuthorityInst transientInstance) {
		log.debug("saving TAuthorityInst instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TAuthorityInst persistentInstance) {
		log.debug("deleting TAuthorityInst instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TAuthorityInst findById(java.lang.Integer id) {
		log.debug("getting TAuthorityInst instance with id: " + id);
		try {
			TAuthorityInst instance = (TAuthorityInst) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityInst",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TAuthorityInst instance) {
		log.debug("finding TAuthorityInst instance by example");
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
		log.debug("finding TAuthorityInst instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityInst as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCIcode(Object CIcode) {
		return findByProperty(_CICODE, CIcode);
	}

	public List findByCIname(Object CIname) {
		return findByProperty(_CINAME, CIname);
	}

	public List findByNIlevel(Object NIlevel) {
		return findByProperty(_NILEVEL, NIlevel);
	}

	public List findByCIleaf(Object CIleaf) {
		return findByProperty(_CILEAF, CIleaf);
	}

	public List findByNItype(Object NItype) {
		return findByProperty(_NITYPE, NItype);
	}

	public List findByCImanager(Object CImanager) {
		return findByProperty(_CIMANAGER, CImanager);
	}

	public List findByCImtel(Object CImtel) {
		return findByProperty(_CIMTEL, CImtel);
	}

	public List findByCImemail(Object CImemail) {
		return findByProperty(_CIMEMAIL, CImemail);
	}

	public List findByCImqq(Object CImqq) {
		return findByProperty(_CIMQQ, CImqq);
	}

	public List findByCIlinkman(Object CIlinkman) {
		return findByProperty(_CILINKMAN, CIlinkman);
	}

	public List findByCIltel(Object CIltel) {
		return findByProperty(_CILTEL, CIltel);
	}

	public List findByCIlemail(Object CIlemail) {
		return findByProperty(_CILEMAIL, CIlemail);
	}

	public List findByCIlqq(Object CIlqq) {
		return findByProperty(_CILQQ, CIlqq);
	}

	public List findByCIaddress(Object CIaddress) {
		return findByProperty(_CIADDRESS, CIaddress);
	}

	public List findByCIdescription(Object CIdescription) {
		return findByProperty(_CIDESCRIPTION, CIdescription);
	}

	public List findByCIcip(Object CIcip) {
		return findByProperty(_CICIP, CIcip);
	}

	public List findByCIcreator(Object CIcreator) {
		return findByProperty(_CICREATOR, CIcreator);
	}

	public List findByCImip(Object CImip) {
		return findByProperty(_CIMIP, CImip);
	}

	public List findByCImodifier(Object CImodifier) {
		return findByProperty(_CIMODIFIER, CImodifier);
	}
	@Override
	public List findByCIons(Object CIons) {
		return findByProperty(_CIONS, CIons);
	}
	
	public List findAll() {
		log.debug("finding all TAuthorityInst instances");
		try {
			String queryString = "from TAuthorityInst";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TAuthorityInst merge(TAuthorityInst detachedInstance) {
		log.debug("merging TAuthorityInst instance");
		try {
			TAuthorityInst result = (TAuthorityInst) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TAuthorityInst instance) {
		log.debug("attaching dirty TAuthorityInst instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TAuthorityInst instance) {
		log.debug("attaching clean TAuthorityInst instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAuthorityInstDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityInstDAO) ctx.getBean("tAuthorityInstDAO");
	}
}