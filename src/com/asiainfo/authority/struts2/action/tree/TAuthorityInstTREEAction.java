package com.asiainfo.authority.struts2.action.tree;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.asiainfo.authority.constant.SessionConstants;
import com.asiainfo.authority.hibernate.pojo.TAuthorityUser;
import com.asiainfo.authority.spring.service.TAuthorityInstService;
import com.asiainfo.authority.struts2.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 模块信息菜单树数据
 * <br>get tree json data 
 * @author dzd
 *
 */
public class TAuthorityInstTREEAction extends BaseAction {
	
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
//	private int flag;//lazy load parameter
	
	private String jdata;
	
	/** move tree node refer **/
	private int target;
	private String point;
	
	private TAuthorityInstService dataService;
	
	//for response
	private String sResponse;
	//for response
	private	Map map = new HashMap();
			
	/**
	 * Module Json数据-menu
	 * @return JSONArray
	 */
	public String query_JEasyUI_Tree(){
//		log.debug("action........query_JEasyUI_Tree............");
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
			sResponse = dataService.getData_JEasyUI_Tree( 1, true );
		}else{
			sResponse = dataService.getData_JEasyUI_Tree( id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * Module Json数据-menu
	 * @return JSONArray
	 */
	public String query_JEasyUI_Tree_Async(){
//		log.debug("action........query_JEasyUI_Tree............");
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
			sResponse = dataService.getData_JEasyUI_Tree_Async( 1, true );
		}else{
			sResponse = dataService.getData_JEasyUI_Tree_Async( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	
	/**
	 * Module Json数据-jQuery EasyUI combotree
	 * @return JSONArray
	 */
	public String query_JEasyUI_CBT(){
//		log.debug("action........query_JEasyUI_Tree............");
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
			this.sResponse = dataService.getData_JEasyUI_CBT( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_CBT( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}

	/**
	 * Module Json数据-jQuery EasyUI combotree asynchronous
	 * @return JSONArray
	 */
	public String query_JEasyUI_CBT_Async(){
//		log.debug("action........query_JEasyUI_Tree............");
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
			this.sResponse = dataService.getData_JEasyUI_CBT_Async( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_CBT_Async( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * Module Json数据-jQuery EasyUI combotree asynchronous,
	 * <p>center user inst sub inst tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_CBT_AsyncUSubI(){
//		log.debug("action........query_JEasyUI_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
		TAuthorityUser user = (TAuthorityUser)session.get( SessionConstants.LOGIN_USER );
		if(user==null){
			return "login";
		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		if( id == 0 ){
//			this.sResponse = dataService.getData_JEasyUI_CBT_Async( 1, true );
			this.sResponse = dataService.getData_JEasyUI_CBT_Async( user.getTAuthorityInst().getNIid(), true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_CBT_Async( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * Module Json数据-jQuery EasyUI combotree
	 * <p>
	 * 查询头三级的所有数据(第四级异步加载),普通的异步加载都是先从根节点开始的，这里是可以从任何一个节点开始
	 * <br>如果传入了节点参数-从参数对应的节点开始算,它本身算一级(现在不是相对的,需要的时候再修改DAO)
	 * <br>加载一级_L1(只加载节点本身，等于没有加载)
	 * <br>异步算_L2(只加载它的直接子节点)
	 * @return JSONArray
	 */
	public String query_JEasyUI_CBT_L3(){
//		log.debug("action........query_JEasyUI_CBT_l3............");
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
		if( id == 0 )
		{
			this.sResponse = dataService.getData_JEasyUI_CBT_L3( 1, true );
		}
//		else if( flag == 1 ){//页面树初始化，返回带请求根节点数据
//			this.sResponse = dataService.getData_JEasyUI_FullTree( 
//					id, true );
//		}
		else
		{
			this.sResponse = dataService.getData_JEasyUI_CBT_L3( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * <p>
	 * full:包括节点(机构)的所有属性
	 * @return JSONArray
	 */
	public String query_JEasyUI_FullTree(){
		log.debug("action........query_JEasyUI_FullTree............");
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
			this.sResponse = dataService.getData_JEasyUI_FullTree( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_FullTree( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_FullTree_Async(){
//		log.debug("action........query_JEasyUI_FullTree............");
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
			this.sResponse = dataService.getData_JEasyUI_FullTree_Async( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_FullTree_Async(
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_FullTree_AsyncUSubI(){
//		log.debug("action........query_JEasyUI_FullTree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
		TAuthorityUser user = (TAuthorityUser)session.get( SessionConstants.LOGIN_USER );
		if(user==null){
			return "login";
		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
//		System.out.println("id:"+id);
		if( id == 0 ){
			this.sResponse = dataService.getData_JEasyUI_FullTree_Async( user.getTAuthorityInst().getNIid(), true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_FullTree_Async(
					id, false );
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
	
//	public void setFlag(int flag) {
//		this.flag = flag;
//	}
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

	public void setDataService(TAuthorityInstService dataService) {
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
