/**
 * 
 */
package com.ziksana.service.subscription;

import java.util.List;

import com.ziksana.domain.course.LinkType;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;

/**
 * @author prabu
 *
 */
public interface SubscriptionService {
	
	
	
	//Educator services 
	/**
	 * 
	 * @param course
	 * @param node
	 * @param contentType values are notes,educator suggested references or reference materials
	 * @return
	 */
	public List<Note> getEducatorContent(SubscriptionCourse course, Node node, Integer contentType);
	
	
	
	//end 
	
	
	
	
	//Learner services 
	public List<Note> getLearnerContent(SubscriptionCourse course, Node node);
	
	public List<Note> getLearnerQuestions(Node node);
	public List<Note>  getLearnerNotes(SubscriptionCourse course, Node node);
	
	
	
	
	/**
	 * Based on the nodetype(learning component and content..) and content type(question,notes..etc).
	 * it adds the content
	 * @param content
	 * @param node
	 */
	public void addLearnerContent(String content, Node node);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
