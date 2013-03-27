package com.ziksana.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExclusionExceptionResolver extends SimpleMappingExceptionResolver
		implements InitializingBean {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ExclusionExceptionResolver.class);
	private Class<Exception>[] excludedExceptions;


	@Override
	  protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	    for (Class<?> excludedClass : excludedExceptions) {
	      if (excludedClass.isInstance(ex)) {
	        return null;
	      }
	    }
	    //return super.doResolveException(request, response, handler, ex);
	    
	    
	    LOGGER.debug("---------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	    LOGGER.error(ex.getMessage(), ex);
	    return new ModelAndView("common/error");
	  }
	  public void setExcludedExceptions(Class<Exception>[] excludedExceptions) {
	    this.excludedExceptions = excludedExceptions;
	  }

	  @Override
	  public void afterPropertiesSet() throws Exception {
	    if (excludedExceptions == null) {
	    	excludedExceptions = new Class[]{};
	    }
	  }
}
