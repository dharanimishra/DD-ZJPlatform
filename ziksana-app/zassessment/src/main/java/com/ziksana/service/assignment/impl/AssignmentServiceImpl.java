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
		// TODO Auto-generated method stub
		Integer assignmentId = assignmentMapper.insertAssignment(assignment);
		System.out.println("THE ASSIGNMENT ID IS "+assignmentId);
		System.out.println("THE ASSIGNMENT ID FROM THE OBJECT  IS "+assignment.getId());
		return assignment;

	}

}
