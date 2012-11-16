package com.ziksana.persistence.program;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.course.subscription.MemberSubscriptionProgram;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.domain.member.Member;

/**
 * @author bhashasp
 */
public interface ProgramsMapper {

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select count(*) from corcourse where memberroleid = #{accountableMember.memberRoleId, jdbcType=INTEGER}" })
	int getCoursesCountByMemberRoleId(Integer memberRoleId);

	/**
	 * @param isLearningObject
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select count(*) from corlearningcomponent where islearningobject = #{isLearningObject, jdbcType=BOOLEAN} "
			+ "and memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	int getLearningObjectsCountByMemberRoleId(Boolean isLearningObject,
			Integer memberRoleId);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ "select count(*) from corlearningcontent where rightsowningmemberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	int getLearningContentsCountByMemberRoleId(Integer memberRoleId);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ " select count(lp.*) from corcurriculumdelivery cd, corprogramcurruculum pc, corleraningprogram lp where"
			+ "  pc.learningprogramid = lp.learningprogramid and cd.programcurriculumid = pc.programcurriculumid "
			+ " and cd.memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	int getLearningProgramsCountByMemberRoleId(Integer memberRoleId);

	/**
	 * @param memberRoleId
	 * @return
	 */
	@Select({ " select lp.learningprogramid, lp.name, lp.rating, lp.description, lp.programtype, lp.programduration"
			+ " from corcurriculumdelivery cd, corprogramcurruculum pc, corleraningprogram lp where"
			+ "  pc.learningprogramid = lp.learningprogramid and cd.programcurriculumid = pc.programcurriculumid "
			+ " and cd.memberroleid = #{memberRoleId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "learningProgramId", column = "learningprogramid"),
			@Result(property = "name", column = "name"),
			@Result(property = "rating", column = "rating"),
			@Result(property = "description", column = "description"),
			@Result(property = "programType", column = "programtype"),
			@Result(property = "programDuration", column = "programDduration") })
	List<LearningProgram> getLearningPrograms(Integer memberRoleId);

	@Select({ " select curriculumcourseid from corcurriculumcourse where curriculumCourseId = #{curriculumCourseId, jdbcType=INTEGER}" })
	@Results(value = { @Result(property = "learningProgramId", column = "curriculumcourseid") })
	CurriculumCourse getCurriculumCourseById(Integer curriculumCourseId);

	
	
	@Select({ " select programcurriculumid from corprogramcurriculum  where "
			+ " programCurriculumid = #{progCurriculumId, jdbcType=INTEGER}" })
	@Results(value = {
			@Result(property = "programcurriculumid", column = "programcurriculumid"),
			@Result(property = "programcurriculumid", column = "programcurriculumid"),
			@Result(property = "learningProgram", column = "learningprogramId", javaType = List.class, many = @Many(select = "getMemberSubscriptionPrograms")) })
	LearningProgram getLearningProgramByProgCurriculum(Integer progCurriculumId);

	
	

}
