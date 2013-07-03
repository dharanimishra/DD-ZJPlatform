package com.ziksana.controller.alert;

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

import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.alerts.Alert;
import com.ziksana.exception.ZiksanaException;
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
		try {
			mv.addObject("alerts", this.alertsService.getAlertList());
		} catch (ZiksanaException ziksanaException) {
			logger.error(ziksanaException.getMessage(), ziksanaException);
			mv.addObject("errorResponse", ziksanaException.getMessage());
		}
		return mv;
	}

	@RequestMapping(value = "/getalertsize", method = RequestMethod.GET)
	public @ResponseBody
	int getAlertSize() {

		Integer alertSize = 0;

		try {
			
			List<Alert> alertList = alertsService.getAlertList();
			if(alertList != null){
				alertSize = alertList.size();
			}
		} catch (ZiksanaException ae) {
			logger.error("Alert Error " + ae.getMessage(), ae);

		}

		return alertSize;
	}

	/**
	 * @param alertItemId
	 * @return
	 */
	@RequestMapping(value = "/deletealert/{alertItemId}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteAlertItem(@PathVariable String alertItemId) {
		String errorResponse = null;

		try {
			this.alertsService.deleteAlertItem(Integer.valueOf(alertItemId));
			errorResponse = ZiksanaConstants.ALERT_DELETION_SUCCESS;

		} catch (ZiksanaException ae) {
			errorResponse = ae.getMessage();
			logger.error(ae.getMessage(), ae);
		}

		return errorResponse;
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
		try {
			modelView.addObject("alerts", alertsService.getMapperAlerts());
		} catch (ZiksanaException ae) {
			modelView.addObject("errorResponse", ae.getMessage());
			logger.error(ae.getMessage(), ae);
		}
		return modelView;
	}
}
