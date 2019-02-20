package person.daizhongde.authority.hibernate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.hibernate.dao.TAuthorityModuleDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityModule;

import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.dao.SpringHibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TAuthorityModule entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see person.daizhongde.person.daizhongde.virtue.ssh.study.TAuthorityModule
 * @author MyEclipse Persistence Tools
 */
public class TAuthorityModuleDAOImpl_Oracle extends SpringHibernateDaoSupport implements TAuthorityModuleDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TAuthorityModuleDAOImpl_Oracle.class);
	protected void initDao() {
		// do nothing
	}

	@Override
	public List findAllWithOrder(){
		
		log.debug("finding all TAuthorityModule instances");
		try {
			String queryString = "from TAuthorityModule m order by m.NMlevel,m.NMorder ";//CMleaf,
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	@Override
	public List findLevel1(){
		
		log.debug("finding all TAuthorityModule instances");
		try {
			String queryString = "from TAuthorityModule m where m.NMlevel=1 order by m.NMorder ";//CMleaf,
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<TAuthorityModule> findByUserId(Integer userId){
		log.debug("findByUserId, find special user's TAuthorityModule instances");
		
		Map map = new HashMap(1);
		map.put("userId", userId);
		return this.NamedQuery("findModuleByUserId_SQLQuery", map);
	}
//	@Override
//	public List findByUserId(Integer userid){
//		//remain to finish.....
//		log.debug("finding special user's TAuthorityModule instances");
//		try {
//			String queryString = "from TAuthorityModule m order by NMlevel,NMorder ";//CMleaf,
//			return getHibernateTemplate().find(queryString);
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
	public List findChildrenRecursive( Integer parentId )
	{
		log.debug("findChildrenRecursive......");
		////my id is other's parent, search downward
		String queryString = "select * " +
							   "from "+ INIT.AUTH_schema +".t_authority_module " +
							  "start with N_Mid= :parentId " +
							"connect by nocycle prior N_Mid=N_Mparent " +
							  "order by N_Mlevel,N_Morder";
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.sqlQuerylistAllByMap( queryString, map, TAuthorityModule.class );
	}
	public List findChildrenRecursive_ExceptDev( Integer parentId )
	{
		log.debug("findChildrenRecursive_ExceptDev......");
		////my id is other's parent, search downward
		String queryString = "select * " +
							   "from "+ INIT.AUTH_schema +".t_authority_module " +
							  "start with N_Mid= :parentId " +
							"connect by nocycle prior N_Mid=N_Mparent and N_Mid not in (98,9801,9802,9803,9804,9805) " +
							  "order by N_Mlevel,N_Morder";
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.sqlQuerylistAllByMap( queryString, map, TAuthorityModule.class );
	}
	public List findChildrenRecursive( Integer parentId, Integer maxLevel )
	{
		log.debug("findChildren......");
		////my id is other's parent, search downward
		String queryString = "select * " +
							   "from "+ INIT.AUTH_schema +".t_authority_module " +
							  "start with N_Mid= :parentId " +
							"connect by nocycle prior N_Mid=N_Mparent and N_MLEVEL <= "+maxLevel+" " +
							  "order by N_Mlevel,N_Morder";
		Map map = new HashMap();
		map.put( "parentId", parentId );
		return this.sqlQuerylistAllByMap( queryString, map, TAuthorityModule.class );
	}

	public List findChildrenNoRecursive( Integer parentId )
	{
		log.debug("findChildren......");
		String queryString = "from TAuthorityModule m " +
						 	"where m.NMparent = :parentId " +
							"order by m.NMlevel, m.NMorder ";
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
	/*@Override
	public List findChildrenRecursiveByParentId( Integer parentId ){
		log.debug("findChildrenRecursiveByParentId......");
		String queryString = "from TAuthorityModule " +
				"start with NMid="+parentId+" connect by prior NMid=NMparent";
		
		return this.listAll( queryString );
	}*/
	
	/*@Override
	public List findChildrenIDRecursiveByParentId( Integer parentId ){
		log.debug("findChildrenIDRecursiveByParentId......");
		String queryString = "select NMid from TAuthorityModule " +
				"start with NMid="+parentId+" connect by prior NMid=NMparent";
		
		return this.listAll( queryString );
		
	}*/
/*
	@Override
	public Integer sqlQueryGetTotal(final String sql, final Object[] values){
		return Integer.valueOf(this.sqlQueryfindaValue(sql,values).toString());
	}

	@Override
	public Integer sqlQueryGetTotal( final String sql, final Map map ){
		return Integer.valueOf(this.sqlQueryfindaValueByMap( sql, map ).toString());
	}
	@Override
	public List sqlQueryGetRows(final String sql, final Object[] values, final Integer offset, final Integer pageSize){
//		sqlWhere="where 1=1 "+sqlWhere;
//		final String sql = SQLSelectF+sqlWhere+SQLOrderBy;
//		List list = getHibernateTemplate().executeFind(
//			new HibernateCallback()
//			{
//				public Object doInHibernate(Session session)
//					throws HibernateException, SQLException
//				{
//					Query query = session.createSQLQuery(sql)
//							.addScalar("id", Hibernate.INTEGER)
//							.addScalar("lotno", Hibernate.STRING)
//							.addScalar("ht", Hibernate.STRING)
//							.addScalar("path", Hibernate.STRING);
//					for (int i = 0 ; i < values.length ; i++)
//					{
//						query.setParameter( i , values[i]);
//					}
//					List result = query.setFirstResult(offset)
//						.setMaxResults(pageSize)
//						.list();
//					return result;
//				}
//			});
//		return list;
//		return this.sqlQueryFindByPage(SQLSelectF+sqlWhere+SQLOrderBy, values, offset, pageSize);
		return this.sqlQueryfindByPage(sql, values, offset, pageSize);
	}

	public List sqlQueryGetRowsInMap(final String sql, final Map map, final Integer offset, final Integer pageSize){
		return this.sqlQueryfindByPageByMap( sql, map, offset, pageSize );
	}
	public List sqlQueryGetRowsInArray(final String sql, final Map map, final Integer offset, final Integer pageSize){
		return this.sqlQueryfindByPageByMapInArray( sql, map, offset, pageSize );
	}
	
	
	public Integer sqlQuerySave(Object[] values){
		Integer i = this.sqlQueryExeU("INSERT INTO t_xxzwzx_announcement(N_AID, C_ATITLE,C_ACONTENT,C_ACLASS, C_ACUSER, C_ACIP,N_ASTATES) " +
		"values(SEQ_XXZWZX_ANNOUNCE_ID.nextval,?,?,?,?,?,?)",values);
		return (Integer)this.sqlQueryfindaValue("select SEQ_XXZWZX_ANNOUNCE_ID.CURRVAL from dual");
	}
//	public Integer sqlQuerySave(SQLAssembleC sqlA){
//		return (Integer)this.sqlQueryExeU(sqlA.getSQL(), sqlA.getMap() );
//	}
	public Integer sqlQuerySave(String sql, Map map){
		return (Integer)this.sqlQueryExeUByMap( sql, map );
	}
	public Integer sqlQueryModify(Object[] values){
		return (Integer)this.sqlQueryExeU("update t_xxzwzx_announcement " +
				"set c_atitle=?,c_acontent=?,c_aclass=?,c_amuser=?,c_amip=?, N_ASTATES=? where n_aid=?",values);
	}

	public Integer sqlQueryModify(String sql, Map map){
		return (Integer)this.sqlQueryExeUByMap( sql, map );
	}

	public Map sqlQueryfindARecordInMap(String sql, Map map){
		return (Map)this.sqlQuerylistAllByMap( sql, map ).get(0);
	}
	@SuppressWarnings("rawtypes")
	public Object[] sqlQueryfindARecordInArray(String sql, Map map){
		return (Object[])this.sqlQuerylistAll( sql, map ).get(0);
	}

	public Integer sqlQueryDelete(Object[] values){
		return (Integer)this.sqlQueryExeU("update t_xxzwzx_announcement set n_astates=1 where n_aid=?",values);
	}
//	public Integer sqlQueryDelete(SQLAssembleD sqlA){
//		return (Integer)this.sqlQueryExeU(sqlA.getSQL(), sqlA.getMap() );
//	}
	public Integer sqlQueryDelete(String sql, Map map){
		return (Integer)this.sqlQueryExeUByMap( sql, map );
	}
	
	public List sqlQueryfindComboboxDataInMap(String sql, Map map){
//		return this.sqlQueryfind(sql, map, ComboboxJSONData.class );
		return this.sqlQuerylistAllByMap( sql, map );
	}
	public List sqlQueryfindComboboxDataInArray(String sql, Map map){
//		return this.sqlQueryfind(sql, map, ComboboxJSONData.class );
		//ordinary return array type data
		return this.sqlQuerylistAllByMap( sql, map );
	}
	
	public Map findARecordInMap(String hql, Map map){
		//HQL contains 'map' keywords
		return (Map)this.listAll( hql, map ).get(0);
	}
	public Object[] findARecordInArray(String hql, Map map){
		return (Object[])this.listAll( hql, map ).get(0);
	}
	public TAuthorityModule findARecordInPOJO( String hql, Map map ){
		return (TAuthorityModule)this.listAll( hql, map ).get(0);
	}
	
	public List findComboboxData(String hql, Map map){
		return this.listAll( hql, map );
	}
	*/
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#save(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public void save(TAuthorityModule transientInstance) {
		log.debug("saving TAuthorityModule instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#delete(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public void delete(TAuthorityModule persistentInstance) {
		log.debug("deleting TAuthorityModule instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findById(java.lang.Integer)
	 */
	@Override
	public TAuthorityModule findById(java.lang.Integer id) {
		log.debug("getting TAuthorityModule instance with id: " + id);
		try {
			TAuthorityModule instance = (TAuthorityModule) getHibernateTemplate()
					.get("person.daizhongde.authority.hibernate.pojo.TAuthorityModule",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByExample(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public List findByExample(TAuthorityModule instance) {
		log.debug("finding TAuthorityModule instance by example");
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

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAuthorityModule instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TAuthorityModule as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMname(java.lang.Object)
	 */
	@Override
	public List findByCMname(Object CMname) {
		return findByProperty(_CMNAME, CMname);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMtype(java.lang.Object)
	 */
	@Override
	public List findByCMleaf(Object CMleaf) {
		return findByProperty(_CMLEAF, CMleaf);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMlevel(java.lang.Object)
	 */
	@Override
	public List findByNMlevel(Object NMlevel) {
		return findByProperty(_NMLEVEL, NMlevel);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMparent(java.lang.Object)
	 */
	@Override
	public List findByNMparent(Object NMparent) {
		return findByProperty(_NMPARENT, NMparent);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMorder(java.lang.Object)
	 */
	@Override
	public List findByNMorder(Object NMorder) {
		return findByProperty(_NMORDER, NMorder);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMiconcls(java.lang.Object)
	 */
	@Override
	public List findByCMiconcls(Object CMiconcls) {
		return findByProperty(_CMICONCLS, CMiconcls);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMstate(java.lang.Object)
	 */
	@Override
	public List findByCMexpanded(Object CMexpanded) {
		return findByProperty(_CMEXPANDED, CMexpanded);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMchecked(java.lang.Object)
	 */
	@Override
	public List findByCMchecked(Object CMchecked) {
		return findByProperty(_CMCHECKED, CMchecked);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMpath(java.lang.Object)
	 */
	@Override
	public List findByCMpath(Object CMpath) {
		return findByProperty(_CMPATH, CMpath);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMnote(java.lang.Object)
	 */
	@Override
	public List findByCMnote(Object CMnote) {
		return findByProperty(_CMNOTE, CMnote);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMcuser(java.lang.Object)
	 */
	@Override
	public List findByNMcuser(Object NMcuser) {
		return findByProperty(_NMCUSER, NMcuser);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMcip(java.lang.Object)
	 */
	@Override
	public List findByCMcip(Object CMcip) {
		return findByProperty(_CMCIP, CMcip);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByNMmuser(java.lang.Object)
	 */
	@Override
	public List findByNMmuser(Object NMmuser) {
		return findByProperty(_NMMUSER, NMmuser);
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findByCMmip(java.lang.Object)
	 */
	@Override
	public List findByCMmip(Object CMmip) {
		return findByProperty(_CMMIP, CMmip);
	}
	@Override
	public List findByCMons(Object CMons) {
		return findByProperty(_CMONS, CMons);
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all TAuthorityModule instances");
		try {
			String queryString = "from TAuthorityModule";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#merge(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public TAuthorityModule merge(TAuthorityModule detachedInstance) {
		log.debug("merging TAuthorityModule instance");
		try {
			TAuthorityModule result = (TAuthorityModule) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#attachDirty(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public void attachDirty(TAuthorityModule instance) {
		log.debug("attaching dirty TAuthorityModule instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see person.daizhongde.authority.hibernate.dao.impl.TAuthorityModuleDAO#attachClean(person.daizhongde.authority.hibernate.pojo.TAuthorityModule)
	 */
	@Override
	public void attachClean(TAuthorityModule instance) {
		log.debug("attaching clean TAuthorityModule instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public static TAuthorityModuleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityModuleDAO) ctx.getBean("tAuthorityModuleDAO");
	}
}