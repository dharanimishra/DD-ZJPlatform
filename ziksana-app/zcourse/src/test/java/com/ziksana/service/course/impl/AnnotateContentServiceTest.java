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
import com.ziksana.service.course.LearningContentDecorationService;


/**
 * @author Arvind
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AnnotateContentServiceTest extends BaseTest {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AnnotateContentServiceTest.class);

	@Autowired
	private LearningContentDecorationService  learningContentDecorationService;
	
	
	private Integer learningContentDecorationId = 15;
	
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
	
	public void testSaveLearningContentDecoration(){
		
		learningContentDecorationService.saveLearningContentDecoration(getLearningContentDecoration());
		LOGGER.debug("AnnotateContentServiceTest.testSaveLearningContentDecoration() test passed");
	}
	
	
	public void testUpadateLearningContentDecoration(){
		
		LearningContentDecoration learningContentDecoration = learningContentDecorationService.getLearningContentDecoration(learningContentDecorationId);
		learningContentDecoration.setDescription("Arvind");
		learningContentDecorationService.updateLearningContentDecoration(learningContentDecoration);
		LOGGER.debug("AnnotateContentServiceTest.testUpadateLearningContentDecoration() test passed");
		
	}
	public void testMarkAsDeletedLearningContentDecoration(){
		LearningContentDecoration learningContentDecoration = learningContentDecorationService.getLearningContentDecoration(learningContentDecorationId);
		learningContentDecorationService.markLearningContentDecorationAsDeleted(learningContentDecoration);
		LOGGER.debug("AnnotateContentServiceTest.testMarkAsDeletedLearningContentDecoration() passed");
	}
	public void testGetLearningContentDecoration(Integer id){
		learningContentDecorationService.getLearningContentDecoration(id);
		LOGGER.debug("AnnotateContentServiceTest.testGetLearningContentDecoration() passed");
	}
	
	private LearningContentDecoration getLearningContentDecoration(){
		LearningContentDecoration learningContentDecoration = new LearningContentDecoration();
		learningContentDecoration.setActive(true);
		learningContentDecoration.setAuthoringMemberRoleId(207);
		learningContentDecoration.setContentDecorationType(ContentDecorationType.ANNOTATED);
		learningContentDecoration.setContentDecorationTypeId(ContentDecorationType.ANNOTATED.getId());
		//System.out.println(ContentDecorationType.ANNOTATED.getName());
		learningContentDecoration.setCreatedBy("Test case");
		//learningContentDecoration.setCreationDate(new Date());
		learningContentDecoration.setDelete(false);
		learningContentDecoration.setDescription("test description");
		learningContentDecoration.setRightsOwningMemberRoleId(207);
		//learningContentDecoration.setSubjClassificationId(subjClassificationId);
		learningContentDecoration.setVersion(1);
		learningContentDecoration.setVersion(1);
		learningContentDecoration.setVersionRemarks("created");


		return learningContentDecoration;
	}

}
