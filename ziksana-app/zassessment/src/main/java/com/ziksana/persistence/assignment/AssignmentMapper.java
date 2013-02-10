/**
 * 
 */
package com.ziksana.persistence.assignment;

import com.ziksana.model.assignment.Assignment;



/**
 * @author prabu
 *
 */
public interface AssignmentMapper {
	
	public Integer insertAssignment(Assignment assignment);
	
	public Assignment getAssignmentById(Integer assignmentId);
	
	
	
	
	

}
