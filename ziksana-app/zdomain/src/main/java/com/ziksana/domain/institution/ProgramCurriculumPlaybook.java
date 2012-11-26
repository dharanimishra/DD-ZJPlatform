/**
 * 
 */
package com.ziksana.domain.institution;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.PlaybookDeliveryType;
import com.ziksana.domain.course.PlaybookStatus;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ProgramCurriculumPlaybook extends AuditHistory {
	
	public ProgramCurriculumPlaybook(Date brochureDate, Boolean active,
			PlaybookDeliveryType deliveryType, String layoutMarkupPath,
			String contentMarkupPath, PlaybookStatus pbStatus,
			String brochureContentPath) {
		this.brochureDate = brochureDate;
		this.active = active;
		this.deliveryType = deliveryType;
		this.layoutMarkupPath = layoutMarkupPath;
		this.contentMarkupPath = contentMarkupPath;
		this.pbStatus = pbStatus;
		this.brochureContentPath = brochureContentPath;
	}

	  private ZID 					progCurriculumPlaybookId; 
	  private Date 					brochureDate 		= null; 
	  private Boolean 				active 				= null;  
	  private PlaybookDeliveryType 	deliveryType 		= null; 
	  private String 				layoutMarkupPath 	= null; 
	  private String 				contentMarkupPath 	= null; 
	  private PlaybookStatus 		pbStatus 			= null; 
	  private String 				brochureContentPath = null; 
	  private LearningProgram 		learningProgram 	= null;
	  private ProgramCurriculum 	progCurriculum 		= null;
	  
	  
	/**
	 * @return the progCurriculumPlaybookId
	 */
	public ZID getProgCurriculumPlaybookId() {
		return progCurriculumPlaybookId;
	}
	/**
	 * @param progCurriculumPlaybookId the progCurriculumPlaybookId to set
	 */
	public void setProgCurriculumPlaybookId(Integer progCurriculumPlaybookId) {
		this.progCurriculumPlaybookId = new IntegerZID(progCurriculumPlaybookId);
	}
	/**
	 * @return the brochureDate
	 */
	public Date getBrochureDate() {
		return brochureDate;
	}
	/**
	 * @param brochureDate the brochureDate to set
	 */
	public void setBrochureDate(Date brochureDate) {
		this.brochureDate = brochureDate;
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
	 * @return the deliveryType
	 */
	public PlaybookDeliveryType getDeliveryType() {
		return deliveryType;
	}
	/**
	 * @param deliveryType the deliveryType to set
	 */
	public void setDeliveryType(PlaybookDeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	/**
	 * @return the layoutMarkupPath
	 */
	public String getLayoutMarkupPath() {
		return layoutMarkupPath;
	}
	/**
	 * @param layoutMarkupPath the layoutMarkupPath to set
	 */
	public void setLayoutMarkupPath(String layoutMarkupPath) {
		this.layoutMarkupPath = layoutMarkupPath;
	}
	/**
	 * @return the contentMarkupPath
	 */
	public String getContentMarkupPath() {
		return contentMarkupPath;
	}
	/**
	 * @param contentMarkupPath the contentMarkupPath to set
	 */
	public void setContentMarkupPath(String contentMarkupPath) {
		this.contentMarkupPath = contentMarkupPath;
	}
	/**
	 * @return the pbStatus
	 */
	public PlaybookStatus getPbStatus() {
		return pbStatus;
	}
	/**
	 * @param pbStatus the pbStatus to set
	 */
	public void setPbStatus(PlaybookStatus pbStatus) {
		this.pbStatus = pbStatus;
	}
	/**
	 * @return the brochureContentPath
	 */
	public String getBrochureContentPath() {
		return brochureContentPath;
	}
	/**
	 * @param brochureContentPath the brochureContentPath to set
	 */
	public void setBrochureContentPath(String brochureContentPath) {
		this.brochureContentPath = brochureContentPath;
	}
	/**
	 * @return the learningProgram
	 */
	public LearningProgram getLearningProgram() {
		return learningProgram;
	}
	/**
	 * @param learningProgram the learningProgram to set
	 */
	public void setLearningProgram(LearningProgram learningProgram) {
		this.learningProgram = learningProgram;
	}
	/**
	 * @return the progCurriculum
	 */
	public ProgramCurriculum getProgCurriculum() {
		return progCurriculum;
	}
	/**
	 * @param progCurriculum the progCurriculum to set
	 */
	public void setProgCurriculum(ProgramCurriculum progCurriculum) {
		this.progCurriculum = progCurriculum;
	} 

	@Override
	public String toString() {
		return "ProgramCurriculumPlaybook [brochureDate=" + brochureDate
				+ ", active=" + active + ", deliveryType=" + deliveryType
				+ ", layoutMarkupPath=" + layoutMarkupPath
				+ ", contentMarkupPath=" + contentMarkupPath + ", pbStatus="
				+ pbStatus + ", brochureContentPath=" + brochureContentPath
				+ "]";
	}

}
