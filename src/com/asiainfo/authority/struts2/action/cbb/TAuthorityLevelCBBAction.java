package com.asiainfo.authority.struts2.action.cbb;

import java.io.UnsupportedEncodingException;

import com.asiainfo.authority.spring.service.TAuthorityLevelService;
import com.asiainfo.authority.struts2.action.BaseAction;

/**
 * 级别信息相关下拉框数据
 * combobox data
 * @author dzd
 *
 */
public class TAuthorityLevelCBBAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1625277481198555717L;

	protected String jdata;
	
	private String sResponse;

	protected TAuthorityLevelService dataService;
	
	/**
	 * 下拉框Json数据
	 * <p>cbb : combobox
	 * @return JSONObject 
	 */
	public String getCBBData_IdAndName(){
		log.debug("action............getCBBData_Id........");
		if( null == jdata || jdata.trim().equalsIgnoreCase("")){
			jdata = "{ act: \"queryCBB\",condition: {},operator : {} }";
		}
		sResponse = dataService.getCBBData_Id(jdata);
		return "sResponse";
	}

	/**
	 * 下拉框Json数据
	 * <p>cbb : combobox
	 * @return JSONArray 
	 */
	public String getCBBDataInArray_IdAndName(){
		log.debug("action............buildComboboxDataInArray_Parent........");
		if( null == jdata || jdata.trim().equalsIgnoreCase("")){
			jdata = "{ act: \"queryCBB\",condition: {},operator : {} }";
		}
		sResponse = dataService.getCBBDataInArray_Id(jdata);
		return "sResponse";
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}
	public void setSResponse(String sResponse) {
		this.sResponse = sResponse;
	}
	public String getSResponse() {
		return sResponse;
	}
	public void setDataService(TAuthorityLevelService dataService) {
		this.dataService = dataService;
	}
}