package person.daizhongde.authority.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import person.daizhongde.authority.constant.SessionConstants;

/**
 * 
 * @author dzd
 *
 */
public class AuthorityFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
        HttpSession session = req.getSession();
		
//        session.getAttribute("TbEmsOprt");
        String path = req.getContextPath();
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
        
//        System.out.println("path："+path);
//        System.out.println("basePath："+basePath);
        
        String ServletPath = req.getServletPath();//index.jsp
        
        //http://localhost:7001/emsda/index.jsp
        String RequestURL = req.getRequestURL().toString();
        
        //emsda/index.jsp
        String RequestURI = req.getRequestURI();
        String RemoteAddr = req.getRemoteAddr();//127.0.0.1
        
//        System.out.println("ServletPath："+ServletPath);
//        System.out.println("RequestURL："+RequestURL);
//        System.out.println("RequestURI："+RequestURI);
//        System.out.println("RemoteAddr："+RemoteAddr);
        
        //compare to smart spring security's none filter(nofilter)
        String[] noCheckURI = {"login","index",
        		"css","images","scripts", "print","ckfinder","dwr","test","demo" };
        
//        String[] logins = {"login.html","login.jsp",
//        		"index.html","index.jsp"};
        
        boolean needCheck = true;
        for(int i=0, j=noCheckURI.length; i<j; i++ )
        {
        	if(RequestURI.trim().startsWith( path+"/"+noCheckURI[i]))
        	{
        		needCheck = false;
        		break;
        	}
        }
        if(RequestURI.trim().equalsIgnoreCase( path ) 
        		|| RequestURI.trim().equalsIgnoreCase( path+"/" ) ){
        	needCheck = false;
        }
        
        if(needCheck)
        {
        	if (session.getAttribute( SessionConstants.LOGIN_USER ) == null) {
    			System.out.println("没有登陆呀......");
//    			request.getRequestDispatcher("/login.jsp").forward(request,response);
        		resp.sendRedirect(basePath + SessionConstants.LOGIN_PAGE);
    		}
        	else
    		{
    			chain.doFilter(request, response);
    		}
        }
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
		
	}
}
