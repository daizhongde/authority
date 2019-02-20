package person.daizhongde.authority.struts2.action.query;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * <br>only used by Ext3,Ext4
 * <br>this type Acitons whose name are match "*Ext3QUERYAction"
 * <br>are only do a work: query table data
 * @author dzd
 * @date 2013-10-09
 * @update 2013-10-10
 */
public class TAuthorityModuleExt3QUERYAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _dc;
	private String callback;
	
	private long totalCount;
	private List results;//results
	
	private String sort;
	private String dir;
	
	/** 起始记录索引 **/
	private int start;// record start index, begin from 0. no pageNumber-没有页码
	private int limit;//pageSize
	
	/** page NO. 页号, ext3  **/
	private int page;
	
	protected String jdata;

	protected TAuthorityModuleService dataService;

	/**
	 * 查询模块信息 row is json
	 * <br>invoke service method: getRowsInMap
	 * @return
	 */
	public String dfind() {
//		pageSize = Integer.parseInt( records.get(0).toString() );// pageSize
		
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();
		
		/** YUI3 style  
		 * <br>[ { LEVEL1:'desc'  }, { LEAF:'asc'} ]
		 * **/
		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			Map map = new HashMap();
			map.put( this.sort, this.dir );
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
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			totalCount = 0;
			results = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			totalCount = dataService.getTotal(sqlA);
			results = dataService.getRowsInMap( sqlA, start, limit );
		}
		return SUCCESS;
	}
	
	/**
	 * 查询模块信息 row is array
	 * <br>invoke service method: getRowsInArray
	 * @return
	 */
	public String dfindArray() {		
		JSONObject jsonObject = JSONObject.fromObject(jdata);
		AbstractConstant absConstant = new AuthorityModule();

		List<Map> sort = new ArrayList<Map>();
		if( this.sort != null && !this.sort.trim().equalsIgnoreCase("") ){
			Map map = new HashMap();
			map.put( this.sort, this.dir );
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
		
		if( jsonObject.getString("act").equalsIgnoreCase("noquery")){
			totalCount = 0;
			results = new ArrayList();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			totalCount = dataService.getTotal(sqlA);
			results = dataService.getRowsInArray( sqlA, start, limit );
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
		
		totalCount = dataService.getTotal(sqlA);
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

	public void set_dc(String _dc) {
		this._dc = _dc;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}
	
	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotalCount() {
		return totalCount;
	}
	
	public List getResults() {
		return results;
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
