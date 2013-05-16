/**
 * 
 */
package com.ziksana.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.PasswordService;

/**
 * @author vtg-p13
 *
 */
@Controller
public class ChangePasswordController {
	
	private static final String RESETPASSWORD = "Reset Password Verification";
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/unsecure/0/password/newpassword/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView passwordCreationPage(@PathVariable String memberId){
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		modelAndView.addObject("resetPassword", RESETPASSWORD);
		modelAndView.addObject("memberId", memberId);
		return modelAndView;
	}
	
	@RequestMapping(value = "/unsecure/0/password/changepassword", method = RequestMethod.POST)
	public @ResponseBody String changePassword(
			@RequestParam(value = "newPassword", required = true) String newPassword,
			@RequestParam(value = "confirmPassword", required = true) String confirmPassword,
			@RequestParam(value = "memberId", required = true) String memberId) {
		
		String responseMessage = null ;
	
			String userId = passwordService.getUserIdByMember(Integer.parseInt(memberId));
			/*String password = passwordService.getUserPassword(userId);
			if(userId != "" && password !=""){
			response = passwordService.replaceExistingPassword(newPassword,userId,password);
			}*/
			String response = "success";
			if(response == "success"){
				passwordService.updateSecMemberCredentional(newPassword,userId);
				responseMessage = "Password reset is successful";
				 
				
			}else{
				responseMessage = "Password reset is not successful, <br/> Password Already used Choose Different Password.";
			}
			
			
			
		return responseMessage;
	}
	@RequestMapping(value = "/secure/password/resetpassword", method = RequestMethod.POST)
	public @ResponseBody String resetPassword(
			@RequestParam(value = "oldPassword", required = true) String oldPassword,
			@RequestParam(value = "confirmPassword", required = true) String confirmPassword,
			@RequestParam(value = "memberId", required = true) String memberId) {
		
		String responseMessage = null ;

			String userId = passwordService.getUserIdByMember(Integer.parseInt(memberId));
			/*String password = passwordService.getUserPassword(userId);

			if(userId != "" && password !=""){
			response = passwordService.replaceExistingPassword(newPassword,userId,password);
			}*/
			if(memberService.isPasswordExists(oldPassword)){
				int i = 0;
				i = passwordService.updateSecMemberCredentional(confirmPassword,userId);
				if(i == 1){
					//responseMessage = "Password reset is successful";	
					responseMessage = getFormattedDate(memberService.getPasswordUpdatedOn(Integer.parseInt(memberId)));
				}else{
					responseMessage = "Password reset is not successful.";
				}
			}else{
				responseMessage = "Old Password is incorrect";
			}
			
		
		return responseMessage;
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
