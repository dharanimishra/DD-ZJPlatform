package com.ziksana.controller;

import java.util.ArrayList;
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

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResultNQuestion;
import com.ziksana.service.polls.PollService;

@Controller
@RequestMapping("/secure")
public class PollController {

	private static final Logger logger = LoggerFactory
			.getLogger(PollController.class);

	@Autowired
	private PollService pollService;
	
	/*
	 * get poll questions
	*/
		
	@RequestMapping(value = "/getallpollquestions", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestions() {


		ModelAndView modelView = new ModelAndView("xml/pollQuestionsList");
		

		modelView.addObject("pollQuestionsList",pollService.getAllPollQuestions());

		
		return modelView;
	}
	
	@RequestMapping(value = "/getallpollquestion", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestion() {


		ModelAndView modelView = new ModelAndView("xml/pollQuestionsList");
		

		modelView.addObject("pollQuestionsList",pollService.getAllPollQuestion());

		
		return modelView;
	}
	
	
	@RequestMapping(value = "/getpollsbetweendate", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getAnnouncementsAllByDate(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView modelView = new ModelAndView("xml/pollQuestionsList");
		
		modelView.addObject("pollQuestionsList",pollService.getAllPollQuestionsByDate(startDate, endDate));
		
		
		

		return modelView;
	}
	
/*
 * Poll Questions And Answers
*/

	@RequestMapping(value = "/getallpollquestionsanswers/{questionId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestionsAndAnswers(@PathVariable Integer questionId) {


		ModelAndView modelView = new ModelAndView("xml/pollQuestionsAnswersList");
		

		modelView.addObject("pollQuestionsAnswersList",pollService.getPollResultByQuestion(questionId));

		
		return modelView;
	}
	
	
	@RequestMapping(value = "/homePage.htm", method = RequestMethod.GET, params = {})
	public @ResponseBody
	List<PollQuestion> getPollQuestions(Integer memberRoleId) {
		// TODO
		return null;

	}

	@RequestMapping(value = "/showpoll/{memberId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showPolls(@PathVariable String memberId) {
		logger.info("Entering showPolls(-----): " + memberId);
		ModelAndView modelView = new ModelAndView("xml/pollResultNQuestionNew");
		

		modelView.addObject("questions",
				pollService.getPollQuestionsAndResults());

		// modelView.addObject("questions", "My test question");

		logger.info("Exiting showPolls(-----): " + memberId);
		return modelView;
	}

	@RequestMapping(value = "/submitpoll", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView submitPoll(@RequestParam(value = "pollId",required = true) String pollId, 
			@RequestParam(value = "optionIndex", required = true) String optionIndex) {
		
		logger.info("Entering submitPoll(): " +  " pollId " + pollId
				+ " optionIndex " + optionIndex);

		PollQuestionResponse pollQuestionResponse = new PollQuestionResponse();

		PollQuestion pollQuestion = new PollQuestion();
		pollQuestion.setID(Integer.valueOf(pollId));

		pollQuestionResponse.setPollQuestion(pollQuestion);
		List<Integer> answers = new ArrayList<Integer>();
		int option = Integer.valueOf(optionIndex);
		option += 1;
		answers.add(Integer.valueOf(option));

		pollQuestionResponse.setAnswers(answers);

		pollService.pollResponse(pollQuestionResponse);

		ModelAndView modelView = new ModelAndView("xml/pollresult");
		
		PollResultNQuestion pollQuestionResult = new PollResultNQuestion();
		
		List<PollResultNQuestion> results = new ArrayList<PollResultNQuestion>();
		PollQuestionResult pollQR =  pollService.getPollResult(pollQuestion);
        
		if (pollQR == null)
		{
			System.out.println(" POLLQR IS NULL");
		}
		
		pollQuestionResult.setPollResult(pollQR);
		results.add(pollQuestionResult);
		
		
		
		
		modelView.addObject("questions",
				results);
		
		
		
		logger.info("Exiting submitPoll():  pollId " + pollId
				+ " optionIndex " + optionIndex);
		return modelView;

	}
	
	@RequestMapping(value = "/getpollpopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		
		ModelAndView modelAndView = new ModelAndView("common/pollResults");
		

		return modelAndView;
		
	}

}
