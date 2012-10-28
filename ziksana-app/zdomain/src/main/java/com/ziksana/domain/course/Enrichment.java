/**
 * 
 */
package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Enrichment extends AuditHistory {


	private ZID 					enrichId;
	private Boolean 				active 					= null;
	private Visibility 				visibility 				= null;
	private Integer 				overrideAt 				= null;
	
	private ContentEnrichment		contentEnrich			= null;
	private Course 					course 					= null;
	private LearningContent 		learningContent 		= null;
	private LearningComponent		learningComponent 		= null;
	//private CurriculumCourse 		curriculumCourse 		= null;
	private MemberPersona  			creatorMemberPersona 	= null;
	
	/**
	 * @return the enrichId
	 */
	public ZID getEnrichId() {
		return enrichId;
	}


	/**
	 * @param enrichId the enrichId to set
	 */
	public void setEnrichId(ZID enrichId) {
		this.enrichId = enrichId;
	}


	public Enrichment() {
		visibility = Visibility.ALL;
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
	 * @return the contentEnrich
	 */
	public ContentEnrichment getContentEnrich() {
		return contentEnrich;
	}


	/**
	 * @param contentEnrich the contentEnrich to set
	 */
	public void setContentEnrich(ContentEnrichment contentEnrich) {
		this.contentEnrich = contentEnrich;
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
		return "ApplyEnrichment [active=" + active + ", visibility="
				+ visibility + ", overrideAt=" + overrideAt + "]";
	}


}
