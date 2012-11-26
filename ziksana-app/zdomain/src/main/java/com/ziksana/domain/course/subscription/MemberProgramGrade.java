package com.ziksana.domain.course.subscription;

import java.util.Date;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class MemberProgramGrade {
	
	private ZID 			memberProgramGradeId;
	private Date 			creationDate 				= null;
	private GradeStatus		status						= null;
	private Integer			overAllGrade				= null;
	private Integer			attendanceGrade				= null;
	private Integer			participationGrade			= null;
	private Integer			peerWorkGrade				= null;
	private Integer			badgeGrade					= null;
	private Integer			comparativePositionTerm 	= null;
	private Integer			overAllComparativePosition 	= null;
	private String			overAllReflectionComment 	= null;
	private MemberSubscriptionProgram memberSbnProgram 	= null;
	/**
	 * @return the memberProgramGradeId
	 */
	public ZID getMemberProgramGradeId() {
		return memberProgramGradeId;
	}
	/**
	 * @param memberProgramGradeId the memberProgramGradeId to set
	 */
	public void setMemberProgramGradeId(Integer memberProgramGradeId) {
		this.memberProgramGradeId = new IntegerZID(memberProgramGradeId);
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
	 * @return the status
	 */
	public GradeStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GradeStatus status) {
		this.status = status;
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
	/**
	 * @return the memberSbnProgram
	 */
	public MemberSubscriptionProgram getMemberSbnProgram() {
		return memberSbnProgram;
	}
	/**
	 * @param memberSbnProgram the memberSbnProgram to set
	 */
	public void setMemberSbnProgram(MemberSubscriptionProgram memberSbnProgram) {
		this.memberSbnProgram = memberSbnProgram;
	}
}
