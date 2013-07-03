/**
 * 
 */
package com.ziksana.service.course.impl;

import java.util.Date;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.ContentDecorationType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.EnrichContentService;
import com.ziksana.service.course.LearningContentDecorationService;


/**
 * @author Arvind
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class EnrichContentServiceTest extends BaseTest {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichContentServiceTest.class);

	@Autowired
	private EnrichContentService  enrichContentService;
	
	
	public void testAll(){
		try {
			//testSaveLearningContentDecoration();
			//testUpadateLearningContentDecoration();
			//testMarkAsDeletedLearningContentDecoration();
			//testGetLearningContentDecoration(learningContentDecorationId);
			LOGGER.debug("AnnotateContentServiceTest.testAll() all tests passed ");
		} catch (Exception e) {
			LOGGER.error("AnnotateContentServiceTest.testAll() test failed " + e.getMessage());
		}
		
	}
	
	public void testSaveNotes(){
		MemberPersona memberPersona = new MemberPersona();
		
		memberPersona.setMemberRoleId(207);
		memberPersona.setMemberRoleId(new Integer(207));
		Course course = enrichContentService.getCourse(7);
		//enrichContentService.get
		
		//enrichContentService.saveContentEnrichment(course, learningComponentContent, contentEnrichment, creator);
	}
}
