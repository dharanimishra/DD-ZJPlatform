package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContentHotspot;

/**
 * @author bhashasp
 */
public interface LearningComponentContentHotspotMapper {
	
	
	/**Retrieves the list of hostpots based on LearningComponentContentId
	 * @param learningComponentContentId
	 * @return
	 */
	@Select({"select componentcontenthotspotid, createdate, coordeinates, name, description, active, learningcomponentcontentid, memberroleid from corlearningcomponentcontenthotspot ", 
		" where learningcomponentcontentid = #{learningComponentContentId,jdbcType=INTEGER}"})
	@Results(value={
			@Result(property="componentContentHotspotId", column="componentcontenthotspotid"),
			@Result(property="createdate", column="createdate"),
			@Result(property="coordinate", column="coordinates"),
			@Result(property="name", column="name"),
			@Result(property="description", column="description"),
			@Result(property="active", column="active"),
			@Result(property="learningComponentContent.learningComponentContentId", column="learningcomponentcontentid"),
			@Result(property="memberPersona.memberRoleId", column="memberroleid")
	})
	List<LearningComponentContentHotspot> getHotspotList(Integer learningComponentContentId);
	
	
	/**
	 * Saves the component content's Hotspot.
	 * @param hotspot
	 */
	@Insert({"insert into corlearningcomponentcontenthotspot (createdate, coordeinates, name, description, active, learningcomponentcontentid, memberroleid) ",
		" values (sysdate(),  #{coordeinates,jdbcType.VARCHAR}, #{name,jdbcType.VARCHAR}, #{description,jdbcType.VARCHAR},",
		" #{active,jdbcType.BIT},  #{learningcomponentcontentid,jdbcType.INTEGER}, #{memberroleid,jdbcType.INTEGER},)"})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "componentcontenthotspotid", before = true, resultType = Integer.class)
	void save(LearningComponentContentHotspot hotspot);

	
	/**
	 * Updates the delete indicator to make a soft delete.
	 * @param hotspotId
	 */
	@Update({"update corlearningcomponentcontenthotspot set deleteIndicator = #{deleteIndicator,jdbcType.BIT} where ",
		" componentcontenthotspotid = #{hotspotId,jdbcType=INTEGER}"})
	void delete(Integer hotspotId);
	

	/**
	 * Modifies Hotspot information
	 * @param hotspot
	 */
	@Update({"update corlearningcomponentcontenthotspot set coordeinates= #{coordeinates,jdbcType.VARCHAR}, name = #{name,jdbcType.VARCHAR}, ",
		" description = #{description,jdbcType.VARCHAR}  where componentcontenthotspotid = #{componentContentHotspotId,jdbcType=INTEGER}"})
	void update(LearningComponentContentHotspot hotspot);
	
	

}
