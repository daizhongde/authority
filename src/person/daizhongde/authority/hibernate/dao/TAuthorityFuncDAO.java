package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityFunc;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityFuncDAO extends SpringHibernateDao {

	//property constants
	public static final String _CFCODE = "CFcode";
	public static final String _CFNAME = "CFname";
	public static final String _CCIP = "CCip";
	public static final String _CCREATOR = "CCreator";

	public abstract void save(TAuthorityFunc transientInstance);

	public abstract void delete(TAuthorityFunc persistentInstance);

	public abstract TAuthorityFunc findById(java.lang.Short id);

	public abstract List findByExample(TAuthorityFunc instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCFcode(Object CFcode);

	public abstract List findByCFname(Object CFname);

	public abstract List findByCCip(Object CCip);

	public abstract List findByCCreator(Object CCreator);

	public abstract List findAll();

	public abstract TAuthorityFunc merge(TAuthorityFunc detachedInstance);

	public abstract void attachDirty(TAuthorityFunc instance);

	public abstract void attachClean(TAuthorityFunc instance);

}