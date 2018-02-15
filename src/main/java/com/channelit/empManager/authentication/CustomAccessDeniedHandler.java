package com.channelit.empManager.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private String errorPage;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendRedirect(errorPage);
	}

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

}
