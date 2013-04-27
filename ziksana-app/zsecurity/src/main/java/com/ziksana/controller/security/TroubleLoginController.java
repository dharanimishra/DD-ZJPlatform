/**
 * 
 */
package com.ziksana.controller.security;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberProfile;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.velocitymail.ZiksanaEmailSender;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.ProfileService;
import com.ziksana.service.security.TroubleLoginService;
import com.ziksana.util.MessageUtil;

/**
 * @author vtg-p13
 * This Controller will allow user is not Authenticated.
 *
 */
@Controller
public class TroubleLoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TroubleLoginController.class);
	
	@Autowired
	private TroubleLoginService troubleLoginService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private MemberService memberService;
	
	//To call Velocity Template
	@Autowired
    private ZiksanaEmailSender emailSender;
	
    @Autowired
    private VelocityEngine velocityEngine;
	
	/*
	 * In Login Page user click TroubleLoggingin link it will redirect user verification page
	*/
	@RequestMapping(value = "/userverficationpage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showUserProfileForm() {
		ModelAndView modelAndView = new ModelAndView("");
		try{
		
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	@RequestMapping(value = "/isuseridexists/{userId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView isUserIdExists(@PathVariable String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		try{
			if(userId.length()<=0){
				modelAndView.addObject("errorResponse", MessageUtil.getMessage(ZiksanaConstants.USERID_ISNULL));
			}else{
				boolean response = troubleLoginService.isUserIdExists(userId);
				 if(response){
					modelAndView.addObject("successResponse", MessageUtil.getMessage(ZiksanaConstants.USERID_VERFICATION_SUCCESS));
					return new ModelAndView("redirect:/unsecure/firstsecurityverfication/"+userId+"");
				}else{
					modelAndView.addObject("errorResponse", MessageUtil.getMessage(ZiksanaConstants.USERID_WRONG));
				}
			}
			
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/firstsecurityverfication/{userId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView securityFormFirstPage(@PathVariable String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		try{
			String securityQuestionId = "1SQ%";
			MemberProfile profile = profileService.getMemberProfile(userId, securityQuestionId);
			modelAndView.addObject("profile", profile);
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/secondsecurityverfication/{userId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView securityFormSecondPage(@PathVariable String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		try{
			String securityQuestionId = "2SQ%";
			MemberProfile profile = profileService.getMemberProfile(userId, securityQuestionId);
			modelAndView.addObject("profile", profile);
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/checkfirstanswer", method = RequestMethod.GET)
	public @ResponseBody ModelAndView secretAnswerVerification(
			@RequestParam(value = "answer", required = true) String answer,
			@RequestParam(value = "secretQuestion", required = false) String secretQuestion,
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "userId", required = true) String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		try{
			boolean response = troubleLoginService.isSecretAnswerExists(answer, secretQuestion, memberId);
			if(response){
				return new ModelAndView("redirect:/unsecure/secondsecurityverfication/"+userId+"");
			}else{
				modelAndView.addObject("errorResponse", MessageUtil.getMessage(ZiksanaConstants.SECRET_ANSWER_WRONG));
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/checksecondanswer", method = RequestMethod.GET)
	public @ResponseBody ModelAndView secretSecondVerification(
			@RequestParam(value = "answer", required = true) String answer,
			@RequestParam(value = "secretQuestion", required = false) String secretQuestion,
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "userId", required = true) String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		try{
			boolean response = troubleLoginService.isSecretAnswerExists(answer, secretQuestion, memberId);
			if(response){
				return new ModelAndView("redirect:/unsecure/password/newpassword/"+userId+"");
			}else{
				modelAndView.addObject("errorResponse", MessageUtil.getMessage(ZiksanaConstants.SECRET_ANSWER_WRONG));
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/forgotuserid", method = RequestMethod.GET)
	public @ResponseBody ModelAndView forgotUserIdPage(){
		ModelAndView modelAndView = new ModelAndView("");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/senduserid", method = RequestMethod.POST)
	public @ResponseBody ModelAndView submitforgotUserIdPage(
		   @RequestParam(value = "emailId", required = true) String emailId){
		ModelAndView modelAndView = new ModelAndView("");
		try{
			Member member = memberService.getMemberByEmailId(emailId);
			String response=null;
			if(member.getPrimaryEmailId() != null){
			 String body="";
	           body+="Hello "+member.getFirstName()+" "+member.getLastName()+",<br/>";
	           body+="Your Ziksana User Id id : "+member.getUserId()+"<br/>";
	           body+= VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mailtemplate/reminder.vm", "UTF-8", null);
	           emailSender.sendEmail(member.getPrimaryEmailId(), "selvan52@gmail.com", "selva Test",body);
	           response="Your User ID has been sent to your Email address";
	           modelAndView.addObject("response", response);
			}
			else{
				response="This Email ID is not in our records";
				modelAndView.addObject("response", response);
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
}
