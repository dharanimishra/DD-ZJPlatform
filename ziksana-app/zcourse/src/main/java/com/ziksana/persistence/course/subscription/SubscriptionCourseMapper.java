package com.ziksana.persistence.course.subscription;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.subscription.CourseItemProgress;
import com.ziksana.domain.course.subscription.MemberSubscriptionProgram;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.domain.member.Member;

/**
 * @author Ratnesh Kumar
 */
public interface SubscriptionCourseMapper {

	@Select({ " select id from sbnsubscriptioncourse where curriculumcourseid = #{currCourseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "subscriptioncourseid", column = "id"),
			@Result(property = "courseItemProgressList", column = "subscriptioncourseid", javaType = List.class, many = @Many(select = "getCourseItemsProgress")) })
	SubscriptionCourse getSubscribedStudentsInfo(Integer currCourseId);

	@Select({ "select * from corcourseitemprogress where subscriptioncourseid = #{subscriptionCourseId,jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "courseitemprogressid", column = "courseitemprogressid"),
			@Result(property = "duration", column = "totaltimespent"),
			@Result(property = "progress", column = "degreeofcompletion") })
	List<CourseItemProgress> getCourseItemsProgress(Integer subscriptionCourseId);

	@Select({ " select id, memberroleid from sbnmembersubscriptionprogram  where "
			+ " learningprogramid = #{learningProgramId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "subscriptionProgramId", column = "id"),
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "Member", column = "memberroleid", javaType = Member.class, one = @One(select = "getMemberByRoleId")) })
	List<MemberSubscriptionProgram> getMemberSubscriptionPrograms(
			Integer learningProgramId);

	@Select({ " select m.* from memmemberrole mr, memmember m  where "
			+ " m.memberid = mr.id and mr.memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "memberRoleId", column = "memberroleid") })
	Member getMemberByRoleId(Integer memberRoleId);

	@Select({ " select id, memberroleid from sbnmembersubscriptionprogram  where "
			+ " learningprogramid = #{learningProgramId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "subscriptionProgramId", column = "id"),
			@Result(property = "memberRoleId", column = "memberroleid"),
			@Result(property = "Member", column = "memberroleid", javaType = Member.class, one = @One(select = "getMemberByRoleId")) })
	List<MemberSubscriptionProgram> getCoursePerformance(
			Integer learningProgramId);

}
