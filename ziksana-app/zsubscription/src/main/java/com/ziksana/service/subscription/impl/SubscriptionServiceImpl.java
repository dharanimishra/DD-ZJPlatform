/**
 * 
 */
package com.ziksana.service.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.EducatorContent;
import com.ziksana.domain.course.EducatorNote;
import com.ziksana.domain.course.Hotspot;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.domain.course.Node;
import com.ziksana.domain.course.Reference;
import com.ziksana.domain.course.subscription.ContentReference;
import com.ziksana.domain.course.subscription.Note;
import com.ziksana.domain.course.subscription.SubscriptionCourse;
import com.ziksana.domain.institution.LearningProgram;
import com.ziksana.persistence.subscription.SubscriptionMapper;
import com.ziksana.security.util.SecurityTokenUtil;
import com.ziksana.service.subscription.SubscriptionService;

/**
 * @author prabu
 * 
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionMapper subscriptionMapper;

	public List<Note> getLearnerNotes(Integer courseId, Integer componentId,
			Integer contentId, Integer type) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getLearnerNotes(
				Integer.valueOf(memberRoleId), Integer.valueOf(courseId),
				componentId, contentId, type);
	}

	public List<EducatorNote> getEducatorContent(SubscriptionCourse course,
			Node node, Integer contentType) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
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

		return subscriptionMapper.getEducatorNotes(contentType,
				Integer.valueOf(memberRoleId), courseId, learnCompId,
				learnCompCntId);
	}

	/*
	 * @Override public List<Note> getTOC(Node node) {
	 * 
	 * String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
	 * .getStorageID();
	 * 
	 * // Integer learnCompId = 0; Integer learnCmpContId = 0;
	 * 
	 * List<Note> tocs = subscriptionMapper.getContentByType(null, learnCompId,
	 * learnCmpContId, Integer.valueOf(memberRoleId), node.getType()); return
	 * tocs; }
	 */

	public int addLearnerContent(Integer courseId, Integer componentId,
			Integer contentId, String noteTitle, String noteDescription,
			Integer noteDuration, Integer type) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
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

	public List<Note> getLearnerContent(SubscriptionCourse course, Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		Integer learnCompId = null;
		Integer learnCmpCntId = null;

		// This logic needs to be revisited based on the sbn subscriber notes
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

	public List<EducatorNote> getEducatorNotes(Integer courseId, Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorNotes(8, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());
	}

	public List<Reference> getEducatorSuggestedReferences(Integer courseId,
			Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorReferences(1, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());

	}

	public void addLearnerQuestion(Integer courseId, String question, Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
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

	public List<Note> getLearnerQuestions(Integer courseId,
			Integer componentId, Integer contentId) {
		return null;
	}

	public List<ContentReference> getContentTOC(Integer courseId, Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getContentTOC(7, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());
	}

	public List<LearningProgram> getLearningPrograms() {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getLearningPrograms(Integer
				.valueOf(memberRoleId));
	}

	public List<Course> getCoursesByLearningProgram(Integer learningProgramId) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getCoursesByLearningProgram(
				Integer.valueOf(memberRoleId), learningProgramId);
	}

	public int deleteLearnerContent(Integer learnerContentId) {
		return subscriptionMapper.deleteNote(learnerContentId);

	}

	public Integer addEducatorContent(Integer courseId, Integer componentId,
			Integer contentId, Integer type, String description, String url,
			String coordinates, Integer duration, String title, Integer parentId) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.addEducatorContent(
				Integer.valueOf(memberRoleId), type, componentId, contentId,
				courseId, description, url, coordinates, duration, title,
				parentId);

	}

	public int editLearnerContent(Integer learnerContentId, String description,
			int duration, String title) {
		return subscriptionMapper.updateNote(learnerContentId, description,
				duration, title);
	}

	public int deleteEducatorContent(Integer contentId) {
		return subscriptionMapper.deleteEducatorContent(contentId);
	}

	public List<Hotspot> getEducatorHotspots(Integer courseId, Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorHotspots(7, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());

	}

	public List<EducatorContent> getAllEducatorContent(Integer courseId,
			Node node) {

		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getAllEducatorContent(Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());

	}

	public int editEducatorContent(Integer contentEnrId, String contentDesc,
			String url, String coordinates, Integer duration, String title,
			Integer parentId) {

		return subscriptionMapper.editEducatorContent(contentEnrId,
				contentDesc, url, coordinates, duration, title, parentId);
	}

	public LearningContent getLinkedLearningContent(Integer learningContentId) {
		return subscriptionMapper.getLinkedLearningContent(learningContentId);
	}

	public EducatorContent getEducatorTOCByContentEnrichId(
			Integer eduContentEnrichId) {
		EducatorContent educatorContent = subscriptionMapper
				.getEducatorTOCByContentEnrichId(eduContentEnrichId);
		return educatorContent;
	}

	public List<EducatorContent> getEducatorTOCByParentEnrichId(
			Integer parentEnrichId) {
		List<EducatorContent> educatorContentList = subscriptionMapper
				.getEducatorTOCByParentEnrichId(parentEnrichId);
		return educatorContentList;
	}

	public List<EducatorNote> getHotspotNotes(Integer courseId, Node node) {
		String memberRoleId = SecurityTokenUtil.getToken().getMemberPersonaId()
				.getStorageID();

		return subscriptionMapper.getEducatorNotes(9, Integer
				.valueOf(memberRoleId), courseId, node.getParent().getId(),
				node.getId());
	}

}
