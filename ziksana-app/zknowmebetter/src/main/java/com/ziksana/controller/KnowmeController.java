/**
 * 
 */
package com.ziksana.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.knowmebetter.PersonalityTestService;

/**
 * @author vtg-p13
 *
 */
@Controller
@RequestMapping("/secure")
public class KnowmeController {
	
	private static final Logger logger = Logger.getLogger(KnowmeController.class);
	
	@Autowired
	PersonalityTestService personalityService;
	
	@RequestMapping(value = "/getansweredquestions", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getUnansweredQuestions() {
		
		logger.info("Know me Better || getansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/answeredquestions");
		modelAndView.addObject("answeredquesList", personalityService.answeredQuestions());
		logger.info("Exit Know me Better");
		
		return modelAndView;
		
	}
	@RequestMapping(value = "/getpopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("xml/e-know-me");
		
		
		return modelAndView;
		
	}
	

}
