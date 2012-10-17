package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class ApplyEmbed extends AuditHistory{
	
	public ApplyEmbed(){
		visibility = Visibility.ALL;
	}
	
	private ZID 					applyEmbedId;
	private Boolean 				active 					= null;
	private Visibility 				visibility 				= null;
	private Integer 				overrideAt 				= null;
	private Course 					course 					= null;
	private LearningContent 		learningContent 		= null;
	private LearningComponent		learningComponent 		= null;
	//private CurriculumCourse 		curriculumCourse 		= null;
	private MemberPersona  			creatorMemberPersona 	= null;
	/**
	 * @return the applyEmbedId
	 */
	public ZID getApplyEmbedId() {
		return applyEmbedId;
	}
	/**
	 * @param applyEmbedId the applyEmbedId to set
	 */
	public void setApplyEmbedId(ZID applyEmbedId) {
		this.applyEmbedId = applyEmbedId;
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
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Visibility visibility) {
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
	 * @return the learningContent
	 */
	public LearningContent getLearningContent() {
		return learningContent;
	}
	/**
	 * @param learningContent the learningContent to set
	 */
	public void setLearningContent(LearningContent learningContent) {
		this.learningContent = learningContent;
	}
	/**
	 * @return the learningComponent
	 */
	public LearningComponent getLearningComponent() {
		return learningComponent;
	}
	/**
	 * @param learningComponent the learningComponent to set
	 */
	public void setLearningComponent(LearningComponent learningComponent) {
		this.learningComponent = learningComponent;
	}
	/**
	 * @return the creatorMemberPersona
	 */
	public MemberPersona getCreatorMemberPersona() {
		return creatorMemberPersona;
	}
	/**
	 * @param creatorMemberPersona the creatorMemberPersona to set
	 */
	public void setCreatorMemberPersona(MemberPersona creatorMemberPersona) {
		this.creatorMemberPersona = creatorMemberPersona;
	}
	
	@Override
	public String toString() {
		return "ApplyEmbed [active=" + active + ", visibility=" + visibility
				+ ", overrideAt=" + overrideAt + "]";
	}

}
