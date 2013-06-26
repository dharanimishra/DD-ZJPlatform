package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class LearningComponentContentEnrichment extends AuditHistory {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContentEnrichment 			contentEnrichment;
	private ZID LearningComponentContentEnrichmentId;
	private Integer 					id;
	private Boolean 					active 						= null;
	private LearningComponentContent 	learningComponentContent 	= null;
	private Course						course = null;
	private CurriculumCourse curriculumCourse = null;
	private Boolean isDelete;
	private Integer visibility;
	private Integer overrideAt;
	private MemberPersona creatingMember = null;

	
	
	
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
	 * @return the learningComponentContent
	 */
	public LearningComponentContent getLearningComponentContent() {
		return learningComponentContent;
	}
	/**
	 * @param learningComponentContent the learningComponentContent to set
	 */
	public void setLearningComponentContent(
			LearningComponentContent learningComponentContent) {
		this.learningComponentContent = learningComponentContent;
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
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
	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
		setLearningComponentContentEnrichmentId(new IntegerZID(id));
	}
	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the overrideAt
	 */
	public Integer getOverrideAt() {
		return overrideAt;
	}
	/**
	 * @param overrideAt the overrideAt to set
	 */
	public void setOverrideAt(Integer overrideAt) {
		this.overrideAt = overrideAt;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the contentEnrichment
	 */
	public ContentEnrichment getContentEnrichment() {
		return contentEnrichment;
	}
	/**
	 * @param contentEnrichment the contentEnrichment to set
	 */
	public void setContentEnrichment(ContentEnrichment contentEnrichment) {
		this.contentEnrichment = contentEnrichment;
	}
	/**
	 * @return the learningComponentContentEnrichmentId
	 */
	public ZID getLearningComponentContentEnrichmentId() {
		return LearningComponentContentEnrichmentId;
	}
	/**
	 * @param learningComponentContentEnrichmentId the learningComponentContentEnrichmentId to set
	 */
	private void setLearningComponentContentEnrichmentId(
			ZID learningComponentContentEnrichmentId) {
		LearningComponentContentEnrichmentId = learningComponentContentEnrichmentId;
	}
	/**
	 * @return the creatingMember
	 */
	public MemberPersona getCreatingMember() {
		return creatingMember;
	}
	/**
	 * @param creatingMember the creatingMember to set
	 */
	public void setCreatingMember(MemberPersona creatingMember) {
		this.creatingMember = creatingMember;
	}
	
	
}