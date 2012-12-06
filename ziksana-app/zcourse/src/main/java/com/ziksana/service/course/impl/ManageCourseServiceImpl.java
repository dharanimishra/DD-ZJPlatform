package com.ziksana.service.course.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.assessment.engagement.EngagementCriteria;
import com.ziksana.domain.assessment.member.StudentInfo;
import com.ziksana.domain.assessment.member.StudentTest;
import com.ziksana.domain.assessment.member.TestProgress;
import com.ziksana.domain.assessment.member.TestSubmission;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.subscription.MemberSubscriptionProgram;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.collaboration.Group;
import com.ziksana.domain.member.collaboration.GroupContext;
import com.ziksana.domain.member.collaboration.GroupMember;
import com.ziksana.domain.member.collaboration.GroupMemberActivity;
import com.ziksana.domain.member.collaboration.GroupMemberConversation;
import com.ziksana.domain.member.collaboration.GroupMessage;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.IntegerZID;

import com.ziksana.persistence.course.CourseMapper;
import com.ziksana.persistence.course.subscription.SubscriptionCourseMapper;
import com.ziksana.persistence.member.collaboration.GroupMapper;
import com.ziksana.service.course.ManageCourseService;

/**
 * @author bhashasp
 */
public class ManageCourseServiceImpl implements ManageCourseService {

	private static Logger logger = Logger
			.getLogger(ManageCourseServiceImpl.class);

	@Autowired
	public CourseMapper courseMapper;
	@Autowired
	public SubscriptionCourseMapper sbnCourseMapper;

	@Autowired
	public GroupMapper groupsMapper;

	@Override
	public List<Engagement> getCourseEngagementRules(Course course)
			throws CourseException {

		List<Engagement> engagementList = null;
		Integer courseId = null;

		if (course.getCourseId() == null) {
			throw new CourseException(" Course ID cannot be null");
		}

		courseId = Integer.valueOf(course.getCourseId().getStorageID());

		// engagementList = engagementMapper
		// .getEngagementeRulesByCourseId(courseId);

		logger.debug("Engagement Rules size : " + engagementList.size());

		return engagementList;
	}

	@Transactional
	@Override
	public void addEngagementRule(Engagement engagement) throws CourseException {

		EngagementCriteria criteria = null;

		if (engagement == null) {
			throw new CourseException("Engagement cannot be null");
		}

		criteria = engagement.getEngagementCriteria();

		// criteria = engagementMapper.saveCriteria(criteria);

		logger.debug("Got the Criteria as a response : " + criteria);

		engagement.setEngagementCriteria(criteria);

		// engagementMapper.saveEngagement(engagement);

	}

	@Transactional
	@Override
	public void updateEngagementRule(Engagement engagement)
			throws CourseException {

		EngagementCriteria criteria = null;

		if (engagement == null) {
			throw new CourseException("Engagement cannot be null");
		}

		criteria = engagement.getEngagementCriteria();

		// engagementMapper.updateCriteria(criteria);

		// engagementMapper.updateEngagement(engagement);

	}

	@Transactional
	@Override
	public void deleteEngagementRule(Engagement engagement)
			throws CourseException {

		EngagementCriteria criteria = null;
		Boolean isDelete = true;

		if (engagement == null) {
			throw new CourseException("Engagement cannot be null");
		}

		criteria = engagement.getEngagementCriteria();

		// engagementMapper.deleteCriteria(isDelete, new Integer(criteria
		// .getEngagementCriteriaId().getStorageID()));
		//
		// engagementMapper.deleteEngagement(isDelete, new Integer(engagement
		// .getEngagementId().getStorageID()));

	}

	@Transactional
	@Override
	public List<MemberSubscriptionProgram> getEnrolledStudentsInfo(
			Integer curriculumCourseId) throws CourseException {

		CurriculumCourse currCourse = null;
		List<MemberSubscriptionProgram> memberProgList = null;
		LearningProgram learningProgram = null;
		Integer progCurriculumCourseId = null;

		if (curriculumCourseId == null) {
			throw new CourseException("CcurriculumCourse ID cannot be null");
		}

		// currCourse =
		// programsMapper.getCurriculumCourseById(curriculumCourseId);

		progCurriculumCourseId = new Integer(currCourse.getProgramCurriculum()
				.getProgramCurriculumId().getStorageID());

		// learningProgram = programsMapper
		// .getLearningProgramByProgCurriculum(progCurriculumCourseId);

		memberProgList = sbnCourseMapper
				.getMemberSubscriptionPrograms(new Integer(learningProgram
						.getLearningProgramId().getStorageID()));

		return memberProgList;
	}

	@Override
	public List<Course> getPublishedCoursesByMember(Integer memberRoleId)
			throws CourseException {

		List<Course> publishedCourseList = null;

		if (memberRoleId == null) {
			throw new CourseException("Member Role cannot be null");
		}

		logger.debug("Member Role Id : " + memberRoleId);

		publishedCourseList = courseMapper.getListOfCourses(memberRoleId);

		logger.debug("Published Courses for Member : " + publishedCourseList);

		return publishedCourseList;
	}

	@Override
	public SubscriptionCourse getCoursePerformance(Integer curriculumCourseId)
			throws CourseException {

		SubscriptionCourse sbnCourse = null;

		if (curriculumCourseId == null) {
			throw new CourseException("CcurriculumCourse ID cannot be null");
		}

		sbnCourse = sbnCourseMapper
				.getSubscribedStudentsInfo(curriculumCourseId);

		return sbnCourse;
	}

	@Override
	public List<GroupMember> getStudentGroupPerformance(Integer memberRoleId)
			throws CourseException {

		List<GroupMember> groupMemberList = null;

		if (memberRoleId == null) {
			throw new CourseException(
					"Student/Learner's MemberRole ID cannot be null");
		}

		groupMemberList = groupsMapper
				.getGroupMemberByMemberRoleId(memberRoleId);

		return groupMemberList;
	}

	@Transactional
	@Override
	public void associateStudentToGroup(Integer groupId, GroupMember groupMember)
			throws CourseException {

		Group group = null;

		group = groupMember.getGroup();

		if (group.getGroupId() == null) {
			throw new CourseException(
					"Group ID cannot be null to Associate to Group");
		}

		logger.debug("Group ID : " + groupId);

		if (groupMember.getMemberRole() == null) {
			throw new CourseException(
					"Member Role for Group Member cannot be null to Associate to Group");
		}

		groupsMapper.createGroupMember(groupMember);

	}

	@Transactional
	@Override
	public List<GroupMemberConversation> getStudentInteraction(
			Integer memberRoleId) throws CourseException {

		List<GroupMemberConversation> interactionList = null;
		List<GroupMember> groupMemberList = null;
		Integer sourceGroupMemberId = null;

		if (memberRoleId == null) {
			throw new CourseException(
					"Student/Learner's MemberRole ID cannot be null");
		}

		logger.debug("Member Role ID : " + memberRoleId);

		groupMemberList = groupsMapper
				.getGroupMemberByMemberRoleId(memberRoleId);

		interactionList = new ArrayList<GroupMemberConversation>();

		for (GroupMember groupMember : groupMemberList) {

			sourceGroupMemberId = new Integer(groupMember.getGroupMemberId()
					.getStorageID());

			interactionList = groupsMapper.getInteractions(sourceGroupMemberId);

		}

		return interactionList;
	}

	@Override
	public void removeInteraction(Integer conversationId)
			throws CourseException {

		if (conversationId == null) {
			throw new CourseException(
					"Student/Learner's Interaction ID cannot be null");
		}

		logger.debug("Member Role ID : " + conversationId);

		groupsMapper.delete(conversationId);

	}

	@Override
	public void removeStudentFromGroup(Integer groupId, Integer groupMemberId)
			throws CourseException {

		if (groupId == null) {
			throw new CourseException(
					"Student/Learner's Group ID cannot be null");
		}

		if (groupMemberId == null) {
			throw new CourseException(
					"Student/Learner's GroupMember ID cannot be null");
		}

		logger.debug("Group ID : [" + groupId + "]  , Group Member ID : ["
				+ groupMemberId + "]");

		groupsMapper.deleteStudentGroupAssociation(groupId, groupMemberId);

	}

	@Override
	public List<Group> getGroupsByCourse(Integer courseId,
			Integer curriculumCourseId) throws CourseException {

		List<Group> groupList = null;

		if (courseId == null || curriculumCourseId == null) {
			throw new CourseException(
					"CourseID/CurriculumCourseID cannot be null");
		}

		groupList = groupsMapper.getGroups(courseId, curriculumCourseId);

		return groupList;
	}

	@Override
	public List<GroupMember> getGroupMembersByGroupId(Integer groupId)
			throws CourseException {

		List<GroupMember> groupMemberList = null;

		if (groupId == null) {
			throw new CourseException("Group ID cannot be null");
		}

		groupMemberList = groupsMapper.getGroupMembersByGroupId(groupId);

		return groupMemberList;

	}

	@Transactional
	@Override
	public void createGroupForCourse(Group group) throws CourseException {

		GroupContext context = null;
		Integer contextId = null;

		context = group.getGroupContext();

		if (context == null) {
			throw new CourseException("Group Context cannot be null");
		}

		if (context.getCourse() == null
				|| context.getCurriculumCourse() == null) {
			throw new CourseException(
					"Course/CurriculumCourse cannot be null to create a new Group");
		}

		logger.debug("Group Context : " + context.toString());

		contextId = groupsMapper.saveGroupContext(context);

		context.setContextId(contextId);

		group.setGroupContext(context);

		groupsMapper.saveGrroup(group);

	}

	@Transactional
	@Override
	public void deleteGroup(Integer groupId) throws CourseException {

		if (groupId == null) {
			throw new CourseException("Group ID cannot be null");
		}

		groupsMapper.deleteGroup(groupId);

		// TODO: Send a Message Notification to Members with in then Group for
		// activities/submissions

	}

	@Transactional
	@Override
	public List<GroupMemberActivity> getGroupActivities(Integer groupId)
			throws CourseException {

		List<GroupMember> groupMembersList = null;
		List<GroupMemberActivity> groupActivitiesList = null;

		if (groupId == null) {
			throw new CourseException("Group ID cannot be null");
		}

		groupMembersList = groupsMapper.getGroupMembersByGroupId(groupId);

		for (GroupMember groupMember : groupMembersList) {

			groupActivitiesList = groupsMapper.getGroupActivities(new Integer(
					groupMember.getGroupMemberId().getStorageID()));

		}

		return groupActivitiesList;
	}

	@Override
	public void sendMessageToGroup(GroupMessage groupMessage)
			throws CourseException {

		Group group = null;

		if (groupMessage == null) {
			throw new CourseException(
					"GroupMessage cannot be null for Sending a message to Group");
		}

		group = groupMessage.getGroup();

		if (group == null) {
			throw new CourseException("Group  cannot be null");
		}

		groupsMapper.sendMessageToGroup(groupMessage);

	}

	@Override
	public StudentInfo getStudentAssignmentPerformance(Integer memberRoleId)
			throws CourseException {

		StudentInfo studentInfo = null;
		TestSubmission testSubmission = null;

		if (memberRoleId == null) {
			throw new CourseException(
					"Student/Learner's MemberRole ID cannot be null");
		}
		studentInfo = new StudentInfo();
		// testSubmission = assignmentTestMapper
		// .getStudentAssignmentPerformance(memberRoleId);

		studentInfo.setTimeSpentOnTest(testSubmission.getDuration());
		studentInfo.setNumberOfAttemps(1);

		StudentTest test = testSubmission.getTest();

		// TestProgress testProgress = assignmentTestMapper
		// .getStudentTestProgress(new Integer(test.getTestId()
		// .getStorageID()));

		// studentInfo.setProgress(testProgress.getProgress());

		studentInfo.setTimeSpentOnTest(11);

		return studentInfo;
	}

	@Override
	public void sendFeedbackToStudent(TestSubmission testSubmission)
			throws CourseException {

		if (testSubmission.getSubmissionId() == null) {
			throw new CourseException("TestSubmission ID cannot be null");
		}

		// assignmentTestMapper.saveStudentFeedback(testSubmission);

	}

}
