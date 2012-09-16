package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.subscription.CourseActivity;

public interface CourseActivityMapper {
	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	@Delete({ "delete from sbncourseactivity",
			"where ID = #{ID,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer ID);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	@Insert({
			"insert into sbncourseactivity (ID, ActivityDate, ",
			"ActivityType, StartTime, ",
			"EndTime, ZeniSuggestedIndicator, ",
			"FacilitationNeededIndicator, FacilitationCompletedIndicator, ",
			"FacilitationUsedIndicator, SubscriptionCourseId, ",
			"Description)",
			"values (#{ID,jdbcType=INTEGER}, #{activityDate,jdbcType=DATE}, ",
			"#{activityType,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
			"#{endTime,jdbcType=TIMESTAMP}, #{zeniSuggestedIndicator,jdbcType=BIT}, ",
			"#{facilitationNeededIndicator,jdbcType=BIT}, #{facilitationCompletedIndicator,jdbcType=BIT}, ",
			"#{facilitationUsedIndicator,jdbcType=BIT}, #{subscriptionCourseId,jdbcType=INTEGER}, ",
			"#{description,jdbcType=LONGVARCHAR})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "ID", before = true, resultType = Integer.class)
	int insert(CourseActivity record);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	int insertSelective(CourseActivity record);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	@Select({
			"select",
			"ID, ActivityDate, ActivityType, StartTime, EndTime, ZeniSuggestedIndicator, ",
			"FacilitationNeededIndicator, FacilitationCompletedIndicator, FacilitationUsedIndicator, ",
			"SubscriptionCourseId, Description", "from sbncourseactivity",
			"where ID = #{ID,jdbcType=INTEGER}" })
	@ResultMap("ResultMapWithBLOBs")
	CourseActivity selectByPrimaryKey(Integer ID);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	int updateByPrimaryKeySelective(CourseActivity record);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	@Update({
			"update sbncourseactivity",
			"set ActivityDate = #{activityDate,jdbcType=DATE},",
			"ActivityType = #{activityType,jdbcType=INTEGER},",
			"StartTime = #{startTime,jdbcType=TIMESTAMP},",
			"EndTime = #{endTime,jdbcType=TIMESTAMP},",
			"ZeniSuggestedIndicator = #{zeniSuggestedIndicator,jdbcType=BIT},",
			"FacilitationNeededIndicator = #{facilitationNeededIndicator,jdbcType=BIT},",
			"FacilitationCompletedIndicator = #{facilitationCompletedIndicator,jdbcType=BIT},",
			"FacilitationUsedIndicator = #{facilitationUsedIndicator,jdbcType=BIT},",
			"SubscriptionCourseId = #{subscriptionCourseId,jdbcType=INTEGER},",
			"Description = #{description,jdbcType=LONGVARCHAR}",
			"where ID = #{ID,jdbcType=INTEGER}" })
	int updateByPrimaryKeyWithBLOBs(CourseActivity record);

	/**
	 * This method corresponds to the database table sbncourseactivity
	 */
	@Update({
			"update sbncourseactivity",
			"set ActivityDate = #{activityDate,jdbcType=DATE},",
			"ActivityType = #{activityType,jdbcType=INTEGER},",
			"StartTime = #{startTime,jdbcType=TIMESTAMP},",
			"EndTime = #{endTime,jdbcType=TIMESTAMP},",
			"ZeniSuggestedIndicator = #{zeniSuggestedIndicator,jdbcType=BIT},",
			"FacilitationNeededIndicator = #{facilitationNeededIndicator,jdbcType=BIT},",
			"FacilitationCompletedIndicator = #{facilitationCompletedIndicator,jdbcType=BIT},",
			"FacilitationUsedIndicator = #{facilitationUsedIndicator,jdbcType=BIT},",
			"SubscriptionCourseId = #{subscriptionCourseId,jdbcType=INTEGER}",
			"where ID = #{ID,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CourseActivity record);
}