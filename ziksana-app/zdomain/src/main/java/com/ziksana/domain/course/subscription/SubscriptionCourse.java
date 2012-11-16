package com.ziksana.domain.course.subscription;

import java.util.Date;
import java.util.List;

import com.ziksana.domain.course.Rating;
import com.ziksana.domain.institution.CurriculumCourse;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class SubscriptionCourse {
	
	private ZID 		subscriptionCourseId;
	private Boolean 	isPrimary 						= null;
	private Boolean 	isSelf 							= null;
	private Date 		includedDate 					= null;
	private Boolean 	isZeniSuggested 				= null;
	private Rating 		contentRating 					= null; 
	private Rating 		contentAuthorRating 			= null;
	private String 		contentRatingDescription 		= null;
	private String 		contentAuthorRatingDescription 	= null;
	private MemberSubscriptionProgram 	memberSubscription		= null;
	private CurriculumCourse 			curriculumCourse		= null;
	private List<CourseItemProgress> 	courseItemProgressList 	= null;
	/**
	 * @return the subscriptionCourseId
	 */
	public ZID getSubscriptionCourseId() {
		return subscriptionCourseId;
	}
	/**
	 * @param subscriptionCourseId the subscriptionCourseId to set
	 */
	public void setSubscriptionCourseId(ZID subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}
	/**
	 * @return the isPrimary
	 */
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	/**
	 * @return the isSelf
	 */
	public Boolean getIsSelf() {
		return isSelf;
	}
	/**
	 * @param isSelf the isSelf to set
	 */
	public void setIsSelf(Boolean isSelf) {
		this.isSelf = isSelf;
	}
	/**
	 * @return the includedDate
	 */
	public Date getIncludedDate() {
		return includedDate;
	}
	/**
	 * @param includedDate the includedDate to set
	 */
	public void setIncludedDate(Date includedDate) {
		this.includedDate = includedDate;
	}
	/**
	 * @return the isZeniSuggested
	 */
	public Boolean getIsZeniSuggested() {
		return isZeniSuggested;
	}
	/**
	 * @param isZeniSuggested the isZeniSuggested to set
	 */
	public void setIsZeniSuggested(Boolean isZeniSuggested) {
		this.isZeniSuggested = isZeniSuggested;
	}
	/**
	 * @return the contentRating
	 */
	public Rating getContentRating() {
		return contentRating;
	}
	/**
	 * @param contentRating the contentRating to set
	 */
	public void setContentRating(Rating contentRating) {
		this.contentRating = contentRating;
	}
	/**
	 * @return the contentAuthorRating
	 */
	public Rating getContentAuthorRating() {
		return contentAuthorRating;
	}
	/**
	 * @param contentAuthorRating the contentAuthorRating to set
	 */
	public void setContentAuthorRating(Rating contentAuthorRating) {
		this.contentAuthorRating = contentAuthorRating;
	}
	/**
	 * @return the contentRatingDescription
	 */
	public String getContentRatingDescription() {
		return contentRatingDescription;
	}
	/**
	 * @param contentRatingDescription the contentRatingDescription to set
	 */
	public void setContentRatingDescription(String contentRatingDescription) {
		this.contentRatingDescription = contentRatingDescription;
	}
	/**
	 * @return the contentAuthorRatingDescription
	 */
	public String getContentAuthorRatingDescription() {
		return contentAuthorRatingDescription;
	}
	/**
	 * @param contentAuthorRatingDescription the contentAuthorRatingDescription to set
	 */
	public void setContentAuthorRatingDescription(
			String contentAuthorRatingDescription) {
		this.contentAuthorRatingDescription = contentAuthorRatingDescription;
	}
	/**
	 * @return the memberSubscription
	 */
	public MemberSubscriptionProgram getMemberSubscription() {
		return memberSubscription;
	}
	/**
	 * @param memberSubscription the memberSubscription to set
	 */
	public void setMemberSubscription(MemberSubscriptionProgram memberSubscription) {
		this.memberSubscription = memberSubscription;
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
	 * @return the courseItemProgressList
	 */
	public List<CourseItemProgress> getCourseItemProgressList() {
		return courseItemProgressList;
	}
	/**
	 * @param courseItemProgressList the courseItemProgressList to set
	 */
	public void setCourseItemProgressList(List<CourseItemProgress> courseItemProgressList) {
		this.courseItemProgressList = courseItemProgressList;
	}
	
	
	

}
