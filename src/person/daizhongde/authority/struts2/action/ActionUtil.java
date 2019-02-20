package person.daizhongde.authority.struts2.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

public class ActionUtil {
	public HttpSession getSession(Boolean create) {
		return ServletActionContext.getRequest().getSession(create);
	}
	
	public Integer getUserId() {
		TAuthorityUser user = (TAuthorityUser)getSession(false).getAttribute( SessionConstants.LOGIN_USER );
		return user.getNUid();
	}
	
	public String getUserlogname() {
		TAuthorityUser user = (TAuthorityUser)getSession(false).getAttribute( SessionConstants.LOGIN_USER );
		return user.getCUlogname();
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
		
	public String getRemoteAddr() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}
}
