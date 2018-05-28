package com.asiainfo.authority.struts2.action.tree;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import person.daizhongde.virtue.util.test.Printer;

import com.asiainfo.authority.constant.SessionConstants;
import com.asiainfo.authority.hibernate.pojo.TAuthorityUser;
import com.asiainfo.authority.spring.service.TAuthorityModuleService;
import com.asiainfo.authority.struts2.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 模块信息菜单树数据
 * <br>get tree json data 
 * @author dzd
 *
 */
public class TAuthorityModuleTREEAction extends BaseAction {
	
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
	
	private int roleId;
	
	private String jdata;
	
	/** move tree node refer **/
	private int target;
	private String point;
	
	private TAuthorityModuleService dataService;
	
	//for response
	private String sResponse;
	//for response
	private	Map map = new HashMap();
	
	/**
	 * move(drag and drop) tree node
	 * @return
	 */
	public String dndNode() {
		try{
			dataService.dndNode( target, id, point );
		}catch(Exception e){
			e.printStackTrace();
			
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			map.put( "success", Boolean.FALSE );
			map.put( "msg", e2.getLocalizedMessage() );
			return "map";
		}
		map.put( "success", Boolean.TRUE );
		map.put( "msg", "更新成功!" );
		this.setMap(map);
		return "map";
	}
		
	/**
	 * 菜单Json数据-有备注
	 * @return JSONArray
	 */
	public String query_JEasyUI_Treegrid(){
//		log.debug("action............query_JEasyUI_Treegrid........");
		sResponse = dataService.getData_JEasyUI_Treegrid();
		this.setSResponse(sResponse);
		return "sResponse";
	}
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
	 * Module Json数据-checkbox tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_CheckBoxTree(){
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
		//roleId==0 is no roleId parameter in the post
		if( roleId == 0 && id ==0 )
		{
//			sResponse = dataService.getData_JEasyUI_Tree( 1, true );
			sResponse = dataService.getData_JEasyUI_CheckBoxTree_ExceptDev( 1, 0 );
		}
		else if( roleId != 0 && id ==0 )
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = dataService.getData_JEasyUI_CheckBoxTree_ExceptDev( 1, roleId );
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
	 * <p>管理员用,区别于不带_ExceptDev的方法就是少了开发人员角色 
	 * @return JSONArray
	 * 
	 */
	public String query_JEasyUI_CheckBoxTree_ExceptDev(){
//		log.debug("action........query_JEasyUI_CheckBoxTree_ExceptDev............");
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
		if( roleId == 0 && id ==0 )
		{
//			sResponse = dataService.getData_JEasyUI_Tree_ExceptDev( 1, true );
			sResponse = dataService.getData_JEasyUI_CheckBoxTree_ExceptDev( 1, roleId );
		}
		else if( roleId != 0 && id ==0 )
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = dataService.getData_JEasyUI_CheckBoxTree_ExceptDev( 1, roleId );
		}
		else
		{//roleId == 0 && id ==0没有传id,is not lasy load tree
			sResponse = "[]";
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
//		System.out.println("this.sResponse:"+this.sResponse);
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
//		System.out.println("this.sResponse:"+this.sResponse);
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * <p>
	 * dnd(full):包括节点(机构)的所有属性
	 * @return JSONArray
	 */
	public String query_JEasyUI_Dndtree(){
//		log.debug("action........query_JEasyUI_Dndtree............");
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
			this.sResponse = dataService.getData_JEasyUI_Dndtree( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_Dndtree( 
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据-jQuery EasyUI tree
	 * @return JSONArray
	 */
	public String query_JEasyUI_Dndtree_Async(){
//		log.debug("action........query_JEasyUI_Dndtree............");
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
			//Don't use getData_JEasyUI_Dndtree_Async,because it is dndtree
			this.sResponse = dataService.getData_JEasyUI_Dndtree( 1, true );
		}else{
			this.sResponse = dataService.getData_JEasyUI_Dndtree(
					id, false );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据
	 * <p>used by fason,gubusoft,webfxtree,yui2,yui3
	 * @return JSONArray
	 */
	public String query_GubuSoft_Tree(){
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
		sResponse = dataService.getData_GubuSoft_Tree();
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by fason,gubusoft,webfxtree,
	 * <p>html页面创建菜单树使用
	 * @return JavaScript
	 */
	public String query_GubuSoft_TreeJS(){
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
		sResponse = "var jsonData ="+dataService.getData_GubuSoft_Tree()+";";
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by fason,gubusoft,webfxtree,
	 * <p>html页面创建菜单树使用
	 * @return JavaScript
	 */
	public String query_GubuSoft_TreeJS_User(){
//		log.debug("action........query_JEasyUI_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		System.out.println("##########test########");
		TAuthorityUser userinfo = (TAuthorityUser)session.get( SessionConstants.LOGIN_USER );
		if(userinfo==null){
			return "login";
		}
		if(userinfo.getCUlogname().equalsIgnoreCase("dev")){
			sResponse = "var jsonData ="+dataService.getData_GubuSoft_Tree()+";";
		}else{
			sResponse = "var jsonData ="+dataService.getData_GubuSoft_Tree( userinfo.getNUid() )+";";
		}
		
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * YUI2 MenuBar Json数据<p>used by YUI2
	 * <p>bar中的item
	 * @return JSONObject
	 */
	public String query_YUI2_Menu(){
//		log.debug("action........query_YUI2_Menu............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = dataService.getData_YUI2_Menu();
//		return "success2";//struts-2.5.5 not available success2   sResponse
		super.setJson( sResponse  );
		this.setSResponse(sResponse);
		return SUCCESS;
	}
	/**
	 * YUI2 MenuBar Json数据<p>used by YUI2
	 * <p>bar
	 * @return JSONObject
	 */
	public String query_YUI2_Menubar(){
//		log.debug("action........query_YUI2_Menu............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = dataService.getData_YUI2_Menubar();
//		return "success2";//struts-2.5.5 not available  success2   sResponse
		super.setJson( sResponse  );
		this.setSResponse(sResponse);
		return SUCCESS;
	}
	/**
	 * 菜单Json数据<p>used by dojo
	 * <p>html页面创建菜单树使用
	 * @return JSONObject
	 */
	public String query_Dojo_Tree(){
//		log.debug("action........query_Dojo_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = "{\"identifier\": \"id\",\"label\": \"text\",\"items\": " + dataService.getData_GubuSoft_Tree() + "}";
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by dojo
	 * <p>html页面创建菜单树使用
	 * @return JSONObject
	 */
	public String query_Dojo_Tree_NoRoot(){
//		log.debug("action........query_Dojo_Tree_NoRoot............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = "{\"identifier\": \"id\",\"label\": \"text\",\"items\": " + dataService.getData_Dojo_Tree_NoRoot() + "}";
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by dojo
	 * <p>html页面创建菜单树使用
	 * @return JSONObject, only root
	 */
	public String query_Dojo_Tree_Root(){
//		log.debug("action........query_Dojo_Tree_Root............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		sResponse = dataService.getData_LazyNode( 1, id );
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = "{\"identifier\": \"id\",\"label\": \"text\",\"items\": [{'id':1, 'text':'湖南社保金融卡省内前置系统', 'iconcls':'icon-web', 'children':true}]}";
//		sResponse = "{\"identifier\": \"id\",\"label\": \"text\",\"items\": "+ dataService.getData_LazyRoot( 1 ) +"}";
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by dojo
	 * <p>html页面创建菜单树使用
	 * @return JSONArray, all with node and node's children
	 */
	public String query_Dojo_Tree_Node_Lazy(){
//		log.debug("action........query_Dojo_Tree_Node_Lazy............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
		sResponse = "{\"identifier\": \"id\",\"label\": \"text\",\"items\": "+dataService.getData_Dojo_Tree_LazyNode( id )+"}";
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by dojo, YUI2
	 * <p>html页面创建菜单树使用
	 * @return JSONObject, all with node's children
	 */
	public String query_Dojo_Tree_Async(){
//		log.debug("action........query_Dojo_Tree_Children............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
		sResponse = dataService.getData_Dojo_Tree_Async( id );
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by dojo
	 * <p>for RESTful
	 * <p>html页面创建菜单树使用
	 * <p>there pay attention, the root's id is '1'. fix 
	 * @return JSONObject or JSONArray
	 */
	public String query_Dojo_Tree_Lazy2(){
//		log.debug("action........query_Dojo_Tree_Lazy............");
		if( id ==1 ){//root's children, jsonArray
			sResponse = dataService.getData_Dojo_Tree_Async( 1 );
		}else{//node and node's children, jsonObject
			sResponse = dataService.getData_Dojo_Tree_LazyNode( id );
		}
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by Ext3
	 * <p>html页面创建菜单树使用
	 * @return JSONArray
	 * <br>example:
	 * <br>[{"children" : [],"cls" : "","expanded" : false,"id" : 2,"target" : "R","text" : "系统管理","url" : ""}]
	 */
	public String query_Ext3_Tree(){
//		log.debug("action........query_Ext3_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = dataService.getData_Ext3_Tree();
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by Ext3
	 * <p>html页面创建菜单树使用
	 * @return JSONArray
	 * <br>example:
	 * <br>[{"children" : true,"cls" : "","expanded" : false,"id" : 2,"target" : "R","text" : "系统管理","url" : ""}]
	 */
	public String query_Ext3_Tree_Async(){
//		log.debug("action........query_Ext3_Tree_Async............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = dataService.getData_Dojo_Tree_Async( Integer.valueOf( node ) );
		this.setSResponse(sResponse);
		return "sResponse";
	}
	/**
	 * 菜单Json数据<p>used by Ext4
	 * <p>html页面创建菜单树使用
	 * @return JSONArray
	 */
	public String query_Ext4_Tree(){
//		log.debug("action........query_Ext4_Tree............");
		//取得ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
		Map session = ctx.getSession();
//		UserInfo userinfo = (UserInfo)session.get("userinfo");
//		if(userinfo==null){
//			return "login";
//		}
//		System.out.println("id:"+userinfo.getNUid()+" name:"+userinfo.getCUname());
		sResponse = dataService.getData_Ext4_Tree();
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
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public void setDataService(TAuthorityModuleService dataService) {
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
