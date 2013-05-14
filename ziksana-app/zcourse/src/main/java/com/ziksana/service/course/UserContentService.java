/**
 * 
 */
package com.ziksana.service.course;

import java.util.List;

import com.ziksana.domain.course.UserContent;

/**
 * @author Ratnesh Kumar
 * 
 */
public interface UserContentService {

	public List<UserContent> getUserContent(Integer memberId);

}
