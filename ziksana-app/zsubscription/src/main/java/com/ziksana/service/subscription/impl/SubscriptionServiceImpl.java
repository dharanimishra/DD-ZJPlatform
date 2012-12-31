/**
 * 
 */
package com.ziksana.service.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.course.LinkType;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.persistence.subscription.SubscriptionMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 * 
 */
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionMapper subscriptionMapper;

	@Override
	public List<Note> getLearnerNotes(SubscriptionCourse course, Node node) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();
		//TODO 
		Integer learnCmpId = null;
		Integer learnCmpCntId=null;

		return subscriptionMapper.getLearnerNotes(
				Integer.valueOf(memberRoleId), Integer.valueOf(course
						.getSubscriptionCourseId().getStorageID()),learnCmpId, learnCmpCntId );
	}

	@Override
	public List<Note> getEducatorNotes(SubscriptionCourse course, Node node) {
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorNotes(Integer
				.valueOf(memberRoleId), Integer.valueOf(course
				.getSubscriptionCourseId().getStorageID()));
	}

	@Override
	public List<LinkType> getContentByType(SubscriptionCourse course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reference> getEducatorReferences(SubscriptionCourse course, Node node) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public List<Note> getLearnerQuestions(Node node) {
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();
		Integer subscrCourseId = null;
		Integer learnCmpId= null;
		Integer learnCmpCntId = null;
		
		//TODO 
		return subscriptionMapper.getLearnerNotes(Integer.valueOf(memberRoleId), subscrCourseId, learnCmpId,learnCmpCntId);
		
	}

	@Override
	public void addLearnerQuestion(String questionText, Node node) {

		Note note = new Note();
		note.setContent(questionText);

		note.setType(Integer.valueOf(node.getType()));

		subscriptionMapper.addNote(note);

	}

	@Override
	public List<Note> getTOC(Node node) {
		
		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();
		
		//TODO 
		Integer learnCompId = 0;
		Integer learnCmpContId = 0;
		//TODO 
		
		List<Note> tocs = subscriptionMapper.getContentByType(null, learnCompId, learnCmpContId, Integer.valueOf(memberRoleId), node.getType());
		return tocs;
	}

	@Override
	public void addLearnerNote(String noteText, Node node) {
		// TODO Auto-generated method stub
		
		Note note = new Note();
		note.setContent(noteText);

		note.setType(Integer.valueOf(node.getType()));

		subscriptionMapper.addNote(note);
		
	}

}
