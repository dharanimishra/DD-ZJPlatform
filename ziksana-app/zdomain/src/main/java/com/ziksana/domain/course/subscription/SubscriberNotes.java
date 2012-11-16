package com.ziksana.domain.course.subscription;

import com.ziksana.domain.course.LearningComponent;
import com.ziksana.domain.course.LearningComponentContent;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class SubscriberNotes {
	
	public SubscriberNotes(NotesType notesType,
			NotesVisibility notesVisibility, String notes) {
		super();
		this.notesType = notesType;
		this.notesVisibility = notesVisibility;
		this.notes = notes;
	}
	
	private ZID 						subscriberNoteId;
	private NotesType 					notesType 				= null;
	private NotesVisibility 			notesVisibility 		= null;
	private String 						notes 					= null;
	private SubscriptionCourse 			subscriptionCourse 		= null;
	private LearningComponent 			courseComponent 		= null;
	private LearningComponentContent 	courseComponentContent 	= null;
	private MemberSubscriptionProgram	memberSubscription 		= null;
	
	/**
	 * @return the subscriberNoteId
	 */
	public ZID getSubscriberNoteId() {
		return subscriberNoteId;
	}
	/**
	 * @param subscriberNoteId the subscriberNoteId to set
	 */
	public void setSubscriberNoteId(ZID subscriberNoteId) {
		this.subscriberNoteId = subscriberNoteId;
	}
	/**
	 * @return the notesType
	 */
	public NotesType getNotesType() {
		return notesType;
	}
	/**
	 * @param notesType the notesType to set
	 */
	public void setNotesType(NotesType notesType) {
		this.notesType = notesType;
	}
	/**
	 * @return the notesVisibility
	 */
	public NotesVisibility getNotesVisibility() {
		return notesVisibility;
	}
	/**
	 * @param notesVisibility the notesVisibility to set
	 */
	public void setNotesVisibility(NotesVisibility notesVisibility) {
		this.notesVisibility = notesVisibility;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the subscriptionCourse
	 */
	public SubscriptionCourse getSubscriptionCourse() {
		return subscriptionCourse;
	}
	/**
	 * @param subscriptionCourse the subscriptionCourse to set
	 */
	public void setSubscriptionCourse(SubscriptionCourse subscriptionCourse) {
		this.subscriptionCourse = subscriptionCourse;
	}
	/**
	 * @return the courseComponent
	 */
	public LearningComponent getCourseComponent() {
		return courseComponent;
	}
	/**
	 * @param courseComponent the courseComponent to set
	 */
	public void setCourseComponent(LearningComponent courseComponent) {
		this.courseComponent = courseComponent;
	}
	/**
	 * @return the courseComponentContent
	 */
	public LearningComponentContent getCourseComponentContent() {
		return courseComponentContent;
	}
	/**
	 * @param courseComponentContent the courseComponentContent to set
	 */
	public void setCourseComponentContent(
			LearningComponentContent courseComponentContent) {
		this.courseComponentContent = courseComponentContent;
	}
	/**
	 * @return the memberSubscription
	 */
	public MemberSubscriptionProgram getMemberSubscription() {
		return memberSubscription;
	}
	/**
	 * @param memberSubscription the memberSubscription to set
	 */
	public void setMemberSubscription(MemberSubscriptionProgram memberSubscription) {
		this.memberSubscription = memberSubscription;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubscriberNotes [notesType=" + notesType + ", notesVisibility="
				+ notesVisibility + ", notes=" + notes + "]";
	}
	
}
