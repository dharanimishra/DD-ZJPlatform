/**
 * 
 */
package com.ziksana.domain.course;

import com.ziksana.domain.common.AuditHistory;

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
		this.layoutPath = layoutMarkupPath;
		this.contentPath = contentMarkupPath;
		this.coursePlaybookStatus = coursePlaybookStatus;
		this.brochurePath = brochureContentPath;
	}

	  public CoursePlaybookView(){
		  
	  }
	  private Integer					coursePlaybookViewId; 
	  private String 					name 					= null;
	  private String					description				= null;
	  private PlaybookDeliveryType 		deliveryType 			= null;
	  private Integer			 		deliveryTypeId 			= null;
	  private String 					layoutPath 				= null; 
	  private String 					contentPath  			= null;
	  private CoursePlaybookStatus 		coursePlaybookStatus 	= null;
	  private Integer 					coursePlaybookStatusId 	= null;
	  private String 					brochurePath 			= null; 
	  private RecipientStudentModel 	recStudentModel 		= null;
	  private Integer 					recStudentModelId 		= null;
	  private CoursePlaybook 			coursePlaybook 			= null; 
	  private LearningComponent 		learningComponent 		= null;
	  
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
		
		if(deliveryTypeId!=null){
			deliveryType = PlaybookDeliveryType.getPlaybookDeliveryType(deliveryTypeId);	
		}
		
		this.deliveryType = deliveryType;
	}
	/**
	 * @return the layoutMarkupPath
	 */
	public String getLayoutMarkupPath() {
		return layoutPath;
	}
	/**
	 * @param layoutMarkupPath the layoutMarkupPath to set
	 */
	public void setLayoutMarkupPath(String layoutMarkupPath) {
		this.layoutPath = layoutMarkupPath;
	}
	/**
	 * @return the contentMarkupPath
	 */
	public String getContentMarkupPath() {
		return contentPath;
	}
	/**
	 * @param contentMarkupPath the contentMarkupPath to set
	 */
	public void setContentMarkupPath(String contentMarkupPath) {
		this.contentPath = contentMarkupPath;
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
		
		if(coursePlaybookStatusId!=null){
			coursePlaybookStatus = CoursePlaybookStatus.getCoursePlaybookStatus(coursePlaybookStatusId);
		}
		this.coursePlaybookStatus = coursePlaybookStatus;
	}
	/**
	 * @return the brochureContentPath
	 */
	public String getBrochureContentPath() {
		return brochurePath;
	}
	/**
	 * @param brochureContentPath the brochureContentPath to set
	 */
	public void setBrochureContentPath(String brochureContentPath) {
		this.brochurePath = brochureContentPath;
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
		
		if(recStudentModelId!=null){
			recStudentModel = RecipientStudentModel.getRecipientStudentModel(recStudentModelId);
		}
		
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

	/**
	 * @return the deliveryTypeId
	 */
	public Integer getDeliveryTypeId() {
		return deliveryTypeId;
	}

	/**
	 * @param deliveryTypeId the deliveryTypeId to set
	 */
	public void setDeliveryTypeId(Integer deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}

	/**
	 * @return the coursePlaybookStatusId
	 */
	public Integer getCoursePlaybookStatusId() {
		return coursePlaybookStatusId;
	}

	/**
	 * @param coursePlaybookStatusId the coursePlaybookStatusId to set
	 */
	public void setCoursePlaybookStatusId(Integer coursePlaybookStatusId) {
		this.coursePlaybookStatusId = coursePlaybookStatusId;
	}

	/**
	 * @return the recStudentModelId
	 */
	public Integer getRecStudentModelId() {
		return recStudentModelId;
	}

	/**
	 * @param recStudentModelId the recStudentModelId to set
	 */
	public void setRecStudentModelId(Integer recStudentModelId) {
		this.recStudentModelId = recStudentModelId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CoursePlaybookView [coursePlaybookViewId="
				+ coursePlaybookViewId + ", name=" + name + ", description="
				+ description + ", deliveryType=" + deliveryType
				+ ", deliveryTypeId=" + deliveryTypeId + ", layoutPath="
				+ layoutPath + ", contentPath=" + contentPath
				+ ", coursePlaybookStatus=" + coursePlaybookStatus
				+ ", coursePlaybookStatusId=" + coursePlaybookStatusId
				+ ", brochurePath=" + brochurePath + ", recStudentModel="
				+ recStudentModel + ", recStudentModelId=" + recStudentModelId
				+ ", coursePlaybook=" + coursePlaybook + ", learningComponent="
				+ learningComponent + "]";
	}

	/**
	 * @return the coursePlaybookViewId
	 */
	public Integer getCoursePlaybookViewId() {
		return coursePlaybookViewId;
	}

	/**
	 * @param coursePlaybookViewId the coursePlaybookViewId to set
	 */
	public void setCoursePlaybookViewId(Integer coursePlaybookViewId) {
		this.coursePlaybookViewId = coursePlaybookViewId;
	}

}
