/**
 * 
 */
package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.service.course.MySubscriptionService;

/**
 * @author Ratnesh Kumar
 * 
 */

@Controller
@RequestMapping("/zcourse")
public class MySubscriptionController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MySubscriptionController.class);

	@Autowired
	MySubscriptionService subscriptionService;

	@RequestMapping(value = "1/mysubscription", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView MySubscription() {
		LOGGER.info("Entering Class " + getClass() + " MySubscription()");

		ModelAndView mv = new ModelAndView("mastermylearnercourse");

		LOGGER.info("Exiting Class " + getClass() + " MySubscription(): ");

		return mv;
	}

	@RequestMapping(value = "1/mylearnercourse/{courseId}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView MySubscriptionCourse(@PathVariable Integer courseId) {
		LOGGER.info("Entering Class " + getClass() + " MySubscriptionCourse()");
		ModelAndView modelView = new ModelAndView("mastermycourseconsumption");
		modelView.addObject("courseId", courseId);
		LOGGER.info("Exiting Class " + getClass() + " MySubscriptionCourse(): ");

		return modelView;
	}
	
	@RequestMapping(value = "/1/consumption", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView annotateContent() {
		ModelAndView modelAndView = new ModelAndView("courses/consumption"); 
		return modelAndView;

	}
	

}
