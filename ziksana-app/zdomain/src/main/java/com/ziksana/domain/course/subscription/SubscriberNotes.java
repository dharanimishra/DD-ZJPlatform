package com.ziksana.domain.course.subscription;

import java.util.Date;

public class SubscriberNotes {
	/**
	 * This field corresponds to the database column sbnsubscribernotes.subcribeNotesId
	 */
	private Integer subcribeNotesId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.CreationDate
	 */
	private Date creationDate;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.NotesType
	 */
	private Integer notesType;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.NotesVisibility
	 */
	private Integer notesVisibility;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.NotesContent
	 */
	private String notesContent;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.SubscriptionCourseId
	 */
	private Integer subscriptionCourseId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.LearningComponentId
	 */
	private Integer learningComponentId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.LearningComponentContentId
	 */
	private Integer learningComponentContentId;

	/**
	 * This field corresponds to the database column
	 * sbnsubscribernotes.MemberSubscriptionId
	 */
	private Integer memberSubscriptionId;

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.subcribeNotesId
	 * 
	 * @return the value of sbnsubscribernotes.subcribeNotesId
	 */
	public Integer getSubcribeNotesId() {
		return subcribeNotesId;
	}

	/**
	 * This method sets the value of the database column sbnsubscribernotes.subcribeNotesId
	 * 
	 * @param subcribeNotesId
	 *            the value for sbnsubscribernotes.subcribeNotesId
	 */
	public void setSubcribeNotesId(Integer subcribeNotesId) {
		this.subcribeNotesId = subcribeNotesId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.CreationDate
	 * 
	 * @return the value of sbnsubscribernotes.CreationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.CreationDate
	 * 
	 * @param creationDate
	 *            the value for sbnsubscribernotes.CreationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.NotesType
	 * 
	 * @return the value of sbnsubscribernotes.NotesType
	 */
	public Integer getNotesType() {
		return notesType;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.NotesType
	 * 
	 * @param notesType
	 *            the value for sbnsubscribernotes.NotesType
	 */
	public void setNotesType(Integer notesType) {
		this.notesType = notesType;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.NotesVisibility
	 * 
	 * @return the value of sbnsubscribernotes.NotesVisibility
	 */
	public Integer getNotesVisibility() {
		return notesVisibility;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.NotesVisibility
	 * 
	 * @param notesVisibility
	 *            the value for sbnsubscribernotes.NotesVisibility
	 */
	public void setNotesVisibility(Integer notesVisibility) {
		this.notesVisibility = notesVisibility;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.NotesContent
	 * 
	 * @return the value of sbnsubscribernotes.NotesContent
	 */
	public String getNotesContent() {
		return notesContent;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.NotesContent
	 * 
	 * @param notesContent
	 *            the value for sbnsubscribernotes.NotesContent
	 */
	public void setNotesContent(String notesContent) {
		this.notesContent = notesContent == null ? null : notesContent.trim();
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.SubscriptionCourseId
	 * 
	 * @return the value of sbnsubscribernotes.SubscriptionCourseId
	 */
	public Integer getSubscriptionCourseId() {
		return subscriptionCourseId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.SubscriptionCourseId
	 * 
	 * @param subscriptionCourseId
	 *            the value for sbnsubscribernotes.SubscriptionCourseId
	 */
	public void setSubscriptionCourseId(Integer subscriptionCourseId) {
		this.subscriptionCourseId = subscriptionCourseId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.LearningComponentId
	 * 
	 * @return the value of sbnsubscribernotes.LearningComponentId
	 */
	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.LearningComponentId
	 * 
	 * @param learningComponentId
	 *            the value for sbnsubscribernotes.LearningComponentId
	 */
	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.LearningComponentContentId
	 * 
	 * @return the value of sbnsubscribernotes.LearningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.LearningComponentContentId
	 * 
	 * @param learningComponentContentId
	 *            the value for sbnsubscribernotes.LearningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the database column
	 * sbnsubscribernotes.MemberSubscriptionId
	 * 
	 * @return the value of sbnsubscribernotes.MemberSubscriptionId
	 */
	public Integer getMemberSubscriptionId() {
		return memberSubscriptionId;
	}

	/**
	 * This method sets the value of the database column
	 * sbnsubscribernotes.MemberSubscriptionId
	 * 
	 * @param memberSubscriptionId
	 *            the value for sbnsubscribernotes.MemberSubscriptionId
	 */
	public void setMemberSubscriptionId(Integer memberSubscriptionId) {
		this.memberSubscriptionId = memberSubscriptionId;
	}
}