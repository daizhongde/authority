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
 * <br>only used by yui3
 * <br>this type Acitons whose name are match "*YUI3QUERYAction"
 * <br>are only do a work: query table data
 * <p>These who use converter is not contains order parameter
 * <br>This class use converter TypeConverter_YUI32YUI3_SortList
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityModuleYUI3QUERYAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String callback;
	private int replyCode;
	private String replyText;
	
	private int recordsReturned;
	private long totalItems;
	private List Results;//results
	
	/** start index 起始记录索引 **/
	private int itemIndexStart;
	
	/** end index 结束记录索引 **/
	private int itemIndexEnd;
	
	/** pageNumber 页码  **/
	private int page;
	
	/** pageSize  **/
	private int itemsPerPage;
	/**  	[{"LEVEL1":"desc"},{"LEAF":"asc"}]  **/
	private List<Map> sortBy;
	
	protected String jdata;

	protected TAuthorityModuleService dataService;

	/**
	 * 查询模块信息 row is json
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind() {
		//offset-第一条记录的索引
		itemIndexStart = (page - 1) * itemsPerPage;// 第一条记录的索引,itemIndexStart begin from 0, page begin from 1
				
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sortBy
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			replyCode = 200;
			replyText = "Ok";
			itemIndexStart = 0;
			itemIndexEnd = 0;
			totalItems = 0;
			Results = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			replyCode = 200;
			replyText = "Ok";
			totalItems = dataService.getTotal(sqlA);
			Results = dataService.getRowsInMap(sqlA, itemIndexStart, itemsPerPage);
			itemIndexEnd = itemIndexStart + Results.size();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询模块信息 row is array
	 * <br>invoke service method: getRowsInArray
	 * @return
	 */
	public String dfindArray() {		
		//offset-第一条记录的索引
		itemIndexStart = (page - 1) * itemsPerPage;// 第一条记录的索引,itemIndexStart begin from 0, page begin from 1
				
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		SQLAssembleQ sqlA = new SQLAssembleQ(
				absConstant.getSQLDOC(),
				absConstant.getQuery_SQL(),
				jsonObject.getJSONObject("condition"), 
				jsonObject.getJSONObject("operator"),
				absConstant.getColumnTypes(),
				absConstant.getFront2col(),
				sortBy
			);
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			replyCode = 200;
			replyText = "Ok";
			itemIndexStart = 0;
			itemIndexEnd = 0;
			totalItems = 0;
			Results = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			replyCode = 200;
			replyText = "Ok";
			totalItems = dataService.getTotal(sqlA);
			Results = dataService.getRowsInArray(sqlA, itemIndexStart, itemsPerPage);
			itemIndexEnd = itemIndexStart + Results.size();
		}
		return SUCCESS;
	}

	/**
	 * 查询模块总数
	 * 
	 * @return
	 */
	public String dfindTotal() {
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
		
		totalItems = dataService.getTotal(sqlA);
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public void setSortBy(List<Map> sortBy) {
		this.sortBy = sortBy;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public String getReplyText() {
		return replyText;
	}

	public int getRecordsReturned() {
		return recordsReturned;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public List getResults() {
		return Results;
	}

	public int getItemIndexStart() {
		return itemIndexStart;
	}

	public int getItemIndexEnd() {
		return itemIndexEnd;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}

	public void setDataService(TAuthorityModuleService dataService) {
		this.dataService = dataService;
	}
}
