/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.service.course.CourseSubjectDetailService;

/**
 * @author vtg-p6 Dec 15, 2012
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseSubjectDetailTest extends BaseTest {

	@Autowired
	public CourseSubjectDetailService courseSubjectDetailService;

	@Test
	public void testgetSubjectDetails() throws Exception {
		
		/*
		System.out
				.println("inside Test ****************************************");

		Map<String, String> map = courseSubjectDetailService
				.getSubjectCategory();

		System.out.println("new saved course : ");

		Assert.isTrue(map != null);
		*/
	}

}
