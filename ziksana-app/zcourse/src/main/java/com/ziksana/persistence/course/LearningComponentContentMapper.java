package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContent;

public interface LearningComponentContentMapper {
	/**
	 * This method saves the learning component content
	 */
	@Insert({
			"insert into corlearningcomponentcontent (creationdate, ",
			"coursestatus, contenttype, ",
			"contentdescription, active, ",
			"contentversionused, learningcomponentid, synchronizewithvideoid, learningcontentid )",
			"values (sysdate(), ",
			"#{courseStatus,jdbcType=INTEGER}, #{contentType,jdbcType=INTEGER}, ",
			"#{contentDescription,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, ",
			"#{contentVersionUsed,jdbcType=INTEGER}, ",
			"#{learningComponentId,jdbcType=INTEGER}, ",
			"#{synchronizeWithVideoId,jdbcType=INTEGER}, ",
			"#{learningContentId,jdbcType=INTEGER} )" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "learningcomponentcontentid", before = true, resultType = Integer.class)
	@Results(value = {
			@Result(property = "learningcomponentcontentid", column = "learningComponentContentId"),
			@Result(property = "coursestatus", column = "courseStatus"),
			@Result(property = "compContentType", column = "contenttype"),
			@Result(property = "contentDescription", column = "contentdescription"),
			@Result(property = "isLearningObject", column = "learningobjectindicator"),
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid")
	})
	LearningComponentContent saveLearningComponentContent(LearningComponentContent learningComponentContent);
	


	@Select({"select learningcomponentcontentid from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	@Results(value = {
			@Result(property = "learningcomponentcontentid", column = "learningComponentContentId"),
	})
	Integer getCompContentByLComponentId(Integer learningComponentId);

	
	@Select({"select learningcontentid from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	@Results(value = {
			@Result(property = "learningComponent.learningComponentId", column = "learningcomponentid")
	})
	Integer getContentByLComponentId(Integer learningComponentId);



	@Select({"select learningcomponentcontentid from corlearningcomponentcontent where isdelete = #{isdelete, jdbcType=BOOLEAN}" +
			" and learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	@Results(value = {
			@Result(property = "learningcomponentcontentid", column = "learningComponentContentId"),
	})
	List<Integer> getLearningComponentContentByComponentId(
			Integer learningComponentId, Boolean isDelete);


	@Update({"update corlearningcomponentcontent set isdelete = #{isDelete, jdbcType=BOOLEAN} where " +
			"learningcomponentcontentId = #{learningComponentContentId, jdbcType=INTEGER}" })
	void delete(Integer learningComponentContentId, Boolean isDelete);

}