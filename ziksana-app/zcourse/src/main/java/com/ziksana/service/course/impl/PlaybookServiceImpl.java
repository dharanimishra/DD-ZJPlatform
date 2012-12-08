package com.ziksana.service.course.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookStatus;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookDeliveryType;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.domain.course.RecipientStudentModel;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CoursePlaybookMapper;
import com.ziksana.service.course.PlaybookService;

/**
 * @author bhashasp
 */
public class PlaybookServiceImpl implements PlaybookService {

	private final static Logger LOGGER = Logger
			.getLogger(PlaybookServiceImpl.class);

	@Autowired
	public CoursePlaybookMapper coursePlaybookMapper;

	@Override
	public CoursePlaybook getCoursePlaybook(Integer playbookId)
			throws CourseException {
		Boolean isDelete = false;
		CoursePlaybook coursePB = null;

		if (playbookId == null) {
			throw new CourseException("Course Playbook ID cannot be null");
		}

		LOGGER.debug("Playbook Id : " + playbookId);

		coursePB = coursePlaybookMapper.getDefaulPlaybookDetails(isDelete,
				playbookId);

		if (coursePB != null) {

			if (coursePB.getCoursePBStatusId() != null) {
				coursePB.setCoursePBStatus(CoursePlaybookStatus
						.getCoursePlaybookStatus(coursePB.getCoursePBStatusId()));
			}

			LOGGER.debug(" Course Playbook details : " + coursePB.toString());

			if (coursePB.getPlaybookView() != null) {

				if (coursePB.getPlaybookView().getDeliveryTypeId() != null) {
					coursePB.getPlaybookView().setDeliveryType(
							PlaybookDeliveryType
									.getPlaybookDeliveryType(coursePB
											.getPlaybookView()
											.getDeliveryTypeId()));
				}

				if (coursePB.getPlaybookView().getCoursePlaybookStatusId() != null) {
					coursePB.getPlaybookView().setCoursePlaybookStatus(
							CoursePlaybookStatus
									.getCoursePlaybookStatus(coursePB
											.getPlaybookView()
											.getCoursePlaybookStatusId()));
				}

				if (coursePB.getPlaybookView().getRecStudentModelId() != null) {
					coursePB.getPlaybookView().setRecStudentModel(
							RecipientStudentModel
									.getRecipientStudentModel(coursePB
											.getPlaybookView()
											.getRecStudentModelId()));
				}
			}

			return coursePB;
		}

		return null;
	}

	@Override
	public List<CoursePlaybook> getPlaybookList(Integer courseId)
			throws CourseException {

		List<CoursePlaybook> playbookList = null;

		if (courseId == null) {
			throw new CourseException("Course ID cannot be null");
		}

		Boolean isDelete = false;

		playbookList = coursePlaybookMapper.getCoursePlaybookList(isDelete,
				courseId);

		if (playbookList != null) {
			LOGGER.debug("Playbook list size :" + playbookList.size());
			return playbookList;
		}

		return null;
	}

	@Override
	public List<CoursePlaybook> getCoursePlaybookList(ZID courseId)
			throws CourseException {
		Boolean isDelete = false;
		List<CoursePlaybook> playbookList = null;

		if (courseId == null) {
			throw new CourseException("Course ID cannot be null");
		}

		playbookList = coursePlaybookMapper.getCoursePlaybookList(isDelete,
				new Integer(courseId.getStorageID()));

		LOGGER.debug("CoursePlaybook list size : " + playbookList.size());

		return playbookList;
	}

	@Override
	public void previewPlaybook(CoursePlaybook coursePB) throws CourseException {

	}

	@Override
	public void generatePlaybook(CoursePlaybook coursePB)
			throws CourseException {
	}

	@Override
	public void createNewCoursePlaybook(CoursePlaybook coursePlaybook,
			CoursePlaybookView coursePBView) throws CourseException {

		CoursePlaybookView playbookView = null;

		if (coursePlaybook.getCourse() == null) {
			throw new CourseException("Course ID cannot be null");
		}

		if (coursePlaybook.getPlaybookType() == PlaybookType.REGULAR) {

			LOGGER.debug("Before saving the course playbook");
			Integer coursePBId = coursePlaybookMapper
					.saveDefaultPlaybook(coursePlaybook);

			playbookView = coursePlaybook.getPlaybookView();

			coursePlaybook.setCoursePlaybookId(coursePBId);

			playbookView.setCoursePlaybook(coursePlaybook);

			LOGGER.debug("Before saving the course playbook view");

			coursePlaybookMapper.savePlaybookView(playbookView);

		}

	}

	@Transactional
	@Override
	public void updateCoursePlaybook(CoursePlaybook coursePB)
			throws CourseException {

		if (coursePB.getCoursePlaybookId() == null) {
			throw new CourseException("Course Playbook ID cannot be null");
		}

		coursePlaybookMapper.updateCoursePlaybook(coursePB.getPlaybookView());

	}

	@Transactional
	@Override
	public void deleteCoursePlaybook(ZID coursePBId) throws CourseException {

		Boolean isDelete = true;
		if (coursePBId == null) {
			throw new CourseException("Course Playbook ID cannot be null");
		}
		LOGGER.debug("Playbook Id : " + new Integer(coursePBId.getStorageID()));

		coursePlaybookMapper.deleteCoursePlaybook(isDelete, new Integer(
				coursePBId.getStorageID()));

	}

	@Transactional
	@Override
	public void createDefaultPlaybook(CoursePlaybook coursePlaybook)
			throws CourseException {

		CoursePlaybookView playbookView = null;

		if (coursePlaybook.getCourse() == null) {
			throw new CourseException("Course ID cannot be null");
		}

		if (coursePlaybook.getPlaybookType() == PlaybookType.PREVIEW) {
			playbookView = coursePlaybook.getPlaybookView();

			LOGGER.debug("Before saving the course playbook");

			coursePlaybookMapper.saveDefaultPlaybook(coursePlaybook);

			LOGGER.debug("After saving the course playbook ::: "
					+ coursePlaybook.getCoursePlaybookId());

			coursePlaybook.setCoursePlaybookId(Integer.valueOf(coursePlaybook
					.getCoursePlaybookId().getStorageID()));

			playbookView.setCoursePlaybook(coursePlaybook);

			LOGGER.debug("Before saving the course playbook view");

			coursePlaybookMapper.savePlaybookView(playbookView);

		}
	}

}
