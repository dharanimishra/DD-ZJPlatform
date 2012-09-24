package com.spring.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.service.polls.PollService;




@Controller
@RequestMapping(value = "/*")
public class PollController {
	
	
	
	@Autowired
	private PollService pollService;
	
	
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	List<PollQuestion> getUnansweredPollQuestions(Integer memberRoleId)
	{
		return pollService.getUnansweredPollQuestions(memberRoleId);
		
	}
	
	
	
	
	
	
	
	
	
	

}
