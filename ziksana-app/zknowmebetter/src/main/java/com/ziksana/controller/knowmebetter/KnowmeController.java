package com.ziksana.controller.knowmebetter;

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

import com.ziksana.domain.common.Choice;
import com.ziksana.domain.common.Question;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.knowmebetter.PersonalityTestService;

/**
 * @author vtg-p13
 * 
 */
@Controller
@RequestMapping("/knowmebetter")
public class KnowmeController {

	private static final Logger logger = LoggerFactory
			.getLogger(KnowmeController.class);

	@Autowired
	private PersonalityTestService personalityService;

	@RequestMapping(value = "/getansweredquestions", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getansweredQuestions() {
		logger.debug("Entered Know me Better || getansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/answeredquestions");
		try {
			
			modelAndView.addObject("answeredquesList",
					personalityService.answeredQuestions());
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}

		logger.debug("Exiting Know me Better");
		return modelAndView;
	}

	@RequestMapping(value = "/getunansweredquestionsbyid/{questionBankId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getUnansweredQuestionsByQuestionId(
			@PathVariable Integer questionBankId) {
		logger.debug("Know me Better || getunansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView(
				"xml/singleunansweredquestions");
		try {
			modelAndView.addObject("unansweredquesList",
					personalityService.getUnansweredQuestionsbyId(questionBankId));
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}
		logger.debug("Exit Know me Better");
		return modelAndView;

	}

	@RequestMapping(value = "/getunansweredquestions", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getUnansweredQuestions() {
		logger.debug("Know me Better || getunansweredQuestions()");
		ModelAndView modelAndView = new ModelAndView("xml/unansweredquestions");
		try {
			modelAndView.addObject("unansweredquesList",
					personalityService.getUnansweredQuestions());
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}
		logger.debug("Exit Know me Better");
		return modelAndView;

	}

	@RequestMapping(value = "/knowmebetterpopuppage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPopupWindow() {
		logger.info("Knowmebetter Popup window");
		ModelAndView modelAndView = new ModelAndView("common/knowmebetter");

		return modelAndView;

	}

	@RequestMapping(value = "/saveknowme", method = RequestMethod.POST)
	public @ResponseBody
	String submitKnowme(
			@RequestParam(value = "memberAnswer", required = true) String memberAnswer,
			@RequestParam(value = "testQuestionValue", required = true) String testQuestionValue,
			@RequestParam(value = "testQuestionId", required = true) Integer testQuestionId,
			@RequestParam(value = "questionBankAnswerId", required = true) Integer questionBankAnswerId) {

		try {
			Question question = new Question(testQuestionId, testQuestionValue);
			Choice userChoice = new Choice(questionBankAnswerId, null, memberAnswer);

			// userChoice.setMemPstTestId(Integer.valueOf(1));
			personalityService.saveAnswer(question, userChoice);
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}
		//TODO get this message from properties file
		return "Answer Submitted Successfully";
	}

	@RequestMapping(value = "/updateknowmebetter", method = RequestMethod.POST)
	public @ResponseBody
	String updateKnowme(
			@RequestParam(value = "editCheckedAnswer", required = true) String editCheckedAnswer,
			@RequestParam(value = "editQuesval", required = true) String editQuesval,
			@RequestParam(value = "editQuesid", required = true) Integer editQuesid,
			@RequestParam(value = "editAnsId", required = true) Integer editAnsId,
			@RequestParam(value = "memberPersonalityTestId", required = true) Integer memberPersonalityTestId) {
		
		//TODO get it from properties file
		String response  = "Answer Updated Successfully";

		try {
			Question question = new Question(editQuesid, editQuesval);
			Choice userChoice = new Choice(editAnsId, editAnsId, editCheckedAnswer,
					memberPersonalityTestId);

			personalityService.updateAnswer(question, userChoice);
		} catch (ZiksanaException exception) {
			response = "Answer Updatation Failed";
			logger.error(exception.getMessage(), exception);
		}
		
		return response;
	}

}
