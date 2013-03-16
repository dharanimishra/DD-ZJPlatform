package com.ziksana.controller.course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziksana.domain.course.CourseSubjectClassification;
import com.ziksana.domain.course.Option;
import com.ziksana.service.course.CourseSubjectDetailService;

@Controller
@RequestMapping("/zcourse")
public class CourseSubjectController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseSubjectController.class);

	@Autowired
	CourseSubjectDetailService courseSubjectDetailService;

	@RequestMapping(value = "/getsubjectarea", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	List<Option> getSubjectArea(
			@RequestParam(value = "subjectArea", required = false) String subject) {
		LOGGER.info("Entering Class " + getClass() + " getSubjectArea()");

		List<Option> list = courseSubjectDetailService.getSubjectCategory();

		LOGGER.info("Exiting Class " + getClass() + " getSubjectArea(): ");

		return list;
	}

	@RequestMapping(value = "/getsubject", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	List<Option> getSubject(
			@RequestParam(value = "Course_Area", required = false) String subject) {
		LOGGER.info("Entering Class " + getClass() + " getSubject()");
		List<Option> list = courseSubjectDetailService.getSubjectArea(subject);
		LOGGER.info("Exiting Class " + getClass() + " getSubjectArea(): ");

		return list;
	}

	@RequestMapping(value = "/gettopic", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	List<Option> getTopic(
			@RequestParam(value = "Course_Subject", required = false) String subject) {
		LOGGER.info("Entering Class " + getClass() + " getTopic()");
		List<Option> list = courseSubjectDetailService.getSubjectTopic(subject);
		LOGGER.info("Exiting Class " + getClass() + " getTopic(): ");

		return list;
	}

	@RequestMapping(value = "/getsubjectclassification", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseSubjectClassification getSubjectClassification(
			@RequestParam(value = "Course_Area", required = false) String subjectArea,
			@RequestParam(value = "Course_Subject", required = false) String subjectCategory,
			@RequestParam(value = "Course_Topic", required = false) String subjectTopic) {
		LOGGER.info("Entering Class " + getClass() + " getTopic()");
		CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
				.getSubjectClassification(subjectTopic);
		LOGGER.info("Exiting Class " + getClass() + " getTopic(): ");

		return courseSubjectClassification;
	}

	@RequestMapping(value = "/getsubclassification", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	CourseSubjectClassification getSubClassification(
			@RequestParam(value = "CourseId", required = false) String CourseId) {

		Integer course_id = 0;
		LOGGER.info("Entering Class " + getClass()
				+ " getSubClassification():course_id:" + course_id);
		try {
			course_id = Integer.parseInt(CourseId.split("_")[1]);
		} catch (NumberFormatException nfe) {
			LOGGER.error("Entering getSubClassification(): NumberFormatException nfe: "
					+ nfe);
		}

		CourseSubjectClassification courseSubjectClassification = courseSubjectDetailService
				.getCourseClassification(course_id);
		LOGGER.info("Exiting Class " + getClass()
				+ " getSubClassification(): course_id:" + course_id);

		return courseSubjectClassification;
	}
}
