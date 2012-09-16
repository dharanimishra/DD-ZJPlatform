package com.spring.controllers;

import java.util.Date;

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
	PollQuestion getPoll(Integer memberRoleId, Integer pollId, Date pollStartDate,Date pollEndDate)
	{
		return pollService.getPoll(memberRoleId, pollId, pollStartDate, pollEndDate);
		
	}
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	PollQuestionResponse answerPoll(Integer pollQuestionId,Integer pollAnswerId)
	{
		return pollService.answerPoll(pollQuestionId, pollAnswerId);
		
	}
	
	
	
	
	
	
	
	

}
