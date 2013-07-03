package com.ziksana.controller.announcements;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.announcements.AnnouncementService;

/**
 * @author vtg-p13
 * 
 */
@Controller
@RequestMapping("/zannouncements/1/")
public class AnnouncementsController {

	private static final Logger logger = LoggerFactory
			.getLogger(AnnouncementsController.class);
	

	@Value("#{pagination['itemsperpage']}")
	private String itemsPerPage;

	@Autowired
	private AnnouncementService announcementService;

	/**
	 * Retrive announcement to display
	 */
	@RequestMapping(value = "/getallannouncements", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncement() {

		ModelAndView mav = new ModelAndView("xml/announcements");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
			announcementList = announcementService.getAllAnnouncement();
			int announcementSize = announcementList.size();
			mav.addObject("announcementSize", announcementSize);
			mav.addObject("announcements", announcementList);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}

	@RequestMapping(value = "/announcementpopuppage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncementByAnnouncementId(
			@RequestParam(value = "anouncementId", required = true) int anouncementId) {

		ModelAndView mav = new ModelAndView("common/announcementsinglepage");

		try {
			mav.addObject("announcement", announcementService.getAnnouncementById(anouncementId));
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}

		logger.info("announcement ID: " + anouncementId);
		return mav;
	}

	/**
	 * Retrive announcement to display get all announcements
	 */
	@RequestMapping(value = "/getannouncements/{startIndex}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncementById(@PathVariable Integer startIndex) {

		ModelAndView mav = new ModelAndView("xml/announcements");

		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
		announcementList = announcementService.getAnnouncement(startIndex, Integer.parseInt(itemsPerPage));
				
		int announcementSize = announcementService.getAllAnnouncementsSize();
		mav.addObject("announcements", announcementList);
		mav.addObject("announcementSize", announcementSize);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}

	
	/**
	 * Retrive announcement to display University Announcements
	 */
	@RequestMapping(value = "/getuniversityannouncements/{startIndex}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getgetuniversityannouncements(@PathVariable Integer startIndex) {

		ModelAndView mav = new ModelAndView("xml/announcements");

		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
		announcementList = announcementService.getInstitutionAnnouncements(startIndex, Integer.parseInt(itemsPerPage));
				
		int announcementSize = announcementService.getUniversityAnnouncementsSize();
		mav.addObject("announcements", announcementList);
		mav.addObject("announcementSize", announcementSize);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}
	
	/**
	 * Retrive announcement to display University Announcements
	 */
	@RequestMapping(value = "/getdeptannouncements/{startIndex}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getdepartmentannouncements(@PathVariable Integer startIndex) {

		ModelAndView mav = new ModelAndView("xml/announcements");

		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
		announcementList = announcementService.getdepartmentAnnouncements(startIndex, Integer.parseInt(itemsPerPage));
		
				
		int announcementSize = announcementService.getDepartmentAnnouncementsSize();
		mav.addObject("announcements", announcementList);
		mav.addObject("announcementSize", announcementSize);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}
	
	/**
	 * Retrive announcement to display University Announcements
	 */
	@RequestMapping(value = "/getcourseannouncements/{startIndex}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getcourseannouncements(@PathVariable Integer startIndex) {

		ModelAndView mav = new ModelAndView("xml/announcements");

		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
		announcementList = announcementService.getCourseAnnouncements(startIndex, Integer.parseInt(itemsPerPage));
				
		int announcementSize = announcementService.getCourseAnnouncementsSize();
		mav.addObject("announcements", announcementList);
		mav.addObject("announcementSize", announcementSize);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}
	
	
	/**
	 * Retrive announcement to display
	 */
	@RequestMapping(value = "/showannouncementbyid/{announcementId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncementByAnnouncementId(
			@PathVariable Integer announcementId) {

		ModelAndView mav = new ModelAndView("xml/announcement");

		try {
			mav.addObject("announcements",
					announcementService.getAnnouncementById(announcementId));
		} catch (ZiksanaException exception) {
			logger.error(exception.getMessage(), exception);
		}

		return mav;
	}

	/*
	 * Get popup Alert window
	 */
	@RequestMapping(value = "/showannouncementpopup", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPopupWindow() {

		ModelAndView modelAndView = new ModelAndView("common/zannouncements");

		return modelAndView;

	}

	@RequestMapping(value = "/getannouncementsallbydate", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getAnnouncementsAllByDate(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView mav = new ModelAndView("xml/announcements");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		try{
		announcementList = announcementService.getAllAnnouncementsByDate(startDate, endDate);
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements",announcementList);
		}
		catch(ZiksanaException ze){
			mav.addObject("errorResponse", ze.getMessage());
			logger.error(ze.getMessage(), ze);
		}
		return mav;
	}

}
