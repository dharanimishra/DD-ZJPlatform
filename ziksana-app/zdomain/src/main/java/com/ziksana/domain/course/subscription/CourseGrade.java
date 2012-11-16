package com.ziksana.domain.course.subscription;

import java.util.Date;

import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class CourseGrade {
	
	private ZID 			courseGradeId;
	private Date 			creationDate 				= null;
	private GradeStatus 	gradeStatus 				= null;
	private Integer			overAllGrade				= null;
	private Integer			attendanceGrade				= null;
	private Integer			participationGrade			= null;
	private Integer			peerWorkGrade				= null;
	private Integer			badgeGrade					= null;
	private Integer			comparativePositionTerm 	= null;
	private Integer			overAllComparativePosition 	= null;
	private String			overAllReflectionComment 	= null;
	private SubscriptionCourse	subscriptionCourse 		= null;
	
	/**
	 * @return the courseGradeId
	 */
	public ZID getCourseGradeId() {
		return courseGradeId;
	}
	/**
	 * @param courseGradeId the courseGradeId to set
	 */
	public void setCourseGradeId(ZID courseGradeId) {
		this.courseGradeId = courseGradeId;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the gradeStatus
	 */
	public GradeStatus getGradeStatus() {
		return gradeStatus;
	}
	/**
	 * @param gradeStatus the gradeStatus to set
	 */
	public void setGradeStatus(GradeStatus gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	/**
	 * @return the overAllGrade
	 */
	public Integer getOverAllGrade() {
		return overAllGrade;
	}
	/**
	 * @param overAllGrade the overAllGrade to set
	 */
	public void setOverAllGrade(Integer overAllGrade) {
		this.overAllGrade = overAllGrade;
	}
	/**
	 * @return the attendanceGrade
	 */
	public Integer getAttendanceGrade() {
		return attendanceGrade;
	}
	/**
	 * @param attendanceGrade the attendanceGrade to set
	 */
	public void setAttendanceGrade(Integer attendanceGrade) {
		this.attendanceGrade = attendanceGrade;
	}
	/**
	 * @return the participationGrade
	 */
	public Integer getParticipationGrade() {
		return participationGrade;
	}
	/**
	 * @param participationGrade the participationGrade to set
	 */
	public void setParticipationGrade(Integer participationGrade) {
		this.participationGrade = participationGrade;
	}
	/**
	 * @return the peerWorkGrade
	 */
	public Integer getPeerWorkGrade() {
		return peerWorkGrade;
	}
	/**
	 * @param peerWorkGrade the peerWorkGrade to set
	 */
	public void setPeerWorkGrade(Integer peerWorkGrade) {
		this.peerWorkGrade = peerWorkGrade;
	}
	/**
	 * @return the badgeGrade
	 */
	public Integer getBadgeGrade() {
		return badgeGrade;
	}
	/**
	 * @param badgeGrade the badgeGrade to set
	 */
	public void setBadgeGrade(Integer badgeGrade) {
		this.badgeGrade = badgeGrade;
	}
	/**
	 * @return the comparativePositionTerm
	 */
	public Integer getComparativePositionTerm() {
		return comparativePositionTerm;
	}
	/**
	 * @param comparativePositionTerm the comparativePositionTerm to set
	 */
	public void setComparativePositionTerm(Integer comparativePositionTerm) {
		this.comparativePositionTerm = comparativePositionTerm;
	}
	/**
	 * @return the overAllComparativePosition
	 */
	public Integer getOverAllComparativePosition() {
		return overAllComparativePosition;
	}
	/**
	 * @param overAllComparativePosition the overAllComparativePosition to set
	 */
	public void setOverAllComparativePosition(Integer overAllComparativePosition) {
		this.overAllComparativePosition = overAllComparativePosition;
	}
	/**
	 * @return the overAllReflectionComment
	 */
	public String getOverAllReflectionComment() {
		return overAllReflectionComment;
	}
	/**
	 * @param overAllReflectionComment the overAllReflectionComment to set
	 */
	public void setOverAllReflectionComment(String overAllReflectionComment) {
		this.overAllReflectionComment = overAllReflectionComment;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseGrade [creationDate=" + creationDate + ", gradeStatus="
				+ gradeStatus + ", overAllGrade=" + overAllGrade
				+ ", attendanceGrade=" + attendanceGrade
				+ ", participationGrade=" + participationGrade
				+ ", peerWorkGrade=" + peerWorkGrade + ", badgeGrade="
				+ badgeGrade + ", comparativePositionTerm="
				+ comparativePositionTerm + ", overAllComparativePosition="
				+ overAllComparativePosition + ", overAllReflectionComment="
				+ overAllReflectionComment + "]";
	}
	/**
	 * @return the subscriptionCourse
	 */
	public SubscriptionCourse getSubscriptionCourse() {
		return subscriptionCourse;
	}
	/**
	 * @param subscriptionCourse the subscriptionCourse to set
	 */
	public void setSubscriptionCourse(SubscriptionCourse subscriptionCourse) {
		this.subscriptionCourse = subscriptionCourse;
	}
	

}
