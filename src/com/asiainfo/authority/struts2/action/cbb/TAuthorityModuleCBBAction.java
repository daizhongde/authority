package com.asiainfo.authority.struts2.action.cbb;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.asiainfo.authority.spring.service.TAuthorityModuleService;
import com.asiainfo.authority.struts2.action.BaseAction;

/**
 * 模块信息相关下拉框数据
 * combobox data
 * @author dzd
 *
 */
public class TAuthorityModuleCBBAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1625277481198555717L;

	protected String jdata;
	
	private String sResponse;

	protected TAuthorityModuleService dataService;
	
	/**
	 * 下拉框Json数据
	 * <p>cbb : combobox
	 * @return JSONObject 
	 */
	public String getCBBData_Parent(){
		log.debug("action............getCBBData_Id........");
		if( null == jdata || jdata.trim().equalsIgnoreCase("")){
			jdata = "{ act: \"queryCBB\",condition: {},operator : {} }";
		}
		sResponse = dataService.getCBBData_Parent(jdata);
		this.setSResponse(sResponse);
		return "sResponse";
	}


	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}
	/**
	 * 升级后的struts2  action属性没有放到request的Attribute中
	 * @param sResponse
	 */
	public void setSResponse(String sResponse) {
		this.sResponse = sResponse;
		HttpServletRequest request=ServletActionContext.getRequest();  
        ServletContext cxt=ServletActionContext.getServletContext();  
        request.setAttribute("sResponse", sResponse );
	}
	public String getSResponse() {
		return sResponse;
	}
	public void setDataService(TAuthorityModuleService dataService) {
		this.dataService = dataService;
	}
}
