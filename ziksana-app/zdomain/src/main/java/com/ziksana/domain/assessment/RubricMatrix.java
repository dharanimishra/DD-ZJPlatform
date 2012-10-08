package com.ziksana.domain.assessment;

import com.ziksana.common.id.ZID;
import com.ziksana.domain.common.AuditHistory;

/**
 * @author bhashasp
 */
public class RubricMatrix extends AuditHistory {
	
	
	public RubricMatrix(String cellName, String cellDescription,
			Integer weightage, RubricCategory rubricCategory,
			RubricLevel rubricLevel, Rubric rubric) {
		this.cellName = cellName;
		this.cellDescription = cellDescription;
		this.weightage = weightage;
		this.rubricCategory = rubricCategory;
		this.rubricLevel = rubricLevel;
		this.rubric = rubric;
	}
	
	private ZID 			rubricMatrixId;
	private String 			cellName 		= null;
	private String 			cellDescription = null;
	private Integer 		weightage 		= null;
	private Boolean 		active 			= null;
	private RubricCategory 	rubricCategory 	= null;
	private RubricLevel 	rubricLevel 	= null;
	private Rubric 			rubric 			= null;

	/**
	 * @return the rubricMatrixId
	 */
	public ZID getRubricMatrixId() {
		return rubricMatrixId;
	}
	/**
	 * @param rubricMatrixId the rubricMatrixId to set
	 */
	public void setRubricMatrixId(ZID rubricMatrixId) {
		this.rubricMatrixId = rubricMatrixId;
	}
	/**
	 * @return the cellName
	 */
	public String getCellName() {
		return cellName;
	}
	/**
	 * @param cellName the cellName to set
	 */
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	/**
	 * @return the cellDescription
	 */
	public String getCellDescription() {
		return cellDescription;
	}
	/**
	 * @param cellDescription the cellDescription to set
	 */
	public void setCellDescription(String cellDescription) {
		this.cellDescription = cellDescription;
	}
	/**
	 * @return the weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}
	/**
	 * @param weightage the weightage to set
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
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
	 * @return the rubricCategory
	 */
	public RubricCategory getRubricCategory() {
		return rubricCategory;
	}
	/**
	 * @param rubricCategory the rubricCategory to set
	 */
	public void setRubricCategory(RubricCategory rubricCategory) {
		this.rubricCategory = rubricCategory;
	}
	/**
	 * @return the rubricLevel
	 */
	public RubricLevel getRubricLevel() {
		return rubricLevel;
	}
	/**
	 * @param rubricLevel the rubricLevel to set
	 */
	public void setRubricLevel(RubricLevel rubricLevel) {
		this.rubricLevel = rubricLevel;
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

	@Override
	public String toString() {
		return "RubricMatrix [cellName=" + cellName + ", cellDescription="
				+ cellDescription + ", weightage=" + weightage + ", active="
				+ active + "]";
	}
	

}
