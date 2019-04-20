package person.daizhongde.authority.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import person.daizhongde.authority.constant.SessionConstants;
import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;

public class LogoutServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4684936051400801090L;

	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		/logoutServlet
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
		response.sendRedirect( SessionConstants.LOGIN_PAGE );
	}

	public void destroy() {
		
	}

}
