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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
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
	public @ResponseBody ModelAndView getansweredQuestions() {
		
		logger.info("Know me Better || getansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/answeredquestions");
		modelAndView.addObject("answeredquesList", personalityService.answeredQuestions());
		logger.info("Exit Know me Better");
		
		return modelAndView;
		 
	}
	
	@RequestMapping(value = "/getunansweredquestionsbyid/{questionBankId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getUnansweredQuestionsByQuestionId(@PathVariable Integer questionBankId) {
		
		logger.info("Know me Better || getunansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/singleunansweredquestions");
		modelAndView.addObject("unansweredquesList", personalityService.getUnansweredQuestionsbyId(questionBankId));
		logger.info("Exit Know me Better");
		
		return modelAndView;
		
	}
	@RequestMapping(value = "/getunansweredquestions", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getUnansweredQuestions() {
		
		logger.info("Know me Better || getunansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/unansweredquestions");
		modelAndView.addObject("unansweredquesList", personalityService.getUnansweredQuestions());
		logger.info("Exit Know me Better");
		
		return modelAndView;
		
	}
	@RequestMapping(value = "/getknowmepopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
		logger.info("Popup window");
		ModelAndView modelAndView = new ModelAndView("xml/e-know-me");
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/saveknowme", method = RequestMethod.POST)
	public @ResponseBody String submitKnowme(
			@RequestParam(value = "memberAnswer", required = true) String memberAnswer,
			@RequestParam(value = "testQuestionValue", required = true) String testQuestionValue,
			@RequestParam(value = "testQuestionId", required = true) Integer testQuestionId,
			@RequestParam(value = "questionBankAnswerId", required = true) Integer questionBankAnswerId){
		
		Question question = new Question(testQuestionId,testQuestionValue);
		Choice userChoice =new Choice(questionBankAnswerId, null, memberAnswer, Integer.valueOf(1));
		
		//userChoice.setMemPstTestId(Integer.valueOf(1));
		personalityService.saveAnswer(question, userChoice);
		return "Answer Submitted Successfully";
	}
	
	@RequestMapping(value = "/updateknowmebetter", method = RequestMethod.POST)
	public @ResponseBody String updateKnowme(
			@RequestParam(value = "editCheckedAnswer", required = true) String editCheckedAnswer,
			@RequestParam(value = "editQuesval", required = true) String editQuesval,			
			@RequestParam(value = "editQuesid", required = true) Integer editQuesid,			
			@RequestParam(value = "editAnsId", required = true) Integer editAnsId){
		
		
		Question question = new Question(editQuesid,editQuesval);
		Choice userChoice =new Choice(editAnsId, editAnsId, editCheckedAnswer, Integer.valueOf(1));
		
		personalityService.updateAnswer(question, userChoice);
		return "Answer Updated Successfully";
	}
	

}
