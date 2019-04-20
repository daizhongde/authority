package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelation;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityUrrelationDAO extends SpringHibernateDao{

	// property constants
	public static final String _CCIP = "CCip";
	public static final String _CCREATOR = "CCreator";

	public abstract void save(TAuthorityUrrelation transientInstance);

	public abstract void delete(TAuthorityUrrelation persistentInstance);

	public abstract TAuthorityUrrelation findById(
			person.daizhongde.authority.hibernate.pojo.TAuthorityUrrelationId id);

	public abstract List findByExample(TAuthorityUrrelation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCCip(Object CCip);

	public abstract List findByCCreator(Object CCreator);

	public abstract List findAll();

	public abstract TAuthorityUrrelation merge(
			TAuthorityUrrelation detachedInstance);

	public abstract void attachDirty(TAuthorityUrrelation instance);

	public abstract void attachClean(TAuthorityUrrelation instance);

}