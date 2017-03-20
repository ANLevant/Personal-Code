package com.seguro.canguro.test.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seguro.canguro.test.proxy.CORSFilter;
import com.seguro.canguro.test.proxy.ProxyFilter;

@Configuration
public class ProxyFilterConfigurator {
	@Value("${proxy-redirection}")
	private String proxyRedirection;
	
	@Bean
	public FilterRegistrationBean corsFilterConfig(){
		
		CORSFilter corsFilter = new CORSFilter();
		
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	    filterRegBean.setFilter(corsFilter);

	    List<String> urlPatterns = new ArrayList<String>();
	    urlPatterns.add("/*");
	    
	    filterRegBean.setUrlPatterns(urlPatterns);
	    filterRegBean.setOrder(1);
	    
	    return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean proxyFilterConfig(){
		
		ProxyFilter proxyFilter = new ProxyFilter();
		
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	    filterRegBean.setFilter(proxyFilter);

	    List<String> urlPatterns = new ArrayList<String>();
	    urlPatterns.add(proxyRedirection+"*");
	    
	    filterRegBean.setUrlPatterns(urlPatterns);
	    filterRegBean.setOrder(2);
	    
	    return filterRegBean;
	}

}
