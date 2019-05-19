package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelation;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityRmrelationDAO extends SpringHibernateDao {

	// property constants
	public static final String _CCIP = "CCip";
	public static final String _CCREATOR = "CCreator";

	public abstract void save(TAuthorityRmrelation transientInstance);

	public abstract void delete(TAuthorityRmrelation persistentInstance);
/**
 * @deprecated
 * @param moduleId
 * @param userId
 * @return
 */
	public abstract List findUserButton4tb(Integer moduleId, Long userId  );
	
	public abstract TAuthorityRmrelation findById(
			person.daizhongde.authority.hibernate.pojo.TAuthorityRmrelationId id);

	public abstract List findByExample(TAuthorityRmrelation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCCip(Object CCip);

	public abstract List findByCCreator(Object CCreator);

	public abstract List findAll();

	public abstract TAuthorityRmrelation merge(
			TAuthorityRmrelation detachedInstance);

	public abstract void attachDirty(TAuthorityRmrelation instance);

	public abstract void attachClean(TAuthorityRmrelation instance);

}