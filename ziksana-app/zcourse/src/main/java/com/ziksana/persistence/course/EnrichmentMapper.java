package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.Enrichment;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public interface EnrichmentMapper {

	/**
	 * This method saves the Course information to corcourse table
	 */
	@Insert({
			"insert into corApplyEnrichment ( creationdate, active, visibility, overrideat, learningcontentid, learningcomponentid, ",
			"courseid, curriculumcourseid, creatormemberroleid) ",
			"values (#{creationdate,jdbcType=TIMESTAMP}, ",
			"#{active,jdbcType=BIT}, ",
			"#{visibility,jdbcType=INTEGER}, ",
			"#{overrideat,jdbcType=INTEGER}, ",
			"#{learningcontentid,jdbcType=INTEGER}, ",
			"#{learningcomponentid,jdbcType=INTEGER}, ",
			"#{courseid,jdbcType=BIT}, #{curriculumcourseid,jdbcType=INTEGER},#{memberroleid,jdbcType=VARCHAR})" })
	@ResultMap("BaseResultMap")
	Enrichment saveReference(Enrichment enrich);
	
	
	/**
	 * updates delete indicator to remove the association with content
	 * @param enrichment
	 */
	@Update({"update corApplyEnrichment set deleteIndicator = #{deleteIndictor,jdbcType=BIT} where enrichmentid = #{enrichId,jdbcType=INTEGER}"})
	void delete(Enrichment enrichment);

	@Select({"select * from corApplyEnrichment where creatormemberroleid = #{memberPersonaId,jdbcType=INTEGER}"})
	List<Enrichment> getAllEnrichments(ZID memberPersonaId);



	@Select({"select enrichmentId from corApplyEnrichment where learningcomponentid = #{learningcomponentid,jdbcType=INTEGER} ",
				" or learningContentId = #{learningContentId,jdbcType=INTEGER}"})
	Integer getEnrichByContentIdOrComponentId(IntegerZID lCompId,
			Integer learningContentId);



}
