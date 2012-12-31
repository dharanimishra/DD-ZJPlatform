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
		// TODO
		Integer learnCmpId = null;
		Integer learnCmpCntId = null;

		return subscriptionMapper.getLearnerNotes(
				Integer.valueOf(memberRoleId), Integer.valueOf(course
						.getSubscriptionCourseId().getStorageID()), learnCmpId,
				learnCmpCntId);
	}

	@Override
	public List<Note> getEducatorContent(SubscriptionCourse course, Node node,
			Integer contentType) {
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

		// TODO
		return subscriptionMapper.getEducatorNotes(1, Integer
				.valueOf(memberRoleId), Integer.valueOf(course
				.getSubscriptionCourseId().getStorageID()), learnCompId,
				learnCompCntId);
	}

	@Override
	public List<Note> getLearnerQuestions(Node node) {
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();
		Integer subscrCourseId = null;
		Integer learnCmpId = null;
		Integer learnCmpCntId = null;

		// TODO
		return subscriptionMapper.getLearnerNotes(
				Integer.valueOf(memberRoleId), subscrCourseId, learnCmpId,
				learnCmpCntId);

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
	public void addLearnerContent(String content, Node node) {
		// TODO Auto-generated method stub

		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Note note = new Note();

		note.setMemberRoleId(Integer.valueOf(memberRoleId));
		note.setContent(content);

		note.setType(Integer.valueOf(node.getType()));

		if (node.getType() == 1000) {
			note.setLearnCompId(node.getId());
		} else if (node.getType() == 1001) {
			note.setLearnCmpContId(node.getId());
		}

		subscriptionMapper.addNote(note);

	}

	@Override
	public List<Note> getLearnerContent(SubscriptionCourse course, Node node) {
		
		String memberRoleId = ThreadLocalUtil.getToken().getMemberPersonaId()
				  .getStorageID();
		
		Integer learnCompId = null;
		Integer learnCmpCntId = null;

		if (node.getType() == 1000) {
			learnCompId = node.getId();
		} else if (node.getType() == 1001) {
			learnCmpCntId = node.getId();
		}
		
		List<Note> notes = subscriptionMapper.getContentByType(Integer.valueOf(course.getSubscriptionCourseId().getStorageID()), learnCompId,
				  learnCmpCntId, Integer.valueOf(memberRoleId), node.getType());
		
		
		return notes;
	}

}
