package com.ziksana.persistence.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.LearningComponent;

public interface LearningComponentMapper {
	/**
	 * This method saves the Learning component
	 * 
	 * @param component
	 * @return
	 */
	Integer saveLearningComponent(LearningComponent component);

	/**
	 * Updates the existing LearningComponent
	 * 
	 * @param component
	 * @return
	 */
	Integer updateLearningComponent(LearningComponent component);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select learningcomponentid, name, description, coursestatus,learningcomponenttypeid, memberroleid, prescribedlcduration, prescribedlcdurationunit"
			+ " from corlearningcomponent where memberroleid =  #{memberRoleId,jdbcType=INTEGER} and islearningobject = #{isLearningObject,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "learningComponentId", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit") })
	List<LearningComponent> getLearningObjects(Boolean isLearningObject,
			Integer memberRoleId);

	/**
	 * @param isLearningObject
	 * @param integer
	 * @return
	 */
	@Select({ "select learningcomponentid, name, description, coursestatus,learningcomponenttypeid, memberroleid, prescribedlcduration, prescribedlcdurationunit"
			+ " from corlearningcomponent where learningcomponentid =  #{learningComponentId,jdbcType=INTEGER} and islearningobject = #{isLearningObject,jdbcType=BOOLEAN}" })
	@Results(value = {
			@Result(property = "learningComponentId", column = "learningcomponentid"),
			@Result(property = "authoredMember.memberRoleId", column = "memberroleid"),
			@Result(property = "name", column = "name"),
			@Result(property = "description", column = "description"),
			@Result(property = "courseStatus", column = "coursestatus"),
			@Result(property = "learningComponentType.learningComponentTypeId", column = "learningcomponenttypeid"),
			@Result(property = "duration.duration", column = "prescribedlcduration"),
			@Result(property = "duration.durationUnits", column = "prescribedlcdurationunit") })
	LearningComponent getLearningObjectById(Boolean isLearningObject,
			Integer learningComponentId);

	@Update({ " update corlearningcomponent set isdelete = #{isdelete, jdbcType=BOOLEAN} where learningcomponentid =  #{learningComponentId,jdbcType=INTEGER}" })
	void delete(Boolean isDelete, Integer learningComponentId);

	@Update({ "update corlearningcomponent set isDelete = true where ID =  #{learningComponentId,jdbcType=INTEGER}" })
	void learningComponentdelete(Integer learningComponentId);

	List<LearningComponent> getComponentsByCourseId(Integer courseId);

	@Select({ "select ID from corcourselearningcomponent where LearningComponentId=#{learningComponentId,jdbcType=INTEGER}" })
	Integer getComponentsByCourseComponentId(Integer learningComponentId);

	LearningComponent getLearningComponent(Integer id);
}
