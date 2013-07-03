/**
 * 
 */

package com.ziksana.domain.course.subscription;

import java.util.Date;



/**
 * @author prabu
 *
 */
public class Note {
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(Integer subCourseId) {
		this.subCourseId = subCourseId;
	}

	public Integer getLearnCompId() {
		return learnCompId;
	}

	public void setLearnCompId(Integer learnCompId) {
		this.learnCompId = learnCompId;
	}

	public Integer getLearnCmpContId() {
		return learnCmpContId;
	}

	public void setLearnCmpContId(Integer learnCmpContId) {
		this.learnCmpContId = learnCmpContId;
	}

	
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}


	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}


	public String getNoteDescription() {
		return noteDescription;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}


	public Integer getNoteDuration() {
		return noteDuration;
	}

	public void setNoteDuration(Integer noteDuration) {
		this.noteDuration = noteDuration;
	}


	private Integer id;
	
	private String content;
	
	private Integer type;
	
	private Date creationDate;
	
	private Integer subCourseId;
	
	private Integer courseId;
	
	private Integer learnCompId;
	
	private Integer learnCmpContId;
	
	private Integer memberRoleId;
	
	private String noteTitle;
	
	private String noteDescription;
	
	private Integer noteDuration;
	
		

	
	
	
		
	

}
