package com.springs.persistence;

import com.springs.domain.ComponentType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ComponentTypeMapper {
	/**
	 * This method corresponds to the database table componenttype
	 */
	@Delete({ "delete from componenttype",
			"where componenttypeid = #{componenttypeid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer componenttypeid);

	/**
	 * This method corresponds to the database table componenttype
	 */
	@Insert({
			"insert into componenttype (componenttypeid, name, ",
			"description)",
			"values (#{componenttypeid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
			"#{description,jdbcType=VARCHAR})" })
	int insert(ComponentType record);

	/**
	 * This method corresponds to the database table componenttype
	 */
	int insertSelective(ComponentType record);

	/**
	 * This method corresponds to the database table componenttype
	 */
	@Select({ "select", "componenttypeid, name, description",
			"from componenttype",
			"where componenttypeid = #{componenttypeid,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	ComponentType selectByPrimaryKey(Integer componenttypeid);

	/**
	 * This method corresponds to the database table componenttype
	 */
	int updateByPrimaryKeySelective(ComponentType record);

	/**
	 * This method corresponds to the database table componenttype
	 */
	@Update({ "update componenttype", "set name = #{name,jdbcType=VARCHAR},",
			"description = #{description,jdbcType=VARCHAR}",
			"where componenttypeid = #{componenttypeid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(ComponentType record);

	String getCompTypeById(Integer compTypeId);

	Integer getCompTypeByName(String componetType);
}