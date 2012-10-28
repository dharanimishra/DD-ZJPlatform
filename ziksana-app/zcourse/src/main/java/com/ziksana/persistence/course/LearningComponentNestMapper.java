package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import com.ziksana.domain.course.LearningComponentNest;

public interface LearningComponentNestMapper {

	/**
	 * Saves the learningcomponentnest
	 */
	@Insert({
			"insert into corlearningcomponentnest (creationdate, ",
			"nestlevel, parentlearningcomponentid, ",
			"nestlearningcomponentid)",
			"values (sysdate(), ",
			"#{nestLevel,jdbcType=INTEGER}, #{parentLearningComponentId,jdbcType=INTEGER}, ",
			"#{nestLearningComponentId,jdbcType=INTEGER})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "componentnestid", before = true, resultType = Integer.class)
	void save(LearningComponentNest record);

}