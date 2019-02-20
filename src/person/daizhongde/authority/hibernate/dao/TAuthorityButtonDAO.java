package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityButton;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityButtonDAO extends SpringHibernateDao {

	// property constants
	public static final String _CBCODE = "CBcode";
	public static final String _CBNAME = "CBname";
	public static final String URL = "url";
	public static final String REMARK = "remark";
	public static final String _NMID = "NMid";

	public abstract List findUserButton4tb(Integer moduleId, Integer userId  );
	
	public abstract void save(TAuthorityButton transientInstance);

	public abstract void delete(TAuthorityButton persistentInstance);

	public abstract TAuthorityButton findById(java.lang.Integer id);

	public abstract List findByExample(TAuthorityButton instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCBcode(Object CBcode);

	public abstract List findByCBname(Object CBname);

	public abstract List findByUrl(Object url);

	public abstract List findByRemark(Object remark);

	public abstract List findByNMid(Object NMid);

	public abstract List findAll();

	public abstract TAuthorityButton merge(TAuthorityButton detachedInstance);

	public abstract void attachDirty(TAuthorityButton instance);

	public abstract void attachClean(TAuthorityButton instance);

}