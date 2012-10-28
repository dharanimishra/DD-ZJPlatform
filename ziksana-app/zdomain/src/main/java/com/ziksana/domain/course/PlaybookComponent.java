/**
 * 
 */
package com.ziksana.domain.course;

import java.util.List;

import com.ziksana.domain.institution.ProgramCurriculumPlaybook;

/**
 * @author bhashasp 
 */
public class PlaybookComponent {

	private List<CoursePlaybook>  			 coursePlaybookList 		= null;
	private List<ProgramCurriculumPlaybook>  progCurriculumPlaybookList = null;
	/**
	 * @return the coursePlaybookList
	 */
	public List<CoursePlaybook> getCoursePlaybookList() {
		return coursePlaybookList;
	}
	/**
	 * @param coursePlaybookList the coursePlaybookList to set
	 */
	public void setCoursePlaybookList(List<CoursePlaybook> coursePlaybookList) {
		this.coursePlaybookList = coursePlaybookList;
	}
	/**
	 * @return the progCurriculumPlaybookList
	 */
	public List<ProgramCurriculumPlaybook> getProgCurriculumPlaybookList() {
		return progCurriculumPlaybookList;
	}
	/**
	 * @param progCurriculumPlaybookList the progCurriculumPlaybookList to set
	 */
	public void setProgCurriculumPlaybookList(
			List<ProgramCurriculumPlaybook> progCurriculumPlaybookList) {
		this.progCurriculumPlaybookList = progCurriculumPlaybookList;
	}
	
}
