package com.ziksana.persistence.course;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.ziksana.domain.course.CourseContentSecurity;

/**
 * @author bhashasp
 */
public interface CourseContentSecurityMapper {
	
	/**
	 * This waves the course tagcloud keys
	 */
	@Insert({
			"insert into corcoursecontentsecurity (creationdate, watermarkcontentpath, embeddedlogopath, floatingindicator, embedusercredentialindicator,",
			" courseid, institutionid)",
			"values (#{creationDate,jdbcType=TIMESTAMP}, ",
			"#{watermarkPath,jdbcType=VARCHAR}, #{logoPath,jdbcType=VARCHAR}, ",
			"#{flotingIndicator,jdbcType=BOOLEAN}, #{signatureIndicator,jdbcType=BOOLEAN}, ",
			"#{courseId,jdbcType=INTEGER}})" })
	void save(CourseContentSecurity contSecurity);

	@Update({"update corcoursecontentsecurity set watermarkcontentpath=#{watermarkPath,jdbcType=VARCHAR}, embeddedlogopath=#{logoPath,jdbcType=VARCHAR}, ", 
		"floatingindicator=#{flotingIndicator,jdbcType=BOOLEAN}, embedusercredentialindicator=#{signatureIndicator,jdbcType=BOOLEAN} " , 
		"where courseid = #{course.courseId,jdbcType=INTEGER}"})
	void update(CourseContentSecurity contSecurity);


}
