/**
 * 
 */
package com.ziksana.domain.institution;

import java.util.Date;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CurriculumDelivery extends AuditHistory {

	
	  public CurriculumDelivery(Date startDate, Date endDate, Boolean active,
			CurriculumTerm term) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
		this.term = term;
	}

	private ZID 				curriculumDeliveryId; 
	  private Date 				startDate 				= null; 
	  private Date 				endDate 				= null; 
	  private Boolean 			active 					= null; 
	  private CurriculumTerm 	term 					= null; 
	  private Boolean 			specialEditionIndicator = null; 
	  private ProgramCurriculum programCurriculum 		= null; 
	  private CurriculumCourse 	curriculumCourse 		= null;
	  
	/**
	 * @return the curriculumDeliveryId
	 */
	public ZID getCurriculumDeliveryId() {
		return curriculumDeliveryId;
	}
	/**
	 * @param curriculumDeliveryId the curriculumDeliveryId to set
	 */
	public void setCurriculumDeliveryId(ZID curriculumDeliveryId) {
		this.curriculumDeliveryId = curriculumDeliveryId;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return the term
	 */
	public CurriculumTerm getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(CurriculumTerm term) {
		this.term = term;
	}
	/**
	 * @return the specialEditionIndicator
	 */
	public Boolean getSpecialEditionIndicator() {
		return specialEditionIndicator;
	}
	/**
	 * @param specialEditionIndicator the specialEditionIndicator to set
	 */
	public void setSpecialEditionIndicator(Boolean specialEditionIndicator) {
		this.specialEditionIndicator = specialEditionIndicator;
	}
	/**
	 * @return the programCurriculum
	 */
	public ProgramCurriculum getProgramCurriculum() {
		return programCurriculum;
	}
	/**
	 * @param programCurriculum the programCurriculum to set
	 */
	public void setProgramCurriculum(ProgramCurriculum programCurriculum) {
		this.programCurriculum = programCurriculum;
	}
	/**
	 * @return the curriculumCourse
	 */
	public CurriculumCourse getCurriculumCourse() {
		return curriculumCourse;
	}
	/**
	 * @param curriculumCourse the curriculumCourse to set
	 */
	public void setCurriculumCourse(CurriculumCourse curriculumCourse) {
		this.curriculumCourse = curriculumCourse;
	}   

	@Override
	public String toString() {
		return "CurriculumDelivery [startDate=" + startDate + ", endDate="
				+ endDate + ", active=" + active + ", term=" + term
				+ ", specialEditionIndicator=" + specialEditionIndicator + "]";
	}

}
