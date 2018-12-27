package cn.zzpigt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.zzpigt.bean.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		System.out.println(request.getRequestURI());
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user != null || request.getRequestURI().contains("login") || request.getRequestURI().contains("checkCode")){
			System.out.println("登入通过：" + request.getRequestURI());
			return true;
		}else{
			System.out.println("登入拦截了：" + request.getRequestURI());
			response.sendRedirect(request.getContextPath() + "/User/login.action");
			return false;
		}
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception { 
		
	}



}
