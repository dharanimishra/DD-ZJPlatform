package com.ziksana.controller.alert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.alert.AlertsService;

@Controller
@RequestMapping("/zalert")
public class AlertController {

	private static final Logger logger = LoggerFactory
			.getLogger(AlertController.class);

	@Autowired
	private AlertsService alertsService;

	/**
	 * Retrive all alerts to display on the dashboard
	 */
	@RequestMapping(value = "/getalerts", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showMyAlerts() {

		ModelAndView mv = new ModelAndView("calendar/alerts");

		mv.addObject("alerts", this.alertsService.getAlertList());
		logger.info("Number of alerts is  "
				+ this.alertsService.getAlertList().size());

		return mv;
	}

	@RequestMapping(value = "/getalertsize", method = RequestMethod.GET)
	public @ResponseBody
	int getAlertSize() {

		int alertSize = 0;

		alertSize = alertsService.getAlertList().size();

		return alertSize;
	}

	/**
	 * 
	 * @param alertItemId
	 * @return
	 */
	/**
	 * @param alertItemId
	 * @return
	 */
	@RequestMapping(value = "/deletealert/{alertItemId}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteAlertItem(@PathVariable String alertItemId) {

		// Calling service to delete alert
		logger.info(" ALERT ITEM ID IS " + alertItemId);
		this.alertsService.deleteAlertItem(Integer.valueOf(alertItemId));

		logger.info("Exiting deleteAlertItem(): " + alertItemId);
		return "Deleted Successfully!";
	}

	/*
	 * Get popup Alert window
	 */
	@RequestMapping(value = "/alertpopuppage", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView getPopupWindow() {

		ModelAndView modelAndView = new ModelAndView("common/alert");

		return modelAndView;

	}

	/**
	 * Retrive Three Alert items to display on the dashboard
	 */
	@RequestMapping(value = "/getthreealerts", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showThreeAlerts() {

		ModelAndView modelView = new ModelAndView("calendar/alerts");

		modelView.addObject("alerts", alertsService.getMapperAlerts());

		logger.info("alerts Size is  " + alertsService.getMapperAlerts().size());
		return modelView;
	}
}
