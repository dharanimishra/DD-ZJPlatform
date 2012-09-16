package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;

public class BookmarkShare implements Serializable{

	/**
	 * serial versionId
	 */
	private static final long serialVersionUID = -9193647186397208254L;
	/**
	 * This field corresponds to the database column corbookmarkshare.bookmarkShareId
	 */
	private Integer bookmarkShareId;
	/**
	 * This field corresponds to the database column corbookmarkshare.SharedDate
	 */
	private Date sharedDate;
	/**
	 * This field corresponds to the database column
	 * corbookmarkshare.SharingType
	 */
	private Integer sharingType;
	/**
	 * This field corresponds to the database column corbookmarkshare.Active
	 */
	private Boolean active;
	/**
	 * This field corresponds to the database column
	 * corbookmarkshare.bookmarkId
	 */
	private Integer bookmarkId;
	/**
	 * This field corresponds to the database column
	 * corbookmarkshare.MemberRoleId
	 */
	private Integer memberRoleId;

	/**
	 * This method returns the value of the database column corbookmarkshare.bookmarkShareId
	 * 
	 * @return the value of corbookmarkshare.bookmarkShareId
	 */
	public Integer getBookmarkShareId() {
		return bookmarkShareId;
	}

	/**
	 * This method sets the value of the database column corbookmarkshare.bookmarkShareId
	 * 
	 * @param bookmarkShareId
	 *            the value for corbookmarkshare.bookmarkShareId
	 */
	public void setBookmarkShareId(Integer bookmarkShareId) {
		this.bookmarkShareId = bookmarkShareId;
	}

	/**
	 * This method returns the value of the database column
	 * corbookmarkshare.SharedDate
	 * 
	 * @return the value of corbookmarkshare.SharedDate
	 */
	public Date getSharedDate() {
		return sharedDate;
	}

	/**
	 * This method sets the value of the database column
	 * corbookmarkshare.SharedDate
	 * 
	 * @param sharedDate
	 *            the value for corbookmarkshare.SharedDate
	 */
	public void setSharedDate(Date sharedDate) {
		this.sharedDate = sharedDate;
	}

	/**
	 * This method returns the value of the database column
	 * corbookmarkshare.SharingType
	 * 
	 * @return the value of corbookmarkshare.SharingType
	 */
	public Integer getSharingType() {
		return sharingType;
	}

	/**
	 * This method sets the value of the database column
	 * corbookmarkshare.SharingType
	 * 
	 * @param sharingType
	 *            the value for corbookmarkshare.SharingType
	 */
	public void setSharingType(Integer sharingType) {
		this.sharingType = sharingType;
	}

	/**
	 * This method returns the value of the database column
	 * corbookmarkshare.Active
	 * 
	 * @return the value of corbookmarkshare.Active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * This method sets the value of the database column corbookmarkshare.Active
	 * 
	 * @param active
	 *            the value for corbookmarkshare.Active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the value of the database column
	 * corbookmarkshare.bookmarkId
	 * 
	 * @return the value of corbookmarkshare.bookmarkId
	 */
	public Integer getBookmarkId() {
		return bookmarkId;
	}

	/**
	 * This method sets the value of the database column
	 * corbookmarkshare.bookmarkId
	 * 
	 * @param bookmarkId
	 *            the value for corbookmarkshare.bookmarkId
	 */
	public void setBookmarkId(Integer bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	/**
	 * This method returns the value of the database column
	 * corbookmarkshare.MemberRoleId
	 * 
	 * @return the value of corbookmarkshare.MemberRoleId
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * This method sets the value of the database column
	 * corbookmarkshare.MemberRoleId
	 * 
	 * @param memberRoleId
	 *            the value for corbookmarkshare.MemberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}
}