package com.ziksana.controller.polls;

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

import com.ziksana.domain.polls.PollQuestion;
import com.ziksana.domain.polls.PollQuestionResponse;
import com.ziksana.domain.polls.PollQuestionResult;
import com.ziksana.domain.polls.PollResultNQuestion;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.polls.PollService;
import com.ziksana.util.MessageUtil;

@Controller
@RequestMapping("/zpolls")
public class PollController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PollController.class);

	@Autowired
	private PollService pollService;
	
	/*
	 * get poll questions
	*/
		
	@RequestMapping(value = "/getallpollquestions", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestions() {


		ModelAndView modelView = new ModelAndView("xml/pollquestionslist");
		

		try {
			modelView.addObject("pollQuestionsList",pollService.getAllPollQuestions());
		} catch (ZiksanaException exception) {
			LOGGER.error(MessageUtil.getMessage(exception.getMessage()), exception );
		}

		
		return modelView;
	}
	
	@RequestMapping(value = "/getallpollquestion", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestion() {


		ModelAndView modelView = new ModelAndView("xml/pollquestionslist");
		try {

			modelView.addObject("pollsList",pollService.getAllPollQuestion());
		} catch (ZiksanaException exception) {
			LOGGER.error(MessageUtil.getMessage(exception.getMessage()), exception );
		}
		return modelView;
	}
	
	
	@RequestMapping(value = "/getpollsbetweendate", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getAllPollQuestionsByDate(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView modelView = new ModelAndView("xml/pollquestionslist");
		try {

			modelView.addObject("pollQuestionsList",pollService.getAllPollQuestionsByDate(startDate, endDate));
		} catch (ZiksanaException exception) {
			LOGGER.error(MessageUtil.getMessage(exception.getMessage()), exception );
		}
		return modelView;
	}
	
/*
 * Poll Questions And Answers
*/

	@RequestMapping(value = "/getallpollquestionsanswers/{questionId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPollQuestionsAndAnswers(@PathVariable Integer questionId) {
		ModelAndView modelView = new ModelAndView("xml/pollquestionsanswerslist");
		try {

			modelView.addObject("pollQuestionsAnswersList",pollService.getPollResultByQuestion(questionId));
		} catch (ZiksanaException exception) {
			LOGGER.error(MessageUtil.getMessage(exception.getMessage()), exception );
		}
		return modelView;
	}
	


	@RequestMapping(value = "/showpoll", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showPolls() {
		ModelAndView modelView = new ModelAndView("xml/pollresultlist");
		try {

			List<PollResultNQuestion> pollQuestionList = pollService.getPollQuestionsAndResults();
			int pollSize = pollQuestionList.size(); 
			modelView.addObject("questions",
					pollService.getPollQuestionsAndResults());

			modelView.addObject("pollSize", pollSize);
		} catch (ZiksanaException exception) {
			LOGGER.error(MessageUtil.getMessage(exception.getMessage()), exception );
		}

		return modelView;
	}

	@RequestMapping(value = "/submitpoll", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView submitPoll(@RequestParam(value = "pollId",required = true) String pollId, 
			@RequestParam(value = "optionIndex", required = true) String optionIndex) {
		
		LOGGER.debug("Entering submitPoll(): " +  " pollId " + pollId
				+ " optionIndex " + optionIndex);
		ModelAndView modelView = new ModelAndView("xml/pollresult");

		try {
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

			
			PollResultNQuestion pollQuestionResult = new PollResultNQuestion();
			
			List<PollResultNQuestion> results = new ArrayList<PollResultNQuestion>();
			PollQuestionResult pollQR =  pollService.getPollResult(pollQuestion);
			
			if (pollQR == null)
			{
				LOGGER.debug(" POLLQR IS NULL");
			}
			
			pollQuestionResult.setPollResult(pollQR);
			results.add(pollQuestionResult);
			
			modelView.addObject("questions",
					results);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		
		
		
		LOGGER.debug("Exiting submitPoll():  pollId " + pollId
				+ " optionIndex " + optionIndex);
		return modelView;

	}
	
	@RequestMapping(value = "/getpollpopuppage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		
		ModelAndView modelAndView = new ModelAndView("common/pollresultspage");
		

		return modelAndView;
		
	}

}
