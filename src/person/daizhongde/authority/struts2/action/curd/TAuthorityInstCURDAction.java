package person.daizhongde.authority.struts2.action.curd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import person.daizhongde.authority.hibernate.pojo.TAuthorityInst;
import person.daizhongde.authority.spring.service.TAuthorityInstService;
import person.daizhongde.authority.struts2.action.BaseAction;

/**
 * 模块信息CURD
 * <br>this type Actions whose name are match "*CURDAction"
 * <br>only do three work:
 * <br>        add, modify, delete a record, current also do read 
 * @author dzd
 * @date 2013-09-29
 */
public class TAuthorityInstCURDAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** jquery-easy-ui refreshpage params **/
	private String _;
	protected String jdata;
	
	private Boolean success;// 只有private的变量(并且定义get方法)json插件才能返回
	private String msg;
	private Integer id;
	
	protected Map map = new HashMap();
	protected Object[] arr;
	protected TAuthorityInst pojo;
	protected TAuthorityInstService dataService;

//	public void validate() {
//		addFieldError("jdata", getText("jdata.required"));
//		addFieldError("jdata", "you must input jdata!");
//		System.out.println(result);
//	}
	/**
	 * 新增模块初始化
	 * @return
	 * @throws Exception
	 */
	public String initAdd() throws Exception {
		this.setTitle("发布模块");
		this.setInfo("请填写模块内容。标有 * 号的为必填项。");
		return "add";
	}
	/**
	 * 新增
	 * @return
	 */
	public String add() {
//		JSONObject jsonObject = JSONObject.fromObject(jdata);
//		AbstractConstant absConstant = new TAuthorityInst_Constant();
//		SQLAssemble sqlA = new SQLAssemble( jsonObject, absConstant );
//		dataService.add(sqlA);
		int i = 0;//insert row count
		try{
			//@return The number of entities updated or deleted or insert.
			i = dataService.add(jdata);
		}catch(Exception e){
//			System.out.println("1:"+e.getLocalizedMessage());
//			System.out.println("2:"+e.getCause().getLocalizedMessage());
//			System.out.println("3:"+e.getCause().getCause().getLocalizedMessage());
			e.printStackTrace();
			
			Throwable e2 = e;
			while(e2.getCause() != null ){
				e2 = e2.getCause();
			}
			this.success = Boolean.FALSE;
			this.msg = e2.getLocalizedMessage();
			return SUCCESS;
		}
//		dataService.addBySave(jdata);// 不推荐
//		System.out.println("pojo:"+this.pojo.getCMname());
		this.success = Boolean.TRUE;
		this.msg = "添加成功！";
		return SUCCESS;
	}
	/**
	 * 新增并返回记录ID
	 * @return
	 */
	public String addRetId() {
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
			return "add";
		}
		this.success = Boolean.TRUE;
		this.msg = "添加成功！";
		return SUCCESS;
	}
	
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
	 * 修改模块初始化,跳到JSP页面
	 * @return
	 * @throws Exception
	 */
	public String initModify() {
		this.pojo = (TAuthorityInst)dataService.browsePOJOById(pojo.getNIid());
		return "modify";
	}
	/**
	 * 修改模块初始化,跳到html页面
	 * @return
	 * @throws Exception
	 */
	public String initModify2() {
		this.pojo = (TAuthorityInst)dataService.browsePOJOById(pojo.getNIid());
		return "modify2";
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
	 * 查看模块
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
	 * 查看模块 
	 * @return array
	*/ 
	public String browseArray(){
//		System.out.println("browseArray 2 jdata:"+jdata);
//		just for test
//		if(jdata==null || jdata.trim().equalsIgnoreCase("")){
//			jdata = "{ act: \"read\",condition: {nmid: 3},operator : {nmid:1} }";
//		}
//		arr = dataService.browseArray(jdata);
		return "browse3";
	}
	/**
	 * 查看模块 
	 * @return pojo
	*/ 
	public String browsePOJO(){
//		System.out.println("browsePOJO 3 jdata:"+jdata);
		if( pojo!=null && pojo.getNIid()!=null ){
			this.pojo = (TAuthorityInst)dataService.browsePOJOById(pojo.getNIid());
			return "browse2";
		}else{
			pojo = (TAuthorityInst)dataService.browsePOJO(jdata);
			return "browse2";
		}
	}
	/**
	 * 删除模块
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
	public void setPojo(TAuthorityInst pojo) {
		this.pojo = pojo;
	}
	/**
	 * struts2 map pojo must have get Method
	 * @return
	 */
	public TAuthorityInst getPojo() {
		return pojo;
	}
	public void setDataService(TAuthorityInstService dataService) {
		this.dataService = dataService;
	}
}
