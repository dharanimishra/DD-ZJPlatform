package com.spring.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.service.polls.PollService;




@Controller
@RequestMapping(value = "/*")
public class PollController {
	
	private static final Logger logger = LoggerFactory.getLogger(PollController.class);
	
	
	
	@Autowired
	private PollService pollService;
	
	
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	List<PollQuestion> getPollQuestions(Integer memberRoleId)
	{
		//TODO
		return null;
		
	}
	
	
	
	@RequestMapping(value = "/showpoll/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showPolls(@PathVariable String memberId) {
		logger.info("Entering showPolls(-----): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/pollResultNQuestion");
		MemberPersona memberPersona = new MemberPersona();
		
		modelView.addObject("questions", pollService.getPollQuestionsAndResults());

//		modelView.addObject("questions", "My test question");

		logger.info("Exiting showPolls(-----): " + memberId);
		return modelView;
	}
	
	
	@RequestMapping(value = "/submitpoll/{memberId}", method = RequestMethod.POST)
	public @ResponseBody void submitPoll(@PathVariable String memberId, @RequestParam String pollId, @RequestParam String optionIndex) {
//	@RequestMapping(value = "/submitpoll/{memberId}/{pollId}/{optionIndex}", method = RequestMethod.POST)
//	public @ResponseBody void submitPoll(@PathVariable String memberId, @PathVariable String pollId, @PathVariable String optionIndex) {	
		logger.info("Entering submitPoll(): " + memberId + " pollId " + pollId + " optionIndex " + optionIndex);
		
		//pollService.pollResponse(memberPersona, pollResponse);
		
		logger.info("Exiting submitPoll(): " + memberId + " pollId " + pollId + " optionIndex " + optionIndex);
	}
	
	
	
	
	
	
	
	
	
	
	

}
