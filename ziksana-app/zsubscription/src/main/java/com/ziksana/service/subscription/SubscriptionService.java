/**
 * 
 */
package com.ziksana.service.subscription;

import java.util.List;

import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;

/**
 * @author prabu
 *
 */
public interface SubscriptionService {
	
	public List<Note>  getLearnerNotes(SubscriptionCourse course);
	
	public List<Note> getEducatorNotes(SubscriptionCourse course);
	

}
