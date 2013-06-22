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

import com.ziksana.domain.member.Member;
import com.ziksana.security.velocitymail.ZiksanaEmailSender;
import com.ziksana.service.security.MemberService;
import com.ziksana.service.security.PasswordService;

/**
 * @author vtg-p13
 *
 */
@Controller
public class ChangePasswordController {
	
	private static final String RESETPASSWORD = "Reset Password Verification";
	
	private static final String RESETPASSWORD_SUCCESS = "Password Reset Successful Page";
	
	
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private MemberService memberService;
	
	//To call Velocity Template
	@Autowired
    private ZiksanaEmailSender emailSender;
	
	@RequestMapping(value = "/unsecure/0/password/newpassword/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView passwordCreationPage(@PathVariable String memberId){
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		String userId = memberId;
		String password = passwordService.getUserPassword(userId);
		modelAndView.addObject("resetPassword", RESETPASSWORD);
		modelAndView.addObject("memberId", memberId);
		modelAndView.addObject("currentPassword",password);
		return modelAndView;
	}
	
	@RequestMapping(value = "/unsecure/0/passwordresetsuccess", method = RequestMethod.GET)
	public @ResponseBody ModelAndView passwordCreationSuccess(){
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
	
		modelAndView.addObject("resetPasswordSuccess", RESETPASSWORD_SUCCESS);
		
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/unsecure/0/password/changepassword", method = RequestMethod.POST)
	public @ResponseBody String changePassword(
			@RequestParam(value = "newPassword", required = true) String newPassword,
			@RequestParam(value = "confirmPassword", required = true) String confirmPassword,
			@RequestParam(value = "memberId", required = true) String memberId) {
		
			String responseMessage = null ;
			
			int updateResponse = 0;
			
			String userId = passwordService.getUserIdByMember(Integer.parseInt(memberId));
			Member member = memberService.getMemberByMemberId(Integer.parseInt(memberId));
			/*if(userId != "" && password !=""){
			response = passwordService.replaceExistingPassword(newPassword,userId,password);
			}*/
			String response = "success";
			if(response == "success"){
				
				updateResponse = passwordService.updateSecMemberCredentional(newPassword,userId);
				if(updateResponse == 1){
					
					String subject = "Ziksana Account password changed";
					StringBuffer body = new StringBuffer();
					body.append("<html><body>");
					body.append("Dear <b>"+member.getFirstName()+" "+member.getLastName()+",</b>");
					body.append("<br/><br/>");
					body.append("<div>");
					body.append("The password for your Ziksana Account - <b>"+member.getUserId()+".</b> - was recently changed.");
					body.append("</div>");
					body.append("<br/><br/>");
					body.append("Regards,<br/>");
					body.append("Ziksana Team");
					body.append("</body></html>");
					emailSender.sendEmailText(member.getPrimaryEmailId(), subject, body.toString());
					responseMessage = "Password reset is successful";
				}
				
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
			Member member = memberService.getMemberByMemberId(Integer.parseInt(memberId));
			if(memberService.isPasswordExists(oldPassword)){
				int i = 0;
				i = passwordService.updateSecMemberCredentional(confirmPassword,userId);
				if(i == 1){
					//responseMessage = "Password reset is successful";	
					responseMessage = getFormattedDate(memberService.getPasswordUpdatedOn(Integer.parseInt(memberId)));
					
					String subject = "Ziksana Account password changed";
					StringBuffer body = new StringBuffer();
					body.append("<html><body>");
					body.append("Dear <b>"+member.getFirstName()+" "+member.getLastName()+",</b>");
					body.append("<br/><br/>");
					body.append("<div>");
					body.append("The password for your Ziksana Account - <b>"+member.getUserId()+".</b> - was recently changed.");
					body.append("</div>");
					body.append("<br/><br/>");
					body.append("Regards,<br/>");
					body.append("Ziksana Team");
					body.append("</body></html>");
					emailSender.sendEmailText(member.getPrimaryEmailId(), subject, body.toString());
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
