/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.domain.course.UserContent;
import com.ziksana.service.course.LearningContentService;

/**
 * @author Ratnesh Kumar
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserContentTest extends BaseTest {

	@Autowired
	public LearningContentService contentService;

	@Test
	public void getUserContent() throws Exception {
		System.out
				.println("inside Test ****************************************");

		Integer memberId = 100;
		// List<UserContent> list = contentService.getUserContent(memberId);

	}

}
