/**
 * 
 */
package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CoursePlaybookView extends AuditHistory {
	
	  public CoursePlaybookView(String name, PlaybookDeliveryType deliveryType,
			String layoutMarkupPath, String contentMarkupPath,
			CoursePlaybookStatus coursePlaybookStatus,
			String brochureContentPath) {
		this.name = name;
		this.deliveryType = deliveryType;
		this.layoutMarkupPath = layoutMarkupPath;
		this.contentMarkupPath = contentMarkupPath;
		this.coursePlaybookStatus = coursePlaybookStatus;
		this.brochureContentPath = brochureContentPath;
	}


	  private ZID 						coursePlaybookViewId; 
	  private String 					name 					= null;
	  private String					description				= null;
	  private PlaybookDeliveryType 		deliveryType 			= null; 
	  private String 					layoutMarkupPath 		= null; 
	  private String 					contentMarkupPath  		= null;
	  private CoursePlaybookStatus 		coursePlaybookStatus 	= null; 
	  private String 					brochureContentPath 	= null; 
	  private RecipientStudentModel 	recStudentModel 		= null;
	  private CoursePlaybook 			coursePlaybook 			= null; 
	  private LearningComponent 		learningComponent 		= null;
	  
	/**
	 * @return the coursePlaybookViewId
	 */
	public ZID getCoursePlaybookViewId() {
		return coursePlaybookViewId;
	}
	/**
	 * @param coursePlaybookViewId the coursePlaybookViewId to set
	 */
	public void setCoursePlaybookViewId(ZID coursePlaybookViewId) {
		this.coursePlaybookViewId = coursePlaybookViewId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the coursePlaybookStatus
	 */
	public CoursePlaybookStatus getCoursePlaybookStatus() {
		return coursePlaybookStatus;
	}
	/**
	 * @param coursePlaybookStatus the coursePlaybookStatus to set
	 */
	public void setCoursePlaybookStatus(CoursePlaybookStatus coursePlaybookStatus) {
		this.coursePlaybookStatus = coursePlaybookStatus;
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
	 * @return the recStudentModel
	 */
	public RecipientStudentModel getRecStudentModel() {
		return recStudentModel;
	}
	/**
	 * @param recStudentModel the recStudentModel to set
	 */
	public void setRecStudentModel(RecipientStudentModel recStudentModel) {
		this.recStudentModel = recStudentModel;
	}
	/**
	 * @return the coursePlaybook
	 */
	public CoursePlaybook getCoursePlaybook() {
		return coursePlaybook;
	}
	/**
	 * @param coursePlaybook the coursePlaybook to set
	 */
	public void setCoursePlaybook(CoursePlaybook coursePlaybook) {
		this.coursePlaybook = coursePlaybook;
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
	  

	public String toString() {
		return "CoursePlaybookView [name=" + name + ", deliveryType="
				+ deliveryType + ", layoutMarkupPath=" + layoutMarkupPath
				+ ", contentMarkupPath=" + contentMarkupPath
				+ ", coursePlaybookStatus=" + coursePlaybookStatus
				+ ", brochureContentPath=" + brochureContentPath + "]";
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
