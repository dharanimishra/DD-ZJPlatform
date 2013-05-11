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

import com.ziksana.service.security.PasswordService;

/**
 * @author vtg-p13
 *
 */
@Controller
@RequestMapping("/unsecure")
public class ChangePasswordController {
	
	private static final String RESETPASSWORD = "Reset Password Verification";
	
	@Autowired
	private PasswordService passwordService;
	
	@RequestMapping(value = "/password/newpassword/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView passwordCreationPage(@PathVariable String memberId){
		ModelAndView modelAndView = new ModelAndView("masterresetpassword");
		modelAndView.addObject("resetPassword", RESETPASSWORD);
		modelAndView.addObject("memberId", memberId);
		return modelAndView;
	}
	
	@RequestMapping(value = "/password/changepassword", method = RequestMethod.POST)
	public @ResponseBody String secretSecondVerification(
			@RequestParam(value = "newPassword", required = true) String newPassword,
			@RequestParam(value = "confirmPassword", required = true) String confirmPassword,
			@RequestParam(value = "memberId", required = true) String memberId) {
		
		String responseMessage = null ;
		String response = null;
			String userId = passwordService.getUserIdByMember(Integer.parseInt(memberId));
			/*String password = passwordService.getUserPassword(userId);

			if(userId != "" && password !=""){
			response = passwordService.replaceExistingPassword(newPassword,userId,password);
			}*/
			response = "success";
			if(response == "success"){
				passwordService.updateSecMemberCredentional(newPassword,userId);
				responseMessage = "Password reset is successful";
				 
				
			}else{
				responseMessage = "Password reset is not successful, <br/> Password Already used Choose Different Password.";
			}
		
		return responseMessage;
	}
}
