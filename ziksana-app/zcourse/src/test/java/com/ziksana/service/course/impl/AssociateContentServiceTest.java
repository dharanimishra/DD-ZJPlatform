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
import com.ziksana.domain.course.LearningContentDecoration;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.LearningContentDecorationService;


/**
 * @author Arvind
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AssociateContentServiceTest extends BaseTest {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssociateContentServiceTest.class);

	@Autowired
	private AssociateContentService  associateContentService;
	
	
	
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
	
	public void testUpdateAssociationWithLatestDecoration(){
		associateContentService.getLearningContent(0);
		//associateContentService.updateAssociationWithLatestDecoration(0, 0, null);
		// revoke
		
		LOGGER.debug("AssociateContentServiceTest.testSaveLearningContentDecoration()");
	}

}
