package com.ziksana.domain.course;

import java.util.Date;

import com.ziksana.id.ZID;
import com.ziksana.domain.common.AuditHistory;

public class CourseContentSecurity extends AuditHistory{
	
	public CourseContentSecurity(String logoPath,
			String watermarkPath, Boolean flotingIndicator,
			Boolean signatureIndicator) {
		super();
		this.setLogoPath(logoPath);
		this.watermarkPath = watermarkPath;
		this.flotingIndicator = flotingIndicator;
		this.signatureIndicator = signatureIndicator;
	}

	
	private ZID 		contentSecurityId;
	private Date 		creationDate			= null;
	private String 		logoPath 				= null;
	private String 		watermarkPath 			= null;
	private Boolean 	flotingIndicator 		= null;
	private Boolean 	signatureIndicator 		= null;
	
	private Institution institution				= null;
	private Course		course					= null;
	
	/**
	 * @return the contentSecurityId
	 */
	public ZID getContentSecurityId() {
		return contentSecurityId;
	}
	/**
	 * @param contentSecurityId the contentSecurityId to set
	 */
	public void setContentSecurityId(ZID contentSecurityId) {
		this.contentSecurityId = contentSecurityId;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the watermarkPath
	 */
	public String getWatermarkPath() {
		return watermarkPath;
	}
	/**
	 * @param watermarkPath the watermarkPath to set
	 */
	public void setWatermarkPath(String watermarkPath) {
		this.watermarkPath = watermarkPath;
	}
	/**
	 * @return the flotingIndicator
	 */
	public Boolean getFlotingIndicator() {
		return flotingIndicator;
	}
	/**
	 * @param flotingIndicator the flotingIndicator to set
	 */
	public void setFlotingIndicator(Boolean flotingIndicator) {
		this.flotingIndicator = flotingIndicator;
	}
	/**
	 * @return the signatureIndicator
	 */
	public Boolean getSignatureIndicator() {
		return signatureIndicator;
	}
	/**
	 * @param signatureIndicator the signatureIndicator to set
	 */
	public void setSignatureIndicator(Boolean signatureIndicator) {
		this.signatureIndicator = signatureIndicator;
	}

	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "CourseContentSecurity [logoPath="
				+ logoPath + ", watermarkPath=" + watermarkPath
				+ ", flotingIndicator=" + flotingIndicator
				+ ", signatureIndicator=" + signatureIndicator + "]";
	}
	
	

}
