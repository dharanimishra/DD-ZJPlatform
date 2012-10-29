package com.ziksana.domain.classtalk;

import com.ziksana.domain.member.MemberPersona;



public class LearnerOnline implements Comparable<LearnerOnline>{

	
	private MemberPersona memberPersona;
	private String learningProgram;
	private String courseName;
	private String mood;
	
	


	/**
	 * @return the memberPersona
	 */
	public MemberPersona getMemberPersona() {
		return memberPersona;
	}










































	/**
	 * @param memberPersona the memberPersona to set
	 */
	public void setMemberPersona(MemberPersona memberPersona) {
		this.memberPersona = memberPersona;
	}










































	/**
	 * @return the learningProgram
	 */
	public String getLearningProgram() {
		return learningProgram;
	}










































	/**
	 * @param learningProgram the learningProgram to set
	 */
	public void setLearningProgram(String learningProgram) {
		this.learningProgram = learningProgram;
	}










































	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}










































	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}










































	/**
	 * @return the mood
	 */
	public String getMood() {
		return mood;
	}










































	/**
	 * @param mood the mood to set
	 */
	public void setMood(String mood) {
		this.mood = mood;
	}










































	@Override
	public int compareTo(LearnerOnline o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
