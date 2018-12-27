package cn.zzpigt.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.zzpigt.bean.User;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
//		//登入放行
//		User user = (User) request.getSession().getAttribute("user");
//		if(user != null || request.getRequestURI().contains("login") || request.getRequestURI().contains("checkCode")){
//			System.out.println("登入过了，可以放行！！!");
//			return true;
//		}
		User user = (User) request.getSession().getAttribute("user");
		//权限拦截
		List<String> operate = (List<String>) request.getSession().getAttribute("perActionList");
		if(operate != null && operate.size() > 0){
			for (String op : operate) {
				if(request.getRequestURI().contains(op) || request.getRequestURI().contains("depttable")|| request.getRequestURI().contains("Attend")|| request.getRequestURI().contains("User")){
					System.out.println("没被拦截的，通过：" + request.getRequestURI());
					return true;
				}
			}
		}else if(user != null || request.getRequestURI().contains("login") || request.getRequestURI().contains("checkCode")){
			return true;
		}
		System.out.println("被拦截的：" + request.getRequestURI());
		response.sendRedirect(request.getContextPath() + "/main.jsp");
		return false;
		
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
