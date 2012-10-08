/**
 * 
 */
package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class AssignmentTestRubric extends AuditHistory {

	public AssignmentTestRubric(Integer cellValue, Boolean active,
			AssignmentTest assignmentTest, Rubric rubric) {
		this.cellValue = cellValue;
		this.active = active;
		this.assignmentTest = assignmentTest;
		this.rubric = rubric;
	}
	
	private ZID 			assignmentTestRubricId;
	private Date 			creationDate 		= null;
	private Integer 		cellValue 			= null;
	private Boolean 		active	 			= null;
	
	private AssignmentTest 	assignmentTest 		= null;
	private Rubric 			rubric 				= null;
	private RubricMatrix 	rubricMatrix 		= null;
	
	/**
	 * @return the assignmentTestRubricId
	 */
	public ZID getAssignmentTestRubricId() {
		return assignmentTestRubricId;
	}
	/**
	 * @param assignmentTestRubricId the assignmentTestRubricId to set
	 */
	public void setAssignmentTestRubricId(ZID assignmentTestRubricId) {
		this.assignmentTestRubricId = assignmentTestRubricId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the cellValue
	 */
	public Integer getCellValue() {
		return cellValue;
	}
	/**
	 * @param cellValue the cellValue to set
	 */
	public void setCellValue(Integer cellValue) {
		this.cellValue = cellValue;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	/**
	 * @return the assignmentTest
	 */
	public AssignmentTest getAssignmentTest() {
		return assignmentTest;
	}
	/**
	 * @param assignmentTest the assignmentTest to set
	 */
	public void setAssignmentTest(AssignmentTest assignmentTest) {
		this.assignmentTest = assignmentTest;
	}
	/**
	 * @return the rubric
	 */
	public Rubric getRubric() {
		return rubric;
	}
	/**
	 * @param rubric the rubric to set
	 */
	public void setRubric(Rubric rubric) {
		this.rubric = rubric;
	}
	/**
	 * @return the rubricMatrix
	 */
	public RubricMatrix getRubricMatrix() {
		return rubricMatrix;
	}
	/**
	 * @param rubricMatrix the rubricMatrix to set
	 */
	public void setRubricMatrix(RubricMatrix rubricMatrix) {
		this.rubricMatrix = rubricMatrix;
	}
			
	@Override
	public String toString() {
		return "AssignmentTestRubric [creationDate=" + creationDate
				+ ", cellValue=" + cellValue + ", active=" + active
				+ ", assignmentTest=" + assignmentTest + ", rubric=" + rubric
				+ ", rubricMatrix=" + rubricMatrix + "]";
	}
	
}
