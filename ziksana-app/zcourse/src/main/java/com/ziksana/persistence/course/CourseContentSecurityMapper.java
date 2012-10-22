package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CourseContentSecurity;

/**
 * @author bhashasp
 *
 */
public interface CourseContentSecurityMapper {
	
	/**
	 * This waves the course tagcloud keys
	 */
	@Insert({
			"insert into corCourseContentSecurity (CreationDate, WatermarkContentPath, EmbeddedLogoPath, FloatingIndicator, EmbedUserCredentialIndicator,",
			" CourseId, InstitutionId)",
			"values (#{creationDate,jdbcType=TIMESTAMP}, ",
			"#{watermarkPath,jdbcType=VARCHAR}, #{logoPath,jdbcType=VARCHAR}, ",
			"#{flotingIndicator,,jdbcType=BIT}, #{signatureIndicator,,jdbcType=BIT}, ",
			"#{courseId,jdbcType=INTEGER}})" })
	void save(CourseContentSecurity contSecurity);

	@Update({"update corCourseContentSecurity set where courseid = #{courseId,jdbcType=INTEGER}"})
	void update(CourseContentSecurity contSecurity);


}
