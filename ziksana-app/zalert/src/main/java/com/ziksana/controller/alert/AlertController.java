package com.ziksana.controller.alert;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.alerts.Alert;
import com.ziksana.service.alert.AlertsService;

@Controller
@RequestMapping("/secure")
public class AlertController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AlertController.class);

	@Autowired
	AlertsService alertsService;

	/**
	 * Retrive all alerts to display on the dashboard
	 */
	@RequestMapping(value = "/showmyalert/{memberId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showMyAlerts(@PathVariable String memberId) {
		LOGGER.info("Entering showMyAlerts(): " + memberId);
		ModelAndView mv = new ModelAndView("calendar/alerts");
		
		mv.addObject("alerts", this.alertsService.getAlertList());
		LOGGER.info("Number of alerts is  " + this.alertsService.getAlertList().size());
		LOGGER.info("Exiting showMyAlerts(): " + memberId);
		return mv;
	}
	@RequestMapping(value = "/getalertsize/{memberId}", method = RequestMethod.GET)
	public @ResponseBody int getAlertSize(@PathVariable String memberId) {
		LOGGER.info("Entering showMyAlerts(): " + memberId);
		int alertSize = 0;
		List<Alert> alertList = new ArrayList<Alert>();
		alertSize = alertsService.getAlertList().size();
				
		return alertSize;
	}

	/**
	 * 
	 * @param memberId
	 * @param alertItemId
	 * @return
	 */
	@RequestMapping(value = "/deletealert/{memberId}/{alertItemId}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteAlertItem(@PathVariable String memberId,
			@PathVariable String alertItemId) {
		LOGGER.info("Entering deleteAlertItem(): " + memberId + " "
				+ alertItemId);
		//ModelAndView modelAndView = new ModelAndView();
		
		//Calling service to delete alert 
		LOGGER.info(" ALERT ITEM ID IS "+alertItemId);
		this.alertsService.deleteAlertItem(Integer.valueOf(alertItemId));
		
		LOGGER.info("Exiting deleteAlertItem(): " + memberId + " "
				+ alertItemId);
		return "Deleted Successfully!";
	}
	
	
	/*Get popup Alert window
	 * */	
	@RequestMapping(value = "/getalertpopupwindow", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getPopupWindow() {
	
		ModelAndView modelAndView = new ModelAndView("common/alert");
		
		return modelAndView;
		
	}

	
	/**
	 * Retrive Three Alert items to display on the dashboard
	 */
	@RequestMapping(value = "/showalert/{memberId}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView showThreeAlerts(@PathVariable String memberId) {
		LOGGER.info("Entering showAlerts: " + memberId);
		ModelAndView modelView = new ModelAndView("calendar/alerts");
		
		
		modelView.addObject("alerts", alertsService.getMapperAlerts());
		LOGGER.info("Exiting showMyAlerts(): " + memberId);
		LOGGER.info("alerts Size is  " + alertsService.getMapperAlerts().size());
		return modelView;
	}
}
