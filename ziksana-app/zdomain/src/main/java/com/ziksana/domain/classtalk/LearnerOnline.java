package com.ziksana.domain.classtalk;

import com.ziksana.domain.member.MemberPersona;



public class LearnerOnline implements Comparable<LearnerOnline>{

	
	private MemberPersona memberPersona;
	private String learningProgram;
	private String courseName;
	private String mood;
	
	


	LearnerOnline(MemberPersona memberPersona, String program, String course,
			String mood) {
		super();
		this.memberPersona = memberPersona;
		this.learningProgram = program;
		this.courseName = course;
		this.mood = mood;
	}
	
	
	
	
	














	/**
	 * @return the memberPersona
	 */
	public MemberPersona getMemberPersona() {
		return memberPersona;
	}



















	/**
	 * @return the program
	 */
	public String getProgram() {
		return learningProgram;
	}



















	/**
	 * @return the course
	 */
	public String getCourse() {
		return courseName;
	}



















	/**
	 * @return the mood
	 */
	public String getMood() {
		return mood;
	}



















	@Override
	public int compareTo(LearnerOnline o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
