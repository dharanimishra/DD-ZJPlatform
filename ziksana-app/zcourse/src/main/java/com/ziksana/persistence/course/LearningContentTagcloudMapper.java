package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.LearningContentTagcloud;
import com.ziksana.domain.course.ReferenceSearchCriteria;

/**
 * @author bhashasp
 */
public interface LearningContentTagcloudMapper {
	
	
	@Select({"select * from corlearningcontenttagcloud where tagname like  % #{tags,jdbcType.VARCHAR} % "})
	List<LearningContentTagcloud> searchReferenceMaterial(ReferenceSearchCriteria searchCriteria);

}
