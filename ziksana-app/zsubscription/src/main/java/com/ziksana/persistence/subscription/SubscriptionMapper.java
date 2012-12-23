/**
 * 
 */
package com.ziksana.persistence.subscription;

import java.util.List;

import com.ziksana.domain.course.subscription.Note;

/**
 * @author prabu
 *
 */
public interface SubscriptionMapper {
	
	public List<Note> getNotes(Integer subscrCourseId);
	
	

}
