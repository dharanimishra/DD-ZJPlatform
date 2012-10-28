package com.ziksana.domain.classtalk;

import com.ziksana.domain.member.MemberPersona;



public class LearnerOnline implements Comparable<LearnerOnline>{

	
	private MemberPersona memberPersona;
	private String program;
	private String course;
	private String mood;
	
	


	LearnerOnline(MemberPersona memberPersona, String program, String course,
			String mood) {
		super();
		this.memberPersona = memberPersona;
		this.program = program;
		this.course = course;
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
		return program;
	}



















	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
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
