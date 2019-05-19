package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityRoleDAO extends SpringHibernateDao{

	// property constants
	public static final String _CRNO = "CRno";
	public static final String _CRNAME = "CRname";
	public static final String _CRNOTE = "CRnote";
	public static final String _CRCIP = "CRcip";
	public static final String _CRCREATOR = "CRcreator";
	public static final String _CRONS = "CRons";
	
	public abstract List<TAuthorityRole> findByUserId(Long userId);
	
	public abstract List findAllWithOrder();
	/**
	 * 约定开发人员角色ID是99
	 * @return
	 */
	public abstract List findAllWithOrder_ExceptDev();
	
	public abstract void save(TAuthorityRole transientInstance);

	public abstract void delete(TAuthorityRole persistentInstance);

	public abstract TAuthorityRole findById(java.lang.Short id);

	public abstract List findByExample(TAuthorityRole instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCRname(Object CRname);

	public abstract List findByCRnote(Object CRnote);

	public abstract List findByCRcip(Object CRcip);

	public abstract List findByCRcreator(Object CRcreator);
	public abstract List findByCRons(Object CRons);
	
	public abstract List findAll();

	public abstract TAuthorityRole merge(TAuthorityRole detachedInstance);

	public abstract void attachDirty(TAuthorityRole instance);

	public abstract void attachClean(TAuthorityRole instance);

}