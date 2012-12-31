package com.ziksana.controller.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.sample.Course;
import com.ziksana.domain.sample.CourseAddlInfo;
import com.ziksana.service.sample.SampleService;

@Controller
@RequestMapping(value="/sample")
public class SampleController {
	
	@Autowired
	SampleService sampleService;

	/**
	 * Method that renders a tiles template 
	 */
	@RequestMapping(value="/home")
	public String home() {
		System.out.println("SampleController::home()...");
		return "dashboard";
	}
	
	/**
	 * Method serving ajax request. JSP has hard coded XML schema.
	 */
	@RequestMapping(value="/course/list")
	public String getCoursesAvailableXML(Model model) {
		
		System.out.println("SampleController::getCoursesAvailableXML()...");
		List<Course> courseList = sampleService.getAvailableCourses();
		
		model.addAttribute("courseList", courseList);
		
		return "courses/course-list";
	}

	/**
	 * Method serving ajax request. JSP has hard coded JSON format.
	 */
	@RequestMapping(value="/course/list-json")
	public ModelAndView getCoursesAvailableJSON() {
		
		System.out.println("SampleController::getCoursesAvailableJSON()...");
		List<Course> courseList = sampleService.getAvailableCourses();
		
		ModelAndView modelView = new ModelAndView("courses/course-list-json");
		modelView.addObject("courseList", courseList);
		
		return modelView;
	}
	
	/**
	 * Method serving ajax request. Response is in XML format using JAXB.
	 * Requires use <mvc:annotation-driven/> tab in spring configuration.
	 * Requires JAXB annotations on the Model object. 
	 * 
	 */
	@RequestMapping(value="/course/details-jaxb", method=RequestMethod.GET)
	public @ResponseBody CourseAddlInfo getCourseDetailsJAXB(
			@RequestParam(value="courseId", required=true) String courseId) {
		
		throw new UnsupportedOperationException("Not supported. Model bean requires JAXB annotations.");
	}

	
	/**
	 * Method serving ajax request. Automatic JSON conversion by spring MessageConverter using Jackson library.
	 * Requires use <mvc:annotation-driven/> tab in spring configuration.
	 * JSON serialization fails if Bean has empty properties. Resolution needs annotations on the bean properties. 
	 * 
	 */
	@RequestMapping(value="/course/details-jackson", method=RequestMethod.GET)
	public @ResponseBody CourseAddlInfo getCourseDetailsJackson(
			@RequestParam(value="courseId", required=true) String courseId) {
		
		System.out.println("SampleController::getCourseDetails()...");
		CourseAddlInfo course = sampleService.getCourseDetails(courseId);
		return course;
	}
	
	/**
	 * Method serving ajax request. JSON conversion via json-lib-ext-spring library.
	 * jsonView is a view bean invoked via XmlViewResolver.
	 * 
	 * This library is lenient towards empty bean properties.
	 * 
	 */
	@RequestMapping(value="/course/details-jsonlib", method=RequestMethod.GET)
	public ModelAndView getCourseDetailsJsonlib(
			@RequestParam(value="courseId", required=true) String courseId) {
		
		System.out.println("SampleController::getCourseDetailsJsonlib()...");
		CourseAddlInfo course = sampleService.getCourseDetails(courseId);
		
		ModelAndView modelView = new ModelAndView("jsonView");
		modelView.addObject("course", course);
		return modelView;
	}
}
