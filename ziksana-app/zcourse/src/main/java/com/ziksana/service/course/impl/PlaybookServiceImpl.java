package com.ziksana.service.course.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookComponent;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.exception.course.CourseException;
import com.ziksana.id.ZID;
import com.ziksana.persistence.course.CoursePlaybookMapper;
import com.ziksana.service.course.PlaybookService;

/**
 * @author bhashasp
 */
public class PlaybookServiceImpl implements PlaybookService {
	
	private static Logger logger = Logger.getLogger(PlaybookServiceImpl.class);
	
	@Autowired
	public CoursePlaybookMapper coursePlaybookMapper;

	@Override
	public CoursePlaybook getCoursePlaybook(CoursePlaybook playbook)
			throws CourseException {
		Boolean 				isDelete 		= false;
		CoursePlaybook 			coursePB 		= null;
		
		if(playbook.getCoursePlaybookId() == null){
			throw new CourseException("Course Playbook ID cannot be null");
		}
		
		coursePB = coursePlaybookMapper.getDefaulPlaybookDetails(isDelete, playbook.getCoursePlaybookId());
		
		if(coursePB != null){
			logger.debug(" Course Playbook details : "+coursePB.toString());
			return coursePB;
		}
		 
		return null;
	}

	@Override
	public Map<PlaybookType, PlaybookComponent> getPlaybookList(ZID courseId)
			throws CourseException {
		 
		return null;
	}
	

	@Override
	public List<CoursePlaybook> getCoursePlaybookList(ZID courseId) throws CourseException {
		Boolean isDelete = false;
		List<CoursePlaybook> playbookList = null;
		 
		if(courseId == null){
			throw new CourseException("Course ID cannot be null");
		}
		
		playbookList = coursePlaybookMapper.getCoursePlaybookList(isDelete, new Integer(courseId.getStorageID()));
		
		logger.debug("CoursePlaybook list size : "+playbookList.size());
		 
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

		CoursePlaybookView 		playbookView 	= null;
		
		if(coursePlaybook.getCourse() == null){
			throw new CourseException("Course ID cannot be null");
		}
		
		if(coursePlaybook.getPlaybookType() == PlaybookType.REGULAR){
			
			logger.debug("Before saving the course playbook");
			Integer coursePBId = coursePlaybookMapper.saveDefaultPlaybook(coursePlaybook);
			
			playbookView = coursePlaybook.getPlaybookView();
			
			coursePlaybook.setCoursePlaybookId(coursePBId);
			
			playbookView.setCoursePlaybook(coursePlaybook);
			
			logger.debug("Before saving the course playbook view");
			
			coursePlaybookMapper.savePlaybookView(playbookView);
			
		}
		
	}

	@Transactional
	@Override
	public void updateCoursePlaybook(CoursePlaybook coursePB)
			throws CourseException {
		
		if(coursePB.getCoursePlaybookId() == null){
			throw new CourseException("Course Playbook ID cannot be null");
		}
		
		coursePlaybookMapper.updateCoursePlaybook(coursePB.getPlaybookView());
		
	}

	@Transactional
	@Override
	public void deleteCoursePlaybook(ZID coursePBId) throws CourseException {
		Boolean isDelete = true;
		if(coursePBId == null){
			throw new CourseException("Course Playbook ID cannot be null");
		}
		
		coursePlaybookMapper.deleteCoursePlaybook(isDelete, new Integer(coursePBId.getStorageID()));
		
	}

	@Transactional
	@Override
	public void createDefaultPlaybook(CoursePlaybook coursePlaybook) throws CourseException {
		
		CoursePlaybookView 		playbookView 	= null;
		
		if(coursePlaybook.getCourse() == null){
			throw new CourseException("Course ID cannot be null");
		}
		
		if(coursePlaybook.getPlaybookType() == PlaybookType.PREVIEW){
			
			playbookView = coursePlaybook.getPlaybookView();
			
			playbookView.setCoursePlaybook(coursePlaybook);
			
			logger.debug("Before saving the course playbook view");
			
			coursePlaybookMapper.savePlaybookView(playbookView);

			
			logger.debug("Before saving the course playbook");
			
			Integer coursePBId = coursePlaybookMapper.saveDefaultPlaybook(coursePlaybook);
			
			logger.debug("After saving the course playbook ::: "+coursePBId);
			
			coursePlaybook.setCoursePlaybookId(coursePBId);
			
				
		}
		
	}
	
	
}
