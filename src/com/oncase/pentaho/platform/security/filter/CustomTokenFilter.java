package com.oncase.pentaho.platform.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.AuthenticationManager;
import org.springframework.util.Assert;

public class CustomTokenFilter implements Filter, InitializingBean {


	private AuthenticationManager authenticationManager;
	private String servlet_name;



	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		System.out.println("----------------------------------------------------");
		System.out.println("-- CustomTokenFilter");
		System.out.println("----------------------------------------------------");
		System.out.println("is authenticationManager null?" + (authenticationManager==null));
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.authenticationManager,
				"authenticationManager is required"); //$NON-NLS-1$
		
		Assert.notNull(this.servlet_name,
				"servlet_name parameter is required"); //$NON-NLS-1$
	}

	@Override
	public void destroy() {		
	}
	
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
	
	public void setAuthenticationManager(
			final AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public String getServlet_name() {
		return this.servlet_name;
	}

	public void setServlet_name(final String servlet_name) {
		this.servlet_name = servlet_name;
	}
	
	
	
}
