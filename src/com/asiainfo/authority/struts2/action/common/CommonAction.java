package com.asiainfo.authority.struts2.action.common;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.asiainfo.authority.struts2.action.BaseAction;

import person.daizhongde.virtue.constant.AbstractConstant;

/**
 * 签约信息个性化业务处理
 * <br>目前为止不处理任何业务
 * special business 
 * @author dzd
 *
 */
public class CommonAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 756574523370955608L;

	
	private String sResponse;
	private Map map = new HashMap();
	/**
	 * 
	 * @return 
	 * {"total":6,
	 * 		"rows":[
	 * 			{"name_zh":"签约专号","name":"PAY_ID"},
	 * 			{"name_zh":"用户名","name":"SIGN_NAME"},
	 * 			{"name_zh":"签约客户账号","name":"ACC_ID"}
	 * 		]
	 * }
	 */
	public String TableNames() {
		System.out.println("#########  TableNames  ########");
		List dataList = new ArrayList(4);
		
//		Map swtData = new HashMap(2);
//		swtData.put("total", size );
//		swtData.put("rows", dataList );
//		JSONObject jsonObject = JSONObject.fromObject(swtData);
//		this.sResponse = jsonObject.toString();
//		this.setSResponse(sResponse);
//		return "sResponse";
//		map.put("total", size );
//		map.put("rows", dataList );
		return "map";
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
	public Map getMap() {
		return map;
	}
}
