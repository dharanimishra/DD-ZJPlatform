package com.ziksana.domain.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ziksana.domain.assessment.TestPackage;
import com.ziksana.domain.assessment.engagement.Engagement;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.utils.SubjectClassification;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class Course extends AuditHistory {

	public Course() {
		// setCourseStatus(CourseStatus.UNDER_CONSTRUCT);
	}

	public Course(String name, String description, CourseStatus courseStatus,
			Duration courseDuration, MemberPersona accountableMember) {
		this.name = name;
		this.description = description;
		this.courseStatus = courseStatus;
		this.courseDuration = courseDuration;
		this.accountableMember = accountableMember;
	}

	public Course(String name, String description, CourseStatus courseStatus,
			Duration courseDuration, MemberPersona accountableMember,
			List<LearningComponent> learningComponentList) {
		this.name = name;
		this.description = description;
		this.courseStatus = courseStatus;
		this.courseDuration = courseDuration;
		this.accountableMember = accountableMember;
		// this.getCourseDetails().learningComponents =learningComponentList;
	}

	private ZID courseId;
	private int coursesId;
	private int memberRoleId;
	
	public int getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(int memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	public int getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(int coursesId) {
		this.coursesId = coursesId;
	}

	/**
	 * Maximum Length:45
	 */
	private String name = null;
	/**
	 * Maximum Length:240
	 */
	private String description = null;
	/**
	 * Course Start Date is for when Course is associate to curriculumm
	 */
	private Date validFromDate = null;
	/**
	 * Course End Date is for When Course is associate to curriculumm
	 */
	private Date validToDate = null;
	private CourseStatus courseStatus = null;
	private Integer courseStatusId = null;
	private Rating rating = null;
	private Boolean securityIndicator = null;
	private Boolean isDelete = null;

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	private CourseContentSecurity courseContSecurity = null;
	/**
	 * Maximum Length:5
	 */

	private String totalCredits = null;

	private String courseCredits = null;
	/**
	 * Maximum Length:5
	 */
	private String extraCredits = null;
	private Boolean additionalInfoIndicator = null;
	/**
	 * Maximum Length:72
	 */
	private String thumbnailPicturePath = null;
	private Duration courseDuration = null;
	private SubjectClassification subjClassification = null;
	private MemberPersona accountableMember = null;
	private CourseDetails courseDetails = null;
	private Integer courseProgress = null;
	private Integer status = null;
	private Integer duration = null;
	private Integer durationUnits = null;
	private Integer subjClassificationId = null;

	public Integer getSubjClassificationId() {
		return subjClassificationId;
	}

	public void setSubjClassificationId(Integer subjClassificationId) {
		this.subjClassificationId = subjClassificationId;
	}

	/**
	 * Maximum Length:240
	 */
	private String versionRemarks = null;
	private Integer version = null;

	private List<CourseTagcloud> courseTagClouds = null;
	private List<CoursePlaybook> coursePlaybookList = null;
	private List<CourseLearningPlanner> courseLearningPlannerList = null;
	private TestPackage testPackage = null;
	private List<Engagement> engagementList = null;

	/**
	 * @param index
	 * @return
	 */
	public CoursePlaybook getCoursePlaybook(int index) {
		if (coursePlaybookList == null) {
			throw new IllegalArgumentException(
					"CoursePlaybook cannot set to null");
		}

		try {
			return coursePlaybookList.get(index);
		} catch (Exception e) {
			throw new IllegalStateException("CoursePlaybook at index [" + index
					+ "] not found");
		}
	}

	/**
	 * @param playbook
	 */
	public void addCoursePlaybook(CoursePlaybook playbook) {
		if (coursePlaybookList == null) {
			coursePlaybookList = new ArrayList<CoursePlaybook>();
		}
		playbook.setCourse(this);
		coursePlaybookList.add(playbook);
	}

	/**
	 * @param list
	 */
	public void setCoursePlaybookList(List<CoursePlaybook> list) {
		this.coursePlaybookList = list;
	}

	/**
	 * @param index
	 * @return
	 */
	public CourseTagcloud getCourseTagcloud(int index) {

		if (courseTagClouds == null) {
			throw new IllegalArgumentException(
					"Course Tag cloud cannot set to null");
		}

		try {
			return courseTagClouds.get(index);
		} catch (Exception e) {
			throw new IllegalStateException("Course Tag cloud at index ["
					+ index + "] not found");
		}
	}

	/**
	 * @param tagCloud
	 */
	public void addCourseTagcloud(CourseTagcloud tagCloud) {

		if (courseTagClouds == null) {
			courseTagClouds = new ArrayList<CourseTagcloud>();
		}

		tagCloud.setCourse(this);

		courseTagClouds.add(tagCloud);

	}

	/**
	 * @param courseTagClouds
	 *            the courseTagClouds to set
	 */
	public void setCourseTagClouds(List<CourseTagcloud> courseTagClouds) {
		this.courseTagClouds = courseTagClouds;
	}

	/**
	 * @param courseTagClouds
	 *            the courseTagClouds to set
	 */
	public List<CourseTagcloud> getCourseTagClouds() {
		return courseTagClouds;
	}

	public void addCourseLearningPlanner(CourseLearningPlanner coursePlanner) {

		if (courseLearningPlannerList == null) {
			courseLearningPlannerList = new ArrayList<CourseLearningPlanner>();
		}

		courseLearningPlannerList.add(coursePlanner);
	}

	/**
	 * @return the courseLearningPlannerList
	 */
	public List<CourseLearningPlanner> getCourseLearningPlannerList() {

		return courseLearningPlannerList;
	}

	/**
	 * @param courseLearningPlannerList
	 *            the courseLearningPlannerList to set
	 */
	public void setCourseLearningPlannerList(
			List<CourseLearningPlanner> courseLearningPlannerList) {

		this.courseLearningPlannerList = courseLearningPlannerList;
	}

	/**
	 * @return the value of attribute Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @throws Exception
	 * @throws NullPointerException
	 */
	public void setName(String name) throws Exception {
		if (name == null) {
			throw new IllegalArgumentException("Null name passed");
		}
		this.name = name;
	}

	/**
	 * @return the value of attribute Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the value for attribute Description
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * @return the validFromDate
	 */
	public Date getValidFromDate() {
		return validFromDate;
	}

	/**
	 * @param validFromDate
	 *            the validFromDate to set
	 */
	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	/**
	 * @return the validToDate
	 */
	public Date getValidToDate() {
		return validToDate;
	}

	/**
	 * @param validToDate
	 *            the validToDate to set
	 */
	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	/**
	 * @return the value of attribute Version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the value for attribute Version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the value of attribute courseId
	 */
	/*
	 * public ZID getCourseId() { return courseId; }
	 *//**
	 * @param courseId
	 *            the value for attribute courseId
	 */
	/*
	 * public void setCourseId(ZID courseId) { this.courseId = courseId; }
	 *//**
	 * @return the courseDetails
	 */
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}

	/**
	 * @param courseDetails
	 *            the courseDetails to set
	 */
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}

	/**
	 * @return the courseProgress
	 */
	public Integer getCourseProgress() {
		return courseProgress;
	}

	/**
	 * @param courseProgress
	 *            the courseProgress to set
	 */
	public void setCourseProgress(Integer courseProgress) {
		this.courseProgress = courseProgress;
	}

	public String getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(String totalCredits) {
		this.totalCredits = totalCredits;
	}

	public String getExtraCredits() {
		return extraCredits;
	}

	public void setExtraCredits(String extraCredits) {
		this.extraCredits = extraCredits;
	}

	public Boolean getAdditionalInfoIndicator() {
		return additionalInfoIndicator;
	}

	public void setAdditionalInfoIndicator(Boolean additionalInfoIndicator) {
		this.additionalInfoIndicator = additionalInfoIndicator;
	}

	public Duration getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Duration courseDuration) {
		if (courseDuration == null) {
			throw new IllegalArgumentException("Duration is cannot set to null");
		}
		this.courseDuration = courseDuration;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}

	/**
	 * @return the courseStatus
	 */
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	/**
	 * @param courseStatus
	 *            the courseStatus to set
	 */
	public void setCourseStatus(CourseStatus courseStatus) {

		if (courseStatusId != null) {
			courseStatus = CourseStatus.getCourseStatus(courseStatusId);
		}
		this.courseStatus = courseStatus;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * @return the securityIndicator
	 */
	public Boolean getSecurityIndicator() {
		return securityIndicator;
	}

	/**
	 * @param securityIndicator
	 *            the securityIndicator to set
	 */
	public void setSecurityIndicator(Boolean securityIndicator) {
		this.securityIndicator = securityIndicator;
	}

	public CourseContentSecurity getCourseContSecurity() {
		return courseContSecurity;
	}

	public void setCourseContSecurity(CourseContentSecurity courseContSecurity) {
		this.courseContSecurity = courseContSecurity;
	}

	/**
	 * @return the courseCredits
	 */
	public String getCourseCredits() {
		return courseCredits;
	}

	/**
	 * @param courseCredits
	 *            the courseCredits to set
	 */
	public void setCourseCredits(String courseCredits) {
		this.courseCredits = courseCredits;
	}

	/**
	 * @return the accountableMember
	 */
	public MemberPersona getAccountableMember() {
		return accountableMember;
	}

	/**
	 * @param accountableMember
	 *            the accountableMember to set
	 */
	public void setAccountableMember(MemberPersona accountableMember) {
		this.accountableMember = accountableMember;
	}

	/**
	 * @return the subjClassification
	 */
	public SubjectClassification getSubjClassification() {
		return subjClassification;
	}

	/**
	 * @param subjClassification
	 *            the subjClassification to set
	 */
	public void setSubjClassification(SubjectClassification subjClassification) {
		this.subjClassification = subjClassification;
	}

	/**
	 * @return the versionRemarks
	 */
	public String getVersionRemarks() {
		return versionRemarks;
	}

	/**
	 * @param versionRemarks
	 *            the versionRemarks to set
	 */
	public void setVersionRemarks(String versionRemarks) {
		this.versionRemarks = versionRemarks;
	}

	/**
	 * @return the testPackage
	 */
	public TestPackage getTestPackage() {
		return testPackage;
	}

	/**
	 * @param testPackage
	 *            the testPackage to set
	 */
	public void setTestPackage(TestPackage testPackage) {
		this.testPackage = testPackage;
	}

	/**
	 * @return the engagementList
	 */
	public List<Engagement> getEngagementList() {
		return engagementList;
	}

	/**
	 * @param engagementList
	 *            the engagementList to set
	 */
	public void setEngagementList(List<Engagement> engagementList) {
		this.engagementList = engagementList;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the durationUnits
	 */
	public Integer getDurationUnits() {
		return durationUnits;
	}

	/**
	 * @param durationUnits
	 *            the durationUnits to set
	 */
	public void setDurationUnits(Integer durationUnits) {
		this.durationUnits = durationUnits;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name
				+ ", description=" + description + ", validFromDate="
				+ validFromDate + ", validToDate=" + validToDate
				+ ", courseStatus=" + courseStatus + ", rating=" + rating
				+ ", securityIndicator=" + securityIndicator
				+ ", courseContSecurity=" + courseContSecurity
				+ ", courseCredits=" + courseCredits + ", extraCredits="
				+ extraCredits + ", additionalInfoIndicator="
				+ additionalInfoIndicator + ", thumbnailPicturePath="
				+ thumbnailPicturePath + ", courseDuration=" + courseDuration
				+ ", accountableMember=" + accountableMember
				+ ", courseProgress=" + courseProgress + ", status=" + status
				+ ", duration=" + duration + ", durationUnits=" + durationUnits
				+ "]";
	}

	/**
	 * @return the courseId
	 */
	public ZID getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = new IntegerZID(courseId);
	}

	/**
	 * @return the courseStatusId
	 */
	public Integer getCourseStatusId() {
		return courseStatusId;
	}

	/**
	 * @param courseStatusId
	 *            the courseStatusId to set
	 */
	public void setCourseStatusId(Integer courseStatusId) {
		this.courseStatusId = courseStatusId;
	}

}