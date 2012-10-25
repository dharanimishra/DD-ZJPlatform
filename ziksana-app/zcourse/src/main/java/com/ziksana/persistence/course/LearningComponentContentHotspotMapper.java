package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponentContentHotspot;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 *
 */
public interface LearningComponentContentHotspotMapper {
	
	
	/**Retrieves the list of hostpots based on LearningComponentContentId
	 * @param learningComponentContentId
	 * @return
	 */
	@Select({"select createdate, coordeinates, name, description, active, learningcomponentcontentid, memberroleid from corlearningcomponentcontenthotspot ", 
		" where learningcomponentcontentid = #{learningComponentContentId,jdbcType=INTEGER}"})
	@ResultMap("BaseResultMap")
	List<LearningComponentContentHotspot> getHotspotList(ZID learningComponentContentId);
	
	/**Saves the component content's Hotspot.
	 * @param hotspot
	 */
	@Insert({"insert into corlearningcomponentcontenthotspot (createdate, coordeinates, name, description, active, learningcomponentcontentid, memberroleid) ",
		" values (#{createdate,jdbcType.TIMESTAMP},  #{coordeinates,jdbcType.VARCHAR}, #{name,jdbcType.VARCHAR}, #{description,jdbcType.VARCHAR},",
		" #{avtive,jdbcType.BIT},  #{learningcomponentcontentid,jdbcType.INTEGER}, #{memberroleid,jdbcType.INTEGER},)"})
	void save(LearningComponentContentHotspot hotspot);

	/**
	 * Updates the delete indicator to make a soft delete.
	 * @param hotspotId
	 */
	@Update({"update corlearningcomponentcontenthotspot set deleteIndicator = #{deleteIndicator,jdbcType.BIT} where componentcontenthotspotid = #{hotspotId,jdbcType=INTEGER}"})
	void delete(ZID hotspotId);

	@Update({"update corlearningcomponentcontenthotspot set  where componentcontenthotspotid = #{hotspotId,jdbcType=INTEGER}"})
	void update(LearningComponentContentHotspot hotspot);
	
	

}
