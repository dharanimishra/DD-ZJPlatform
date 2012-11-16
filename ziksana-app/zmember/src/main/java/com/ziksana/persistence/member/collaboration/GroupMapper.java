package com.ziksana.persistence.member.collaboration;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.member.Group;
import com.ziksana.domain.member.GroupContext;
import com.ziksana.domain.member.GroupMember;
import com.ziksana.domain.member.GroupMemberActivity;
import com.ziksana.domain.member.GroupMemberConversation;
import com.ziksana.domain.member.Member;
import com.ziksana.domain.member.MemberPersona;

/**
 * @author bhashasp
 */
public interface GroupMapper {

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select groupmemberid, islead, isnominated, isvolunteer, totalmembertime, memberpersonality, groupid"
			+ " from clngroupmember  where  memberroleid = #{memberRoleId, jdbcType=INTEGER} and isdelete = false" })
	@Results(value = {
			@Result(property = "groupMemberId", column = "groupmemberid"),
			@Result(property = "isLead", column = "islead"),
			@Result(property = "isNominated", column = "isnominated"),
			@Result(property = "isVolunteer", column = "isvolunteer"),
			@Result(property = "totalMemberTime", column = "totalmembertime"),
			@Result(property = "memberPersonality", column = "memberpersonality"),
			@Result(property = "groupId", column = "groupid"),
			@Result(property = "group", column = "groupId", javaType = Group.class, one = @One(select = "getGroupById")) })
	List<GroupMember> getGroupMemberByMemberRoleId(Integer memberRoleId);

	/**
	 * @param groupId
	 * @return
	 */
	@Select({ "select groupid, totalparticipants, name, grouppersonality from clngroup where  groupid = #{groupId, jdbcType=INTEGER} and isdelete = false" })
	@Results(value = {
			@Result(property = "groupId", column = "groupid"),
			@Result(property = "totalParticipants", column = "totalparticipants"),
			@Result(property = "name", column = "name"),
			@Result(property = "groupPersonality", column = "grouppersonality") })
	Group getGroupById(Integer groupId);

	/**
	 * Retrieves the Interactions associated with Source(self) and Target Group
	 * Member.
	 * 
	 * @param sourceGroupMemberId
	 * @return
	 */
	@Select({ "select conversationid, conversationmode, conversationtext, recordingpath, creationdate, sourcegroupmemberid, targergroupmemberid"
			+ " from clngroupmemberconversation"
			+ " where sourcegroupmemberid = #{sourceGroupMemberId, jdbcType=INTEGER} and isdelete = false" })
	@Results(value = {
			@Result(property = "conversationId", column = "conversationid"),
			@Result(property = "conversationMode", column = "conversationmode"),
			@Result(property = "conversationText", column = "conversationtext"),
			@Result(property = "recordingPath", column = "recordingpath"),
			@Result(property = "creationDate", column = "creationdate"),
			@Result(property = "sourceGroupMemberId", column = "sourcegroupmemberid"),
			@Result(property = "targetGroupMemberId", column = "targergroupmemberid") })
	List<GroupMemberConversation> getInteractions(Integer sourceGroupMemberId);

	/**
	 * Creates a new GroupMember and assoicates to Group and MemberRole
	 * 
	 * @param groupMember
	 */
	@Insert({ "insert into clngroupmember"
			+ " (creationdate, islead, isnominated, isvolunteer, memberpersonality, groupid, memberroleid, isdelete) values "
			+ "(sysdate(), #{isLead,jdbcType=BOOLEAN}, #{isNominated,jdbcType=BOOLEAN}, #{isVolunteer,jdbcType=BOOLEAN}, #{memberPersonality,jdbcType=INTEGER},"
			+ " #{groupId,jdbcType=INTEGER}, #{memberRoleId,jdbcType=INTEGER}, 'false' ) " })
	void createGroupMember(GroupMember groupMember);

	/**
	 * Removes the GroupMember association from
	 * GroupMemberConversation(Interaction)
	 * 
	 * @param conversationId
	 */
	@Update({ "update from clngroupmemberconversation set isdelete='true' where conversationid = #{conversationId, jdbcType=INTEGER} " })
	void delete(Integer conversationId);

	/**
	 * Removes the GroupMember association from Group
	 * 
	 * @param groupId
	 * @param groupMemberId
	 */
	@Update({ "update from clngroupmember set isdelete='true' , groupid = #{groupId,jdbcType=INTEGER} , "
			+ "groupmemberid = #{groupMemberId,jdbcType=INTEGER} where conversationid = #{conversationId, jdbcType=INTEGER} " })
	void deleteStudentGroupAssociation(Integer groupId, Integer groupMemberId);

	/**
	 * @param courseId
	 * @param curriculumCourseId
	 * @return
	 */
	@Select({ "select groupid, totalparticipants, name, grouppersonality from clngroup where  "
			+ "courseId = #{courseId, jdbcType=INTEGER} and curriculumCourseId = #{curriculumCourseId, jdbcType=INTEGER} "
			+ "and isdelete = false" })
	@Results(value = {
			@Result(property = "groupId", column = "groupid"),
			@Result(property = "totalParticipants", column = "totalparticipants"),
			@Result(property = "name", column = "name"),
			@Result(property = "groupPersonality", column = "grouppersonality") })
	List<Group> getGroups(Integer courseId, Integer curriculumCourseId);

	
	/**
	 * @param groupId
	 * @return
	 */
	@Select({ "select groupmemberid, islead, isnominated, isvolunteer, totalmembertime, memberpersonality, groupid"
			+ " from clngroupmember  where  groupId = #{groupId, jdbcType=INTEGER} and isdelete = 'false' " })
	@Results(value = {
			@Result(property = "groupMemberId", column = "groupmemberid"),
			@Result(property = "isLead", column = "islead"),
			@Result(property = "isNominated", column = "isnominated"),
			@Result(property = "isVolunteer", column = "isvolunteer"),
			@Result(property = "totalMemberTime", column = "totalmembertime"),
			@Result(property = "memberPersonality", column = "memberpersonality"),
			@Result(property = "groupId", column = "groupid"),
			@Result(property = "group", column = "groupId", javaType = Group.class, one = @One(select = "getGroupById")) })
	List<GroupMember> getGroupMembersByGroupId(Integer groupId);

	
	/**
	 * Creates a new GroupContext for a new Group creation.
	 * @param context
	 * @return
	 */
	@Insert({ "insert into clngroupcontext"
			+ " (creationdate, courseid, curriculumcourseid) values "
			+ "(sysdate(),  #{course.courseId,jdbcType=INTEGER},"
			+ " #{curriculumCourse.curriculumCourseId,jdbcType=INTEGER} ) " })
	@Results(value = {
			@Result(property = "groupContextId", column = "groupcontextid"),
			})
	Integer saveGroupContext(GroupContext context);

	
	/**
	 * Creates a new Group with context Defined
	 * @param group
	 */
	@Insert({ "insert into clngroup"
			+ " (creationdate, name, grouppersonality, contextid) values "
			+ "(sysdate(),  #{name,jdbcType=VARCHAR}, #{groupPersonality,jdbcType=INTEGER},"
			+ " #{groupContext.contextId,jdbcType=INTEGER} ) " })
	void saveGrroup(Group group);

	@Update({ "update from clngroup set isdelete='true'  where groupid = #{groupId, jdbcType=INTEGER} " })
	void deleteGroup(Integer groupId);

	 
	@Select({"select * from clngroupmemberactivity where groupmemberid = #{groupMemberId, jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "groupmemberactivityId", column = "groupmemberactivityid"),
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "memberRole", column = "memberroleid", javaType = MemberPersona.class, one = @One(select = "getMemberRoleById"))
			})
	List<GroupMemberActivity> getGroupActivities(Integer groupMemberId);
	

	@Select({"select * from memmemberrole where memberroleid = #{memberRoleId, jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "member", column = "memberid", javaType = Member.class, one = @One(select = "getMemberById"))
			})
	MemberPersona getMemberRoleById(Integer memberRoleId);
	
	
	@Select({"select * from memmember where memberid = #{memberId, jdbcType=INTEGER}"})
	@Results(value = {
			@Result(property = "memberId", column = "memberid"),
			@Result(property = "firstname", column = "firstname"),
			@Result(property = "lastname", column = "lastname"),
			})
	Member getMemberById(Integer memberId);
	

}
