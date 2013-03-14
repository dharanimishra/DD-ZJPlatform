package com.ziksana.controller.announcements;

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

import com.ziksana.domain.announcements.Announcement;
import com.ziksana.service.announcements.AnnouncementService;

/**
 * @author vtg-p13
 * 
 */
@Controller
@RequestMapping("/zannouncements")
public class AnnouncementsController {

	private static final Logger logger = LoggerFactory
			.getLogger(AnnouncementsController.class);

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
		announcementList = announcementService.getAllAnnouncement();
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements", announcementService.getAllAnnouncement());

		return mav;
	}

	@RequestMapping(value = "/announcementpopuppage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncementByAnnouncementId(
			@RequestParam(value = "anouncementId", required = true) int anouncementId) {

		ModelAndView mav = new ModelAndView("common/announcementsinglepage");

		mav.addObject("announcement",
				announcementService.getAnnouncementById(anouncementId));

		logger.info("announcement ID: " + anouncementId);
		return mav;
	}

	/**
	 * Retrive announcement to display
	 */
	@RequestMapping(value = "/getannouncements", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getAnnouncementById() {

		ModelAndView mav = new ModelAndView("xml/announcements");

		List<Announcement> announcementList = new ArrayList<Announcement>();
		announcementList = announcementService.getAnnouncement();
		int announcementSize = announcementList.size();
		mav.addObject("announcements", announcementService.getAnnouncement());
		mav.addObject("announcementSize", announcementSize);

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

		mav.addObject("announcements",
				announcementService.getAnnouncementById(announcementId));

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
		announcementList = announcementService.getAllAnnouncementsByDate(
				startDate, endDate);
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements", announcementService
				.getAllAnnouncementsByDate(startDate, endDate));

		return mav;
	}

	@RequestMapping(value = "/getinstitutionannouncements", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getInstitutionAnnouncements(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView mav = new ModelAndView("xml/announcements");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		announcementList = announcementService.getInstitutionAnnouncements(
				startDate, endDate);
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements", announcementService
				.getInstitutionAnnouncements(startDate, endDate));

		return mav;
	}

	@RequestMapping(value = "/getinstitutionunitannouncements", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getInstitutionunitAnnouncements(

	@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView mav = new ModelAndView("xml/announcements");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		announcementList = announcementService.getInstitutionUnitAnnouncements(
				startDate, endDate);
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements", announcementService
				.getInstitutionUnitAnnouncements(startDate, endDate));

		return mav;
	}

	@RequestMapping(value = "/getcourseannouncements", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView getCourseAnnouncements(

	@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) {

		ModelAndView mav = new ModelAndView("xml/announcements");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		announcementList = announcementService.getCourseAnnouncements(
				startDate, endDate);
		int announcementSize = announcementList.size();
		mav.addObject("announcementSize", announcementSize);
		mav.addObject("announcements",
				announcementService.getCourseAnnouncements(startDate, endDate));

		return mav;
	}

}
