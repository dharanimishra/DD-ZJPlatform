package com.ziksana.persistence.course;

import com.ziksana.domain.course.CourseContentSecurity;

/**
 * @author bhashasp
 */
public interface CourseContentSecurityMapper {
	
	/**
	 * This saves the course Security parameters
	 */
	void save(CourseContentSecurity contSecurity);

	/**
	 * Updates the course Security parameters
	 * @param contSecurity
	 */
	void update(CourseContentSecurity contSecurity);


}
