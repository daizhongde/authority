package person.daizhongde.authority.struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import person.daizhongde.virtue.codec.PasswordUtil;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.listener.OnLine;
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

public class LoginAction extends ActionSupport
{
/**
	 * 
	 */
	private static final long serialVersionUID = -294174729527631835L;
	private String tip;
	private PasswordUtil  pwdUtil;
	private TAuthorityUserService userService;

    public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setPwdUtil(PasswordUtil pwdUtil) {
		this.pwdUtil = pwdUtil;
	}

	public void setUserService(TAuthorityUserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception
	{
//		/loginServlet
		//下面几行代码用来禁止重复提交
//		HttpSession session = request.getSession(true);
//		String PageFlag=(String) session.getAttribute("SubmitFlag");
//		if (PageFlag.equalsIgnoreCase("Over")){
//			return (mapping.findForward("main"));
//		}
//		//设置标志变量SubmitFlag值为Over，表示已经提交
//	    session.setAttribute("SubmitFlag","Over");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String j_username = request.getParameter("j_username");//<action name="*JsonQuery*" class="{1}JsonQueryAction" method="{2}">
		String j_password = request.getParameter("j_password");
		String rand = request.getParameter("rand");
		String checkrand = request.getParameter("checkrand");
		
		System.out.println("Action j_username:"+j_username);
		System.out.println("Action j_password:"+j_password);
		System.out.println("rand:"+rand);
		System.out.println("checkrand:"+checkrand);
		
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( this.getServletContext() );
		TAuthorityUser user = userService.findByLogname(j_username);
		
		//如果请求参数中没有checkrand就不需要校验rand
        if( checkrand!=null && !checkrand.equalsIgnoreCase( rand ) )
        {
          request.setAttribute("tip", "验证码有误，请重新输入!");
          this.setTip("验证码有误，请重新输入!");
          request.setAttribute("j_username", j_username);
//          request.getRequestDispatcher("login.jsp").forward(request, response); 
          return ERROR;
        }
        else if(user==null)
		{
			request.setAttribute("tip", "该用户不存在!");
			this.setTip("该用户不存在!");
			request.setAttribute("j_username", j_username);
//		    request.getRequestDispatcher("login.jsp").forward(request, response);
			return ERROR;
		}
		else if( !pwdUtil.check( j_password, user.getCUpassword() ) )
		{
//			System.out.println("user.getCUpassword():"+user.getCUpassword());
			
//			response.setContentType("text/html; charset=UTF-8");
//		    ServletContext sc = this.getServletContext();
//		    RequestDispatcher rd = sc.getRequestDispatcher("login.html?msg=密码不正确"); //定向的页面
			
			request.setAttribute("tip", "密码不正确!");
			this.setTip("密码不正确!");
			request.setAttribute("j_username", j_username);
//		    request.getRequestDispatcher("login.jsp").forward(request, response);
			return ERROR;
		}
		else
		{
		    OnLine on=new OnLine();
		    user.setCLoginip( request.getRemoteAddr() );
			on.setUser( user );
			
			request.getSession().setAttribute( SessionConstants.LOGIN_USER, user);
			request.getSession().setAttribute( SessionConstants.ONLINE_USER, on);
//			request.getSession().setAttribute( SessionConstants.ONLINE_USER, user);
			
//			System.out.println("登陆成功："+user.getCUname()+"<"+user.getCUlogname()+">");
//			response.sendRedirect("Webmain/main.html");
			return SUCCESS;
		}
    }
}