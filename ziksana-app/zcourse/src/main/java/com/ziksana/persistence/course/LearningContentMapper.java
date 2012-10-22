package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningContent;

public interface LearningContentMapper {
	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	@Delete({ "delete from corlearningcontent",
			"where learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer learningContentId);

	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	@Insert({
			"insert into corlearningcontent (learningcontentid, creationdate, ",
			"active, contenttype, ",
			"contentpath, contentformat, ",
			"status, version, contentname, contentdescription, thumbnailpicturepath, ",
			"rightsowningmemberroleid, authoringmemberroleid, subjclassificationid, linkedlearningcontentid)",
			"values (#{learningContentId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, #{contentType,jdbcType=INTEGER}, ",
			"#{contentPath,jdbcType=VARCHAR}, #{contentFormat,jdbcType=INTEGER}, ",
			"#{status,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, #{contentName,jdbcType=VARCHAR}, ",
			"#{contentDescription,jdbcType=VARCHAR}, #{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{rightsOwningMemberRoleId,jdbcType=INTEGER}, #{authoringMemberRoleId,jdbcType=INTEGER}, ",
			"#{subjClassificationId,jdbcType=INTEGER}, #{linkedLearningContentId,jdbcType=INTEGER}  )" })
	@SelectKey(statement = "select last_insert_id()", keyProperty = "learningContentId", before = true, resultType = Integer.class)
	@ResultMap("BaseResultMap")
	LearningContent save(LearningContent record);

	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	int insertSelective(LearningContent record);

	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	@Select({
			"select",
			"learningcontentid, creationdate, active, contenttype, contentpath, contentformat, status, version, ",
			"contentname, contentdescription, thumbnailpicturepath, rightsowningmemberroleid, ",
			"authoringmemberroleid, subjclassificationid, linkedlearningcontentid ",
			"from corlearningcontent where learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningContent selectByPrimaryKey(Integer learningContentId);

	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	int updateByPrimaryKeySelective(LearningContent record);

	/**
	 * This method corresponds to the database table corlearningcontent
	 */
	@Update({ "update corlearningcontent",
			"set creationdate = #{creationDate,jdbcType=TIMESTAMP},",
			"active = #{active,jdbcType=BIT},",
			"contenttype = #{contentType,jdbcType=INTEGER},",
			"contentpath = #{contentPath,jdbcType=VARCHAR},",
			"contentformat = #{contentFormat,jdbcType=INTEGER},",
			"status = #{status,jdbcType=INTEGER},",
			"version = #{version,jdbcType=INTEGER},",
			"contentname = #{contentName,jdbcType=VARCHAR}, ",
			"contentdescription = #{contentDescription,jdbcType=VARCHAR},",
			"thumbnailpicturepath = #{thumbnailPicturePath,jdbcType=VARCHAR},",
			"rightsowningmemberroleid = #{rightsOwningMemberRoleId,jdbcType=INTEGER},",
			"authoringmemberroleid = #{authoringMemberRoleId,jdbcType=INTEGER},",
			"subjclassificationid = #{subjClassificationId,jdbcType=INTEGER}, ",
			"linkedlearningcontentid = #{linkedLearningContentId,jdbcType=INTEGER}",
			"where learningcontentid = #{learningContentId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningContent record);
}