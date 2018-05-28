package com.asiainfo.authority.struts2.action.tree;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.asiainfo.authority.constant.SessionConstants;
import com.asiainfo.authority.hibernate.pojo.TAuthorityUser;
import com.asiainfo.authority.spring.service.TAuthorityRoleService;
import com.asiainfo.authority.struts2.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 模块信息菜单树数据
 * <br>get tree json data 
 * @author dzd
 *
 */
public class TAuthorityRoleTREEAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6083717096366337811L;

	/** ext3 and ext4 treeload params **/
	private String node;
	
	/** ext4 treeload params **/
	private String _dc;
	
	/** lazy load YUI2, JEasyUI, dnd node source, remove node id **/
	private int id;//lazy load parameter
	
	private int userId;
	
	private String jdata;
	
	/** move tree node refer **/
	private int target;
	private String point;
	
	private TAuthorityRoleService dataService;
	
	//for response
	private String sResponse;
	//for response
	private	Map map = new HashMap();
			
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * <p>
	 * 开发人员用
	 * @return JSONArray
	 */
	public String query_JEasyUI_Tree(){
		log.debug("action........query_JEasyUI_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		if( id == 0 ){
			this.sResponse = dataService.getData_JEasyUI_Tree( );
		}else{
			this.sResponse = "[]";
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据 - query_JEasyUI_Tree_ExceptDev
	 * <p>管理员用,区别于query_JEasyUI_Tree就是少了开发人员角色
	 * @return JSONArray
	 */
	public String query_JEasyUI_Tree_ExceptDev(){
		log.debug("action........query_JEasyUI_Tree_ExceptDev............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
		TAuthorityUser userinfo = (TAuthorityUser)session.get( SessionConstants.LOGIN_USER );
		if(userinfo==null){
			return "login";
		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		if( id == 0 ){//用户拥有的最高角色级别
//			this.sResponse = dataService.getData_JEasyUI_Tree_ExceptDev( user.getroles.getMaxRoleLevel );
			this.sResponse = dataService.getData_JEasyUI_Tree_ExceptDev( );
		}else{
			this.sResponse = "[]";
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * Module Json数据-checkbox tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_CheckBoxTree(){
		log.debug("action........query_JEasyUI_CheckBoxTree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		//roleId==0 is no roleId parameter in the post
		if( userId == 0 && id ==0 )
		{
			sResponse = dataService.getData_JEasyUI_Tree( );
		}
		else if( userId != 0 && id ==0 )
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = dataService.getData_JEasyUI_CheckBoxTree( userId );
		}
		else
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = "[]";
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * Module Json数据-checkbox tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_CheckBoxTree_ExceptDev(){
		log.debug("action........query_JEasyUI_CheckBoxTree_ExceptDev............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		//roleId==0 is no roleId parameter in the post
		if( userId == 0 && id ==0 )
		{
			sResponse = dataService.getData_JEasyUI_Tree_ExceptDev( );
		}
		else if( userId != 0 && id ==0 )
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = dataService.getData_JEasyUI_CheckBoxTree_ExceptDev( userId );
		}
		else
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = "[]";
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	
	public void setNode(String node) {
		this.node = node;
	}

	public void set_dc(String _dc) {
		this._dc = _dc;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("before decode jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
//		log.debug("after  decode jdata:" + decode.toString());
		this.jdata = decode;
	}

	public void setTarget(int target) {
		this.target = target;
	}
	public void setPoint(String point) {
		this.point = point;
	}

	public void setDataService(TAuthorityRoleService dataService) {
		this.dataService = dataService;
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
	public void setMap(Map map) {
		this.map = map;
		HttpServletRequest request=ServletActionContext.getRequest();  
        ServletContext cxt=ServletActionContext.getServletContext();  
        request.setAttribute("map", map );
	}
	
}
