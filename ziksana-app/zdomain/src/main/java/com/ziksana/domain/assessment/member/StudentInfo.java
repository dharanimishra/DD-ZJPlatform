package com.ziksana.domain.assessment.member;

import java.util.Date;

/**
 * @author bhashasp
 */
public class StudentInfo {

	private String 		name 				= null;
	private Date 		testSubmissionDate 	= null;
	private String 		grade 				= null;
	private Integer 	timeSpentOnTest 	= null;
	private Integer 	numberOfAttemps 	= null;
	private Integer 	timeSpentOnCourse 	= null;
	private Integer 	groupParticipation 	= null;
	private Integer		progress			= null;
	
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
	 * @return the testSubmissionDate
	 */
	public Date getTestSubmissionDate() {
		return testSubmissionDate;
	}
	/**
	 * @param testSubmissionDate the testSubmissionDate to set
	 */
	public void setTestSubmissionDate(Date testSubmissionDate) {
		this.testSubmissionDate = testSubmissionDate;
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
	 * @return the timeSpentOnTest
	 */
	public Integer getTimeSpentOnTest() {
		return timeSpentOnTest;
	}
	/**
	 * @param timeSpentOnTest the timeSpentOnTest to set
	 */
	public void setTimeSpentOnTest(Integer timeSpentOnTest) {
		this.timeSpentOnTest = timeSpentOnTest;
	}
	/**
	 * @return the groupParticipation
	 */
	public Integer getGroupParticipation() {
		return groupParticipation;
	}
	/**
	 * @param groupParticipation the groupParticipation to set
	 */
	public void setGroupParticipation(Integer groupParticipation) {
		this.groupParticipation = groupParticipation;
	}
	/**
	 * @return the numberOfAttemps
	 */
	public Integer getNumberOfAttemps() {
		return numberOfAttemps;
	}
	/**
	 * @param numberOfAttemps the numberOfAttemps to set
	 */
	public void setNumberOfAttemps(Integer numberOfAttemps) {
		this.numberOfAttemps = numberOfAttemps;
	}
	/**
	 * @return the timeSpentOnCourse
	 */
	public Integer getTimeSpentOnCourse() {
		return timeSpentOnCourse;
	}
	/**
	 * @param timeSpentOnCourse the timeSpentOnCourse to set
	 */
	public void setTimeSpentOnCourse(Integer timeSpentOnCourse) {
		this.timeSpentOnCourse = timeSpentOnCourse;
	}
	/**
	 * @return the progress
	 */
	public Integer getProgress() {
		return progress;
	}
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	
	
}
