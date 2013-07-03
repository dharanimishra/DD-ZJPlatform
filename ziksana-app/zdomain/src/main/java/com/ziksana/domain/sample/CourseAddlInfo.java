package com.ziksana.domain.sample;

public class CourseAddlInfo extends Course {
	
	CourseContents courseContents;
	AcademicProgram academicProgram;
	
	int merits;
	int durationInWeeks;
	
	public CourseContents getCourseContents() {
		return courseContents;
	}
	public void setCourseContents(CourseContents courseContents) {
		this.courseContents = courseContents;
	}
	public AcademicProgram getAcademicProgram() {
		return academicProgram;
	}
	public void setAcademciProgram(AcademicProgram academicProgram) {
		this.academicProgram = academicProgram;
	}
	public int getMerits() {
		return merits;
	}
	public void setMerits(int merits) {
		this.merits = merits;
	}
	public int getDurationInWeeks() {
		return durationInWeeks;
	}
	public void setDurationInWeeks(int durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}
}
