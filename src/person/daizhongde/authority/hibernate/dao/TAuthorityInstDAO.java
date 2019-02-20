package person.daizhongde.authority.hibernate.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;

import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityInstDAO extends SpringHibernateDao{

	// property constants
	public static final String _CICODE = "CIcode";
	public static final String _CINAME = "CIname";
	public static final String _NILEVEL = "NIlevel";
	public static final String _CILEAF = "CIleaf";
	public static final String _NITYPE = "NItype";
	public static final String _CIMANAGER = "CImanager";
	public static final String _CIMTEL = "CImtel";
	public static final String _CIMEMAIL = "CImemail";
	public static final String _CIMQQ = "CImqq";
	public static final String _CILINKMAN = "CIlinkman";
	public static final String _CILTEL = "CIltel";
	public static final String _CILEMAIL = "CIlemail";
	public static final String _CILQQ = "CIlqq";
	public static final String _CIADDRESS = "CIaddress";
	public static final String _CIDESCRIPTION = "CIdescription";
	public static final String _CICIP = "CIcip";
	public static final String _CICREATOR = "CIcreator";
	public static final String _CIMIP = "CImip";
	public static final String _CIMODIFIER = "CImodifier";
	public static final String _CIONS = "CIons";
	
	public abstract List findAllWithOrder();
	
	public abstract List findChildrenRecursive( Integer parentId );

	public abstract List findChildrenRecursive( Integer parentId, Integer maxLevel );
	
	public abstract List findChildrenNoRecursive( Integer parentId );
	
	/**
	 * 通过上级模块ID查询该模块的子模块
	 * @param parentId
	 * @return
	 */
	public abstract List findChildren( Integer parentId, boolean recursive, Integer maxLevel );
	
	public abstract void save(TAuthorityInst transientInstance);

	public abstract void delete(TAuthorityInst persistentInstance);

	public abstract TAuthorityInst findById(java.lang.Integer id);

	public abstract List findByExample(TAuthorityInst instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCIcode(Object CIcode);

	public abstract List findByCIname(Object CIname);

	public abstract List findByNIlevel(Object NIlevel);

	public abstract List findByCIleaf(Object CIleaf);

	public abstract List findByCImanager(Object CImanager);

	public abstract List findByCImtel(Object CImtel);

	public abstract List findByCImemail(Object CImemail);

	public abstract List findByCImqq(Object CImqq);

	public abstract List findByCIlinkman(Object CIlinkman);

	public abstract List findByCIltel(Object CIltel);

	public abstract List findByCIlemail(Object CIlemail);

	public abstract List findByCIlqq(Object CIlqq);

	public abstract List findByCIaddress(Object CIaddress);

	public abstract List findByCIdescription(Object CIdescription);

	public abstract List findByCIcip(Object CIcip);

	public abstract List findByCIcreator(Object CIcreator);

	public abstract List findByCImip(Object CImip);

	public abstract List findByCImodifier(Object CImodifier);
	public abstract List findByCIons(Object CIons);
	
	public abstract List findAll();

	public abstract TAuthorityInst merge(TAuthorityInst detachedInstance);

	public abstract void attachDirty(TAuthorityInst instance);

	public abstract void attachClean(TAuthorityInst instance);

}