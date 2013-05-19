package com.ziksana.service.course.impl;

/**
 * @author Ratnesh Kumar
 * 
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.ContentStatus;

import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.service.course.CourseContentService;
import com.ziksana.service.course.impl.BaseTest;

/**
 * @author ratneshkumar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CreateContentTest extends BaseTest {

	@Autowired
	public CourseContentService courseContentService;

	@Test
	public void testSaveContent() throws Exception {
		System.out
				.println("inside Test ****************************************");
		Integer learnComponentId = 100;
		MemberPersona accountableMember = new MemberPersona();
		accountableMember.setMemberRoleId(100);

		String ContentDescription = "Video";
		String ContentPath = "";
		String ThumbnailPicturePath = "";
		String ScreenshotPath = "";
		Integer numberOfThumbnails = 1;

		LearningComponent component = new LearningComponent();
		component.setLearningComponentId(learnComponentId);

		LearningContent content = new LearningContent();
		content.setAuthoringMember(accountableMember);
		content.setContentName("Videos");
		content.setContentDescription(ContentDescription);
		content.setContentPath(ContentPath);
		content.setStatusId(1);
		content.setActive(true);
		// content.setContentTypeId(ContentType);
		content.setThumbnailPicturePath(ThumbnailPicturePath);
		content.setScreenshotPath(ScreenshotPath);
//		content.setStatus(ContentStatus.ACTIVE);
		content.setNumberOfThumbnails(numberOfThumbnails);
		content.setRightsOwningMember(accountableMember);

		LearningComponentContent compContent = new LearningComponentContent();
		compContent.setContentDescription(ContentDescription);
		compContent.setLearningComponent(component);
//		compContent.setCompContentTypeId(ComponentContentType.COURSE_CONTENT
//				.getID());
		compContent.setBaseLearningContent(content);

		compContent.setCourseStatusId(CourseStatus.ACTIVE.getID());

		courseContentService.saveOrUpdateContent(compContent);

		System.out.println("Tested ...");

	}

}
