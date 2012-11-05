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

import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.alert.AlertsService;

@Controller
@RequestMapping("/secure")
public class AlertController {

	private static final Logger logger = LoggerFactory
			.getLogger(AlertController.class);

	@Autowired
	AlertsService alertsService;

	/**
	 * Retrive all alerts to display on the dashboard
	 */
	@RequestMapping(value = "/showmyalert/{memberId}", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView showMyAlerts(@PathVariable String memberId) {
		logger.info("Entering showMyAlerts(): " + memberId);
		ModelAndView mv = new ModelAndView("calendar/alerts");
		ZID member = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(member, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

		mv.addObject("alerts", this.alertsService.getAlertList());
		logger.info("Number of alerts is  " + this.alertsService.getAlertList().size());
		logger.info("Exiting showMyAlerts(): " + memberId);
		return mv;
	}

	/**
	 * 
	 * @param memberId
	 * @param alertItemId
	 * @return
	 */
	@RequestMapping(value = "/deletealert/{memberId}/{alertItemId}", method = RequestMethod.DELETE)
	public @ResponseBody
	ModelAndView deleteAlertItem(@PathVariable String memberId,
			@PathVariable String alertItemId) {
		logger.info("Entering deleteAlertItem(): " + memberId + " "
				+ alertItemId);
		ModelAndView mv = new ModelAndView();
		
		//Calling service to delete alert 
		logger.info(" ALERT ITEM ID IS "+alertItemId);
		this.alertsService.deleteAlertItem(Integer.valueOf(alertItemId));
		
		logger.info("Exiting deleteAlertItem(): " + memberId + " "
				+ alertItemId);
		return mv;
	}

}
