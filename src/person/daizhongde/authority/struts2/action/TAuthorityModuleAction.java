package person.daizhongde.authority.struts2.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import person.daizhongde.authority.hibernate.pojo.TAuthorityModule;
import person.daizhongde.authority.spring.service.TAuthorityModuleService;

/**
 * 模块信息个性化业务处理
 * <br>目前为止不处理任何业务
 * special business 
 * @author dzd
 *
 */
public class TAuthorityModuleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5849224233065897224L;
	
	private String jdata;
	
	private String sResponse;
	private Map map = new HashMap();
	private Object[] rs;
	
	private TAuthorityModule pojo;
	private TAuthorityModuleService dataService;

	public void setJdata(String jdata) throws UnsupportedEncodingException {
		String decode = java.net.URLDecoder.decode(jdata, "UTF-8");
		this.jdata = decode;
	}
	
	public void setPojo(TAuthorityModule pojo) {
		this.pojo = pojo;
	}

	public TAuthorityModule getPojo() {
		return pojo;
	}

	public Map getMap() {
		return map;
	}

	public Object[] getRs() {
		return rs;
	}

	public void setDataService(TAuthorityModuleService dataService) {
		this.dataService = dataService;
	}
	public String getSResponse() {
		return sResponse;
	}
}
