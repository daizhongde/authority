package person.daizhongde.authority.struts2.action.curd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import person.daizhongde.authority.hibernate.pojo.TAuthorityButton;
import person.daizhongde.authority.spring.service.TAuthorityButtonService;
import person.daizhongde.authority.struts2.action.BaseAction;

import person.daizhongde.virtue.util.json.JsonUtils;

/**
 * 级别信息CURD
 * <br>this type Actions whose name are match "*JsonCURDAction"
 * <br>only do three work:
 * <br>        add, modify, delete a record, current also do read 
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityButtonCURDAction extends BaseAction {
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
	private String sid;
	
	protected Map map = new HashMap();
	protected Object[] arr;
	protected TAuthorityButton pojo;
	protected TAuthorityButtonService dataService;

//	public void validate() {
//		addFieldError("jdata", getText("jdata.required"));
//		addFieldError("jdata", "you must input jdata!");
//		System.out.println(result);
//	}
	/**
	 * 新增级别初始化
	 * @return
	 * @throws Exception
	 */
	public String initAdd() throws Exception {
		this.setTitle("发布级别");
		this.setInfo("请填写级别内容。标有 * 号的为必填项。");
		return "add";
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
	
	public String curdAllinOne(){
		int i = 0;//update row count
		try{
//			// 前台传来的某个模块的所有按钮信息
//			List<TAuthorityButton> list = (List<TAuthorityButton>)JsonUtils.jsonStr2List(jdata, TAuthorityButton.class);
//			//@return The number of entities updated / deleted / inserted.
//			dataService.curdAllinOne(list);
			
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
	public String mergeRecords(){
		int i = 0;//update row count
		try{
			// 前台传来的某个模块的所有按钮信息
			List<TAuthorityButton> list = (List<TAuthorityButton>)JsonUtils.jsonStr2List(jdata, TAuthorityButton.class);
			dataService.mergeRecords(list, id);
			
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
	 * 删除级别
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
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Map getMap() {
		return map;
	}
	public Object[] getArr() {
		return arr;
	}
	/** if haven't this method page cann't get pojo's property value  **/
	public void setPojo(TAuthorityButton pojo) {
		this.pojo = pojo;
	}
	/**
	 * struts2 map pojo must have get Method
	 * @return
	 */
	public TAuthorityButton getPojo() {
		return pojo;
	}
	
//	/**
//	 * getDetailFromRequest:(从上下文中获取 外部对账单增款明细). <br/>
//	 * @author d144574
//	 * @since JDK 1.7
//	 */
//	private List<TAuthorityButton> getRowsFromRequest() throws Exception{
//		// 获取 request 上下文
////		HttpServletRequest request = ActionContextUtil.getRequest();
//		// 获取 前台 传入 参数
////		String data = request.getParameter("adddetail");
//		
//		List<TAuthorityButton> list = (List<TAuthorityButton>)JsonUtils.jsonStr2List(rows, TAuthorityButton.class);
//		
//		//Json 字符串转List
//		@SuppressWarnings("unchecked")
//		List<TAuthorityButton> param = (List<TAuthorityButton>) JsonUtils.jsonStr2List(data,TAuthorityButton.class);
//		// 参数 返回
//		return param;
//	}
	
	public void setDataService(TAuthorityButtonService dataService) {
		this.dataService = dataService;
	}
}
