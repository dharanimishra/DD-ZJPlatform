/**
 * 
 */
package com.ziksana.service.course.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.course.CourseService;

/**
 * @author prabu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseServiceImplTest {

	@Autowired
	public CourseService courseService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1007");
		ZID memberPersonaId = new StringZID("107");
		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.ziksana.service.course.impl.CourseServiceImpl#getCoursesByStatus(com.ziksana.domain.course.CourseStatus)}
	 * .
	 */
	@Ignore
	public void testGetCoursesByStatus() {

		List<Course> courses = courseService
				.getCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
		assertTrue(courses.size() == 1);

	}

	@Ignore
	public void testGetAllCoursesByStatus() {
		List<Course> courses = courseService
				.getAllCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
		assertTrue(courses.size() == 1);

	}

	@Ignore
	public void testTotalNumberOfCourses() {
		Integer total = courseService
				.totalNumberOfCoursesByStatus(CourseStatus.UNDER_CONSTRUCT);
		assertTrue(total > 0);

	}

	@Test
	public void testGetCourseByCourseId() {
		Course course = new Course();
		course = courseService.getCourseByCourseId(277);

	}

}
