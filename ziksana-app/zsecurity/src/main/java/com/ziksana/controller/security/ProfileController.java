/**
 * 
 */
package com.ziksana.controller.security;

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

import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberProfile;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.security.MediaService;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.ProfileService;

/**
 * @author vtg-p13
 *
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MediaService mediaService;
	
	@RequestMapping(value = "/1/profilepage/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showUserProfileForm(@PathVariable int memberId) {
		ModelAndView modelAndView = new ModelAndView("profilepagesetup");
		try{		
			List<MemberProfile> profileList = new ArrayList<MemberProfile>();
			
			profileList = profileService.getMemberProfileList(memberId);
			Member member = memberService.getMemberByMemberId(memberId);
			modelAndView.addObject("applicationTitle", "User Profile Page creation");
			modelAndView.addObject("profileList", profileList);
			
			modelAndView.addObject("member", member);
			modelAndView.addObject("ms", mediaService.getMediaContents());
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	@RequestMapping(value = "/1/profilepagebylang", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showUserProfileFormByLang(
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "language", required = true) String language) {
		ModelAndView modelAndView = new ModelAndView("profilepagesetup");
		try{		
			List<MemberProfile> profileList = new ArrayList<MemberProfile>();
			
			profileList = profileService.getMemberProfileList(Integer.parseInt(memberId));
			Member member = memberService.getMemberByMemberId(Integer.parseInt(memberId));
			modelAndView.addObject("applicationTitle", "User Profile Page creation");
			modelAndView.addObject("profileList", profileList);
			
			modelAndView.addObject("member", member);
			modelAndView.addObject("ms", mediaService.getMediaContents());
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/1/manageprofile/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showManageProfile(@PathVariable int memberId) {
		ModelAndView modelAndView = new ModelAndView("profilepagesetup");
		try{		
			List<MemberProfile> profileList = new ArrayList<MemberProfile>();
			
			profileList = profileService.getMemberProfileList(memberId);
			Member member = memberService.getMemberByMemberId(Integer.valueOf(SecurityTokenUtil.getToken().getMemberPersonaId().getStorageID()));
			modelAndView.addObject("applicationTitle", "User Profile Page Edit");
			modelAndView.addObject("profileList", profileList);
			modelAndView.addObject("passwordUpdated", getFormattedDate(memberService.getPasswordUpdatedOn(memberId)));
			modelAndView.addObject("profileAnswerOne",profileService.getMemberProfileByMemberId(memberId, "1SQ%"));
			modelAndView.addObject("profileAnswerTwo",profileService.getMemberProfileByMemberId(memberId, "2SQ%"));
			modelAndView.addObject("member", member);
			modelAndView.addObject("ms", mediaService.getMediaContents());
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/1/updateprofile", method = RequestMethod.POST)
	public @ResponseBody String updateUserProfile(
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "alternateEmailId", required = false) String alternateEmailId,
			@RequestParam(value = "firstSecurityQuestionId", required = true) String firstSecurityQuestionId,
			@RequestParam(value = "firstSecurityAnswer", required = true) String firstSecurityAnswer,
			@RequestParam(value = "secondSecurityQuestionId", required = true) String secondSecurityQuestionId,
			@RequestParam(value = "secondSecurityAnswer", required = true) String secondSecurityAnswer,
			@RequestParam(value = "profileImage", required = false) String profileImage) {
		
		String responseMsg ="";
	
		try{	
	
			boolean updateResponse = false;
			int response = 0;
			if(firstSecurityAnswer.length()<=0 && secondSecurityAnswer.length() <=0){
				responseMsg = "error";
				return responseMsg;
				
			}else{
				
				MemberProfile profile = new MemberProfile();
				profile.setAlternateEmailId(alternateEmailId);
				profile.setMemberId(Integer.parseInt(memberId));
				profile.setSecurityQuestionId(firstSecurityQuestionId);
				profile.setMemberAnswer(firstSecurityAnswer);
				response = profileService.updateMemberProfile(profile);
				if(response==1){
					profile = new MemberProfile();
					profile.setAlternateEmailId(alternateEmailId);
					profile.setSecurityQuestionId(secondSecurityQuestionId);
					profile.setMemberId(Integer.parseInt(memberId));
					profile.setMemberAnswer(secondSecurityAnswer);
					response = profileService.updateMemberProfile(profile);
					if(response==1){
						updateResponse = true;
						if(profileImage != ""){
							int re = memberService.updateMemberProfileImage(profileImage, Integer.parseInt(memberId));
							LOGGER.info("Image Updated response == >"+re);
						}
						responseMsg = "success";
						
					}
				}
				
			}
			
			
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return responseMsg;
		
	}
	
	@RequestMapping(value = "/1/updateprofileimage", method = RequestMethod.POST)
	public @ResponseBody int updateUserProfileImage(
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "profileImage", required = false) String profileImage){
		
			int response= 0;
			try{
				
				response = memberService.updateMemberProfileImage(profileImage, Integer.parseInt(memberId));
				
			}
			catch(ZiksanaException zexception){
	
				LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
			}
			
		return response;
		
	}
	
	@RequestMapping(value = "/1/editupdateprofile", method = RequestMethod.POST)
	public @ResponseBody int editAndUpdateUserProfile(
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "alternateEmailId", required = false) String alternateEmailId,
			@RequestParam(value = "SecurityQuestionId", required = true) String SecurityQuestionId,
			@RequestParam(value = "SecurityQuestionValue", required = true) String SecurityQuestionValue,
			@RequestParam(value = "SecurityAnswer", required = true) String SecurityAnswer) {
		
		int response = 0;
	
		try{	
				MemberProfile profile = new MemberProfile();
				profile.setAlternateEmailId(alternateEmailId);
				profile.setMemberId(Integer.parseInt(memberId));
				profile.setSecurityQuestionId(SecurityQuestionId);
				profile.setSecurityQuestionText(SecurityQuestionValue);
				profile.setMemberAnswer(SecurityAnswer);
				response = profileService.updateMemberProfile(profile);
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return response;
		
	}
	
	@RequestMapping(value = "/1/updatealternatemail", method = RequestMethod.POST)
	public @ResponseBody int updateProfileAlternateMail(
			@RequestParam(value = "memberId", required = true) String memberId,
			@RequestParam(value = "alternateEmailId", required = true) String alternateEmailId) {
		int response = 0;
		try{		
			
			response = profileService.updateProfileAlternateMail(Integer.parseInt(memberId), alternateEmailId);
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return response;
		
	}
	
	
	private  String getFormattedDate(String value) {
		String month = value.substring(5, 7);
		String monthText = "";
		if(month.equalsIgnoreCase("01")){
			monthText = "January";
		}else if(month.equalsIgnoreCase("02")){
			monthText = "February";
		}else if(month.equalsIgnoreCase("03")){
			monthText = "March";			
		}else if(month.equalsIgnoreCase("04")){
			monthText = "April";
		}else if(month.equalsIgnoreCase("05")){
			monthText = "May";
		}else if(month.equalsIgnoreCase("06")){
			monthText = "June";
		}else if(month.equalsIgnoreCase("07")){
			monthText = "July";
		}else if(month.equalsIgnoreCase("08")){
			monthText = "August";
		}else if(month.equalsIgnoreCase("09")){
			monthText = "September";
		}else if(month.equalsIgnoreCase("10")){
			monthText = "October";
		}else if(month.equalsIgnoreCase("11")){
			monthText = "November";
		}else {
			monthText = "December";
		}
		
		String year = value.substring(0, 4);
		String date = value.substring(8, 11);
				
		return "Last updated "+monthText+" "+date+", "+year+"";
	}

}
