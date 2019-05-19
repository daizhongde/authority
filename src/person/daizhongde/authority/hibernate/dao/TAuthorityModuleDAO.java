package person.daizhongde.authority.hibernate.dao;

import java.util.List;

import person.daizhongde.authority.hibernate.pojo.TAuthorityModule;

import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityModuleDAO extends SpringHibernateDao{

	// property constants
	public static final String _CMNAME = "CMname";
	public static final String _CMLEAF = "CMleaf";
	public static final String _NMLEVEL = "NMlevel";
	public static final String _NMPARENT = "NMparent";
	public static final String _NMORDER = "NMorder";
	public static final String _CMICONCLS = "CMiconcls";
	public static final String _CMEXPANDED = "CMexpanded";
	public static final String _CMCHECKED = "CMchecked";
	public static final String _CMPATH = "CMpath";
	public static final String _CMNOTE = "CMnote";
	public static final String _NMCUSER = "NMcuser";
	public static final String _CMCIP = "CMcip";
	public static final String _NMMUSER = "NMmuser";
	public static final String _CMMIP = "CMmip";
	public static final String _CMONS = "CMons";
	
	//通过userid查询module的sql
	public static final String moduleSql = "select * from "+ INIT.AUTH_schema +".T_AUTHORITY_module a where a.n_mid in " +
			"(select distinct b.n_mid " +
			" from "+ INIT.AUTH_schema +".T_AUTHORITY_rmrelation b where b.c_rid in " +
			"  (select c.c_rid from "+ INIT.AUTH_schema +".T_AUTHORITY_role c where c.c_rname in " +
			"    (select d.c_rname from "+ INIT.AUTH_schema +".T_AUTHORITY_user d where d.n_uid=?)" +
			"   ) " +
			")  order by n_mid asc ";
	
	public static final String SelectSQL = "select " +
			"a.n_id,     a.c_xm,   a.c_zjhm, a.c_zjlx, a.c_yhkh, " +
			"a.c_bglx,   a.c_jyfqf,a.n_clbz, a.c_jbsj, a.c_wjpch, " +
			"decode(a.c_jyfqf,'1',c.param_value,'2',b.param_value,a.c_zjlx) zjlx, " +
			"d.param_value kbglx,a.C_jyrq,a.C_jylsh,a.c_gettime " +  
			"from t_online_trans a " +
			"left outer join T_SBQZ_SETTING b on b.param_describe='身份证件类型' and a.c_zjlx=b.param_key " +
			"left outer join T_SBQZ_SETTING c on c.param_describe='身份证件类型-IC卡系统' and a.c_zjlx=c.param_key " +
			"left outer join T_SBQZ_SETTING d on d.param_describe='卡变更类型' and a.c_bglx=d.param_key ";
	
	public static final String SelectHQL = "from TAuthorityModule m order by NMlevel,NMtype,NMorder ";
	
	
	/** 默认natice sql OrderBy语句  */
	public static final String SQLOrderBy = "order by a.n_id desc ";
	public static final String SQLOrderByDesc = "order by 1 desc ";
	public static final String SQLOrderByAsc = "order by 1 asc ";
	
	/** 默认HQL OrderBy语句  */
	public static final String HQLOrderBy = "order by a.NFid desc ";
	public static final String HQLOrderByDesc = "order by 1 desc ";
	public static final String HQLOrderByAsc = "order by 1 asc ";
	
	public abstract List findAllWithOrder();
	public abstract List findLevel1();
	/**
	 * 通过用户ID查询该用户所能访问的所有模块列表
	 * @param userid
	 * @return
	 */
	public abstract List findByUserId(Long userId);
	
	public abstract List findChildrenRecursive( Integer parentId );
	/**
	 * 管理员用,区别于不带_ExceptDev的方法就是少了开发人员专用模块
	 * <p>开发人员专用模块ID:
	 * (98,9801,9802,9803,9804,9805,9806)
	 * @param parentId
	 * @return
	 */
	public abstract List findChildrenRecursive_ExceptDev( Integer parentId );
	
	public abstract List findChildrenRecursive( Integer parentId, Integer maxLevel );
	
	public abstract List findChildrenNoRecursive( Integer parentId );
	/**
	 * 通过上级模块ID查询该模块的子模块
	 * @param parentId
	 * @return
	 */
	public abstract List findChildren( Integer parentId, boolean recursive, Integer maxLevel );
	
	/**
	 * 通过上级模块ID查询该模块的子模块ID
	 * @param parentId
	 * @return
	 * @deprecated
	 
	public abstract List findChildrenIDRecursiveByParentId( Integer parentId );*/
	
	/**
	 * 分页查询时用到
	 * @param sql
	 * @param map
	 * @return 记录总条数
	 *
	public abstract Object sqlQueryfindaValueByMap(final String sql, final Map map );
	
	/**
	 * 分页查询时用到
	 * @param sql
	 * @param values
	 * @return 记录总条数
	 *
	public abstract Integer sqlQueryGetTotal(final String sql, final Object[] values);
	
	
	/**
	 * 分页查询时用到
	 * @param sql
	 * @param map
	 * @return 记录总条数
	 *
	public abstract Integer sqlQueryGetTotal(final String sql, final Map map );
	/**
	 * 分页查询
	 * @param jdata
	 * @param values
	 * @param offset
	 * @param pageSize
	 * @return 指定页的所有行
	 *
	public abstract List sqlQueryGetRows(final String sql, final Object[] values, final Integer offset, final Integer pageSize);

	/**
	 * 分页查询
	 * @param sql
	 * @param map
	 * @param offset
	 * @param pageSize
	 * @return 指定页的所有行
	 *
	public abstract List sqlQueryGetRowsInMap( final String sql, final Map map, Integer offset, Integer pageSize);
	/**
	 * 分页查询
	 * @param sql
	 * @param map
	 * @param offset
	 * @param pageSize
	 * @return 指定页的所有行
	 *
	public abstract List sqlQueryGetRowsInArray( final String sql, final Map map, Integer offset, Integer pageSize);
	
	/**
	 * 装业务SQL组装工作放在service层
	 * @param SQL
	 * @param map
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	public abstract List sqlQueryGetRows(String SQL, Map map, Integer offset, Integer pageSize);
	*/
	
	/** C  **
	public abstract Integer sqlQuerySave(Object[] values);
//	public abstract Integer sqlQuerySave(SQLAssembleC sqlA);
	public abstract Integer sqlQuerySave(String sql, Map map);
	/** U  **
	public abstract Integer sqlQueryModify(Object[] values);
//	public abstract Integer sqlQueryModify(SQLAssembleU sqlA);
	public abstract Integer sqlQueryModify(String sql, Map map);
//	public abstract Integer sqlQueryModify(String sqlSet, String sqlWhere, Object[] values);
	/** R  **
	public abstract Map sqlQueryfindARecordInMap(String sql, Map map);
	public abstract Object[] sqlQueryfindARecordInArray(String sql, Map map);
	/**  D **
	public abstract Integer sqlQueryDelete(Object[] values);
//	public abstract Integer sqlQueryDelete(SQLAssembleD sqlA);
	public abstract Integer sqlQueryDelete(String sql, Map map);
	
	public abstract List sqlQueryfindComboboxDataInMap(String sql, Map map);
	public abstract List sqlQueryfindComboboxDataInArray(String sql, Map map);
	/** return map or array depends on how to write HQL **
	public abstract Map findARecordInMap(String hql, Map map);
	public abstract Object[] findARecordInArray(String hql, Map map);
	public abstract TAuthorityModule findARecordInPOJO( String hql, Map map );
	/** return map or array depends on the HQL **
	public abstract List findComboboxData(String hql, Map map);
	*/
	/** 除了按具体属性查询的方法以及initDao,getFromApplicationContext,hibernate自动生成了9个方法  */
	public abstract void save(TAuthorityModule transientInstance);

	public abstract void delete(TAuthorityModule persistentInstance);

	public abstract TAuthorityModule findById(java.lang.Integer id);

	public abstract List findByExample(TAuthorityModule instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCMname(Object CMname);

	public abstract List findByCMleaf(Object CMleaf);

	public abstract List findByNMlevel(Object NMlevel);

	public abstract List findByNMparent(Object NMparent);

	public abstract List findByNMorder(Object NMorder);

	public abstract List findByCMiconcls(Object CMiconcls);

	public abstract List findByCMexpanded(Object CMexpanded);

	public abstract List findByCMchecked(Object CMchecked);

	public abstract List findByCMpath(Object CMpath);

	public abstract List findByCMnote(Object CMnote);

	public abstract List findByNMcuser(Object NMcuser);

	public abstract List findByCMcip(Object CMcip);

	public abstract List findByNMmuser(Object NMmuser);

	public abstract List findByCMmip(Object CMmip);
	public abstract List findByCMons(Object CMons);
	
	public abstract List findAll();
	
	public abstract TAuthorityModule merge(TAuthorityModule detachedInstance);

	public abstract void attachDirty(TAuthorityModule instance);

	public abstract void attachClean(TAuthorityModule instance);

}