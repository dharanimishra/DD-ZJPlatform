/**
 * 
 */
package com.ziksana.service.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.EducatorNote;
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
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionMapper subscriptionMapper;

	@Override
	public List<Note> getLearnerNotes(Integer courseId, Integer componentId, Integer contentId, Integer type) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();
		// TODO
		Integer learnCmpId = null;
		Integer learnCmpCntId = null;

		return subscriptionMapper.getLearnerNotes(
				Integer.valueOf(memberRoleId), Integer.valueOf(courseId
						), componentId,
				contentId, type);
	}

	@Override
	public List<EducatorNote> getEducatorContent(SubscriptionCourse course,
			Node node, Integer contentType) {
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Integer learnCompId = null;
		Integer learnCompCntId = null;

		if (node.getType() == 1000) {
			learnCompId = node.getId();
		} else if (node.getType() == 1001) {
			learnCompCntId = node.getId();
		}

		Integer courseId = null;

		if (course != null) {
			courseId = Integer.valueOf(course.getSubscriptionCourseId()
					.getStorageID());
		}

		// TODO
		return subscriptionMapper.getEducatorNotes(contentType,
				Integer.valueOf(memberRoleId), courseId, learnCompId,
				learnCompCntId);
	}

	

	/*
	 * @Override public List<Note> getTOC(Node node) {
	 * 
	 * String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
	 * .getStorageID();
	 * 
	 * // TODO Integer learnCompId = 0; Integer learnCmpContId = 0; // TODO
	 * 
	 * List<Note> tocs = subscriptionMapper.getContentByType(null, learnCompId,
	 * learnCmpContId, Integer.valueOf(memberRoleId), node.getType()); return
	 * tocs; }
	 */

	@Override
	public int addLearnerContent(Integer courseId, Integer componentId, Integer contentId, String noteTitle, String noteDescription, Integer noteDuration, Integer type){
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Note note = new Note();

		note.setMemberRoleId(Integer.valueOf(memberRoleId));
		note.setLearnCompId(componentId);
		note.setLearnCmpContId(contentId);
		note.setNoteTitle(noteTitle);
		note.setNoteDescription(noteDescription);
		note.setNoteDuration(noteDuration);
		
        note.setCourseId(courseId);
		
		note.setType(type);

		

		return subscriptionMapper.addNote(note);

	}

	@Override
	public List<Note> getLearnerContent(SubscriptionCourse course, Node node) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Integer learnCompId = null;
		Integer learnCmpCntId = null;

		// This logic needs to be revisited based on the sbnsubscribernotes
		if (node.getType() == 1000) {
			learnCompId = node.getId();
		} else if (node.getType() == 1001) {
			learnCmpCntId = node.getId();
		}

		List<Note> notes = subscriptionMapper.getContentByType(Integer
				.valueOf(course.getSubscriptionCourseId().getStorageID()), node
				.getParent().getId(), node.getId(), Integer
				.valueOf(memberRoleId), node.getType());

		return notes;
	}

	@Override
	public List<EducatorNote> getEducatorNotes(Integer courseId, Node node) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		// TODO
		return subscriptionMapper.getEducatorNotes(8, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());
		// TODO Auto-generated method stub

	}

	@Override
	public List<Reference> getEducatorSuggestedReferences(Integer courseId,
			Node node) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorReferences(8, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());

	}

	@Override
	public void addLearnerQuestion(Integer courseId, String question, Node node) {

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Note note = new Note();

		note.setMemberRoleId(Integer.valueOf(memberRoleId));
		note.setContent(question);
	    note.setCourseId(courseId);

		note.setType(Integer.valueOf(node.getType()));

		if (node.getType() == 1000) {
			note.setLearnCompId(node.getId());
		} else if (node.getType() == 1001) {
			note.setLearnCmpContId(node.getId());
		}

		subscriptionMapper.addNote(note);

	}

	@Override
	public List<Note> getLearnerQuestions(Integer courseId,
			Integer componentId, Integer contentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
