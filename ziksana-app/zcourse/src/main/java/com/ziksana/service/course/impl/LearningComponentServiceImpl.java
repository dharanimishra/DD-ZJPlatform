package com.ziksana.service.course.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.persistence.course.LearningComponentMapper;
import com.ziksana.service.course.LearningComponentService;

@Service
public class LearningComponentServiceImpl implements LearningComponentService {

	@Autowired
	LearningComponentMapper learningComponentMapper;
	
	public LearningComponent getLearningComponent(Integer id) {
		// TODO Auto-generated method stub
		return learningComponentMapper.getLearningComponent(id);
	}

}
