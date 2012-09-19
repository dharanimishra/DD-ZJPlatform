package com.spring.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.service.polls.PollService;




@Controller
@RequestMapping(value = "/*")
public class PollController {
	
	
	
	@Autowired
	private PollService pollService;
	
	
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	List<PollQuestion> getPoll(Integer memberRoleId)
	{
		return pollService.getPoll(memberRoleId);
		
	}
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	PollQuestionResponse answerPoll(Integer pollQuestionId,Integer pollAnswerId)
	{
		return pollService.answerPoll(pollQuestionId, pollAnswerId);
		
	}
	
	
	
	
	
	
	
	

}
