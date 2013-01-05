/**
 * 
 */
package com.ziksana.service.subscription;

import java.util.List;

import com.ziksana.domain.course.EducatorNote;
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

	// Educator services
	/**
	 * 
	 * @param course
	 * @param node
	 * @param contentType
	 *            values are notes,educator suggested references or reference
	 *            materials
	 * @return
	 */
	public List<EducatorNote> getEducatorContent(SubscriptionCourse course,
			Node node, Integer contentType);

	public List<EducatorNote> getEducatorNotes(Integer courseId, Node node);

	public List<Reference> getEducatorSuggestedReferences(Integer courseId,
			Node node);

	// end

	// Learner services
	public List<Note> getLearnerContent(SubscriptionCourse course, Node node);

	

	public List<Note> getLearnerNotes(Integer courseId, Integer componentId, Integer contentId, Integer type);
	
	
	public List<Note> getLearnerQuestions(Integer courseId, Integer componentId, Integer contentId);
	

	/**
	 * Based on the nodetype(learning component and content..) and content
	 * type(question,notes..etc). it adds the content
	 * 
	 * @param content
	 * @param node
	 */
	public int addLearnerContent(Integer courseId, Integer componentId, Integer contentId, String noteTitle, String noteDescription, Integer noteDuration, Integer type);

	
	/**
	 * Adding learner question(s) 
	 * @param question
	 * @param node
	 */
	public void addLearnerQuestion(Integer courseId,String question, Node node);
	

}
