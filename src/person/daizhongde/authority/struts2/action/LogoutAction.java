package person.daizhongde.authority.struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import person.daizhongde.virtue.codec.PasswordUtil;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.TAuthorityUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */

public class LogoutAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6968312571158278259L;
	private String tip;
	private PasswordUtil  pwdUtil;
	private TAuthorityUserService userService;

	public void setTip(String tip)
	{
		this.tip = tip; 
	}

	public String getTip() 
	{
		return (this.tip); 
	}

    public void setPwdUtil(PasswordUtil pwdUtil) {
		this.pwdUtil = pwdUtil;
	}

	public void setUserService(TAuthorityUserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception
	{
		
//		/logoutServlet
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Object o = request.getSession().getAttribute( SessionConstants.LOGIN_USER );
		
		if(o!=null)
		{
			TAuthorityUser user = (TAuthorityUser)o;
//			System.out.println("开始注销："+user.getCUname()+"<"+user.getCUlogname()+">");
			request.getSession().removeAttribute( SessionConstants.LOGIN_USER );
			request.getSession().removeAttribute( SessionConstants.ONLINE_USER );
			request.getSession().invalidate();
			
//			System.out.println("注销成功！"+user.getCUname()+"<"+user.getCUlogname()+">");
		}

//		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return SUCCESS;
    }
}