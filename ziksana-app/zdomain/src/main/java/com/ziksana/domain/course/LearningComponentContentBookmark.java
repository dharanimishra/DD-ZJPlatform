package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class LearningComponentContentBookmark implements Serializable{

	/**
	 * serial version ID
	 */
	private static final long serialVersionUID = -5246583160385660525L;
	
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.bookmarkId
	 */
	private Integer bookmarkId;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.BookmarkType
	 */
	private Integer bookmarkType;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.StartTime
	 */
	private Date startTime;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.EndTime
	 */
	private Date endTime;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.StartLocation
	 */
	private Integer startLocation;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.EndLocation
	 */
	private Integer endLocation;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.SpotCoordindates
	 */
	private String spotCoordindates;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.BookmarkDate
	 */
	private Date bookmarkDate;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.BookmarkVisibility
	 */
	private Integer bookmarkVisibility;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.BookmarkNotes
	 */
	private String bookmarkNotes;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.LearningComponentContentId
	 */
	private Integer learningComponentContentId;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.MemberRoleId
	 */
	private Integer memberRoleId;
	/**
	 * This field corresponds to the database column
	 * corcomponentcontentbookmark.CourseCurriculumId
	 */
	private Integer courseCurriculumId;

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.bookmarkId
	 * 
	 * @return the value of corcomponentcontentbookmark.bookmarkId
	 */
	public Integer getBookmarkId() {
		return bookmarkId;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.bookmarkId
	 * 
	 * @param bookmarkId
	 *            the value for corcomponentcontentbookmark.bookmarkId
	 */
	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.BookmarkType
	 * 
	 * @return the value of corcomponentcontentbookmark.BookmarkType
	 */
	public Integer getBookmarkType() {
		return bookmarkType;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.BookmarkType
	 * 
	 * @param bookmarkType
	 *            the value for corcomponentcontentbookmark.BookmarkType
	 */
	public void setBookmarkType(Integer bookmarkType) {
		this.bookmarkType = bookmarkType;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.StartTime
	 * 
	 * @return the value of corcomponentcontentbookmark.StartTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.StartTime
	 * 
	 * @param startTime
	 *            the value for corcomponentcontentbookmark.StartTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.EndTime
	 * 
	 * @return the value of corcomponentcontentbookmark.EndTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.EndTime
	 * 
	 * @param endTime
	 *            the value for corcomponentcontentbookmark.EndTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.StartLocation
	 * 
	 * @return the value of corcomponentcontentbookmark.StartLocation
	 */
	public Integer getStartLocation() {
		return startLocation;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.StartLocation
	 * 
	 * @param startLocation
	 *            the value for corcomponentcontentbookmark.StartLocation
	 */
	public void setStartLocation(Integer startLocation) {
		this.startLocation = startLocation;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.EndLocation
	 * 
	 * @return the value of corcomponentcontentbookmark.EndLocation
	 */
	public Integer getEndLocation() {
		return endLocation;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.EndLocation
	 * 
	 * @param endLocation
	 *            the value for corcomponentcontentbookmark.EndLocation
	 */
	public void setEndLocation(Integer endLocation) {
		this.endLocation = endLocation;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.SpotCoordindates
	 * 
	 * @return the value of corcomponentcontentbookmark.SpotCoordindates
	 */
	public String getSpotCoordindates() {
		return spotCoordindates;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.SpotCoordindates
	 * 
	 * @param spotCoordindates
	 *            the value for corcomponentcontentbookmark.SpotCoordindates
	 */
	public void setSpotCoordindates(String spotCoordindates) {
		this.spotCoordindates = spotCoordindates == null ? null
				: spotCoordindates.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.BookmarkDate
	 * 
	 * @return the value of corcomponentcontentbookmark.BookmarkDate
	 */
	public Date getBookmarkDate() {
		return bookmarkDate;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.BookmarkDate
	 * 
	 * @param bookmarkDate
	 *            the value for corcomponentcontentbookmark.BookmarkDate
	 */
	public void setBookmarkDate(Date bookmarkDate) {
		this.bookmarkDate = bookmarkDate;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.BookmarkVisibility
	 * 
	 * @return the value of corcomponentcontentbookmark.BookmarkVisibility
	 */
	public Integer getBookmarkVisibility() {
		return bookmarkVisibility;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.BookmarkVisibility
	 * 
	 * @param bookmarkVisibility
	 *            the value for corcomponentcontentbookmark.BookmarkVisibility
	 */
	public void setBookmarkVisibility(Integer bookmarkVisibility) {
		this.bookmarkVisibility = bookmarkVisibility;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.BookmarkNotes
	 * 
	 * @return the value of corcomponentcontentbookmark.BookmarkNotes
	 */
	public String getBookmarkNotes() {
		return bookmarkNotes;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.BookmarkNotes
	 * 
	 * @param bookmarkNotes
	 *            the value for corcomponentcontentbookmark.BookmarkNotes
	 */
	public void setBookmarkNotes(String bookmarkNotes) {
		this.bookmarkNotes = bookmarkNotes == null ? null : bookmarkNotes
				.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.Active
	 * 
	 * @return the value of corcomponentcontentbookmark.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.Active
	 * 
	 * @param active
	 *            the value for corcomponentcontentbookmark.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.LearningComponentContentId
	 * 
	 * @return the value of corcomponentcontentbookmark.LearningComponentContentId
	 */
	public Integer getLearningComponentContentId() {
		return learningComponentContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.LearningComponentContentId
	 * 
	 * @param LearningComponentContentId
	 *            the value for
	 *            corcomponentcontentbookmark.LearningComponentContentId
	 */
	public void setLearningComponentContentId(Integer learningComponentContentId) {
		this.learningComponentContentId = learningComponentContentId;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.MemberRoleId
	 * 
	 * @return the value of corcomponentcontentbookmark.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corcomponentcontentbookmark.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * This method returns the value of the database column
	 * corcomponentcontentbookmark.CourseCurriculumId
	 * 
	 * @return the value of corcomponentcontentbookmark.CourseCurriculumId
	 */
	public Integer getCourseCurriculumId() {
		return courseCurriculumId;
	}

	/**
	 * This method sets the value of the database column
	 * corcomponentcontentbookmark.CourseCurriculumId
	 * 
	 * @param courseCurriculumId
	 *            the value for corcomponentcontentbookmark.CourseCurriculumId
	 */
	public void setCourseCurriculumId(Integer courseCurriculumId) {
		this.courseCurriculumId = courseCurriculumId;
	}
}