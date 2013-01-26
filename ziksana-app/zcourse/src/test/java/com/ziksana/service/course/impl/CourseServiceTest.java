package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ziksana.domain.assessment.TagType;
import com.ziksana.domain.course.ComponentContentType;
import com.ziksana.domain.course.ContentType;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CourseContentSecurity;
import com.ziksana.domain.course.CourseDetails;
import com.ziksana.domain.course.CourseLearningComponent;
import com.ziksana.domain.course.CourseStatus;
import com.ziksana.domain.course.CourseTagcloud;
import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningComponentContentDetails;
import com.ziksana.domain.course.LearningComponentDetails;
import com.ziksana.domain.course.LearningComponentNest;
import com.ziksana.domain.course.LearningComponentType;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.CourseService;
import com.ziksana.service.course.impl.BaseTest;

/**
 * @author ratneshkumar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CourseServiceTest extends BaseTest {

	@Autowired
	public CourseService courseService;

	@Ignore
	@Test
	public void testSaveCourse() throws Exception {
		System.out
				.println("inside Test ****************************************");

		Course newCourse = null;
		//Course course = buildCourseForSave();
		 Course course = buildCourseForUpdate();

		newCourse = courseService.saveOrUpdateCourse(course);

		System.out.println("new saved course : " + course.toString());

	}


	public void testgetListOfCourses() throws CourseException {

		List<Course> courses = courseService.getListOfCourses(100);
		System.out.println(" The number of courses are " + courses.size());

		Course course = courses.get(0);
		System.out.println(" course status is " + course.getCourseProgress());
		System.out.println(" course status is " + course.getCourseStatusId());

	}

	@Ignore
	@Test
	public void testSaveCourseComponents() throws Exception {

		System.out
				.println("*************inside testSaveCourseComponent************************");

		Course newCourse = null;

		 //Course course = buildCourseWithComponentForSave();

		Course course = buildCourseWithComponentForUpdate();

		newCourse = courseService.saveOrUpadteCourseComponents(course);

		System.out.println("new saved course : " + course.toString());

	}

	private Course buildCourseForUpdate() throws Exception {
		List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
		List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();
		Course course1 = new Course();
		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		course1.setCourseId(150);
		course1.setAccountableMember(authoredMember);
		course1.setName("Mathematics");
		course1.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
		course1.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
		course1.setDescription("Discrete Mathematics3");
		course1.setSecurityIndicator(true);
		CourseContentSecurity courseSecurity = new CourseContentSecurity();
		courseSecurity.setContentSecurityId(17);
		courseSecurity.setFlotingIndicator(true);
		courseSecurity.setLogoPath("/newlogopath/");
		courseSecurity.setCourse(course1);
		course1.setCourseContSecurity(courseSecurity);

		CourseTagcloud tagcloud = new CourseTagcloud();
		tagcloud.setCreatingMember(authoredMember);
		tagcloud.setTagName("Trigonometry");
		tagcloud.setTagType(TagType.TAG_TYPE1);
		tagcloudList.add(tagcloud);
		// tagcloud.setCourse(course1);
		course1.setCourseTagClouds(tagcloudList);

		System.out.println("Constructed Course  : " + course1);

		return course1;

	}

	private Course buildCourseForSave() throws Exception {
		Course course1 = new Course();
		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();

		course1.setAccountableMember(authoredMember);

		course1.setName("DMS 001");
		course1.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
		course1.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
		course1.setDescription("Discrete Mathematics3");

		course1.setSecurityIndicator(true);

		CourseContentSecurity courseSecurity = new CourseContentSecurity();
		courseSecurity.setContentSecurityId(17);
		courseSecurity.setFlotingIndicator(true);
		courseSecurity.setLogoPath("/newlogopath/");
		courseSecurity.setCourse(course1);
		course1.setCourseContSecurity(courseSecurity);

		CourseTagcloud tagcloud = new CourseTagcloud();
		tagcloud.setCreatingMember(authoredMember);
		tagcloud.setTagName("Trigonometry");
		tagcloud.setTagType(TagType.TAG_TYPE1);
		tagcloudList.add(tagcloud); // tagcloud.setCourse(course1);
		course1.setCourseTagClouds(tagcloudList);

		System.out.println("Constructed Course  : " + course1);

		return course1;

	}

	private Course buildCourseWithComponentForSave() throws Exception {
		List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
		Course course1 = new Course();
		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		course1.setCourseId(150);

		LearningComponent comp1 = new LearningComponent();
		comp1.setAuthoredMember(authoredMember);
		comp1.setName("Module1");

		LearningComponentNest compNest1 = new LearningComponentNest(null, comp1);
		compNest1.setNestLearningComponent(comp1);
		// compNest1.setComponentNestId(11);
		LearningComponentDetails compDetails1 = new LearningComponentDetails();
		// comp1.getLearningComponentDetails();
		compDetails1.setLearningComponentNest(compNest1);

		LearningComponentType compType1 = new LearningComponentType();
		compType1.setLearningComponentTypeId(1);

		comp1.setLearningComponentType(compType1);

		CourseLearningComponent corComp1 = new CourseLearningComponent();
		corComp1.setLearningComponent(comp1);
		corComp1.setLearningComponentType(compType1);
		corComp1.setCourse(course1);

		compDetails1.setCourseLearningComponent(corComp1);

		comp1.setLearningComponentDetails(compDetails1);

		compList.add(corComp1);

		CourseDetails courseDetails = new CourseDetails();

		courseDetails.setCourseLearningComponentsList(compList);

		System.out.println("Constructed Course  : " + course1);

		return course1;

	}

	private Course buildCourseWithComponentForUpdate() throws Exception {
		List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
		Course course1 = new Course();
		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		course1.setCourseId(150);

		LearningComponent comp1 = new LearningComponent();
		comp1.setAuthoredMember(authoredMember);

		comp1.setName("Module1");
		LearningComponentNest compNest1 = new LearningComponentNest(null, comp1);
		compNest1.setNestLearningComponent(comp1);
		// compNest1.setComponentNestId(11);
		LearningComponentDetails compDetails1 = new LearningComponentDetails();
		// comp1.getLearningComponentDetails();
		compDetails1.setLearningComponentNest(compNest1);

		LearningComponentType compType1 = new LearningComponentType();
		compType1.setLearningComponentTypeId(1);

		comp1.setLearningComponentType(compType1);

		CourseLearningComponent corComp1 = new CourseLearningComponent();
		corComp1.setLearningComponent(comp1);
		corComp1.setLearningComponentType(compType1);
		corComp1.setCourse(course1);

		compDetails1.setCourseLearningComponent(corComp1);

		comp1.setLearningComponentDetails(compDetails1);

		compList.add(corComp1);

		CourseDetails courseDetails = new CourseDetails();

		courseDetails.setCourseLearningComponentsList(compList);

		System.out.println("Constructed Course  : " + course1);

		return course1;

	}

	private Course buildCourseTreeData() throws Exception {

		List<CourseLearningComponent> compList = new ArrayList<CourseLearningComponent>();
		List<CourseTagcloud> tagcloudList = new ArrayList<CourseTagcloud>();
		Course course1 = new Course();
		MemberPersona authoredMember = new MemberPersona();
		authoredMember.setMemberRoleId(100);
		course1.setCourseId(150);
		course1.setAccountableMember(authoredMember);
		// course1.setName("DMS 001");
		course1.setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
		course1.setCourseStatusId(CourseStatus.UNDER_CONSTRUCT.getID());
		course1.setDescription("Discrete Mathematics3");

		course1.setSecurityIndicator(true);
		CourseContentSecurity courseSecurity = new CourseContentSecurity();
		courseSecurity.setContentSecurityId(17);
		courseSecurity.setFlotingIndicator(true);
		courseSecurity.setLogoPath("/newlogopath/");
		courseSecurity.setCourse(course1);
		course1.setCourseContSecurity(courseSecurity);

		CourseTagcloud tagcloud = new CourseTagcloud();
		tagcloud.setCreatingMember(authoredMember);
		tagcloud.setTagName("Trigonometry");
		tagcloud.setTagType(TagType.TAG_TYPE1);
		tagcloudList.add(tagcloud); // tagcloud.setCourse(course1);
		course1.setCourseTagClouds(tagcloudList);

		LearningComponent comp1 = new LearningComponent();
		comp1.setAuthoredMember(authoredMember);

		comp1.setName("Module1");
		LearningComponentNest compNest1 = new LearningComponentNest(null, comp1);
		compNest1.setNestLearningComponent(comp1);
		// compNest1.setComponentNestId(11);
		LearningComponentDetails compDetails1 = new LearningComponentDetails();
		// comp1.getLearningComponentDetails();
		compDetails1.setLearningComponentNest(compNest1);

		LearningComponentType compType1 = new LearningComponentType();
		compType1.setLearningComponentTypeId(1);

		comp1.setLearningComponentType(compType1);

		CourseLearningComponent corComp1 = new CourseLearningComponent();
		corComp1.setLearningComponent(comp1);
		corComp1.setLearningComponentType(compType1);
		corComp1.setCourse(course1);

		compDetails1.setCourseLearningComponent(corComp1);

		comp1.setLearningComponentDetails(compDetails1);

		compList.add(corComp1);

		CourseDetails courseDetails = new CourseDetails();

		courseDetails.setCourseLearningComponentsList(compList);

		course1.setCourseDetails(courseDetails);

		System.out.println("Constructed Course  : " + course1);

		return course1;

	}

	/**
	 * Below tree structure is the constructure below:
	 * 
	 * CourseName / | \ Module1 LearningObject1 DefineQualifier1 / \ |
	 * Assignment1 SampleTextFile VideoFile / Test1
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private Course buildCourseTreeData1() throws Exception {

		List<LearningComponent> compList = new ArrayList<LearningComponent>();
		List<LearningComponentContent> compContentList = new ArrayList<LearningComponentContent>();
		Course course1 = new Course();

		course1.setCourseId(100);
		course1.setName("Mathematics for Information Technology");

		// Module1 as a Learning component and child as a text content
		// STARTS
		// HERE
		LearningComponent comp1 = new LearningComponent();

		comp1.setLearningComponentId(1);
		comp1.setName("Module1");
		comp1.setLearningObjIndicator(0);

		LearningComponentNest compNest1 = new LearningComponentNest(null, comp1);
		compNest1.setComponentNestId(11);

		LearningComponentDetails compDetails1 = new LearningComponentDetails();
		// comp1.getLearningComponentDetails();
		compDetails1.setLearningComponentNest(compNest1);

		LearningComponentType compType1 = new LearningComponentType();
		compType1.setLearningComponentTypeId(1);
		compType1.setQualifierIndicator(false);

		LearningComponentContent compContent1 = new LearningComponentContent();
		compContent1.setLearningComponentContentId(111);
		compContent1.setCompContentType(ComponentContentType.COURSE_CONTENT);

		LearningContent content1 = new LearningContent();
		content1.setLearningContentId(1111);
		content1.setContentType(ContentType.TEXTUAL);
		content1.setContentName("SampleTextFile");
		content1.setContentPath("/filepath");
		content1.setActive(true);

		// AssignmentTest assignment = new AssignmentTest();
		// assignment.setAssignmentTestId(new IntegerZID(1000));
		// assignment.setName("Assignment1");
		// assignment
		// .setAssignmentContentType(AssignmentContentType.ASSIGNMENT);
		//
		// AssignmentTest test1 = new AssignmentTest();
		// test1.setAssignmentTestId(new IntegerZID(1001));
		// test1.setName("Test1");
		// test1.setTestType(TestType.PRACTICE_TEST);
		// test1.setAssignmentContentType(AssignmentContentType.TEST);
		//
		// assignment.setTest(test1);

		// compDetails1.setAssignmentTest(assignment);

		compContent1.setBaseLearningContent(content1);
		compContentList.add(compContent1);

		comp1.setLearningComponentType(compType1);
		compDetails1.setLearningCompContentList(compContentList);

		comp1.setLearningComponentDetails(compDetails1);

		compList.add(comp1);
		// Module1 as a Learning component and child as a text content ENDS
		// HERE

		// LearningObject1 as LearningComponent and its child as a
		// content(video) ---STARTS HERE
		LearningComponent comp2 = new LearningComponent();
		comp2.setLearningComponentId(2);
		comp2.setName("LearningObject1");
		comp2.setLearningObjIndicator(1);

		LearningComponentContent compContent2 = new LearningComponentContent();
		compContent2.setLearningComponentContentId(111);
		compContent2.setCompContentType(ComponentContentType.COURSE_CONTENT);

		LearningContent content2 = new LearningContent();
		content2.setLearningContentId(1111);
		content2.setContentType(ContentType.VIDEO);
		content2.setContentName("VideoFileName");
		content2.setContentPath("/filepath");
		content2.setActive(true);

		compContent2.setBaseLearningContent(content2);

		LearningComponentContentDetails compContentDetails2 = new LearningComponentContentDetails();

		compContent2.setLearrningComponentContentDetails(compContentDetails2);

		LearningComponentNest compNest2 = new LearningComponentNest(null, comp2);
		compNest2.setComponentNestId(12);

		LearningComponentDetails compDetails2 = new LearningComponentDetails();

		compDetails2.setLearningComponentNest(compNest2);

		LearningComponentType compType2 = new LearningComponentType();
		compType2.setLearningComponentTypeId(2);
		compType2.setQualifierIndicator(false);

		comp2.setLearningComponentType(compType2);
		compDetails2.setLearningCompContentList(compContentList);

		comp2.setLearningComponentDetails(compDetails2);
		compList.add(comp2);
		// LearningObject1 as LearningComponent and its child as a
		// content(video) ---ENDS HERE

		// DefineQualifier1 as a Learning Component -- STARTS HERE
		LearningComponent comp3 = new LearningComponent();
		comp3.setLearningComponentId(3);
		comp3.setName("DefineQualifier1");
		comp3.setLearningObjIndicator(0);

		LearningComponentNest compNest3 = new LearningComponentNest(null, comp3);
		compNest2.setComponentNestId(13);

		LearningComponentDetails compDetails3 = new LearningComponentDetails();

		compDetails3.setLearningComponentNest(compNest3);

		LearningComponentType compType3 = new LearningComponentType();
		compType3.setLearningComponentTypeId(3);
		compType3.setQualifierIndicator(true);

		comp3.setLearningComponentType(compType3);

		comp3.setLearningComponentDetails(compDetails3);
		compList.add(comp3);
		// DefineQualifier1 as a Learning Component -- ENDS HERE

		// Assignment -> Test add to course -- STARTS HERE
		/*
		 * AssignmentTest assignment2 = new AssignmentTest();
		 * assignment2.setAssignmentTestId(new IntegerZID(2000));
		 * assignment2.setName("Assignment2");
		 * assignment2.setAssignmentContentType
		 * (AssignmentContentType.ASSIGNMENT);
		 * 
		 * AssignmentTest test2 = new AssignmentTest();
		 * test2.setAssignmentTestId(new IntegerZID(2001));
		 * test2.setName("Test2"); test2.setTestType(TestType.PRACTICE_TEST);
		 * test2.setAssignmentContentType(AssignmentContentType.TEST);
		 * 
		 * assignment2.setTest(test2);
		 */// (Assignment -> Test) add to course -- ENDS HERE

		CourseDetails courseDetails = new CourseDetails();
		// courseDetails.addAssignmentTest(assignment2);

		courseDetails.setLearningComponents(compList);

		course1.setCourseDetails(courseDetails);

		System.out.println("course  : " + course1);

		return course1;

	}

}
