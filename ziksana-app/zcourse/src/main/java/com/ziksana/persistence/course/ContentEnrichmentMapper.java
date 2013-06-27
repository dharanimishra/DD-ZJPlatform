package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.ContentEnrichment;

public interface ContentEnrichmentMapper {

	/**
	 * Saves the ContentEnrichment
	 */
	Integer saveContentEnrichment(ContentEnrichment record);

	/**
	 * Updates the ContentEnrichment
	 */
	ContentEnrichment updateContentEnrichment(ContentEnrichment record);



	@Update({ "update corContentEnrichment set isdelete = true where ID =  #{contentEnrichmentId,jdbcType=INTEGER}" })
	void deleteContentEnrichment(@Param("contentEnrichmentId") Integer contentEnrichmentId);


}