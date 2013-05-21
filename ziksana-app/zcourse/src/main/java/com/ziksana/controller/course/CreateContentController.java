/**
 * 
 */
package com.ziksana.controller.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.service.course.CourseContentService;
import com.ziksana.service.security.MediaService;

/**
 * @author Ratnesh Kumar
 * 
 */

@Controller
@RequestMapping("/zcourse")
public class CreateContentController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreateContentController.class);

	@Autowired
	CourseContentService courseContentService;

	@Autowired
	MediaService mediaService;

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "0/createcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView createContent() {
		LOGGER.debug(" Entering Class " + getClass() + " createContent()");
		ModelAndView mv = new ModelAndView("mastercreatecontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "CreateContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting createContent(): ");
		return mv;
	}

	@RequestMapping(value = "0/editcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView editContent() {
		LOGGER.debug(" Entering Class " + getClass() + " editContent()");
		ModelAndView mv = new ModelAndView("mastereditcontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "EditContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting editContent(): ");
		return mv;
	}

	@RequestMapping(value = "0/weblinkcontent", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	ModelAndView webLinkContent() {
		LOGGER.debug(" Entering Class " + getClass() + " webLinkContent()");
		ModelAndView mv = new ModelAndView("masterweblinkcontent");
		try {
			mediaServerURL = mediaService.getMediaContents();
			mv.addObject("ms", mediaServerURL);
			mv.addObject("pageTitle", "WeblinkContent");
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting webLinkContent(): ");
		return mv;
	}
}
