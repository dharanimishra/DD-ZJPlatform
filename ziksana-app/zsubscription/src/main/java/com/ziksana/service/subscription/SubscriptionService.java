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
	public List<Note> getEducatorNotes(SubscriptionCourse course, Node node);
	public List<Reference> getEducatorReferences(SubscriptionCourse course, Node node);
	
	//end 
	
	
	
	//Learner services 
	public List<Note> getLearnerQuestions(Node node);
	public List<Note>  getLearnerNotes(SubscriptionCourse course, Node node);
	public void addLearnerQuestion(String questionText, Node node);
	public void addLearnerNote(String note, Node node);
	public List<Note> getTOC(Node node);
	
	//end 
	
	
	
	public List<LinkType> getContentByType(SubscriptionCourse course);
	
	
	
	
	
	
	
	
	
	

}
