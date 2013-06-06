/**
 * 
 */
package com.ziksana.controller.security;

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

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberProfile;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.velocitymail.ZiksanaEmailSender;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.ProfileService;
import com.ziksana.service.security.TroubleLoginService;

/**
 * @author vtg-p13
 * This Controller will allow user is not Authenticated.
 *
 */
@Controller
@RequestMapping("/unsecure")
public class TroubleLoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TroubleLoginController.class);
	
	private static final String USERID_VERIFICATION_PAGE = "UserId Verfication Page";
	private static final String SQ1_VERIFICATION_PAGE = "Sec Ques 1 Verfication Page";
	private static final String SQ2_VERIFICATION_PAGE = "Sec Ques 2 Verfication Page";
	private static final String EMAIL_VERIFICATION_PAGE = "Email Verfication Page";
	
	@Autowired
	private TroubleLoginService troubleLoginService;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private MemberService memberService;
	
	//To call Velocity Template
	@Autowired
    private ZiksanaEmailSender emailSender;
	
	
	/*
	 * In Login Page user click TroubleLoggingin link it will redirect user verification page
	*/
	@RequestMapping(value = "/0/userverficationpage", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showUserProfileForm() {
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		try{
			
			modelAndView.addObject("userIdVerfication", USERID_VERIFICATION_PAGE);
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	@RequestMapping(value = "/0/isuseridexists/{userId}", method = RequestMethod.GET)
	public @ResponseBody String isUserIdExists(@PathVariable String userId) {
		String pageResponse = null;
		try{
			
				boolean response = troubleLoginService.isUserIdExists(userId);
				 if(response){
					 pageResponse = "UserId Verification Successful.";
					
				}else{
					pageResponse = "User ID entered is incorrect.";
				}
			
			
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return pageResponse;
		
	}
	@RequestMapping(value = "/0/isprofilecompleted/{username}", method = RequestMethod.GET)
	public @ResponseBody String isProfileCompleted(@PathVariable String username) {
		String pageResponse = null;
		try{
			
			int isUserProfileUpdated = profileService.isProfileCompleted(username);
				 if(isUserProfileUpdated == 1){
					 pageResponse = "SUCCESS";
					
				}else{
					pageResponse = "Setup your basic profile page or Contact <a href='#'>Administrator</a>";
				}
			
			
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return pageResponse;
		
	}
	
	@RequestMapping(value = "/0/isaccountlocked/{username}", method = RequestMethod.GET)
	public @ResponseBody String isAccountLocked(@PathVariable String username) {
		String pageResponse = null;
		try{
			
			int isUserAccountLocked = memberService.isMemberAccountLocked(username);
				 if(isUserAccountLocked == 1){
					 pageResponse = "Your account was already locked ,please contact <a href='#'>Administrator</a>";
					 
					
				}else{
					pageResponse = "SUCCESS";
				}
			
			
		}
		catch(ZiksanaException zexception){
	
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return pageResponse;
		
	}
	
	
	@RequestMapping(value = "/0/firstsecurityverfication/{userId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView securityFormFirstPage(@PathVariable String userId) {
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		try{
			String securityQuestionId = "1SQ%";
			MemberProfile profile = profileService.getMemberProfile(userId, securityQuestionId);
			
			modelAndView.addObject("seqVerfication", SQ1_VERIFICATION_PAGE);
			modelAndView.addObject("profile", profile);
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/0/secondsecurityverfication/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView securityFormSecondPage(@PathVariable String memberId) {
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		try{
			String securityQuestionId = "2SQ%";
			MemberProfile profile = profileService.getMemberProfileByMemberId(Integer.parseInt(memberId), securityQuestionId);
			modelAndView.addObject("seqVerfication", SQ2_VERIFICATION_PAGE);
			modelAndView.addObject("profile", profile);
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/0/checkfirstanswer", method = RequestMethod.POST)
	public @ResponseBody String secretAnswerVerification(
			@RequestParam(value = "answer", required = true) String answer,
			@RequestParam(value = "secretQuestion", required = false) String secretQuestion,
			@RequestParam(value = "memberId", required = true) String memberId) {
		String pageResponse = null;
		try{
			boolean response = troubleLoginService.isSecretAnswerExists(answer, secretQuestion, memberId);
			if(response){
				pageResponse = "SUCCESS";
			}else{
				pageResponse = "FAIL";
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return pageResponse;
	}
	
	@RequestMapping(value = "/0/checksecondanswer", method = RequestMethod.POST)
	public @ResponseBody String secretSecondAnswerVerification(
			@RequestParam(value = "answer", required = true) String answer,
			@RequestParam(value = "secretQuestion", required = false) String secretQuestion,
			@RequestParam(value = "memberId", required = true) String memberId) {
		String pageResponse = null;
		try{
			boolean response = troubleLoginService.isSecretAnswerExists(answer, secretQuestion, memberId);
			if(response){
				pageResponse = "SUCCESS";
			}else{
				pageResponse = "FAIL";
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return pageResponse;
	}
	
	@RequestMapping(value = "/0/forgotuserid", method = RequestMethod.GET)
	public @ResponseBody ModelAndView forgotUserIdPage(){
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		modelAndView.addObject("emailVerfication", EMAIL_VERIFICATION_PAGE);
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/0/senduserid", method = RequestMethod.POST)
	public @ResponseBody String submitforgotUserIdPage(
		   @RequestParam(value = "emailId", required = true) String emailId){
		
		String response=null;
		try{
			boolean isEmailExists = memberService.isPrimaryEmailIdExists(emailId);
			
		
			if(isEmailExists){
				Member member = memberService.getMemberByEmailId(emailId);
				
					emailSender.sendEmailText1(member);
				    
				
				response="Success";	           
			}
			else{
				response="Fail";
				
			}
		}
		catch(ZiksanaException zexception){
			
			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return response;
		
	}
	
}
