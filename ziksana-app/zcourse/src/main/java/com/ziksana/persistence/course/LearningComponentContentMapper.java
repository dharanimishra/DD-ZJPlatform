package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public interface LearningComponentContentMapper {
	/**
	 * This method corresponds to the database table
	 * corlearningcomponentcontent
	 */
	@Delete({ "delete from corlearningcomponentcontent",
			"where learningcomponentcontentid = #{learningComponentContentId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer learningComponentContentId);


	/**
	 * This method corresponds to the database table
	 * corlearningcomponentcontent
	 */
	int insertSelective(LearningComponentContent record);

	/**
	 * This method corresponds to the database table
	 * corlearningcomponentcontent
	 */
	@Select({
			"select",
			"learningcomponentcontentid, creationdate, coursestatus, contenttype, contentdescription, active, contentversionused,",
			" learningcomponentid, synchronizewithvideoid, learningcontentid",
			"from corlearningcomponentcontent",
			"where learningcomponentcontentid = #{learningComponentContentId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningComponentContent selectByPrimaryKey(Integer learningComponentContentId);

	/**
	 * This method corresponds to the database table
	 * corlearningcomponentcontent
	 */
	int updateByPrimaryKeySelective(LearningComponentContent record);

	/**
	 * This method corresponds to the database table
	 * corlearningcomponentcontent
	 */
	@Update({
			"update corlearningcomponentcontent",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"CourseStatus = #{courseStatus,jdbcType=INTEGER},",
			"ContentType = #{contentType,jdbcType=INTEGER},",
			"ContentDescription = #{contentDescription,jdbcType=VARCHAR},",
			"Active = #{active,jdbcType=BIT},",
			"ContentVersionUsed = #{contentVersionUsed,jdbcType=INTEGER}, ",
			"LearningComponentId = #{learningComponentId,jdbcType=INTEGER}, ",
			"SynchronizeWithVideoId =#{synchronizeWithVideoId,jdbcType=INTEGER}, ",
			"LearningContentId = #{learningContentId,jdbcType=INTEGER} ",
			"where learningComponentContentId = #{learningComponentContentId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningComponentContent record);
	
	
	/**
	 * This method saves the learning component content to the database
	 */
	@Insert({
			"insert into corlearningcomponentcontent (learningcomponentcontentid, creationdate, ",
			"coursestatus, contenttype, ",
			"contentdescription, active, ",
			"contentversionused, learningcomponentid, synchronizewithvideoid, learningcontentid )",
			"values (#{learningComponentContentId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{courseStatus,jdbcType=INTEGER}, #{contentType,jdbcType=INTEGER}, ",
			"#{contentDescription,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, ",
			"#{contentVersionUsed,jdbcType=INTEGER}, ",
			"#{learningComponentId,jdbcType=INTEGER}, ",
			"#{synchronizeWithVideoId,jdbcType=INTEGER}, ",
			"#{learningContentId,jdbcType=INTEGER} )" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "learningComponentContentId", before = true, resultType = Integer.class)
	@ResultMap("BaseResultMap")
	LearningComponentContent saveLearningComponentContent(LearningComponentContent learningComponentContent);
	

	@Select({"select learningcomponentcontentid from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	Integer getCompContentByLComponentId(ZID learningComponentId);

	@Select({"select learningcontentid from corlearningcomponentcontent where learningcomponentid = #{learningComponentId,jdbcType.INTEGER}"})
	Integer getContentByLComponentId(IntegerZID lCompId);

}