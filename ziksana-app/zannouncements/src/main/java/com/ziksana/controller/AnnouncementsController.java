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
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/showannouncementsAll/{memberRoleId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAnnouncement(@PathVariable Integer memberRoleId) {
		
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getAllAnnouncement(memberRoleId));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	@RequestMapping(value = "/showannouncementsinglepopup", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAnnouncementByAnnouncementId(@RequestParam(value = "memberRoleId", required = true) int memberRoleId,
			@RequestParam(value = "anouncementId", required = true) int anouncementId) {
		
		ModelAndView mav = new ModelAndView("common/announcementsinglepage");
		
		mav.addObject("announcement", announcementService.getAnnouncementById(memberRoleId, anouncementId));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	
	/**
	 * Retrive announcement to display 
	 */
	@RequestMapping(value = "/getannouncement/{memberRoleId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAnnouncementById(@PathVariable Integer memberRoleId) {
		
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getAnnouncement(memberRoleId));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	/**
	 * Retrive announcement to display 
	 */
	@RequestMapping(value = "/showannouncementbyid/{memberRoleId}/{announcementId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getAnnouncementByAnnouncementId(@PathVariable Integer memberRoleId, @PathVariable Integer announcementId) {
		
		ModelAndView mav = new ModelAndView("xml/announcement");
		
		mav.addObject("announcements", announcementService.getAnnouncementById(memberRoleId, announcementId));
		
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
	
	@RequestMapping(value = "/getinstitutionannouncements", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getInstitutionAnnouncements(
			@RequestParam(value = "memberRoleId", required = true) int memberRoleId,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate){
		
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getInstitutionAnnouncements(memberRoleId, startDate, endDate));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	@RequestMapping(value = "/getinstitutionunitannouncements", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getInstitutionunitAnnouncements(
			@RequestParam(value = "memberRoleId", required = true) int memberRoleId,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {
		
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getInstitutionUnitAnnouncements(memberRoleId, startDate, endDate));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	@RequestMapping(value = "/getcourseannouncements", method = RequestMethod.POST)
	public @ResponseBody ModelAndView getCourseAnnouncements(
			@RequestParam(value = "memberRoleId", required = true) int memberRoleId,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {
		
		ModelAndView mav = new ModelAndView("xml/announcements");
		
		mav.addObject("announcements", announcementService.getCourseAnnouncements(memberRoleId, startDate, endDate));
		
		logger.info("announcement ID: " + memberRoleId);
		return mav;
	}
	
	
}
