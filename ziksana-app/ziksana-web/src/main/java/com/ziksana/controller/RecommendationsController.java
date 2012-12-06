/**
 * 
 */
package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.recommendations.RecommendationsService;


/**
 * @author vtg-p13
 *
 */
@Controller
@RequestMapping("/secure")
public class RecommendationsController {
	private static final Logger logger = LoggerFactory.getLogger(RecommendationsController.class);
 
	@Autowired
	RecommendationsService recomendationsservice;
	
	@RequestMapping(value = "/showrecByCateg/{category}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showRecommendByCategory(@PathVariable Integer category) {
	
		logger.info("Category Id: " + category);
		ModelAndView modelAndView = new ModelAndView("xml/zrecommendations");
		modelAndView.addObject("recommendItem", recomendationsservice.getRecommendations(category));
		logger.info("Exit Recommend By category");
		
		return modelAndView;
	}
	
}