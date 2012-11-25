package com.ziksana.persistence.assessment;

import com.ziksana.domain.assessment.VisualSpot;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VisualSpotMapper {/*

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	@Delete({ "delete from asmvisualspot",
			"where VisualSpotId = #{visualSpotId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer visualSpotId);

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	@Insert({
			"insert into asmvisualspot (VisualSpotId, CreationDate, ",
			"VisualSize, SpotRelativeCoordinate, ",
			"QuestionLabelText, Active, ",
			"QuestionVisualId)",
			"values (#{visualSpotId,jdbcType=INTEGER}, #{creationDate,jdbcType=TIMESTAMP}, ",
			"#{visualSize,jdbcType=VARCHAR}, #{spotRelativeCoordinate,jdbcType=VARCHAR}, ",
			"#{questionLabelText,jdbcType=VARCHAR}, #{active,jdbcType=BIT}, ",
			"#{questionVisualId,jdbcType=INTEGER})" })
	int insert(VisualSpot record);

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	int insertSelective(VisualSpot record);

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	@Select({
			"select",
			"VisualSpotId, CreationDate, VisualSize, SpotRelativeCoordinate, QuestionLabelText, ",
			"Active, QuestionVisualId", "from asmvisualspot",
			"where VisualSpotId = #{visualSpotId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	VisualSpot selectByPrimaryKey(Integer visualSpotId);

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	int updateByPrimaryKeySelective(VisualSpot record);

	*//**
	 * This method corresponds to the database table asmvisualspot
	 *//*
	@Update({
			"update asmvisualspot",
			"set CreationDate = #{creationDate,jdbcType=TIMESTAMP},",
			"VisualSize = #{visualSize,jdbcType=VARCHAR},",
			"SpotRelativeCoordinate = #{spotRelativeCoordinate,jdbcType=VARCHAR},",
			"QuestionLabelText = #{questionLabelText,jdbcType=VARCHAR},",
			"Active = #{active,jdbcType=BIT},",
			"QuestionVisualId = #{questionVisualId,jdbcType=INTEGER}",
			"where VisualSpotId = #{visualSpotId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(VisualSpot record);
*/}