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
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseService;

/**
 * @author prabu
 * 
 */
@Controller
@RequestMapping("/secure")
public class MyCoursesController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyCoursesController.class);

	@Autowired
	CourseService courseService;
	
	
		

	@RequestMapping(value = "/showmycourse/111111", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyCourses() throws CourseException {

		LOGGER.info("Entering Class " + getClass() + " showCourse()");

		List<Course> draftedCourses = courseService
				.getCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
		List<Course> reviewedCourses = courseService
				.getCoursesByStatus(CourseStatus.REVIEW);
		List<Course> activeCourses = courseService
				.getCoursesByStatus(CourseStatus.ACTIVE);

		ModelAndView mv = new ModelAndView("courses/course-list-new");

		LOGGER.info("Exiting Class " + getClass() + " showCourse(): ");

		// TODO we need to add object
		mv.addObject("DRAFTED_COURSES", draftedCourses);
		mv.addObject("REVIEWED_COURSES", reviewedCourses);
		mv.addObject("ACTIVE_COURSES", activeCourses);
		return mv;
	}

	@RequestMapping(value = "/showMyProgramsDraft", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyProgramsDraft() throws CourseException {

		LOGGER.info("Entering Class " + getClass() + " readMyPrograms()");

		MemberRoleType roleType = ThreadLocalUtil.getToken().getRole();

		if (roleType == MemberRoleType.EDUCATOR) {
			List<Course> courses = courseService
					.getAllCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
			Integer courseCount = courseService
					.totalNumberOfCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
			ModelAndView mv = new ModelAndView("courses/myprograms-draft");
			mv.addObject("courses", courses);
			mv.addObject("courseCount", courseCount);
			return mv;
		} else {

			List<LearningProgram> programs = courseService
				     .getLearningPrograms();
				   LearningProgram program = programs.get(0);
				   List<Course> courses = courseService.getCoursesByLearningProgram(Integer.valueOf(program
				       .getLearningProgramId().getStorageID()));

				   System.out.println(" TOTAL NUMBER OF COURSES IS  "+courses.size());
				   System.out.println(" THE COURSE NAME IS   "+courses.get(0).getName() );
				   ModelAndView mvLearner = new ModelAndView("courses/learnerprograms");
				   mvLearner.addObject("program", program.getName());
				   mvLearner.addObject("courses", courses);

				   // TODO need to implement learner my programs...
				   return mvLearner;
		}

	}
	@RequestMapping(value = "/showMyPrograms", method = RequestMethod.GET)
	public @ResponseBody
	ModelAndView readMyPrograms() throws CourseException {

		LOGGER.info("Entering Class " + getClass() + " readMyPrograms()");

		MemberRoleType roleType = ThreadLocalUtil.getToken().getRole();

		if (roleType == MemberRoleType.EDUCATOR) {
			List<Course> courses = courseService
					.getAllCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
			Integer courseCount = courseService
					.totalNumberOfCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
			ModelAndView mv = new ModelAndView("courses/myprograms");
			mv.addObject("courses", courses);
			mv.addObject("courseCount", courseCount);
			return mv;
		} else {


			List<LearningProgram> programs = courseService
				     .getLearningPrograms();
				   LearningProgram program = programs.get(0);
				   List<Course> courses = courseService.getCoursesByLearningProgram(Integer.valueOf(program
				       .getLearningProgramId().getStorageID()));

				   System.out.println(" TOTAL NUMBER OF COURSES IS  "+courses.size());
				   System.out.println(" THE COURSE NAME IS   "+courses.get(0).getName() );
				   ModelAndView mvLearner = new ModelAndView("courses/learnerprograms");
				   mvLearner.addObject("program", program.getName());
				   mvLearner.addObject("courses", courses);

				   // TODO need to implement learner my programs...
				   return mvLearner;

		}

	}

}
