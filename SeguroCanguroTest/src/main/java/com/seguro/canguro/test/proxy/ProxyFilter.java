package com.seguro.canguro.test.proxy;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.GenericFilterBean;

public class ProxyFilter extends GenericFilterBean{
	
	@Value("${proxy-redirection}")
	private String proxyFilterUrl = "/proxy";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponnse, FilterChain chain) throws IOException, ServletException {		
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponnse;
		
		String requestUrl = httpServletRequest.getRequestURL().toString();
		
		String[] urlParts = requestUrl.split(proxyFilterUrl);
		
		String completeUrl = urlParts[0] + "/SeguroCanguro" + urlParts[1];
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(completeUrl, HttpMethod.valueOf(httpServletRequest.getMethod()), null, String.class);
		
		httpServletResponse.setStatus(200);
		httpServletResponse.getWriter().write(response.getBody());
		httpServletResponse.setContentType("application/json");
		httpServletResponse.getWriter().flush();
		httpServletResponse.getWriter().close();
	}

}
