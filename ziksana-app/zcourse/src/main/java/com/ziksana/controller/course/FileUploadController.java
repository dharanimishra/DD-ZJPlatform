package com.ziksana.controller.course;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ratneshkumar
 */
@Controller
@RequestMapping("/zcourse")
public class FileUploadController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUploadController.class);

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public @ResponseBody
	ModelAndView fileUpload(@RequestParam File file) {
		LOGGER.info("Entering Class " + getClass() + " fileUpload()");
		ModelAndView mv = new ModelAndView("courses/createcourses");
		LOGGER.info("Exiting Class " + getClass() + " fileUpload(): ");

		return mv;
	}

}
