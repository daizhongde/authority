package person.daizhongde.authority.struts2.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import person.daizhongde.virtue.constant.INIT;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7546060204136034008L;
	
	/** 日志 */
	protected Logger log = LogManager.getLogger(BaseAction.class.getName() );
	{
		System.setProperty("VirtueLog4j.root", INIT.localFileRootDirectory );
//		getServlet().getServletContext().getRealPath(""); 
		
//		System.out.println("log.getLogger(\"D\").getHierarchy():"+
//				log.getLogger("D").getHierarchy());
//		System.out.println("log.getLogger(\"D\").getHierarchy():"+
//				log.getLogger("D"));
	}
//	protected org.apache.commons.logging.Log log1 = LogFactory.getLog(this.getClass());
//	private static final org.slf4j.Logger log2 = org.slf4j.LoggerFactory.getLogger(BaseAction.class);


	private String jdata;
	private JSONObject jsonObject;
	private Map map;
	
	private Object json;
	
	/** 标题  */
	protected String title;

	/** 提示信息 */
	protected String info;

	/** 警告信息 */
	protected String error;
	/** 用户ID */
	private Integer userId;
	/** 用户登陆名 */
	private String userlogname;
	/** 用户名 */
	protected String username;
	/** 地址 */
	protected String remoteAddr;

	public Integer getUserId() {
		TAuthorityUser user = (TAuthorityUser)getSession(false).getAttribute( SessionConstants.LOGIN_USER );
		return user.getNUid();
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserlogname() {
		TAuthorityUser user = (TAuthorityUser)getSession(false).getAttribute( SessionConstants.LOGIN_USER );
		return user.getCUlogname();
	}

	public void setUserlogname(String userlogname) {
		this.userlogname = userlogname;
	}

	/**
	 * getLoginUser:(从上下文中获取 登录用户). <br/>
	 * @author d144574
	 * @since JDK 1.7
	 */
	public  TAuthorityUser getLoginUser(){
		TAuthorityUser user = (TAuthorityUser)getSession(false).getAttribute( SessionConstants.LOGIN_USER );
		return user;
	}
	
	public HttpSession getSession(Boolean create) {
		return ServletActionContext.getRequest().getSession(create);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getError() {
		return error;
	}

	public String getRemoteAddr() {
		remoteAddr = ServletActionContext.getRequest().getRemoteAddr();
		return remoteAddr;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	public Object getJson() {
		return json;
	}
	public void setJson(Object json) {
		this.json = json;
	}

	public String getJdata() {
		return jdata;
	}
	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("#######");
		log.debug("decoded jdata:" + decode.toString());
		log.debug("#######");
		this.jdata = decode;
	}
	public String get(String key){
		return this.jsonObject.getString(key);
	}
	public int getInt(String key){
		return this.jsonObject.getInt(key);
	}
	public Map getMapValue(String key){
		return this.jsonObject.getJSONObject(key);
	}
	public List getListValue(String key){
		return this.jsonObject.getJSONArray( key );
	}
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void setMap(Map map) {
		this.map = map;
		HttpServletRequest request=ServletActionContext.getRequest();  
        ServletContext cxt=ServletActionContext.getServletContext();  
        request.setAttribute("map", map );
	}

	public Map getMap() {
		return map;
	}
	
}
