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
	
	@Autowired
	private PasswordService passwordService;
	
	@RequestMapping(value = "/password/newpassword/{userId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView passwordCreationPage(@PathVariable String userId){
		ModelAndView modelAndView = new ModelAndView("passwordcreationpage");
		modelAndView.addObject("userId", userId);
		return modelAndView;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public @ResponseBody ModelAndView secretSecondVerification(
			@RequestParam(value = "newPassword", required = true) String newPassword,
			@RequestParam(value = "confirmPassword", required = true) String confirmPassword,
			@RequestParam(value = "userId", required = true) String userId) {
		ModelAndView modelAndView = new ModelAndView("");
		String responseMessage ;
		if(newPassword.equalsIgnoreCase(confirmPassword)){
			String response = passwordService.replaceExistingPassword(newPassword,userId);
			if(response == "success"){
				passwordService.updateSecMemberCredentional(newPassword,userId);
			}
		}else{
			responseMessage = "newPassword and confirmPassword is not match";
			modelAndView.addObject("responseMessage", responseMessage);
		}
		return modelAndView;
	}
}
