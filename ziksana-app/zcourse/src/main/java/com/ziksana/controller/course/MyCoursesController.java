/**
 * 
 */
package com.ziksana.controller.course;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziksana.domain.common.MediaServerURL;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.json.JSONCourse;

import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.exception.ZiksanaException;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.security.MediaService;
import com.ziksana.util.JSONUtil;

/**
 * @author Ratnesh Kumar
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

	MediaServerURL mediaServerURL = new MediaServerURL();

	@RequestMapping(value = "1/mycourse", method = { RequestMethod.GET })
	public @ResponseBody
	ModelAndView myCourse() {
		LOGGER.debug(" Entering Class " + getClass() + " myCourse()");
		ModelAndView modelView = new ModelAndView("mastermycourse");
		try {
			mediaServerURL = mediaService.getMediaContents();
			modelView.addObject("ms", mediaServerURL);
			modelView.addObject("pageTitle", "My Course");

			Integer memberId = Integer.valueOf(SecurityTokenUtil.getToken()
					.getMemberPersonaId().getStorageID());
			List<Course> courses = courseService.getListOfCourses(memberId);

			List<JSONCourse> jsonCourseList = getJSONCourseObjects(courses);
			String jsonString = JSONUtil.objectToJSONString(jsonCourseList);

			modelView.addObject("courseAsJSONString", jsonString);

		} catch (ZiksanaException exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		LOGGER.debug("Class " + getClass() + "Exiting myCourse(): ");
		return modelView;
	}

	@RequestMapping(value = "1/educatorcourses", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyCourses() throws CourseException {

		LOGGER.debug("Entering Class " + getClass() + " showCourse()");
		ModelAndView mv = new ModelAndView("courses/course-list-new");

		try {
			List<Course> draftedCourses = courseService
					.getCoursesByStatus(CourseStatus.DRAFT);
			List<Course> reviewedCourses = courseService
					.getCoursesByStatus(CourseStatus.READY_FOR_RELEASE);
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

	@RequestMapping(value = "1/myprogramsdraft", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyProgramsDraft() {

		LOGGER.debug("Entering Class " + getClass() + " readMyPrograms()");
		ModelAndView mv = null;
		try {
			MemberRoleType roleType = SecurityTokenUtil.getToken().getRole();

			if (roleType == MemberRoleType.EDUCATOR) {
				List<Course> courses = courseService
						.getAllCoursesByStatus(CourseStatus.DRAFT);
				Integer courseCount = courseService
						.totalNumberOfCoursesByStatus(CourseStatus.DRAFT);
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

	@RequestMapping(value = "1/learnercourses", method = RequestMethod.GET)
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

	@RequestMapping(value = "1/myprograms", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyPrograms() throws CourseException {

		LOGGER.debug("Entering Class " + getClass() + " readMyPrograms()");

		ModelAndView mv = null;
		try {
			MemberRoleType roleType = SecurityTokenUtil.getToken().getRole();
			if (roleType == MemberRoleType.EDUCATOR) {
				List<Course> courses = courseService
						.getAllCoursesByStatus(CourseStatus.DRAFT);
				Integer courseCount = courseService
						.totalNumberOfCoursesByStatus(CourseStatus.DRAFT);
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

	/**
	 * This method converts collection of {@link Course} objects into
	 * {@link JSONCourse} objects
	 * 
	 * @param courseList
	 * @return
	 */
	private List<JSONCourse> getJSONCourseObjects(List<Course> courseList) {
		List<JSONCourse> jsonCourseList = new ArrayList<JSONCourse>();
		for (Course course : courseList) {
			jsonCourseList.add(new JSONCourse(course));
		}
		return jsonCourseList;

	}

}
