package com.ziksana.service.assignment.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.ziksana.model.assignment.Assignment;
import com.ziksana.persistence.assignment.AssignmentMapper;
import com.ziksana.service.assignment.AssignmentService;

/**
 * @author bhashasp
 */
public class AssignmentServiceImpl implements AssignmentService {

	private static Logger logger = Logger
			.getLogger(AssignmentServiceImpl.class);

	@Autowired
	AssignmentMapper assignmentMapper;

	@Override
	public Assignment createAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		Integer assignmentId = assignmentMapper.insertAssignment(assignment);
		logger.debug(" THE ASSIGNMENT ID IS "+assignmentId);
		logger.debug(" THE ASSIGNMENT ID FROM THE OBJECT  IS "+assignment.getId());
		return assignmentMapper.getAssignmentById(assignment.getId());

	}

}
