package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

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
			@Result(property="learningContentId", column="contentpartsid"),
			@Result(property="contentPath", column="contentpath"),
			@Result(property="contentName", column="contentname"),
			@Result(property="contentType", column="contenttype"),
			@Result(property="contentFormat", column="contentformat"),
			@Result(property="rightsOwningMemberRoleId", column="rightsowningmemberroleid"),
			@Result(property="thumbnailPicturePath", column="thumbnailpicturepath"),
			@Result(property="contentDescription", column="contentdescription")
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


	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({"select learningcontentid, contentpath, contentformat, ",
			"contentname, contentdescription, thumbnailpicturepath, ",
			"rightsowningmemberroleid from corlearningcontent where rightsowningmemberroleid = #{memberRoleId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="learningContentId", column="contentpartsid"),
			@Result(property="contentPath", column="contentpath"),
			@Result(property="contentName", column="contentname"),
			@Result(property="contentType", column="contenttype"),
			@Result(property="contentFormat", column="contentformat"),
			@Result(property="rightsOwningMemberRoleId", column="rightsowningmemberroleid"),
			@Result(property="thumbnailPicturePath", column="thumbnailpicturepath"),
			@Result(property="contentDescription", column="contentdescription")
	})
	List<LearningContent> getListOfContentsByMemberRoleId(Integer memberRoleId);


	@Update({" update corlearningcontent set isdelete = #{isdelete, jdbcType=BOOLEAN} where learningcontentid =  #{learningContentId,jdbcType=INTEGER}"})
	void deleteContent(Boolean isDelete, Integer learningContentId);

	@Select({"select learningcontentpartsid from corlearningcontentparts where learningcontentid = #{learningContentId,jdbcType=INTEGER}"})
	List<Integer> getLearningContetPartsByContentId(Integer integer);

	@Update({"update corlearningcontentparts set isdelete = #{isdelete, jdbcType=BOOLEAN} where learningcontentpartsid = #{learningContentPartsId,jdbcType=INTEGER}"})
	void deleteContentParts(Boolean isDelete, Integer learningContentPartsId);



}