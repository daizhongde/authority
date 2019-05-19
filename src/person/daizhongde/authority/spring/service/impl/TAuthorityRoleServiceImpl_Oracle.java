package person.daizhongde.authority.spring.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityRole;
import person.daizhongde.authority.hibernate.dao.TAuthorityLevelDAO;
import person.daizhongde.authority.hibernate.dao.TAuthorityRoleDAO;
import person.daizhongde.authority.hibernate.pojo.JEasyUI_Tree;
import person.daizhongde.authority.hibernate.pojo.TAuthorityLevel;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityRoleService;
import person.daizhongde.authority.util.TreeDataUtil_Role;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;

public class TAuthorityRoleServiceImpl_Oracle implements TAuthorityRoleService {

	private static final Log log = LogFactory.getLog(TAuthorityRoleServiceImpl_Oracle.class);
	
	private TAuthorityRoleDAO dataDAO;
	private TAuthorityLevelDAO levelDAO;

	private TreeDataUtil_Role mdUtil = new TreeDataUtil_Role();
	
	public List<TAuthorityRole> findRoleByUserId(Long userId ){
		return dataDAO.findByUserId(userId);
	}
	
	public String getCBBData_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() )).toString();
		
	}
	public String getCBBDataInArray_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();
		
		SQLAssembleQ_CBB sqlA = new SQLAssembleQ_CBB(
				absConstant.getSQLDOC(),
				absConstant.getCombobox_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		return JSONArray.fromObject(dataDAO.sqlQuerylistAllRetArrayByMap( sqlA.getSQL(), sqlA.getMap() )).toString();
	}
	
	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Tree(){
//		log.debug("service....AllNode...getData_JEasyUI_Tree...........");
		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
//		List dataList2 = new ArrayList();//Root's children
				
//		List<TAuthorityRole> mList = dataDAO.findAllWithOrder();
//		List<TAuthorityRole> level0ModuleList = new ArrayList<TAuthorityRole>();
		List<TAuthorityLevel> level1ModuleList = levelDAO.findAllWithOrder();
		List<TAuthorityRole> level2ModuleList = dataDAO.findAllWithOrder();
		
//		System.out.println("total module count:"+mList.size());
		
		if( level1ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level1ModuleList.size(); i<j; i++ ){
			
			TAuthorityLevel l = (TAuthorityLevel) level1ModuleList.get(i);
			
			List nextList = new ArrayList();
			JEasyUI_Tree mJEU = new JEasyUI_Tree();

			mdUtil.assembleData_JEasyUI_Tree(nextList, l, level2ModuleList );
			
			LinkedHashMap attr1 = new LinkedHashMap();
			mJEU.setId( l.getNLid().intValue() );
			mJEU.setText( l.getCLname() );
			
			if(nextList.size()==0){
				mJEU.setState("closed");
			}else{
				mJEU.setState( "open" );
			}
			attr1.put("no", "" );
			attr1.put("level", new Integer(1) );
			attr1.put("rlevel", l.getNLid());
			attr1.put("note", l.getCLnote() );
			
			mJEU.setAttributes(attr1);
			mJEU.setChildren(nextList);
			dataList.add(mJEU);
		}

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}

	@SuppressWarnings("unchecked")
	public String getData_JEasyUI_Tree_ExceptDev(){
//		log.debug("service....AllNode...getData_JEasyUI_Tree_ExceptDev...........");
		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node
//		List dataList2 = new ArrayList();//Root's children
				
//		List<TAuthorityRole> mList = dataDAO.findAllWithOrder();
//		List<TAuthorityRole> level0ModuleList = new ArrayList<TAuthorityRole>();
		List<TAuthorityLevel> level1ModuleList = levelDAO.findAllWithOrder();
		List<TAuthorityRole> level2ModuleList = dataDAO.findAllWithOrder_ExceptDev();
		
//		System.out.println("total module count:"+mList.size());
		
		if( level1ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level1ModuleList.size(); i<j; i++ ){
			
			TAuthorityLevel l = (TAuthorityLevel) level1ModuleList.get(i);
			
			List nextList = new ArrayList();
			JEasyUI_Tree mJEU = new JEasyUI_Tree();

			mdUtil.assembleData_JEasyUI_Tree(nextList, l, level2ModuleList );
			
			LinkedHashMap attr1 = new LinkedHashMap();
			mJEU.setId( l.getNLid().intValue() );
			mJEU.setText( l.getCLname() );
			
			if(nextList.size()==0){
				mJEU.setState("closed");
			}else{
				mJEU.setState( "open" );
			}
			attr1.put("no", "" );
			attr1.put("level", new Integer(1) );
			attr1.put("rlevel", l.getNLid());
			attr1.put("note", l.getCLnote() );
			
			mJEU.setAttributes(attr1);
			mJEU.setChildren(nextList);
			dataList.add(mJEU);
		}

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_CheckBoxTree( Integer userId )
	{

		AbstractConstant absConstant = new AuthorityRole();
		Map map = new HashMap();
		map.put( "userId", userId );
		
		String queryString = ((SQLNode)absConstant.getSQLDOC()
					.getTree().get("tree_CheckBoxTree")
				).getSQL();
		

		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node

//		List<TAuthorityRole> mList = dataDAO.findAllWithOrder();
//		List<TAuthorityRole> level0ModuleList = new ArrayList<TAuthorityRole>();
		List<TAuthorityLevel> level1ModuleList = levelDAO.findAllWithOrder();
		List<TAuthorityRole> level2ModuleList = dataDAO.sqlQuerylistAllByMap( queryString, map, TAuthorityRole.class );
		
//		System.out.println("total module count:"+mList.size());
		
		if( level1ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level1ModuleList.size(); i<j; i++ ){
			
			TAuthorityLevel l = (TAuthorityLevel) level1ModuleList.get(i);
			
			List nextList = new ArrayList();
			JEasyUI_Tree mJEU = new JEasyUI_Tree();

			mdUtil.assembleData_JEasyUI_Tree(nextList, l, level2ModuleList );
			
			LinkedHashMap attr1 = new LinkedHashMap();
			mJEU.setId( l.getNLid().intValue() );
			mJEU.setText( l.getCLname() );
			
			if(nextList.size()==0){
				mJEU.setState("closed");
			}else{
				mJEU.setState( "open" );
			}
			attr1.put("no", "" );
			attr1.put("level", new Integer(1) );
			attr1.put("rlevel", l.getNLid());
			attr1.put("note", l.getCLnote() );
			
			mJEU.setAttributes(attr1);
			mJEU.setChildren(nextList);
			dataList.add(mJEU);
		}

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	public String getData_JEasyUI_CheckBoxTree_ExceptDev( Integer userId )
	{

		AbstractConstant absConstant = new AuthorityRole();
		Map map = new HashMap();
		map.put( "userId", userId );
		
		String queryString = ((SQLNode)absConstant.getSQLDOC()
					.getTree().get("tree_CheckBoxTree_ExceptDev")
				).getSQL();
		

		List dataList = new ArrayList();//use to save menu JSON data if it has root node when it have mitiply root node

//		List<TAuthorityRole> mList = dataDAO.findAllWithOrder();
//		List<TAuthorityRole> level0ModuleList = new ArrayList<TAuthorityRole>();
		List<TAuthorityLevel> level1ModuleList = levelDAO.findAllWithOrder();
		List<TAuthorityRole> level2ModuleList = dataDAO.sqlQuerylistAllByMap( queryString, map, TAuthorityRole.class );
		
//		System.out.println("total module count:"+mList.size());
		
		if( level1ModuleList.size()== 0 ){
			return "[]";
		}
		
		for(int i=0, j=level1ModuleList.size(); i<j; i++ ){
			
			TAuthorityLevel l = (TAuthorityLevel) level1ModuleList.get(i);
			
			List nextList = new ArrayList();
			JEasyUI_Tree mJEU = new JEasyUI_Tree();

			mdUtil.assembleData_JEasyUI_Tree(nextList, l, level2ModuleList );
			
			LinkedHashMap attr1 = new LinkedHashMap();
			mJEU.setId( l.getNLid().intValue() );
			mJEU.setText( l.getCLname() );
			
			if(nextList.size()==0){
				mJEU.setState("closed");
			}else{
				mJEU.setState( "open" );
			}
			attr1.put("no", "" );
			attr1.put("level", new Integer(1) );
			attr1.put("rlevel", l.getNLid());
			attr1.put("note", l.getCLnote() );
			
			mJEU.setAttributes(attr1);
			mJEU.setChildren(nextList);
			dataList.add(mJEU);
		}

		JSONArray jsonArray = JSONArray.fromObject(dataList);
//		log.debug("jsonArray:"+jsonArray.toString());
		return jsonArray.toString();
	}
	
	@Override
	public long getTotal(SQLAssembleQ sqlA) {
//		Object o= dataDAO.sqlQueryfindaValueByMap( sqlA.getCountSQL(), sqlA.getMap() );
		return Long.valueOf(
				dataDAO.sqlQueryfindaValueByMap( sqlA.getCountSQL(), sqlA.getMap() ).toString()
			).longValue();
	}
	
	@Override
	public List getRowsInMap(SQLAssembleQ sqlA) {
		return dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() );//使用native数据量小
	}
	@Override
	public List getRowsInMap(SQLAssembleQ sqlA, int offset, int pageSize) {
		return dataDAO.sqlQueryfindByPageByMap(sqlA.getSQL(), sqlA.getMap(), 
				offset, pageSize);//使用native数据量小
	}

	@Override
	public long getTotal(HQLAssembleQ hqlA) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getRowsInMap(HQLAssembleQ hqlA) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getRowsInMap(HQLAssembleQ sqlA, int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List getRowsInArray(SQLAssembleQ sqlA) {
		return dataDAO.sqlQuerylistAllRetArrayByMap(sqlA.getSQL(), sqlA.getMap());//使用native数据量小
	}
	@Override
	public List getRowsInArray(SQLAssembleQ sqlA, int offset,
			int pageSize) {
		return dataDAO.sqlQueryfindRetArrayByPageByMap(sqlA.getSQL(), sqlA.getMap(), 
				offset, pageSize);//使用native数据量小
	}
	@Override
	public int add(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();
		
		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}

	public int add(Map data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRetId(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();
		//nextval  CURRVAL
		Integer id = Integer.valueOf(
				dataDAO.sqlQueryfindaValueByMap("select " + INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".nextval from dual", new HashMap() ).toString()
				);
		
		Map valueMap = new HashMap();
		valueMap.put(absConstant.getPrimaryKeyColumnName(), id);
		if( !jsonObject.getJSONObject("data").containsKey("no") )
		{
			valueMap.put("C_RNO", new DecimalFormat("000").format(id) );
		}
		
		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				valueMap
				);
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		
		/* 2.返回记录ID */
		return id.intValue();
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityRoleService#addWithId(java.lang.String)
	 */
	@Override
	public int addWithId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	@Override
	public int addWithIdRetId(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		
//		return (Integer)sqlA.getMap().get(
//					absConstant.getBack2front().get("NLid")
//				);
		/*The below Code is dependent on front field, 
		 * but sometimes It's compatibility is better then the top Code  */
		return Integer.valueOf( sqlA.getMap().get("id").toString()).intValue();
	}
	
	@Override
	public void addBySavePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		TAuthorityRole pojo = new TAuthorityRole();
		Map map =sqlA.getMap();
		for(int i=0, j=sqlA.getMap().size(); i<j; i++){
//			pojo.setNLid((Short)map.get("id"));
//			pojo.setCLname(String.valueOf(map.get("name")));
		}
		dataDAO.save(pojo);
		
	}
	public void addBySavePOJO2( Object pojo ){
		
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityRoleService#modify(java.lang.String)
	 */
	@Override
	public int modify( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleU sqlA = new SQLAssembleU(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				jsonObject.getJSONObject("algorithm"),
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	@Override
	public Map browse(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}
	@Override
	public Map browseById(int id) {
		AbstractConstant absConstant = new AuthorityRole();
		String pkcolName = absConstant.getPrimaryKeyColumnName();
		
		Map cond = new HashMap(1);
		cond.put( pkcolName, id);
		Map oper = new HashMap(1); 
		oper.put( pkcolName, Operator.EQUAL);
		
		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				cond,
				oper,
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}
	@Override
	public Map browseById(String id) {
		AbstractConstant absConstant = new AuthorityRole();
		String pkcolName = absConstant.getPrimaryKeyColumnName();
		
		Map cond = new HashMap(1);
		cond.put( pkcolName, id);
		Map oper = new HashMap(1); 
		oper.put( pkcolName, Operator.EQUAL);
		
		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				cond,
				oper,
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Map)dataDAO.sqlQuerylistAllByMap(sqlA.getSQL(), sqlA.getMap()).get(0);
	}

	public Object[] browseArray(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Object[])dataDAO.sqlQuerylistAllByMap( sqlA.getSQL(), sqlA.getMap() ).get(0);
	}
	
	public TAuthorityRole browsePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		HQLAssembleR hqlA = new HQLAssembleR(absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2back() );
		
		return (TAuthorityRole)dataDAO.listAllByMap( "from TAuthorityRole t1 where "+hqlA.getWhereBackHQL(), hqlA.getMap() ).get(0);
	}
	public TAuthorityRole browsePOJOById(long id) {
		return dataDAO.findById((short)id);
	}
	public TAuthorityRole browsePOJOById(String id) {
		return dataDAO.findById( Short.valueOf(id).shortValue() );
	}
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityRoleService#delete(java.lang.String)
	 */
	@Override
	public int delete( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityRole();

		SQLAssembleD sqlA = new SQLAssembleD(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	@Override
	public int deleteNP(String jdata) {
		return this.modify(jdata);
	}

	public void setDataDAO(TAuthorityRoleDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public void setLevelDAO(TAuthorityLevelDAO levelDAO) {
		this.levelDAO = levelDAO;
	}
	public static TAuthorityRoleService getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityRoleService) ctx.getBean("tAuthorityRoleService");
	}
}
