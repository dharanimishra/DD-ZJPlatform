package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningContentParts;

public interface LearningContentPartsMapper {
	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	@Delete({ "delete from corlearningcontentparts",
			"where contentpartsid = #{contentPartsId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer contentPartsId);

	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	@Insert({
			"insert into corlearningcontentparts (contentpartsid, creationdate, ",
			"partpath, partsequence, learningcontentid)",
			"values (#{contentPartsId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{partPath,jdbcType=VARCHAR}, #{learningContentId,jdbcType=INTEGER})" })
	@ResultMap("BaseResultMap")
	LearningContentParts save(LearningContentParts record);

	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	int insertSelective(LearningContentParts record);

	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	@Select({ "select contentpartsid, creationdate, partpath, partsequence, learningcontentid from corlearningcontentparts",
			"where contentpartsid = #{contentPartsId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	LearningContentParts selectByPrimaryKey(Integer contentPartsId);

	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	int updateByPrimaryKeySelective(LearningContentParts record);

	/**
	 * . This method corresponds to the database table corlearningcontentparts
	 */
	@Update({ "update corlearningcontentparts",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"PartPath = #{partPath,jdbcType=VARCHAR},",
			"PartSequence = #{partsequence,jdbcType=INTEGER}, ",
			"LearningContentId = #{learningContentId,jdbcType=INTEGER} ",
			"where contentPartsId = #{contentPartsId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(LearningContentParts record);
}