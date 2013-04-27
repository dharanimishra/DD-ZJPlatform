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
	
	@RequestMapping(value = "/profilepage/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showUserProfileForm(@PathVariable int memberId) {
		ModelAndView modelAndView = new ModelAndView("profilepagesetup");
		try{		
			List<MemberProfile> profileList = new ArrayList<MemberProfile>();
			
			profileList = profileService.getMemberProfileList(memberId);
			Member member = memberService.getMemberByMemberId(memberId);
			modelAndView.addObject("applicationTitle", "User Profile Page");
			modelAndView.addObject("profileList", profileList);
			modelAndView.addObject("member", member);
			modelAndView.addObject("ms", mediaService.getMediaContents());
		}
		catch(ZiksanaException zexception){

			LOGGER.error("Caught Exception. class ="+ zexception.getClass().getName() + ",message ="+ zexception.getMessage());
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
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

}
