/**
 * 
 */
package com.ziksana.controller.course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.security.MediaService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/zcourse")
public class MyCoursesController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyCoursesController.class);

	@Autowired
	CourseService courseService;

	@Autowired
	private MediaService mediaService;

	@RequestMapping(value = "/educatorcourses", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyCourses() throws CourseException {

		LOGGER.debug("Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("courses/course-list-new");

		try {
			List<Course> draftedCourses = courseService
					.getCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
			List<Course> reviewedCourses = courseService
					.getCoursesByStatus(CourseStatus.REVIEW);
			List<Course> activeCourses = courseService
					.getCoursesByStatus(CourseStatus.ACTIVE);

			LOGGER.debug("Exiting Class " + getClass() + " showCourse(): ");

			// TODO we need to add object
			mv.addObject("DRAFTED_COURSES", draftedCourses);
			mv.addObject("REVIEWED_COURSES", reviewedCourses);
			mv.addObject("ACTIVE_COURSES", activeCourses);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mv;
	}

	@RequestMapping(value = "/myprogramsdraft", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyProgramsDraft() {

		LOGGER.debug("Entering Class " + getClass() + " readMyPrograms()");
		ModelAndView mv = null;
		try {
			MemberRoleType roleType = SecurityTokenUtil.getToken().getRole();

			if (roleType == MemberRoleType.EDUCATOR) {
				List<Course> courses = courseService
						.getAllCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
				Integer courseCount = courseService
						.totalNumberOfCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
				mv = new ModelAndView("draftedcourses");
				mv.addObject("courses", courses);
				mv.addObject("courseCount", courseCount);
				mv.addObject("ms", mediaService.getMediaContents());
			} else {

				mv = new ModelAndView("learnerdraftedcourses");

				List<LearningProgram> programs = courseService
						.getLearningPrograms();
				LOGGER.debug("Learner Program Size==>" + programs.size());
				LearningProgram program = null;
				List<Course> courses = null;

				if (programs.size() >= 1) {

					program = programs.get(0);

					courses = courseService.getCoursesByLearningProgram(Integer
							.valueOf(program.getLearningProgramId()
									.getStorageID()));

					mv.addObject("program", program.getName());

					mv.addObject("courses", courses);
					mv.addObject("ms", mediaService.getMediaContents());
				}
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mv;

	}

	@RequestMapping(value = "/learnercourses", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readLearnerMyPrograms() throws CourseException {
		ModelAndView mvLearner = new ModelAndView("courses/learner-courses");
		try {
			List<LearningProgram> programs = courseService
					.getLearningPrograms();

			LearningProgram program = programs.get(0);
			List<Course> courses = courseService
					.getThreeCoursesByLearningProgram(Integer.valueOf(program
							.getLearningProgramId().getStorageID()));

			LOGGER.debug(" TOTAL NUMBER OF COURSES IS  " + courses.size());
			LOGGER.debug(" THE COURSE NAME IS   " + courses.get(0).getName());

			mvLearner.addObject("program", program.getName());
			mvLearner.addObject("ms", mediaService.getMediaContents());
			mvLearner.addObject("courses", courses);
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mvLearner;

	}

	@RequestMapping(value = "/myprograms", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyPrograms() throws CourseException {

		LOGGER.debug("Entering Class " + getClass() + " readMyPrograms()");

		ModelAndView mv = null;
		try {
			MemberRoleType roleType = SecurityTokenUtil.getToken().getRole();
			if (roleType == MemberRoleType.EDUCATOR) {
				List<Course> courses = courseService
						.getAllCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
				Integer courseCount = courseService
						.totalNumberOfCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
				mv = new ModelAndView("mycoursesdraft");
				mv.addObject("courses", courses);
				mv.addObject("courseCount", courseCount);
				mv.addObject("ms", mediaService.getMediaContents());
			} else {

				List<LearningProgram> programs = courseService
						.getLearningPrograms();
				LearningProgram program = programs.get(0);
				List<Course> courses = courseService
						.getCoursesByLearningProgram(Integer.valueOf(program
								.getLearningProgramId().getStorageID()));

				LOGGER.debug(" TOTAL NUMBER OF COURSES IS  " + courses.size());
				int learnerCourseSize = courses.size();
				LOGGER.debug(" THE COURSE NAME IS   "
						+ courses.get(0).getName());
				mv = new ModelAndView("learnerdraftedcourses");
				mv.addObject("program", program.getName());
				mv.addObject("courses", courses);
				mv.addObject("learnerCourseSize", learnerCourseSize);
				// TODO need to implement learner my programs...
			}
		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return mv;
	}

}
