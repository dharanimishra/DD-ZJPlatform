package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utilz.SubjectClassification;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Course extends AuditHistory{

	public Course() {
		setCourseStatus(CourseStatus.DRAFT);
	}
	
	public Course(String name, String description, CourseStatus courseStatus,
			Duration courseDuration,	MemberPersona accountableMember) {
		this.name = name;
		this.description = description;
		this.courseStatus = courseStatus;
		this.courseDuration = courseDuration;
		this.accountableMember = accountableMember;
	}


	public Course(String name, String description, CourseStatus courseStatus,
			Duration courseDuration,
			MemberPersona accountableMember, List<LearningComponent> learningComponentList) {
		this.name = name;
		this.description = description;
		this.courseStatus = courseStatus;
		this.courseDuration = courseDuration;
		this.accountableMember = accountableMember;
		this.getCourseDetails().learningComponents =learningComponentList;
	}

	private ZID 					courseId;
	/**
	 * Maximum Length:45
	 */
	private String 					name 					= null;
	/**
	 * Maximum Length:240
	 */
	private String 					description 			= null;
	/**
	 * Course Start Date is for when Course is associate to curriculumm
	 */
	private Date 					validFromDate 			= null;
	/**
	 * Course End Date is for When Course is associate to curriculumm
	 */
	private Date 					validToDate 			= null;
	private CourseStatus 			courseStatus 			= null;
	private Rating 					rating 					= null;
	private Boolean 				securityIndicator 		= null;
	private CourseContentSecurity	courseContSecurity 		= null;
	/**
	 * Maximum Length:5
	 */
	private String 					courseCredits 			= null;
	/**
	 *  Maximum Length:5
	 */
	private String 					extraCredits			= null;
	private Boolean 				additionalInfoIndicator	= null;
	/**
	 * Maximum Length:72
	 */
	private String 					thumbnailPicturePath 	= null;
	private Duration 				courseDuration			= null;
	private SubjectClassification 	subjClassification	 	= null;
	private MemberPersona 			accountableMember 		= null;
	private CourseDetails 			courseDetails 			= null;
	private Integer					courseProgress			= null;
	private List<CourseTagcloud> 	courseTagClouds			= null;
	/**
	 * Maximum Length:240
	 */
	private String 					versionRemarks 	= null;
	private Integer 				version 		= null;

	/**
	 * @param index
	 * @return
	 */
	public CourseTagcloud getCourseTagcloud(int index){
		
		if(courseTagClouds == null){
			throw new IllegalArgumentException("Course Tag cloud cannot set to null");
		}
		
		try{
			return courseTagClouds.get(index);
		}catch(Exception e){
			throw new IllegalStateException("Course Tag cloud at index ["+index+"]  not found");
		}
	}
	
	/**
	 * @param tagCloud
	 */
	public void addCourseTagcloud(CourseTagcloud tagCloud){
		
		if(courseTagClouds == null){
			courseTagClouds = new ArrayList<CourseTagcloud>();
		}
		
		tagCloud.setCourse(this);
		
		courseTagClouds.add(tagCloud);

	}

	/**
	 * @param courseTagClouds the courseTagClouds to set
	 */
	public void setCourseTagClouds(List<CourseTagcloud> courseTagClouds) {
		this.courseTagClouds = courseTagClouds;
	}


	/**
	 * @return the value of attribute Name
	 */
	public String getName() {
		return name;
	}
/*	*//**
	 *//*
	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	*//**
	 *//*
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier == null ? null
				: courseIdentifier.trim();
	}
*/	/**
	 * @param name
 * @throws Exception 
	 * @throws NullPointerException
	 */
	public void setName(String name) throws Exception {
		if (name == null) {
			throw new IllegalArgumentException("Null name passed");
		}
			this.name = name;
	}
	/**
	 * @return the value of attribute Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the value for attribute Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * @return the validFromDate
	 */
	public Date getValidFromDate() {
		return validFromDate;
	}

	/**
	 * @param validFromDate the validFromDate to set
	 */
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	/**
	 * @return the validToDate
	 */
	public Date getValidToDate() {
		return validToDate;
	}

	/**
	 * @param validToDate the validToDate to set
	 */
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	/**
	 * @return the value of attribute Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the value for attribute Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @return the value of attribute courseId
	 */
	public ZID getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the value for attribute courseId
	 */
	public void setCourseId(ZID courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseDetails
	 */
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}

	/**
	 * @param courseDetails
	 *            the courseDetails to set
	 */
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}


	/**
	 * @return the courseProgress
	 */
	public Integer getCourseProgress() {
		return courseProgress;
	}

	/**
	 * @param courseProgress the courseProgress to set
	 */
	public void setCourseProgress(Integer courseProgress) {
		this.courseProgress = courseProgress;
	}

	public String getExtraCredits() {
		return extraCredits;
	}

	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits;
	}

	public Boolean getAdditionalInfoIndicator() {
		return additionalInfoIndicator;
	}

	public void setAdditionalInfoIndicator(
			Boolean additionalInfoIndicator) {
		this.additionalInfoIndicator = additionalInfoIndicator;
	}

	public Duration getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Duration courseDuration) {
		if(courseDuration == null){
			throw new IllegalArgumentException("Duration is cannot set to null");
		}
		this.courseDuration = courseDuration;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus
	 *            the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	/**
	 * @return the securityIndicator
	 */
	public Boolean getSecurityIndicator() {
		return securityIndicator;
	}

	/**
	 * @param securityIndicator the securityIndicator to set
	 */
	public void setSecurityIndicator(Boolean securityIndicator) {
		this.securityIndicator = securityIndicator;
	}

	public CourseContentSecurity getCourseContSecurity() {
		return courseContSecurity;
	}

	public void setCourseContSecurity(CourseContentSecurity courseContSecurity) {
		this.courseContSecurity = courseContSecurity;
	}

	/**
	 * @return the courseCredits
	 */
	public String getCourseCredits() {
		return courseCredits;
	}

	/**
	 * @param courseCredits the courseCredits to set
	 */
	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}

	/**
	 * @return the accountableMember
	 */
	public MemberPersona getAccountableMember() {
		return accountableMember;
	}

	/**
	 * @param accountableMember the accountableMember to set
	 */
	public void setAccountableMember(MemberPersona accountableMember) {
		this.accountableMember = accountableMember;
	}

	/**
	 * @return the subjClassification
	 */
	public SubjectClassification getSubjClassification() {
		return subjClassification;
	}

	/**
	 * @param subjClassification the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	/**
	 * @return the versionRemarks
	 */
	public String getVersionRemarks() {
		return versionRemarks;
	}

	/**
	 * @param versionRemarks the versionRemarks to set
	 */
	public void setVersionRemarks(String versionRemarks) {
		this.versionRemarks = versionRemarks;
	}

	public String toString() {
		return "Course [name=" + name + ", courseStatus=" + courseStatus
				+ ", courseDuration=" + courseDuration + "]";
	}


}