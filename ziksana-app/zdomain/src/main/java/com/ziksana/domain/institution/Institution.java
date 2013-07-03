package com.ziksana.domain.institution;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.Rating;
import com.ziksana.domain.course.WalletShare;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Institution extends AuditHistory{

	private ZID 				institutionId;
	private String				name					= null;
	private String				description				= null;
	private InstitutionType 	institutionType 		= null;
	private Date 				startDate 				= null;
	private Date 				endDate 				= null;
	private WalletShare 		walletShare 			= null;
	private Rating 				institutionRating 		= null;
	private String 				certifyingAuthority 	= null;
	private String 				thumbnailPicturePath	= null;
	private MemberPersona 		memberPersona 			= null;

	/**
	 * @return the institutionId
	 */
	public ZID getInstitutionId() {
		return institutionId;
	}
	/**
	 * @param institutionId the institutionId to set
	 */
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = new IntegerZID(institutionId);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the institutionType
	 */
	public InstitutionType getInstitutionType() {
		return institutionType;
	}
	/**
	 * @param institutionType the institutionType to set
	 */
	public void setInstitutionType(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the walletShare
	 */
	public WalletShare getWalletShare() {
		return walletShare;
	}
	/**
	 * @param walletShare the walletShare to set
	 */
	public void setWalletShare(WalletShare walletShare) {
		this.walletShare = walletShare;
	}
	/**
	 * @return the institutionRating
	 */
	public Rating getInstitutionRating() {
		return institutionRating;
	}
	/**
	 * @param institutionRating the institutionRating to set
	 */
	public void setInstitutionRating(Rating institutionRating) {
		this.institutionRating = institutionRating;
	}
	/**
	 * @return the certifyingAuthority
	 */
	public String getCertifyingAuthority() {
		return certifyingAuthority;
	}
	/**
	 * @param certifyingAuthority the certifyingAuthority to set
	 */
	public void setCertifyingAuthority(String certifyingAuthority) {
		this.certifyingAuthority = certifyingAuthority;
	}
	/**
	 * @return the thumbnailPicturePath
	 */
	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}
	/**
	 * @param thumbnailPicturePath the thumbnailPicturePath to set
	 */
	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}
	/**
	 * @return the memberPersona
	 */
	public MemberPersona getMemberPersona() {
		return memberPersona;
	}
	/**
	 * @param memberPersona the memberPersona to set
	 */
	public void setMemberPersona(MemberPersona memberPersona) {
		this.memberPersona = memberPersona;
	}
	
	@Override
	public String toString() {
		return "Institution [name=" + name + ", description=" + description
				+ ", institutionType=" + institutionType + ", startDate="
				+ startDate + ", endDate=" + endDate + ", institutionRating="
				+ institutionRating + ", thumbnailPicturePath="
				+ thumbnailPicturePath + "]";
	}
	
}
