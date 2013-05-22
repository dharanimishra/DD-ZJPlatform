package com.ziksana.service.course.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.domain.course.LearningContent;
import com.ziksana.service.course.AssociateContentService;
import com.ziksana.service.course.ContentService;
import com.ziksana.service.course.LearningComponentService;
import com.ziksana.service.course.LearningContentService;


public class AssociateContentServiceImpl implements AssociateContentService {

	
	//@Autowired
	//LearningComponentService componentService;
	
	//@Autowired
	LearningContentService learningContentService;
	
	
	
	public List<LearningContent> getLearningContents(Integer authMemberRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void associateContentToComponent(
			List<LearningComponentContent> learningComponentContents) {
		// TODO Auto-generated method stub
		//componentService.
	}

	public List<LearningContent> unAssociateContentFromComponent(
			LearningComponentContent learningComponentContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
