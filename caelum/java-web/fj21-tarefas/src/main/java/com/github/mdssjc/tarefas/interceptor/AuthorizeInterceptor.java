package com.github.mdssjc.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {

	String uri = request.getRequestURI();
	if (uri.endsWith("login") || uri.endsWith("doLogin") || uri.contains("resources")) {
	    return true;
	}

	if (request.getSession().getAttribute("validUser") != null) {
	    return true;
	}

	response.sendRedirect("login");
	return false;
    }
}
