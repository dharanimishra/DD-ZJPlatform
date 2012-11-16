package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.assessment.member.TestSubmission;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.subscription.MemberSubscriptionProgram;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.domain.member.Group;
import com.ziksana.domain.member.GroupMember;
import com.ziksana.domain.member.GroupMemberActivity;
import com.ziksana.domain.member.GroupMemberConversation;
import com.ziksana.domain.member.GroupMessage;
import com.ziksana.domain.member.StudentInfo;
import com.ziksana.exception.course.CourseException;

/**
 * @author bhashasp
 */
/**
 * @author bhashasp
 */
public interface ManageCourseService {
	 
	/**
	 * @param course
	 * @return
	 * @throws CourseException
	 */
	public List<Engagement> getCourseEngagementRules(Course course) throws CourseException;
	
	/**
	 * @param engagement
	 * @throws CourseException
	 */
	public void addEngagementRule(Engagement engagement) throws CourseException;
	
	/**
	 * @param engagement
	 * @throws CourseException
	 */
	public void updateEngagementRule(Engagement engagement) throws CourseException;
	
	/**
	 * @param engagement
	 * @throws CourseException
	 */ 
	public void deleteEngagementRule(Engagement engagement) throws CourseException;
		
	/**
	 * Retrieves the list of course which are in Curriculum
	 * @param member
	 * @return
	 * @throws CourseException
	 */
	public List<Course> getPublishedCoursesByMember(Integer memberRoleId) throws CourseException;
	
		/**
	 * @param courseId
	 * @return
	 * @throws CourseException
	 */
	public List<MemberSubscriptionProgram> getEnrolledStudentsInfo( Integer courseId) throws CourseException;
		
	
	/**
	 * @return
	 * @throws CourseException
	 */
	public SubscriptionCourse getCoursePerformance(Integer curriculumCourseId) throws CourseException;
	
	
	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public List<GroupMember> getStudentGroupPerformance(Integer memberRoleId) throws CourseException;

	/**
	 * Creates a new Group Member for memberRoleId and associate the Group Member to Group
	 * @param groupId
	 * @param groupMember
	 * @throws CourseException
	 */
	public void associateStudentToGroup(Integer groupId, GroupMember groupMember) throws CourseException;
	
	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public List<GroupMemberConversation> getStudentInteraction(Integer memberRoleId) throws CourseException;
	
	
	/**{Cancel Interaction action}<br>
	 * Removes the association GroupMember from GroupMemberConversation(Interaction)
	 * @param conversationId
	 * @throws CourseException
	 */
	public void removeInteraction(Integer conversationId) throws CourseException;
	
	/**
	 * Removes the association Student from Group
	 * @param groupId
	 * @param groupMemberId
	 * @throws CourseException
	 */
	public void removeStudentFromGroup(Integer groupId, Integer groupMemberId) throws CourseException;
	
	
	/**
	 * Gets the List of Groups by providing the course and curriculumcourse.
	 * @param courseId
	 * @param curriculumCourseId
	 * @return 
	 * @throws CourseException
	 */
	public List<Group> getGroupsByCourse(Integer courseId, Integer curriculumCourseId) throws CourseException;
	
	/**
	 * Retrieves the list of group Members by GroupId
	 * @param groupId
	 * @return
	 * @throws CourseException
	 */
	public List<GroupMember> getGroupMembersByGroupId(Integer groupId) throws CourseException;
	 
	
	/**
	 * Creates a New Group for the course.<br>
	 * Creates/Saves a new GroupContext for a new Group creation..<br>
	 * Saves the Group to create a new group.
	 * @param group
	 * @param courseId
	 * @param curriculumCourseId
	 * @throws CourseException
	 */
	public void createGroupForCourse(Group group) throws CourseException;
	
	/**
	 * Deletes the group and send the message to GroupMembers for a Activities/Submissions.
	 * @param groupId
	 * @throws CourseException
	 */
	public void deleteGroup(Integer groupId) throws CourseException; 
	
	/**
	 * Retrieves the Group Actitivities for Group
	 * @param groupId
	 * @return
	 * @throws CourseException
	 */
	public List<GroupMemberActivity> getGroupActivities(Integer groupId) throws CourseException;
	
	/**
	 * @param groupMessage
	 * @throws CourseException
	 */
	public void sendMessageToGroup(GroupMessage groupMessage) throws CourseException;
	
	/**
	 * @param memberRoleId
	 * @return
	 * @throws CourseException
	 */
	public StudentInfo getStudentPerformance(Integer memberRoleId) throws CourseException;

	/**
	 * @param testSubmission
	 * @throws CourseException
	 */
	public void sendFeedbackToStudent(TestSubmission testSubmission) throws CourseException;
	
	
	
}
