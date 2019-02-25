package person.daizhongde.authority.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityRole;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.listener.OnLine;
import person.daizhongde.authority.spring.service.impl.TAuthorityRoleServiceImpl;
import person.daizhongde.authority.spring.service.impl.TAuthorityUserServiceImpl;
import person.daizhongde.virtue.assemble.sql.SQLAssembleQ;
import person.daizhongde.virtue.codec.PasswordUtil;
import person.daizhongde.virtue.constant.Lic;

public class LoginServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5770443378099558280L;
	private PasswordUtil  pwdUtil;
	private ApplicationContext ctx;
	
	public void init() throws ServletException {
//		pwdUtil = new PasswordUtil();
//		pwdUtil.setEA( new EA_SHA1Impl() );
//		System.out.println("servlet infor:\n"+this.getServletInfo());
		
//		Properties  properties = System.getProperties();
//		properties.list(System.out);
		
		ctx = WebApplicationContextUtils.getWebApplicationContext( this.getServletContext() );
		pwdUtil = PasswordUtil.getFromApplicationContext(ctx);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		/loginServlet
		//下面几行代码用来禁止重复提交
//		HttpSession session = request.getSession(true);
//		String PageFlag=(String) session.getAttribute("SubmitFlag");
//		if (PageFlag.equalsIgnoreCase("Over")){
//			return (mapping.findForward("main"));
//		}
//		//设置标志变量SubmitFlag值为Over，表示已经提交
//	    session.setAttribute("SubmitFlag","Over");
		String j_username = request.getParameter("j_username");//<action name="*JsonQuery*" class="{1}JsonQueryAction" method="{2}">
		String j_password = request.getParameter("j_password");
		String rand = request.getParameter("rand");
		String checkrand = request.getParameter("checkrand");
		
		System.out.println("Servlet j_username:"+j_username);
		System.out.println("Servlet j_password:"+j_password);
		System.out.println("rand:"+rand);
		System.out.println("checkrand:"+checkrand);
		
//		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( this.getServletContext() );
		TAuthorityUser user = TAuthorityUserServiceImpl.getFromApplicationContext(ctx).findByLogname(j_username);
		
		//如果请求参数中没有checkrand就不需要校验rand
        if( checkrand!=null && !checkrand.equalsIgnoreCase( rand ) )
        {
          request.setAttribute("tip", "Verification Code error!");
          request.setAttribute("j_username", j_username);
          request.getRequestDispatcher( SessionConstants.LOGIN_PAGE ).forward(request, response); 
        }
        else if(user==null)
		{
			request.setAttribute("tip", "The user is not exist!");
			request.setAttribute("j_username", j_username);
		    request.getRequestDispatcher( SessionConstants.LOGIN_PAGE ).forward(request, response); 
		}
		else if( !pwdUtil.check( j_password, user.getCUpassword() ) )
		{
//			System.out.println("user.getCUpassword():"+user.getCUpassword());
			
//			response.setContentType("text/html; charset=UTF-8");
//		    ServletContext sc = this.getServletContext();
//		    RequestDispatcher rd = sc.getRequestDispatcher("login.html?msg=密码不正确"); //定向的页面
			
			request.setAttribute("tip", "Password error!");
			request.setAttribute("j_username", j_username);
		    request.getRequestDispatcher( SessionConstants.LOGIN_PAGE ).forward(request, response); 
		}
		else
		{
		    OnLine on=new OnLine();
		    user.setCLoginip( request.getRemoteAddr() );
			on.setUser( user );
			
			request.getSession().setAttribute( SessionConstants.LOGIN_USER, user);
			request.getSession().setAttribute( SessionConstants.ONLINE_USER, on);
			
			List<TAuthorityRole> roles  = TAuthorityRoleServiceImpl.getFromApplicationContext(ctx).findRoleByUserId( user.getNUid() );
			
			String role = "";
			for (int i = 0, j = roles.size(); i < j; i++) {
				if (i == 0) {
					role += roles.get(i).getCRname();
				} else {
					role += "+" + roles.get(i).getCRname();
				}
			}
			
			if(role.contains("migrator")){
				request.getSession().setAttribute( SessionConstants.CKFINDER_USERROLE, "migrator" );
			}else{
				request.getSession().setAttribute( SessionConstants.CKFINDER_USERROLE, "registered" );
			}
//			request.getSession().setAttribute( SessionConstants.CKFINDER_USERROLE, "guest" );
			
//			System.out.println("登陆成功："+user.getCUname()+"<"+user.getCUlogname()+">");
//			response.sendRedirect("Webmain/main.html");
			SQLAssembleQ.check(String.valueOf( Lic.getYear()));
			response.sendRedirect( SessionConstants.WELCOME_PAGE );
		}
	}

	public void destroy() {
		
	}

}
