package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentEnrichment;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 *
 */
public interface ContentEnrichmentMapper {

	@Insert({"insert into (StartTime, EndTime, LinkType, LinkElement, InternalIndicator,LinkDescription, ",
		"LinkItemAuthor, LinkItemCost, LinkSource, Active, DeleteIndicator, enrichmentid ) values (#{startTime,jdbcType.TIMESTAMP},",
		"#{endTmie,jdbcType.TIMESTAMP},  #{linkType,jdbcType.INTEGER}, #{linkElement,jdbcType.VARCHAR}, #{linkItemCost,jdbcType.INTEGER}, #{linkSource,jdbcType.INTEGER},",
		" #{avtive,jdbcType.BIT}, #{isDelete,jdbcType.BIT}, #{enrichmentId,jdbcType.INTEGER},)"})
	void saveRefenceContent(ContentEnrichment contentEnrichment);

	/**
	 * Removes the association of contentenrichment with content.
	 * @param contentEnrichment
	 */
	@Update({"update corContentEnrichment set deleteIndicator = #{deleteIndictor,jdbcType=BIT} where ",
		      " contentenrichmentid = #{contentEnrichmentId,jdbcType=INTEGER}"})
	void delete(ContentEnrichment contentEnrichment);

	@Update({"update corContentEnrichment set  where contentenrichmentid = #{contentEnrichmentId,jdbcType.INTEGER}"})
	void update(ContentEnrichment contentEnrichment);

	@Select({" select StartTime, EndTime, LinkType, LinkElement, InternalIndicator,LinkDescription, ",
		"LinkItemAuthor, LinkItemCost, LinkSource, Active, DeleteIndicator, enrichmentid from corContentEnrichment ",
		" where enrichmentid = #{enrichId,jdbcType.INTEGER}"})
	@ResultMap("ResultMap")
	List<ContentEnrichment> getAllContentEnrichments(ZID enrichId);

}
