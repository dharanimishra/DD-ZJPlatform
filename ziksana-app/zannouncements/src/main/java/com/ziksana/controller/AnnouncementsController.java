/**
 * 
 */
package com.ziksana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.announcements.AnnouncementService;



/**
 * @author vtg-p13
 *
 */
@Controller
@RequestMapping("/secure")
public class AnnouncementsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnouncementsController.class);

	@Autowired
	AnnouncementService announcementService;
	
	/**
	 * Retrive announcement to display 
	 */
	@RequestMapping(value = "/showannouncementbyid/{memberRoleId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAnnouncementById(@PathVariable Integer memberRoleId) {
		logger.info("Entering showMyAlerts(): " + memberRoleId);
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getAnnouncement(memberRoleId));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	/*Get popup Alert window
	 * */	
	@RequestMapping(value = "/showannouncementpopup", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
	
		ModelAndView modelAndView = new ModelAndView("common/zannouncements");
		
		return modelAndView;
		
	}
	
}
