package com.ziksana.service.course.impl;

import java.util.Map;
import com.ziksana.domain.course.Course;
import com.ziksana.domain.course.CoursePlaybook;
import com.ziksana.domain.course.CoursePlaybookView;
import com.ziksana.domain.course.PlaybookComponent;
import com.ziksana.domain.course.PlaybookType;
import com.ziksana.domain.course.ProgramCurriculumPlaybook;
import com.ziksana.domain.member.Member;
import com.ziksana.exception.course.CourseException;
import com.ziksana.service.course.PlaybookService;

public class PlaybookServiceImpl implements PlaybookService {

	@Override
	public CoursePlaybook getDefaultCoursePlaybook(Member member)
			throws CourseException {
		 
		return null;
	}

	@Override
	public ProgramCurriculumPlaybook getDefaultLearningLProgramPlaybook(
			Member member) throws CourseException {
		 
		return null;
	}

	@Override
	public Map<PlaybookType, PlaybookComponent> getPlaybookList(Member member)
			throws CourseException {
		 
		return null;
	}

	@Override
	public CoursePlaybook createNewPlaybook(Member member, Course course,
			CoursePlaybook coursePB, CoursePlaybookView coursePBView)
			throws CourseException {
		 
		return null;
	}

	@Override
	public void updateCoursePlaybook(CoursePlaybook coursePB,
			CoursePlaybookView coursePBView) throws CourseException {
		 
		
	}

	@Override
	public void deleteCoursePlaybook(CoursePlaybook coursePB)
			throws CourseException {
		 
		
	}

	@Override
	public void previewPlaybook(CoursePlaybook coursePB) throws CourseException {
		 
		
	}

	@Override
	public CoursePlaybook getPlaybook(CoursePlaybook coursePB)
			throws CourseException {
		 
		return null;
	}

	@Override
	public void generatePlaybook(CoursePlaybook coursePB)
			throws CourseException {
		 
		
	}
	
	
}
