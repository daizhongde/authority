package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityLevel;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityLevelDAO extends SpringHibernateDao{

	// property constants
	public static final String _CLNAME = "CLname";

	public abstract List findAllWithOrder();
	
	public abstract void save(TAuthorityLevel transientInstance);

	public abstract void delete(TAuthorityLevel persistentInstance);

	public abstract TAuthorityLevel findById(java.lang.Short id);

	public abstract List findByExample(TAuthorityLevel instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCLname(Object CLname);

	public abstract List findAll();

	public abstract TAuthorityLevel merge(TAuthorityLevel detachedInstance);

	public abstract void attachDirty(TAuthorityLevel instance);

	public abstract void attachClean(TAuthorityLevel instance);

}