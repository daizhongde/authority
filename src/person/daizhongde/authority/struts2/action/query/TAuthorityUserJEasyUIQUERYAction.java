package person.daizhongde.authority.struts2.action.query;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import person.daizhongde.authority.constant.AuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityUserService;
import person.daizhongde.authority.struts2.action.BaseAction;

import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.configutils.SQLNode;
import person.daizhongde.virtue.constant.AbstractConstant;
import net.sf.json.JSONObject;

/**
 * 用户信息查询-JQueryEasyUI DataGrid
 * <br>only used by jquery-easy-ui
 * <br>this type Acitons whose name are match "*JEasyUIQUERYAction"
 * <br>are only do a work: query table data
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityUserJEasyUIQUERYAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long total;// 只有private的变量(并且定义get方法)json插件才能返回
	private List rows;// pageSize->results

	private long online;
	private String json;
	
	/** 页号 **/
	protected int page;// pageNumber
	
	protected String jdata;
	/** level,leaf */
	protected String sort;//sort column name or column's index
	/** desc,asc */
	protected String order;//'desc','asc' can be used
	
	protected TAuthorityUserService dataService;

	/**
	 * 查询用户信息 row is json
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind() {
		int pageSize = Integer.parseInt(rows==null?"0":rows.get(0).toString());// pageSize
		int offset = (page - 1) * pageSize;// 第一条记录的索引,offset begin from 0, page begin from 1
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql和参数values
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();
		
		/*
		 * <p>dojo style
		 * <br>[{attribute: "LEVEL1", descending: true},{attribute: "LEAF", descending: false}]
		 * <br>[{attribute: "LEVEL1"}] 
		 * <br>descending: default: false 默认情况下，数值排序是升序的
		 * <br>default: asc
		 * 
		List<Map> sort = new ArrayList<Map>();
		Map map = new HashMap();
		map.put( "attribute", this.sort );
		if( this.order.equalsIgnoreCase("asc") ){
			map.put( "descending", false );
		}else{
			map.put( "descending", true );
		}
		sort.add(map);
			*/	
		
		/** YUI3 style  
		 * <br>[ { LEVEL1:'desc'  }, { LEAF:'asc'} ]
		 * **/ 
		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			String[] a1 = this.sort.split("\\,");
			String[] a2 = this.order.split("\\,");
			
			for(int i=0, j=a1.length; i<j; i++ ){
				Map map = new HashMap();
				map.put( a1[i], a2[i] );
				sort.add(map);
			}
		}
		
//		String[] sort = new String[1];
//		sort[0] = order.trim().equalsIgnoreCase("asc")?"":"-" + this.sort;
		
//		SQLAssembleQ sqlA = new SQLAssembleQ(jsonObject, absConstant, this.order, this.sort);
//		System.out.println("absConstant.getQuery_SQL():"+absConstant.getQuery_SQL());
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
//				((SQLNode)absConstant.getSQLDOC()
//						.getQuery().get("query")
//					).getSQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sort
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery") ){
			total = 0;
			rows = new ArrayList();
		}else if( pageSize==0 ){//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA);
		}else{//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA, offset, pageSize);
		}
		return SUCCESS;
	}
	/**
	 * 查询用户信息 row is json
	 * <p>返回结果不包括拥有开发者角色的用户
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind_ExceptDev() {
		int pageSize = Integer.parseInt(rows==null?"0":rows.get(0).toString());// pageSize
		int offset = (page - 1) * pageSize;// 第一条记录的索引,offset begin from 0, page begin from 1
		
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			String[] a1 = this.sort.split("\\,");
			String[] a2 = this.order.split("\\,");
			
			for(int i=0, j=a1.length; i<j; i++ ){
				Map map = new HashMap();
				map.put( a1[i], a2[i] );
				sort.add(map);
			}
		}
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
//				absConstant.getQuery_SQL(),
				((SQLNode)absConstant.getSQLDOC()
						.getQuery().get("query_ExceptDev")
					).getSQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sort
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery") ){
			total = 0;
			rows = new ArrayList();
		}else if( pageSize==0 ){//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA);
		}else{//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA, offset, pageSize);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户信息 row is json
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind4Chat() {
		int pageSize = Integer.parseInt(rows==null?"0":rows.get(0).toString());// pageSize
		int offset = (page - 1) * pageSize;// 第一条记录的索引,offset begin from 0, page begin from 1
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql和参数values
		JSONObject jsonObject=null;
		if(null==jdata || "".equalsIgnoreCase(jdata)){
			jsonObject = new JSONObject();
		}else{
			 jsonObject = JSONObject.fromObject(jdata);
		}
		AbstractConstant absConstant = new AuthorityUser();

		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			String[] a1 = this.sort.split("\\,");
			String[] a2 = this.order.split("\\,");
			
			for(int i=0, j=a1.length; i<j; i++ ){
				Map map = new HashMap();
				map.put( a1[i], a2[i] );
				sort.add(map);
			}
		}

		/** 给sql文件中的静态sql参数赋值  */
		Map param = new HashMap(1);
		/** 因为用户pojo中的inst成员是通过dept字段关联查询的     */
		param.put("did", super.getLoginUser().getTAuthorityInst().getNIid() );
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				((SQLNode)absConstant.getSQLDOC()
						.getQuery().get("query4Chat")
					).getSQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sort
			);
		sqlA.setMap(param);
		
		if( jsonObject.containsKey("act") && jsonObject.getString("act").equalsIgnoreCase("noquery") ){
			total = 0;
			rows = new ArrayList();
		}else if( pageSize==0 ){//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA);
			online = dataService.getOnlineCount();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
			rows = dataService.getRowsInMap(sqlA, offset, pageSize);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户信息 row is array
	 * <br>invoke service method: getRowsInArray
	 * @return
	 */
	public String dfindArray() {
		int pageSize = Integer.parseInt(rows.get(0).toString());// pageSize
		int offset = (page - 1) * pageSize;// 第一条记录的索引;
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql的where条件
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();
		
		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			Map map = new HashMap();
			map.put( this.sort, this.order );
			sort.add(map);
		}
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sort
			);
		
//		sqlA.setOrder(this.order);
//		sqlA.setSort(this.sort);
//		System.out.println("action:"+this.order+" "+this.sort);
//		List<Integer> a = new LinkedList<Integer>();
//		a.add(0);
//		a.add(1);
//		a.add(2);
//		a.add(3);
//		
//		List<String> b = new LinkedList<String>();
//		b.add("R");
//		b.add("B");
//		
//		Object[] values = new Object[4];
//		values[0]=1;
//		values[1]="%统%";
//		values[2]=a;
//		values[3]=b;
//		sqlA.setValues(values);
//		sqlA.setSqlCondition("t1.n_mid = ? and t1.c_mname like ? and t1.n_mlevel in ? and t1.c_mtarget in ( ? )");
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			total = 0;
//			rows = null;
			rows = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			total = dataService.getTotal(sqlA);
//			if( sort == null ){
//				rows = dataService.getRows(sqlA, offset, pageSize);
//			}else{
//				rows = dataService.getRows(sqlA, sort, order,offset, pageSize);
//			}
			rows = dataService.getRowsInArray(sqlA, offset, pageSize);
//			rows = dataService.getRows(jdata, this.order, this.sort, offset, pageSize);
		}
		
//		Map map = new HashMap();
//		total = dataService.getTotal(map);
//		rows = dataService.getRows(map, offset, pageSize);
		return SUCCESS;
	}

	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	public String dfindTotal() {
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql的where条件
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityUser();

		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		total = dataService.getTotal(sqlA);
		return SUCCESS;
	}
	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	public String dfindCip() {
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql的where条件
		int cip = super.getUserId();
		
		JSONObject jsonObject = JSONObject.fromObject("{act:\"query\",condition:{},operator:{}}");
		AbstractConstant absConstant = new AuthorityUser();

		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				"SELECT c_ucip FROM t_authority_user WHERE n_uid="+cip,
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		json = dataService.getCip(sqlA);
		if( StringUtils.isNotBlank( json ) ){
			//反转
			StringBuffer sb = new StringBuffer(json);
			sb = sb.reverse();
			String reve=sb.toString();
//		     System.out.println("反转:"+reve);
		    //解密
			byte[] byteArr = Base64.getDecoder().decode(reve);
			json = new String(byteArr);
//			System.out.println("解密:" + emailpwd);
		}else{
			json="";
		}
		return "json";
	}

	public void validate() {
//		if (jdata.length() == 0) {
//			addFieldError("jdata", getText("jdata.required"));
//			addFieldError("jdata", "you must input jdata!");
//		} else {
//			JSONObject jsonObject = JSONObject.fromObject(jdata);
//			String result =  checker.queryCheck();
//			System.out.println(result);
//			if(!result.equalsIgnoreCase("true")){
//				addFieldError("jdata", result);
//			}
//		}
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSort(String sort) {
//		this.sort = String.valueOf(Integer.valueOf(sort) + 1 );//where datatable's data is array use NO. to order, because front column index begin from 0 ,so plus one
		this.sort = sort;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("#######");
		log.debug("decoded jdata:" + decode.toString());
		log.debug("#######");
		this.jdata = decode;
	}
//	public void setParam(AParameter param) {
//		this.param = param;
//	}
//	
//	public AParameter getParam() {
//		return param;
//	}

	public void setDataService(TAuthorityUserService dataService) {
		this.dataService = dataService;
	}
	public long getOnline() {
		return online;
	}
	public void setOnline(long online) {
		this.online = online;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
}
