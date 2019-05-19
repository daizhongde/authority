package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityUserDAO extends SpringHibernateDao {

	// property constants
	public static final String _CULOGNAME = "CUlogname";
	public static final String _CUNAME = "CUname";
	public static final String _CUPASSWORD = "CUpassword";
	public static final String _CUSEX = "CUsex";
	public static final String _CUPHONE = "CUphone";
	public static final String _CUEMAIL = "CUemail";
	public static final String _CUQQ = "CUqq";
	public static final String _CUADDR = "CUaddr";
	public static final String _CUTEL = "CUtel";
	public static final String _CUFAX = "CUfax";
	public static final String _NDID = "NDid";
	public static final String _CUCIP = "CUcip";
	public static final String _CUCREATOR = "CUcreator";
	public static final String _CUMIP = "CUmip";
	public static final String _CUMODIFIER = "CUmodifier";
	public static final String _CUONS = "CUons";
	
	public abstract List<TAuthorityUser> findAllBoss();
	public abstract List findChildrenNoRecursive( Long parentId );
	
	public abstract long getOnlineCount();
	public abstract void updateLogState( String state, Long N_UID );
	public abstract void updateLogState20( String state, Long N_UID );
	public abstract void updateLogState21( String state, Long N_UID, String ip );
	
	public abstract void save(TAuthorityUser transientInstance);

	public abstract void delete(TAuthorityUser persistentInstance);

	public abstract TAuthorityUser findById(java.lang.Long id);

	public abstract List findByExample(TAuthorityUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCUlogname(Object CUlogname);

	public abstract List findByCUname(Object CUname);

	public abstract List findByCUpassword(Object CUpassword);

	public abstract List findByCUsex(Object CUsex);

	public abstract List findByCUphone(Object CUphone);

	public abstract List findByCUemail(Object CUemail);

	public abstract List findByCUqq(Object CUqq);

	public abstract List findByCUaddr(Object CUaddr);

//	public abstract List findByCIcode(Object CIcode);

	public abstract List findByNDid(Object NDid);

	public abstract List findByCUcip(Object CUcip);

	public abstract List findByCUcreator(Object CUcreator);

	public abstract List findByCUmip(Object CUmip);

	public abstract List findByCUmodifier(Object CUmodifier);
	public abstract List findByCUons(Object CUons);
	
	public abstract List findAll();

	public abstract TAuthorityUser merge(TAuthorityUser detachedInstance);

	public abstract void attachDirty(TAuthorityUser instance);

	public abstract void attachClean(TAuthorityUser instance);

}