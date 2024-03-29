package com.ziksana.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.util.MessageUtil;

public class ExclusionExceptionResolver extends SimpleMappingExceptionResolver
		implements InitializingBean {

	private static Logger LOGGER = LoggerFactory
			.getLogger(ExclusionExceptionResolver.class);
	private Class<Exception>[] excludedExceptions;

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		for (Class<?> excludedClass : excludedExceptions) {
			if (excludedClass.isInstance(ex)) {
				return null;
			}
		}
		// return super.doResolveException(request, response, handler, ex);

		LOGGER.error(ex.getMessage(), ex);
		//TODO fetch it from propertis 
		ModelAndView modelAndView = new ModelAndView("error/ziksana_error");
		modelAndView.addObject("errorMessage","Ziksana Error!!");
		return modelAndView;
	}

	public void setExcludedExceptions(Class<Exception>[] excludedExceptions) {
		this.excludedExceptions = excludedExceptions;
	}

	public void afterPropertiesSet() throws Exception {
		if (excludedExceptions == null) {
			excludedExceptions = new Class[] {};
		}
	}
}
