package com.ziksana.domain.course;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Institution implements Serializable{
	private static final long serialVersionUID = -8942693018614959114L;

	/**
	 * This field corresponds to the database column corinstitution.institutionId
	 */
	private Integer institutionId;

	/**
	 * This field corresponds to the database column
	 * corinstitution.InstitutionType
	 */
	private Integer institutionType;

	/**
	 * This field corresponds to the database column
	 * corinstitution.StartDateonZiksana
	 */
	private Date startDateonZiksana;

	/**
	 * This field corresponds to the database column
	 * corinstitution.EndDateonZiksana
	 */
	private Date endDateonZiksana;

	/**
	 * This field corresponds to the database column
	 * corinstitution.InstitutionWalletShare
	 */
	private Integer institutionWalletShare;

	/**
	 * This field corresponds to the database column
	 * corinstitution.InstitutionRating
	 */
	private String institutionRating;

	/**
	 * This field corresponds to the database column
	 * corinstitution.CertifyingAuthority
	 */
	private String certifyingAuthority;

	/**
	 * This field corresponds to the database column memmemberrole.thumbnailPicturePath
	 */
	private Integer thumbnailPicturePath;


	/**
	 * This field corresponds to the database column memmemberrole.memberRoleId
	 */
	private Integer memberRoleId;
	
	
	//private List<LearningProgram> learningProgramList;
	//private List<InstitutionUnit> institutionUnitList;
	private List<CurriculumCourse> curriculumCourseList;
	/**
	 * . This method returns the value of the database column corinstitution.institutionId
	 * @return the value of corinstitution.institutionId
	 */
	public Integer getInstitutionId() {
		return institutionId;
	}

	/**
	 * . This method sets the value of the database column corinstitution.institutionId
	 * @param institutionId
	 *            the value for corinstitution.ID
	 */
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.InstitutionType
	 * @return the value of corinstitution.InstitutionType
	 */
	public Integer getInstitutionType() {
		return institutionType;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.InstitutionType
	 * @param institutionType
	 *            the value for corinstitution.InstitutionType
	 */
	public void setInstitutionType(Integer institutionType) {
		this.institutionType = institutionType;
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.StartDateonZiksana
	 * @return the value of corinstitution.StartDateonZiksana
	 */
	public Date getStartDateonZiksana() {
		return startDateonZiksana;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.StartDateonZiksana
	 * @param startDateonZiksana
	 *            the value for corinstitution.StartDateonZiksana
	 */
	public void setStartDateonZiksana(Date startDateonZiksana) {
		this.startDateonZiksana = startDateonZiksana;
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.EndDateonZiksana
	 * @return the value of corinstitution.EndDateonZiksana
	 */
	public Date getEndDateonZiksana() {
		return endDateonZiksana;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.EndDateonZiksana
	 * @param endDateonZiksana
	 *            the value for corinstitution.EndDateonZiksana
	 */
	public void setEndDateonZiksana(Date endDateonZiksana) {
		this.endDateonZiksana = endDateonZiksana;
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.InstitutionWalletShare
	 * @return the value of corinstitution.InstitutionWalletShare
	 */
	public Integer getInstitutionWalletShare() {
		return institutionWalletShare;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.InstitutionWalletShare
	 * @param institutionWalletShare
	 *            the value for corinstitution.InstitutionWalletShare
	 */
	public void setInstitutionWalletShare(Integer institutionWalletShare) {
		this.institutionWalletShare = institutionWalletShare;
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.InstitutionRating
	 * @return the value of corinstitution.InstitutionRating
	 */
	public String getInstitutionRating() {
		return institutionRating;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.InstitutionRating
	 * @param institutionRating
	 *            the value for corinstitution.InstitutionRating
	 */
	public void setInstitutionRating(String institutionRating) {
		this.institutionRating = institutionRating == null ? null
				: institutionRating.trim();
	}

	/**
	 * . This method returns the value of the database column
	 * corinstitution.CertifyingAuthority
	 * @return the value of corinstitution.CertifyingAuthority
	 */
	public String getCertifyingAuthority() {
		return certifyingAuthority;
	}

	/**
	 * . This method sets the value of the database column
	 * corinstitution.CertifyingAuthority
	 * @param certifyingAuthority
	 *            the value for corinstitution.CertifyingAuthority
	 */
	public void setCertifyingAuthority(String certifyingAuthority) {
		this.certifyingAuthority = certifyingAuthority == null ? null
				: certifyingAuthority.trim();
	}

	/**
	 * @return
	 */
	public Integer getMemberRoleId() {
		return memberRoleId;
	}

	/**
	 * @param memberRoleId
	 */
	public void setMemberRoleId(Integer memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	/**
	 * @return the curriculumCourseList
	 */
	public List<CurriculumCourse> getCurriculumCourseList() {
		return curriculumCourseList;
	}

	/**
	 * @param curriculumCourseList the curriculumCourseList to set
	 */
	public void setCurriculumCourseList(List<CurriculumCourse> curriculumCourseList) {
		this.curriculumCourseList = curriculumCourseList;
	}

	/**
	 * @return the thumbnailPicturePath
	 */
	public Integer getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	/**
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(Integer thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}
}