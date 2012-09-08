package com.springs.persistence;

import com.springs.domain.ComponentNest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ComponentNestMapper {
	/**
	 * This method corresponds to the database table componentnest
	 */
	@Delete({ "delete from componentnest",
			"where nestid = #{nestid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer nestid);

	/**
	 * This method corresponds to the database table componentnest
	 */
	@Insert({ "insert into componentnest (nestid, description)",
			"values (#{nestid,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})" })
	int insert(ComponentNest record);

	/**
	 * This method corresponds to the database table componentnest
	 */
	int insertSelective(ComponentNest record);

	/**
	 * This method corresponds to the database table componentnest
	 */
	@Select({ "select", "nestid, description", "from componentnest",
			"where nestid = #{nestid,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	ComponentNest selectByPrimaryKey(Integer nestid);

	/**
	 * This method corresponds to the database table componentnest
	 */
	int updateByPrimaryKeySelective(ComponentNest record);

	/**
	 * This method corresponds to the database table componentnest
	 */
	@Update({ "update componentnest",
			"set description = #{description,jdbcType=VARCHAR}",
			"where nestid = #{nestid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(ComponentNest record);
}