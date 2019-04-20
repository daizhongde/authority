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
 * <br>only used by yui2
 * <br>this type Acitons whose name are match "*YUI2QUERYAction"
 * <br>are only do a work: query table data
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityModuleYUI2QUERYAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int recordsReturned;
	private long totalRecords;
	private List records;//results
	
	private String sort;
	private String dir;
	
	/** 起始记录索引(页号) **/
	private int startIndex;// record start index, begin from 0. no pageNumber-没有页码
	private int pageSize;//pageSize
	
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

		/*
		 * dojo style:
		 * 
		 * map.put( "attribute", this.sort );
		if( this.dir.equalsIgnoreCase("asc") ){
			map.put( "descending", false );
		}else{
			map.put( "descending", true );
		}
		sort.add(map);*/
		
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
			totalRecords = 0;
			records = new ArrayList();
			recordsReturned = 0;
		}else if( startIndex==0 || pageSize==0 ){//parameter sqlA pass in, because of it can only assemble a time
			totalRecords = dataService.getTotal(sqlA);
			records = dataService.getRowsInMap(sqlA);
			recordsReturned = records.size();
		}else{//parameter sqlA pass in, because of it can only assemble a time
			totalRecords = dataService.getTotal(sqlA);
			records = dataService.getRowsInMap(sqlA, startIndex, pageSize);
			recordsReturned = records.size();
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
			totalRecords = 0;
			records = new ArrayList();
			recordsReturned = 0;
		}else{//parameter sqlA pass in, because of it can only assemble a time
			totalRecords = dataService.getTotal(sqlA);
			records = dataService.getRowsInArray(sqlA, startIndex, pageSize);
			recordsReturned = records.size();
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
		
		totalRecords = dataService.getTotal(sqlA);
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

	public int getRecordsReturned() {
		return recordsReturned;
	}

	public void setRecordsReturned(int recordsReturned) {
		this.recordsReturned = recordsReturned;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
