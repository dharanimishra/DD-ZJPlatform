package com.ziksana.service.assignment.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.model.assignment.Assignment;
import com.ziksana.persistence.assignment.AssignmentMapper;
import com.ziksana.service.assignment.AssignmentService;

/**
 * @author bhashasp
 */
public class AssignmentServiceImpl implements AssignmentService {

	private static Logger logger = LoggerFactory
			.getLogger(AssignmentServiceImpl.class);

	@Autowired
	AssignmentMapper assignmentMapper;

	@Override
	public Assignment createAssignment(Assignment assignment) {
		Integer assignmentId = assignmentMapper.insertAssignment(assignment);
		return assignment;

	}

}
