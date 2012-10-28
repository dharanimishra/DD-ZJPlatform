package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;

import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.LearningContentParts;

public interface LearningContentMapper {

	/**
	 * Saves the Learning Content
	 */
	@Insert({
			"insert into corlearningcontent (creationdate, ",
			"active, contenttype, contentpath, contentformat, ",
			"status, version, contentname, contentdescription, thumbnailpicturepath, ",
			"rightsowningmemberroleid, authoringmemberroleid, subjclassificationid, linkedlearningcontentid)",
			"values (sysdate(), #{active,jdbcType=BIT}, #{contentType,jdbcType=INTEGER}, ",
			"#{contentPath,jdbcType=VARCHAR}, #{contentFormat,jdbcType=INTEGER}, ",
			"#{status,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, #{contentName,jdbcType=VARCHAR}, ",
			"#{contentDescription,jdbcType=VARCHAR}, #{thumbnailPicturePath,jdbcType=VARCHAR}, ",
			"#{rightsOwningMemberRoleId,jdbcType=INTEGER}, #{authoringMemberRoleId,jdbcType=INTEGER}, ",
			"#{subjClassificationId,jdbcType=INTEGER}, #{linkedLearningContentId,jdbcType=INTEGER}  )" })
	@SelectKey(statement = "select last_insert_id()", keyProperty = "learningcontentid", before = true, resultType = Integer.class)
	@Results(value={
			@Result(property="learningcontentid", column="contentpartsid"),
			@Result(property="partPath", column="partpath"),
			@Result(property="partSequence", column="partsequence"),
			@Result(property="learningContent.learningContentId", column="learningcontentid")
	})
	LearningContent save(LearningContent record);
	
	
	/**
	 * Saves the learningcontentparts
	 */
	@Insert({
			"insert into corlearningcontentparts (creationdate, ",
			"partpath, partsequence, learningcontentid)",
			"values (sysdate(), ",
			"#{partPath,jdbcType=VARCHAR}, #{learningContentId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "contentpartsid", before = true, resultType = Integer.class)
	@Results(value={
			@Result(property="contentPartsId", column="contentpartsid"),
			@Result(property="partPath", column="partpath"),
			@Result(property="partSequence", column="partsequence"),
			@Result(property="learningContent.learningContentId", column="learningcontentid")
	})
	LearningContentParts save(LearningContentParts contentParts);



}