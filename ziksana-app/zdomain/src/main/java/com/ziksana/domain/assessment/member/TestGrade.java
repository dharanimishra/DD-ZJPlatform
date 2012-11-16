package com.ziksana.domain.assessment.member;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestGrade {
	
	private ZID 			testGradeId;
	private String 			grade 						= null;
	private GradeVisibility visibility 					= null;
	private Boolean 		isZeniGraded 				= null;
	private Boolean 		isZeniGradedUsed 			= null;
	private Boolean 		isFacilitationNeeded 		= null;
	private Boolean 		isFacilitationCompleted 	= null;
	private Boolean 		isFacilitationUsed 			= null;
	private Boolean 		isPeerEvaluation 			= null;
	private MemberPersona 	evaluatingMemberRole 		= null;
	private StudentTest		studentTest 				= null;
	
	/**
	 * @return the testGradeId
	 */
	public ZID getTestGradeId() {
		return testGradeId;
	}
	/**
	 * @param testGradeId the testGradeId to set
	 */
	public void setTestGradeId(ZID testGradeId) {
		this.testGradeId = testGradeId;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the visibility
	 */
	public GradeVisibility getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(GradeVisibility visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the isZeniGraded
	 */
	public Boolean getIsZeniGraded() {
		return isZeniGraded;
	}
	/**
	 * @param isZeniGraded the isZeniGraded to set
	 */
	public void setIsZeniGraded(Boolean isZeniGraded) {
		this.isZeniGraded = isZeniGraded;
	}
	/**
	 * @return the isZeniGradedUsed
	 */
	public Boolean getIsZeniGradedUsed() {
		return isZeniGradedUsed;
	}
	/**
	 * @param isZeniGradedUsed the isZeniGradedUsed to set
	 */
	public void setIsZeniGradedUsed(Boolean isZeniGradedUsed) {
		this.isZeniGradedUsed = isZeniGradedUsed;
	}
	/**
	 * @return the isFacilitationNeeded
	 */
	public Boolean getIsFacilitationNeeded() {
		return isFacilitationNeeded;
	}
	/**
	 * @param isFacilitationNeeded the isFacilitationNeeded to set
	 */
	public void setIsFacilitationNeeded(Boolean isFacilitationNeeded) {
		this.isFacilitationNeeded = isFacilitationNeeded;
	}
	/**
	 * @return the isFacilitationCompleted
	 */
	public Boolean getIsFacilitationCompleted() {
		return isFacilitationCompleted;
	}
	/**
	 * @param isFacilitationCompleted the isFacilitationCompleted to set
	 */
	public void setIsFacilitationCompleted(Boolean isFacilitationCompleted) {
		this.isFacilitationCompleted = isFacilitationCompleted;
	}
	/**
	 * @return the isFacilitationUsed
	 */
	public Boolean getIsFacilitationUsed() {
		return isFacilitationUsed;
	}
	/**
	 * @param isFacilitationUsed the isFacilitationUsed to set
	 */
	public void setIsFacilitationUsed(Boolean isFacilitationUsed) {
		this.isFacilitationUsed = isFacilitationUsed;
	}
	/**
	 * @return the isPeerEvaluation
	 */
	public Boolean getIsPeerEvaluation() {
		return isPeerEvaluation;
	}
	/**
	 * @param isPeerEvaluation the isPeerEvaluation to set
	 */
	public void setIsPeerEvaluation(Boolean isPeerEvaluation) {
		this.isPeerEvaluation = isPeerEvaluation;
	}
	/**
	 * @return the evaluatingMemberRole
	 */
	public MemberPersona getEvaluatingMemberRole() {
		return evaluatingMemberRole;
	}
	/**
	 * @param evaluatingMemberRole the evaluatingMemberRole to set
	 */
	public void setEvaluatingMemberRole(MemberPersona evaluatingMemberRole) {
		this.evaluatingMemberRole = evaluatingMemberRole;
	}
	/**
	 * @return the studentTest
	 */
	public StudentTest getStudentTest() {
		return studentTest;
	}
	/**
	 * @param studentTest the studentTest to set
	 */
	public void setStudentTest(StudentTest studentTest) {
		this.studentTest = studentTest;
	}

	@Override
	public String toString() {
		return "TestGrade [grade=" + grade + ", visibility=" + visibility
				+ ", isZeniGraded=" + isZeniGraded + ", isZeniGradedUsed="
				+ isZeniGradedUsed + ", isFacilitationNeeded="
				+ isFacilitationNeeded + ", isFacilitationCompleted="
				+ isFacilitationCompleted + ", isFacilitationUsed="
				+ isFacilitationUsed + ", isPeerEvaluation=" + isPeerEvaluation
				+ ", evaluatingMemberRole=" + evaluatingMemberRole + "]";
	}
	

}

