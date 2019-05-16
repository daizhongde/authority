package person.daizhongde.authority.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import person.daizhongde.authority.constant.AuthorityUser;
import person.daizhongde.authority.hibernate.dao.TAuthorityUserDAO;
import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityUserService;
import person.daizhongde.authority.util.TreeDataUtil_User;

import person.daizhongde.virtue.assemble.hql.HQLAssembleQ;
import person.daizhongde.virtue.assemble.hql.HQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleC;
import person.daizhongde.virtue.assemble.sql.SQLAssembleD;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ_CBB;
import person.daizhongde.virtue.assemble.sql.SQLAssembleR;
import person.daizhongde.virtue.assemble.sql.SQLAssembleU;
import person.daizhongde.virtue.codec.PasswordUtil;
import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.constant.INIT;
import person.daizhongde.virtue.constant.Operator;

public class TAuthorityUserServiceImpl implements TAuthorityUserService {

	private static final Log log = LogFactory.getLog(TAuthorityUserServiceImpl.class);
	
	private TAuthorityUserDAO dataDAO;

	private PasswordUtil  pwdUtil;
	
	private TreeDataUtil_User mdUtil = new TreeDataUtil_User();
	
	public void updateLogState( String state, Integer N_UID, String ip ){
		if("0".equalsIgnoreCase(state)){
			dataDAO.updateLogState20( state, N_UID );
		}else{
			dataDAO.updateLogState21( state, N_UID, ip );
		}
//		dataDAO.updateLogState( state, N_UID );
	};
	
	public TAuthorityUser findById( int id ){
		return dataDAO.findById( new Integer(id) );
	}
	public TAuthorityUser findByLogname( String logname ){
		List list = dataDAO.findByCUlogname( logname );
//		System.out.println("list.size():"+list.size());
		return list.size()==1?(TAuthorityUser)list.get(0): null;
	}
	
	public long getOnlineCount(){
		return dataDAO.getOnlineCount( );
	}
	
	public String getCBBData_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

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
	public String getCip(SQLAssembleQ asQ){ 
		
		return dataDAO.sqlQueryfindaValueByMap( asQ.getSQL(), asQ.getMap() ).toString();
		
	}
	public String getCBBDataInArray_Id(String jdata){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();
		
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
	public String getData_JEasyUI_CBT_Async( Integer moduleid, boolean WithRoot ){
		if(WithRoot)
		{
			return getData_JEasyUI_CBT_AsyncWithRoot(moduleid);
		}
		else
		{
			return getData_JEasyUI_CBT_AsyncNoRoot(moduleid);
		}
	}
	
	
	public String getData_JEasyUI_CBT_AsyncWithRoot( Integer moduleid ){
		List dataList = new ArrayList();//Root's children

		List<TAuthorityUser> rootModules = dataDAO.findAllBoss();
		
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, rootModules );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
		return jsonArray.toString();
	}
	
	/**
	 * Usually, It would not use this method
	 * @param moduleid
	 * @return
	 */
	public String getData_JEasyUI_CBT_AsyncNoRoot( Integer moduleid ) {
		List dataList = new ArrayList();//Root's children
		
		List moduleList = dataDAO.findChildrenNoRecursive( moduleid );//module's children
		mdUtil.assembleData_JEasyUI_CBT_Async( dataList, moduleList );
		
		JSONArray jsonArray = JSONArray.fromObject(dataList);
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
		AbstractConstant absConstant = new AuthorityUser();
		Map data = jsonObject.getJSONObject("data");
		data.put("password", 
				pwdUtil.encode( 
						data.get("password").toString() 
				) 
			);
		
		Map valueMap = new HashMap();
		valueMap.put(absConstant.getPrimaryKeyColumnName(), INIT.AUTH_schema + "." + absConstant.getPrimaryKeySequence()+".nextval");

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				data,
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				valueMap
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
		AbstractConstant absConstant = new AuthorityUser();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityUserService#addWithId(java.lang.String)
	 */
	@Override
	public int addWithId( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

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
		AbstractConstant absConstant = new AuthorityUser();

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
		return new Integer(sqlA.getMap().get("id").toString()).intValue();
	}
	
	@Override
	public void addBySavePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		SQLAssembleC sqlA = new SQLAssembleC(
				INIT.AUTH_schema,
				absConstant.getTableName(),
				jsonObject.getJSONObject("data"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
				);
		
		TAuthorityUser pojo = new TAuthorityUser();
		Map map =sqlA.getMap();

		TAuthorityInst inst = new TAuthorityInst();
		inst.setNIid( new Integer( 
				String.valueOf( map.get("iid") ) 
				) );
		pojo.setTAuthorityInst(inst);
		pojo.setCUlogname( String.valueOf(map.get("logname")) );
		pojo.setCUname(String.valueOf(map.get("name")) );
		pojo.setCUpassword(
//			String.valueOf(map.get("password"))
			pwdUtil.encode( map.get("password").toString() )
		);
		pojo.setCUsex(String.valueOf(map.get("sex")) );
		pojo.setEmployeeNumber( String.valueOf(map.get("employee_number")) );
		pojo.setSupervisorId( Integer.valueOf(map.get("supervisor_id").toString()) );
		
		pojo.setCUphone(String.valueOf(map.get("phone")) );
		pojo.setCUemail(String.valueOf(map.get("email")) );
		pojo.setCUqq(String.valueOf(map.get("qq")) );
		pojo.setCUaddr(String.valueOf(map.get("addr")) );
		pojo.setCUnote(String.valueOf(map.get("note")) );
		pojo.setCUtel(String.valueOf(map.get("tel")) );
		pojo.setCUfax(String.valueOf(map.get("fax")) );
		
		dataDAO.save(pojo);
		
	}
	public void addBySavePOJO2( Object pojo ){
		
	}
	
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityUserService#modify(java.lang.String)
	 */
	@Override
	public int modify( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		Map data = jsonObject.getJSONObject("data");
		if( data.containsKey("password") )
		{
			data.put("password", pwdUtil.encode( 
					data.get("password").toString() 
					)
			);
		}
		SQLAssembleU sqlA = new SQLAssembleU(
				INIT.AUTH_schema,
				absConstant.getSQLDOC(),
				absConstant.getTableName(),
				data,
				jsonObject.getJSONObject("algorithm"),
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
	}
	public int modifyPWD( String jdata ) throws Exception{
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		Map data = jsonObject.getJSONObject("data");
		if( data.containsKey("password") )
		{
			data.put("password", pwdUtil.encode( 
					data.get("password").toString() 
					)
			);
		}
		
		Map cond = jsonObject.getJSONObject("condition");
		System.out.println("cond:"+ JSONObject.fromObject(cond).toString() );
		
		String oldPwd = cond.get("oldPwd").toString();
		cond.remove("oldPwd");

		TAuthorityUser user = dataDAO.findById( jsonObject.getJSONObject("condition").getInt("id") );
		
		if(pwdUtil.check( oldPwd, user.getCUpassword() ) ) 
		{
			SQLAssembleU sqlA = new SQLAssembleU(
					INIT.AUTH_schema,
					absConstant.getSQLDOC(),
					absConstant.getTableName(),
					data,
					jsonObject.getJSONObject("algorithm"),
					cond,
					jsonObject.getJSONObject("operator"),
					absConstant.getColumnTypes(),
					absConstant.getFront2col() );
			
			return dataDAO.sqlQueryExeUByMap(sqlA.getSQL(), sqlA.getMap());
		}
		else
		{
			throw new Exception("原密码不正确！");
//			return -1;
		}		
	}
	@Override
	public Map browse(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

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
		AbstractConstant absConstant = new AuthorityUser();
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
		AbstractConstant absConstant = new AuthorityUser();
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
		AbstractConstant absConstant = new AuthorityUser();

		SQLAssembleR sqlA = new SQLAssembleR(
				absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col() );
		
		return (Object[])dataDAO.sqlQuerylistAllRetArrayByMap( sqlA.getSQL(), sqlA.getMap() ).get(0);
	}
	
	public TAuthorityUser browsePOJO(String jdata) {
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		HQLAssembleR hqlA = new HQLAssembleR(absConstant.getSQLDOC(),
				absConstant.getRead_SQL(), 
				jsonObject.getJSONObject("condition"),
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2back() );
		
		return (TAuthorityUser)dataDAO.listAllByMap( "from TAuthorityUser t1 where "+hqlA.getWhereBackHQL(), hqlA.getMap() ).get(0);
	}
	public TAuthorityUser browsePOJOById(int id) {
		return dataDAO.findById( id );
	}
	
	public TAuthorityUser browsePOJOById(String id) {
		return dataDAO.findById( Integer.valueOf(id).intValue() );
	}
	/* (non-Javadoc)
	 * @see person.daizhongde.authority.spring.service.impl.TAuthorityUserService#delete(java.lang.String)
	 */
	@Override
	public int delete( String jdata ){
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

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

	public void setDataDAO(TAuthorityUserDAO dataDAO) {
		this.dataDAO = dataDAO;
	}

	public void setPwdUtil(PasswordUtil pwdUtil) {
		this.pwdUtil = pwdUtil;
	}
	public static TAuthorityUserService getFromApplicationContext(
			ApplicationContext ctx) {
		return (TAuthorityUserService) ctx.getBean("tAuthorityUserService");
	}
}
