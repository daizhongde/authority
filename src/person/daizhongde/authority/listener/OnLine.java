package person.daizhongde.authority.listener;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import person.daizhongde.authority.hibernate.pojo.TAuthorityUser;
import person.daizhongde.authority.spring.service.impl.TAuthorityUserServiceImpl;

public class OnLine implements HttpSessionBindingListener{
//    private String username;
    private TAuthorityUser user;
    
    private boolean mark=true;
    private Vector vc=new Vector();
//    public void setUsername(String username){
//    	this.username=username;
//    }
	public void setUser(TAuthorityUser user) {
		this.user = user;
	}

	
//	public void setTAuthorityUser(TAuthorityUser tAuthorityUser) {
//		TAuthorityUser = tAuthorityUser;
//	}
/**
 * HttpSessionBindingListener必须实例化后放入某一个session中，才可以进行监听。
 */
	public void valueBound(HttpSessionBindingEvent se) {
		HttpSession session=se.getSession();
//		System.out.println("TAuthorityUser:"+user.getCUlogname() +"-"+user.getCUname());
		
		ServletContext sct=session.getServletContext();
		vc=(Vector)sct.getAttribute("online");
		if(vc==null){
			vc=new Vector();
			System.out.println("用户<"+user.getCUlogname()+">登陆成功！");
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( sct );
						
			TAuthorityUserServiceImpl.getFromApplicationContext(ctx).updateLogState("1", user.getNUid(), user.getCLoginip() );
			
			vc.add(user);
		}
		else
		{
			if(vc.contains(user)){
				mark=false;
			}
			else{
				System.out.println("用户<"+user.getCUlogname()+">登陆成功！");
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( sct );
				TAuthorityUserServiceImpl.getFromApplicationContext(ctx).updateLogState("1", user.getNUid(), user.getCLoginip()  );
				vc.add(user);
			}
		}
		sct.setAttribute("online",vc);
	}
/**
 * 这里可以直接使用listener的username操作在线列表，不必再去担心session中是否存在username。
	valueUnbound的触发条件是以下三种情况：
	a.执行session.invalidate()时。
	b.session超时，自动销毁时。
	c.执行session.setAttribute("onlineUserListener", "其他对象");或session.removeAttribute("onlineUserListener");将listener从session中删除时。
	因此，只要不将listener从session中删除，就可以监听到session的销毁。
 */
	public void valueUnbound(HttpSessionBindingEvent se) {
		HttpSession session=se.getSession();
		ServletContext sct=session.getServletContext();
		vc=(Vector)sct.getAttribute("online");
		if(vc!=null){
			System.out.println("用户<"+user.getCUlogname()+">注销成功！");
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext( sct );
			TAuthorityUserServiceImpl.getFromApplicationContext(ctx).updateLogState("0", user.getNUid(), user.getCLoginip() );
			vc.removeElement(this.user);
		}
	}
	public boolean getMark(){
		return this.mark;
	}
}
