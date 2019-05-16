package person.daizhongde.authority.struts2.action.curd;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityUserService;
import person.daizhongde.authority.struts2.action.BaseAction;

import net.sf.json.JSONObject;

/**
 * 用户信息CURD
 * <br>this type Actions whose name are match "*JsonCURDAction"
 * <br>only do three work:
 * <br>        add, modify, delete a record, current also do read 
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityUserCURDAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** jquery-easy-ui refreshpage params 
	 * $('#win').window("refresh", "../tAM_add.html");
	 * **/
	private String _;
	protected String jdata;
	
	private Boolean success;// 只有private的变量(并且定义get方法)json插件才能返回
	private String msg;
	private Integer id;
	
	protected Map map = new HashMap();
	protected Object[] arr;
	protected TAuthorityUser pojo;
	protected TAuthorityUserService dataService;

//	public void validate() {
//		addFieldError("jdata", getText("jdata.required"));
//		addFieldError("jdata", "you must input jdata!");
//		System.out.println(result);
//	}
	/**
	 * 新增用户初始化
	 * @return
	 * @throws Exception
	 */
	public String initAdd() throws Exception {
		this.setTitle("发布用户");
		this.setInfo("请填写用户内容。标有 * 号的为必填项。");
		return "add";
	}
	/**
	 * 新增
	 * @return
	 */
	public String add() {
		try{
			//@return The number of entities updated or deleted or insert.
			dataService.addBySavePOJO(jdata);
		}catch(Exception e){
			e.printStackTrace();
			
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "添加成功！";
		return SUCCESS;
	}
	/**
	 * 新增
	 * @return
	 */
	public String addWithId() {
		int i = 0;//insert row count
		try{
			//@return The number of entities updated or deleted or insert.
			i = dataService.addWithId(jdata);
		}catch(Exception e){
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "添加成功！";
		return SUCCESS;
	}
	/**
	 * 修改用户初始化,跳到JSP页面
	 * @return
	 * @throws Exception
	 */
	public String initModify() {
		this.pojo = (TAuthorityUser)dataService.browsePOJOById(pojo.getNUid());
		return "modify";
	}

	public String modify(){
		int i = 0;//update row count
		try{
			//@return The number of entities updated or deleted or insert.
			i = dataService.modify(jdata);
		}catch(Exception e){
			e.printStackTrace();
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "更新成功！";
		return SUCCESS;
	}
	/**
	 * This is  effective.
	 * @return
	 */
	public String modifyPWD(){
		int i = 0;//update row count
		try{
			//@return The number of entities updated or deleted or insert.
			JSONObject json = JSONObject.fromObject( jdata );
			
			Map cond = json.getJSONObject("condition");
			cond.put("id", super.getLoginUser().getNUid() );
			json.put("condition", cond);
						
			i = dataService.modifyPWD( json.toString() );
		}catch(Exception e){
			e.printStackTrace();
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "更新成功！";
		return SUCCESS;
	}
	/**
	 * This is  effective.
	 * <p>
	 *   和modify方法一样的效果
	 *   区别：modify需要传id条件
	 * @return
	 */
	public String modifyEMAILPWD(){
		int i = 0;//update row count
		try{
			//@return The number of entities updated or deleted or insert.
			JSONObject json = JSONObject.fromObject( jdata );
			
			Map cond = json.getJSONObject("condition");
			Map data = json.getJSONObject("data");
			String pwd = String.valueOf( data.get("cip") );
			//加密
			String msg = Base64.getEncoder().encodeToString(pwd.getBytes());
//			System.out.println("加密：" + msg);
			//反转
			StringBuffer sb = new StringBuffer(msg);
			sb = sb.reverse();
			String reve=sb.toString();
//	        System.out.println("反转:"+reve);
			data.put("cip", reve);
			json.put("data", data);
			
			cond.put("id", super.getLoginUser().getNUid() );
			json.put("condition", cond);
			
			i = dataService.modify(json.toString());
		}catch(Exception e){
			e.printStackTrace();
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "更新成功！";
		return SUCCESS;
	}
	/**
	 * 查看用户
	 * @return map
	 */
	public String browse(){
//		System.out.println("browse jdata:"+jdata);
//		just for test
//		if(jdata==null || jdata.trim().equalsIgnoreCase("")){
//			jdata = "{ act: \"read\",condition: {nmid: 3},operator : {nmid:1} }";
//		}
		map = dataService.browse(jdata);
//		System.out.println("browse map:"+map);
		return "browse";
	}
	/**
	 * 删除用户
	 * @return
	 */
	public String delete(){
		int i = 0;//delete count
		try{
			//@return The number of entities updated or deleted or insert.
			i = dataService.delete(jdata);
		}catch(Exception e){
			e.printStackTrace();
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
		this.success = Boolean.TRUE;
		this.msg = "删除成功！";
		return SUCCESS;
	}

	public void set_(String _) {
		this._ = _;
	}
	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("decoded jdata:" + decode.toString());
		this.jdata = decode;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public String getMsg() {
		return msg;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public Map getMap() {
		return map;
	}
	public Object[] getArr() {
		return arr;
	}
	/** if haven't this method page cann't get pojo's property value  **/
	public void setPojo(TAuthorityUser pojo) {
		this.pojo = pojo;
	}
	/**
	 * struts2 map pojo must have get Method
	 * @return
	 */
	public TAuthorityUser getPojo() {
		return pojo;
	}
	public void setDataService(TAuthorityUserService dataService) {
		this.dataService = dataService;
	}
}
