package com.ziksana.service.classtalk.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.classtalk.LearnerOnline;
import com.ziksana.domain.course.Course;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.StringZID;
import com.ziksana.id.ZID;
import com.ziksana.security.util.SecurityToken;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.classtalk.ClassTalkService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ClassTalkServiceImplTest {
    
	
	@Autowired
	private ClassTalkService classTalkService;

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ZID memberId = new StringZID("1000");
		ZID memberPersonaId = new StringZID("100");

		SecurityToken token = new SecurityToken(memberId, memberPersonaId, null);
		ThreadLocalUtil.setToken(token);
	}

	@After
	public void tearDown() throws Exception {
		ThreadLocalUtil.unset();
	}

	@Test
	public void testGetAllOnlineLearners() {
		Course course = new Course("testcourse","testdesc",null,null,null);
		course.setCourseId(new IntegerZID(1));
		List<LearnerOnline> learners = classTalkService.getAllOnlineLearners(course);
		Assert.assertTrue(learners.size() == 1);
		
	}

	@Test
	public void testGetOnlineLearnersByCircle() {
		fail("Not yet implemented");
	}

}
