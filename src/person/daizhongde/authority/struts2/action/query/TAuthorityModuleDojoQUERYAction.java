package person.daizhongde.authority.struts2.action.query;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import person.daizhongde.authority.constant.AuthorityModule;
import person.daizhongde.authority.spring.service.TAuthorityModuleService;
import person.daizhongde.authority.struts2.action.BaseAction;

import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.constant.AbstractConstant;
import net.sf.json.JSONObject;

/**
 * 模块信息查询
 * <br>only used by dojo
 * <br>this type Acitons whose name are match "*DojoQUERYAction"
 * <br>are only do a work: query table data
 * <p>These who use converter is not contains order parameter
 * <br>This class use converter TypeConverter_Dojo2YUI3_SortList
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityModuleDojoQUERYAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numRows;// 只有private的变量(并且定义get方法)json插件才能返回
	private String identifier;// 
	private String label;// 
	private List items;//results

	/** 起始记录索引(页号) **/
	protected int start;// record start index, begin from 0. no pageNumber-没有页码
	protected int count;//pageSize
	
	protected String jdata;

	/**
	 * -LEVEL1,LEAF 
	 * [{attribute: 'LEVEL1', descending: true },{attribute: 'LEAF', descending: false}]
	 *  <br>[{attribute: "LEVEL1"}] 
	 *  <br>descending: default: false 默认情况下，数值排序是升序的(列名或列索引前面没有序号)
	 *  <br>because oracle "select ***...  order by -LEAF" can't execute, there column 'LEAF' type is varchar2, so use List<Map> instead of String[]
	 *    **/
	//@SuppressWarnings("rawtypes")
	private List<Map> sort;
//	private String sort;
	
	protected TAuthorityModuleService dataService;

	/**
	 * 查询模块信息 row is json
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind() {		
//		int offset = (page - 1) * pageSize;// 第一条记录的索引;
		
//		int pageNumber=( start + count ) / count;
//		int offset = ( pageNumber - 1) * count;// 第一条记录的索引;
		
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql和参数values
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		/*List<Map> sort = new LinkedList<Map>();
		Map map = new HashMap();
		map.put( "attribute", this.sort );
		if( this.order.equalsIgnoreCase("asc") ){
			map.put( "descending", false );
		}else{
			map.put( "descending", true );
		}
		sort.add(map);*/
		
//		String[] sort = this.sort.trim().split(",");
		
//		SQLAssembleQ sqlA = new SQLAssembleQ(jsonObject, absConstant, this.order, this.sort);
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				this.sort
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			numRows = 0;
			items = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			numRows = dataService.getTotal(sqlA);
			items = dataService.getRowsInMap(sqlA, start, count);
		}
		identifier = "id";
		label = "id";
		return SUCCESS;
	}
	
	/**
	 * 查询模块信息 row is array
	 * <br>invoke service method: getRowsInArray
	 * @return
	 */
	public String dfindArray() {		
//		int offset = (page - 1) * pageSize;// 第一条记录的索引;
		
//		int pageNumber=( start + count ) / count;
//		int offset = ( pageNumber - 1) * count;// 第一条记录的索引;
		
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql和参数values
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
//		String[] sort = this.sort.trim().split(",");
		
//		SQLAssembleQ sqlA = new SQLAssembleQ(jsonObject, absConstant, this.order, this.sort);
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				this.sort
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			numRows = 0;
			items = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			numRows = dataService.getTotal(sqlA);
			items = dataService.getRowsInArray(sqlA, start, count);
		}
		identifier = "id";
		label = "id";
		return SUCCESS;
	}

	/**
	 * 查询模块总数
	 * 
	 * @return
	 */
	public String dfindTotal() {
		// 当jdata.condition为空 没有where条件
		// 在这里读配置文件sql并组装sql的where条件
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col()
			);
		
		numRows = dataService.getTotal(sqlA);
		return SUCCESS;
	}

	public void validate() {
		if (jdata.length() == 0) {
//			addFieldError("jdata", getText("jdata.required"));
//			addFieldError("jdata", "you must input jdata!");
		} else {
//			JSONObject jsonObject = JSONObject.fromObject(jdata);
//			JdataChecker checker = new JdataChecker(jsonObject, "TAuthorityModule");
//			String result =  checker.queryCheck();
//			System.out.println(result);
//			if(!result.equalsIgnoreCase("true")){
//				addFieldError("jdata", result);
//			}
		}
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setSort(List<Map> sort) {
		this.sort = sort;
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}
	
	public long getNumRows() {
		return numRows;
	}
	public String getIdentifier() {
		return identifier;
	}

	public String getLabel() {
		return label;
	}

	public List getItems() {
		return items;
	}

	public void setDataService(TAuthorityModuleService dataService) {
		this.dataService = dataService;
	}
}
