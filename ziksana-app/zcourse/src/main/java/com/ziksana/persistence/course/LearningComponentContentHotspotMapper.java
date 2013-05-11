package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
			@Result(property="coordinates", column="coordinates"),
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
	void save(LearningComponentContentHotspot hotspot);

	
	/**
	 * Updates the delete indicator to make a soft delete.
	 * @param hotspotId
	 */
	@Update({"update corlearningcomponentcontenthotspot set isdelete = #{isDelete,jdbcType.BIT} where ",
		" componentcontenthotspotid = #{hotspotId,jdbcType=INTEGER}"})
	void delete(Integer hotspotId);
	

	/**
	 * Modifies Hotspot information
	 * @param hotspot
	 */
	void update(LearningComponentContentHotspot hotspot);
	
	

}
