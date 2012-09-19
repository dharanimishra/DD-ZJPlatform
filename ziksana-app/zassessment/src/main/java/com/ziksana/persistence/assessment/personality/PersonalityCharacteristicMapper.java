package com.ziksana.persistence.assessment.personality;

import com.ziksana.domain.assessment.personality.PersonalityCharacteristic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PersonalityCharacteristicMapper {

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	@Delete({ "delete from pstcharacteristic",
			"where CharacteristicId = #{characteristicId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer characteristicId);

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	@Insert({
			"insert into pstcharacteristic (CharacteristicId, Type, ",
			"Name, Value, Description, ",
			"Version, Active, CategoryId)",
			"values (#{characteristicId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
			"#{name,jdbcType=INTEGER}, #{value,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
			"#{version,jdbcType=INTEGER}, #{active,jdbcType=BIT}, #{categoryId,jdbcType=INTEGER})" })
	int insert(PersonalityCharacteristic record);

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	int insertSelective(PersonalityCharacteristic record);

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	@Select({
			"select",
			"CharacteristicId, Type, Name, Value, Description, Version, Active, CategoryId",
			"from pstcharacteristic",
			"where CharacteristicId = #{characteristicId,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	PersonalityCharacteristic selectByPrimaryKey(Integer characteristicId);

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	int updateByPrimaryKeySelective(PersonalityCharacteristic record);

	/**
	 * This method corresponds to the database table pstcharacteristic
	 */
	@Update({ "update pstcharacteristic",
			"set Type = #{type,jdbcType=INTEGER},",
			"Name = #{name,jdbcType=INTEGER},",
			"Value = #{value,jdbcType=VARCHAR},",
			"Description = #{description,jdbcType=VARCHAR},",
			"Version = #{version,jdbcType=INTEGER},",
			"Active = #{active,jdbcType=BIT},",
			"CategoryId = #{categoryId,jdbcType=INTEGER}",
			"where CharacteristicId = #{characteristicId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(PersonalityCharacteristic record);
}