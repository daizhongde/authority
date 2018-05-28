package com.asiainfo.authority.struts2.action.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import person.daizhongde.virtue.constant.AbstractConstant;
import person.daizhongde.virtue.spring.BaseExportService;
import person.daizhongde.virtue.util.character.CharacterConvert;
import person.daizhongde.virtue.util.file.FileUtil;

import com.asiainfo.authority.constant.AuthorityModule;
import com.asiainfo.authority.spring.service.CommonService;
import com.asiainfo.authority.struts2.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
/**
 * 通用导出用，对应界面的通用导出功能（可以选择某个表进行导出-单选）
 * this type Acitons whose name are match "*ExportAction"
 * are only do a work: export data
 * <br>wait to finish..... add sort....
 * @author dzd
 * 
 */
public class DownloadEXPAction extends BaseAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3791570688481329748L;

	/** for muti-thread */
	private String _;
	
	private String jdata;
	/**  	[{"LEVEL1":"desc"},{"LEAF":"asc"}]  **/
	@SuppressWarnings({ "unused", "rawtypes" })
	private List<Map> sortBy;
	
	private List customColumns;
	
	/** wizard export options */
	@SuppressWarnings("rawtypes")
	private Map options;
	
	/** XLS文件的导出次数 **/
	private static int countXLS=0;
	/** TXT文件的导出次数 **/
	private static int countTXT=0;
	
//	/** file absolute directory , end with '/' **/
//	private String tempFAbsDir;
//	/** 服务器临时文件名称（完整文件名） **/
//	private String tempFAbsName;
//	/** 服务器临时文件名称（不包括扩展名） **/
//	private String tempFName;
//	/** 服务器临时文件的扩展名（文件类型） **/
	private String tempFExtName;
	
	/** file absolute path **/
	private String tempFAbsPath;
	
	/** 要导出的文件  */
	private InputStream inStream;
	/** 用户导出到本地的文件名 **/
	private String fileName;
	
//	private String url;
	
	/** 导出文件是否需要登陆  */
	private Boolean loginCheck;
//	private BaseExportService dataService;
	private CommonService commonService;
	
    /** for response */
	private String sResponse;
	/** for response--currently use it when In ColumnNames and show export progress */
	private	Map map = new HashMap();

	/**
	 * 导出用的Action应该返回一个InputStream实例
	 * 该方法对应在result里的inputName属性值为targetFile
	 * @return
	 * @throws Exception
	 */
	public InputStream getTargetFile() throws Exception {
//		System.out.println("----------getTargetFile--------------");
		this.inStream = new BufferedInputStream(new FileInputStream( tempFAbsPath ), 1*1024*1024);
		String iso88951 = "";//这里还没有转换  eg: temp.xls
		CharacterConvert cv = new CharacterConvert();

		String Timestamp="";
//		Encoding		: "GB2312",
//		AddTimestamp 	: "false",//or "true"
//		TimestampFormat	: "",////or "YYYYMMDD","YYYY-MM-DD-HHNNSS"
		
		if( options!=null 
		 && Boolean.parseBoolean(options.get("AddTimestamp").toString()) ){
			//"yyyy年MM月dd日 HH:mm"
			SimpleDateFormat stm=new SimpleDateFormat(options.get("TimestampFormat").toString());
			Timestamp = "_"+stm.format(new Date());
		}
		
		java.io.File fold = new java.io.File(tempFAbsPath);
		iso88951 = cv.getGBK2ISO( FileUtil.getFileNameNoEx( fold.getName() ) + Timestamp + "."+ FileUtil.getExtensionName( fold.getName() ) );
		
//		System.out.println("iso88951:"+iso88951);
		this.setFileName(iso88951);
		return this.inStream;  
	}
	/**
	 * 处理用户导出文件的方法
	 * 同步导出EXCEL(以提交form的形式导出)
	 * AuthorityModule.Export.export  --ExportXLS()
	 * AuthorityModule.Export.exportDayReport  --ExportDayReportXLS()
	 * AuthorityModule.Export.exportMonthReport  --ExportMonthReportXLS()
	 * @throws Throwable 
	 * 
	 * 
	 * 
	 */
	public String downloadXLS() throws Throwable{
		java.io.File fold = new java.io.File(tempFAbsPath);
		if(!fold.exists())
			throw new RuntimeException("文件不存在！tempFAbsPath："+tempFAbsPath);

		this.tempFExtName = FileUtil.getExtensionName(tempFAbsPath);
		switch(this.tempFExtName){
		case "xls": return SUCCESS;
		case "xlsx": return "xlsx";
		case "txt": return "txt";
		default : return SUCCESS;		
		}
	}
	/**
	 * 处理用户导出文件的方法
	 * 同步导出(以提交form的形式导出)
	 * 
	 * @see com.asiainfo.CommonEXPAction.struts2.action.exp.TAuthorityModuleEXPAction#ExportXLS()
	 * @throws Throwable 
	 * 
	 */
	public String downloadTXT() throws Throwable{
		
		java.io.File fold = new java.io.File(tempFAbsPath);
		if(!fold.exists())
			throw new RuntimeException("文件不存在！tempFAbsPath："+tempFAbsPath);
		
		this.tempFExtName = FileUtil.getExtensionName(tempFAbsPath);
		switch(this.tempFExtName){
		case "xls": return SUCCESS;
		case "xlsx": return "xlsx";
		case "txt": return "txt";
		default : return SUCCESS;		
		}
	}
	public String TableNames() {
		System.out.println("###1 this.sResponse:"+this.sResponse);

		List dataList = new ArrayList(1);
		int size =1;
		
//		for( int i=0, j=size; i<j; i++ ) {
//			Map map = new HashMap(2);
//			map.put("tname", "TB_PAYER_COMMI_INFO" );
//			map.put("comments", "模块信息表 1" );
//			dataList.add(map);
//		}
	
		String key ="TB_PAYER_COMMI_INFO";
		for( int i=0, j=size; i<j; i++ ) {
			Map map = new HashMap(2);
			map.put("tname", key );
			map.put("comments", 
					commonService.getTableNames_Map().get(key).toString() 
					);
//			map.put("comments", "模块信息表" );
			dataList.add(map);
		}
		
		map.put("total", size );
		map.put("rows", dataList );
		System.out.println("map:"+JSONObject.fromObject(map).toString() );
		return "map";
	}
	
	public String DefaultColumns(){
		AbstractConstant absConstant = new AuthorityModule();

		this.sResponse = absConstant
				.getJSDOC()
				.getExport()
				.get("export")
				.getDefaultColumns().toString();
		
		System.out.println("###DefaultColumns() this.sResponse:"+this.sResponse);
		this.setSResponse(sResponse);
		return "sResponse";
	}
	
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
	public String ColumnNames() {
		System.out.println("###1 this.sResponse:"+this.sResponse);
		AbstractConstant absConstant = new AuthorityModule();
		
//		Map<String, List> ColumnMap = absConstant.getJSDOC().getExport().get("export").getColumnMap();
    	Map<String, List> ColumnMap = absConstant.getEXPcolumnMap();
    	this.sResponse ="";
		Set set = ColumnMap.keySet();
		int size = ColumnMap.size();

		List dataList = new ArrayList(size);
		
		Iterator it = set.iterator();
		Object key;
		for( int i=0, j=size; i<j; i++ ) {
			key = it.next();
			List list = (List)ColumnMap.get( key );
			Map map = new HashMap(2);
			map.put("name", (String)key );
			map.put("name_zh", (String)list.get(3) );
			dataList.add(map);
		}
//		Map swtData = new HashMap(2);
//		swtData.put("total", size );
//		swtData.put("rows", dataList );
//		JSONObject jsonObject = JSONObject.fromObject(swtData);
//		this.sResponse = jsonObject.toString();
//		System.out.println("###2 this.sResponse:"+this.sResponse);
//		this.setSResponse(sResponse);
//		return "sResponse";
		
		map.put("total", size );
		map.put("rows", dataList );
		System.out.println("map:"+JSONObject.fromObject(map).toString() );
		return "map";
	}

	/**
	 * Get process rate and message
	 * @return
	 */
	public String getProgress(){
		//取得ActionContext实例
//		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext访问用户的HttpSession
//		Map<String, Object> session = ctx.getSession();
//		HttpServletRequest request = ServletActionContext.getRequest();
		
//		System.out.println( "#############################\n"+
//			JSONObject.fromObject( request.getSession() ).toString() 
//			+"\n#############################"
//		);
//		Progress temp = Progresses.map.get(_);
//		Progress p = temp == null? temp: new Progress(0,"正在开始...");
//		Progress p;
//		if(Progresses.map.size()!=0){
//			p = Progresses.map.get(_);
//		}else{
//			p = new Progress(0,"正在开始...");
//		}
//		map.put( "progress", p.getProgress() );
//		map.put( "msg", p.getMsg() );
		return "map";
	}

	public void setJdata(String jdata) throws UnsupportedEncodingException {
//		log.debug("encoded jdata:" + jdata.toString());
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		log.debug("#######");
		log.debug("decoded jdata:" + decode.toString());
		log.debug("#######");
		this.jdata = decode;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setOptions(String options) throws UnsupportedEncodingException {
		log.debug("encoded options:" + options.toString());
		String decode=null;
		try {
			decode = java.net.URLDecoder.decode(options, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		log.debug("#######");
		log.debug("decoded options:" + decode.toString());
		log.debug("#######");
		this.options = JSONObject.fromObject(decode);
	}
//	public void setOptions(Map options) {
//		this.options = options;
//	}
	
	public void setSortBy(List<Map> sortBy) {
		this.sortBy = sortBy;
	}
	/**
	 * '["PAY_ID","ACC_ID"]' or '[PAY_ID,ACC_ID]'  --> list
	 * 
	 * @param customColumns
	 */
	public void setCustomColumns(String customColumns) {
//		this.customColumns = customColumns;
		log.debug("encoded customColumns:" + customColumns.toString());
		String decode=null;
		try {
			decode = java.net.URLDecoder.decode(customColumns, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		log.debug("#######");
		log.debug("decoded customColumns:" + decode.toString());
		log.debug("#######");
		this.customColumns = JSONArray.fromObject(decode);
	}
	public void set_(String _) {
		this._ = _;
	}
	public void setLoginCheck(Boolean loginCheck) {
		this.loginCheck = loginCheck;
	}
	
	public String getTempFAbsPath() {
		return tempFAbsPath;
	}
	public void setTempFAbsPath(String tempFAbsPath) {
		this.tempFAbsPath = tempFAbsPath;
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
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
}
