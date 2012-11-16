package com.ziksana.persistence.assessment.engagement;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.assessment.engagement.EngagementCriteria;

/**
 * @author bhashasp
 */
public interface EngagementMapper {

	/**
	 * @param courseId
	 * @return
	 */
	@Select({ " select engagementid, engagementcriteriaid from asmengagement where courseid = #{courseId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = {
			@Result(property = "engagementid", column = "engagementid"),
			@Result(property = "engagementcriteriaid", column = "engagementcriteriaid"),
			@Result(property = "engagementCriteria", column = "engagementcriteriaid", javaType = EngagementCriteria.class, one = @One(select = "getEngagementCriteria")) })
	List<Engagement> getEngagementeRulesByCourseId(Integer courseId);

	/**
	 * @param engagementCriteriaId
	 * @return
	 */
	@Select({ " select engagementcriteriaid from asmengagementcriteria where engagementcriteriaid = #{engagementCriteriaId,jdbcType=INTEGER} and isdelete=false" })
	@Results(value = {
			@Result(property = "engagementCriteriaId", column = "engagementcriteriaid"),
			@Result(property = "engagementid", column = "engagementid"),

	})
	EngagementCriteria getEngagementCriteria(Integer engagementCriteriaId);

	/**
	 * @param criteria
	 * @return
	 */
	@Insert({ " insert into asmengagementcriteria (creationdate, performanceparameter, operator, paramvalue, isdelete)"
			+ " values (sysdate(), #{performanceparameter,jdbcType=INTEGER}, #{operator,jdbcType=INTEGER},"
			+ " #{paramvalue,jdbcType=VARCHAR}, #{isDelete,jdbcType=BOOLEAN})" })
	@Results(value = { @Result(property = "engagementCriteriaId", column = "engagementcriteriaid") })
	EngagementCriteria saveCriteria(EngagementCriteria criteria);

	/**
	 * @param engagement
	 */
	@Insert({ "insert into asmengagement (creationdate, engagementmode, ishierarchy, engagementcriteriaid, courseid) "
			+ "values (sysdate(), #{engagementmode,jdbcType=INTEGER}, #{ishierarchy,jdbcType=BOOLEAN},"
			+ " #{engagementCriteria.engagementcriteriaid,jdbcType=INTEGER}, #{course.courseid,jdbcType=INTEGER},)" })
	void saveEngagement(Engagement engagement);

	
	/**
	 * @param criteria
	 */
	@Update({ " update asmengagementcriteria set performanceparameter=#{performanceParameter,jdbcType=INTEGER},  operator=#{operator,jdbcType=INTEGER},"
			+ " paramvalue=#{paramValue,jdbcType=VARCHAR} where  engagementcriteriaid = #{engagementCriteriaId,,jdbcType=INTEGER}" })
	void updateCriteria(EngagementCriteria criteria);
	
	
	/**
	 * @param engagement
	 */
	@Update({ " update asmengagement set engagementmode=#{engagementMode,jdbcType=INTEGER} where  engagementid = #{engagementId,,jdbcType=INTEGER}" })
	void updateEngagement(Engagement engagement);
	

	/**
	 * @param isDelete
	 * @param engagementCriteriaId
	 */
	@Update({ " update asmengagementcriteria set isdelete =#{isDelete,jdbcType=BOOLEAN} where  engagementcriteriaid = #{engagementCriteriaId,,jdbcType=INTEGER}" })
	void deleteCriteria(Boolean isDelete, Integer engagementCriteriaId);

	
	/**
	 * @param isDelete
	 * @param engagementId
	 */
	@Update({ " update asmengagement set isdelete =#{isDelete,jdbcType=BOOLEAN} where  engagementid = #{engagementId,,jdbcType=INTEGER}" })
	void deleteEngagement(Boolean isDelete, Integer engagementId);

}
