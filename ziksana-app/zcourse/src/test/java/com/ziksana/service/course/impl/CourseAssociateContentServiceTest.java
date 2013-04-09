package com.ziksana.service.course.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.ContentFormat;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentDeleteType;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.CourseContentService;

/**
 * @author ratneshkumar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseAssociateContentServiceTest extends BaseTest {

	@Autowired
	public CourseContentService courseContentService;

	@Test
	public void testSaveOrUpdateAssociateContent() throws Exception {

		LearningComponentContent learningComponentContent = null;

		learningComponentContent = constructContent(learningComponentContent);

//		ZID LearningComponentContentId = learningComponentContent
//				.getLearningComponentContentId();
//		String id = LearningComponentContentId.getStorageID();

		courseContentService.saveOrUpdateContent(learningComponentContent);

//		LearningComponentContent expected = courseContentService
//				.getLearningComponentContent(Integer.valueOf(id));

		//Assert.assertNotNull(learningComponentContent);

	}

	@Test
	public void testEnhanceContent() throws Exception {

	}

	@Test
	public void testlDeleteLearningContentOnly() throws Exception {

		System.out
				.println("********* Inside testlDeleteLearningContentOnly method ***********");

		Integer learningContentId = 6;

		courseContentService.deleteContent(
				LearningContentDeleteType.LEARNINGCONTENT, learningContentId);

	}

	@Test
	public void testlDeleteContentPartsOnly() throws Exception {

	
		Integer learningContentId = 6;

		courseContentService.deleteContent(
				LearningContentDeleteType.LEARNINGCONTENT_PARTS,
				learningContentId);

	}

	@Test
	public void testlDeleteContentAndParts() throws Exception {

	
		Integer learningContentId = 6;

		courseContentService.deleteContent(
				LearningContentDeleteType.LEARNINGCONTENT_AND_PARTS,
				learningContentId);

		List<LearningContent> learningContent = courseContentService
				.getLearningContent(learningContentId);
		Assert.assertNull(learningContent);

	}

	@Test
	public void testGetLearningContent() throws Exception {

		MemberPersona rightsOwningMember = new MemberPersona();
		rightsOwningMember.setMemberRoleId(100);

		List<LearningContent> contentList = courseContentService
				.getLearningContent(rightsOwningMember.getMemberRoleId());

	

		Assert.assertTrue(contentList.size() > 0);

	}

	private LearningComponentContent constructContent(
			LearningComponentContent learningComponentContent) {

		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);

		Course course = new Course();
		course.setCourseId(100);

		LearningComponent component = new LearningComponent();
		component.setLearningComponentId(3);

		LearningContent content = new LearningContent();
		content.setContentName("Trignometry Intro");
		// content.setAuthoringMember(authoredMember);
		content.setContentDescription("Trigonommetry Introduction");
		content.setContentName("Trigonommetry_Intro");
		content.setContentPath("/content/");
		content.setContentTypeId(ContentType.TEXTUAL.getID());
		content.setRightsOwningMember(authoredMember);
		content.setContentFormatId(ContentFormat.WORD.getID());

		LearningComponentContent compContent = new LearningComponentContent();
		compContent.setLearningComponent(component);
		compContent.setCompContentTypeId(ComponentContentType.COURSE_CONTENT
				.getID());
		compContent.setContentDescription("Trigonommetry Introduction");
		compContent.setBaseLearningContent(content);
		compContent.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());

		Assert.assertNull(compContent);

		return compContent;
	}
}
