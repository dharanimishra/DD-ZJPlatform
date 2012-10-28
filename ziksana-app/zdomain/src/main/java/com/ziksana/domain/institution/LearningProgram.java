package com.ziksana.domain.institution;

import java.util.Date;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.course.CertificateType;
import com.ziksana.domain.course.Institution;
import com.ziksana.domain.course.Rating;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class LearningProgram extends AuditHistory{
	
	
	public LearningProgram(String name, Rating programRating,
			ProgramType programType, CertificateType certificateType,
			Integer programDuration) {
		this.name = name;
		this.programRating = programRating;
		this.programType = programType;
		this.certificateType = certificateType;
		this.programDuration = programDuration;
	}

	private ZID 				learningProgramId;
	private String 				name 				= null;
	private Date 				startDate 			= null;
	private Date 				endDate 			= null;
	private String 				description 		= null;
	private Rating 				programRating 		= null;
	private ProgramType 		programType 		= null;
	private Boolean 			ziksanaIndicator 	= null;
	private String 				programIdentifier 	= null;
	private CertificateType 	certificateType 	= null;
	private Integer 			programDuration 	= null;
	private Institution 		institution 		= null;
	private Integer 			version 			= null;
	
	/**
	 * @return the learningProgramId
	 */
	public ZID getLearningProgramId() {
		return learningProgramId;
	}
	/**
	 * @param learningProgramId the learningProgramId to set
	 */
	public void setLearningProgramId(ZID learningProgramId) {
		this.learningProgramId = learningProgramId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the starDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param starDate the starDate to set
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the programRating
	 */
	public Rating getProgramRating() {
		return programRating;
	}
	/**
	 * @param programRating the programRating to set
	 */
	public void setProgramRating(Rating programRating) {
		this.programRating = programRating;
	}
	/**
	 * @return the programType
	 */
	public ProgramType getProgramType() {
		return programType;
	}
	/**
	 * @param programType the programType to set
	 */
	public void setProgramType(ProgramType programType) {
		this.programType = programType;
	}
	/**
	 * @return the ziksanaIndicator
	 */
	public Boolean getZiksanaIndicator() {
		return ziksanaIndicator;
	}
	/**
	 * @param ziksanaIndicator the ziksanaIndicator to set
	 */
	public void setZiksanaIndicator(Boolean ziksanaIndicator) {
		this.ziksanaIndicator = ziksanaIndicator;
	}
	/**
	 * @return the programIdentifier
	 */
	public String getProgramIdentifier() {
		return programIdentifier;
	}
	/**
	 * @param programIdentifier the programIdentifier to set
	 */
	public void setProgramIdentifier(String programIdentifier) {
		this.programIdentifier = programIdentifier;
	}
	/**
	 * @return the certificateType
	 */
	public CertificateType getCertificateType() {
		return certificateType;
	}
	/**
	 * @param certificateType the certificateType to set
	 */
	public void setCertificateType(CertificateType certificateType) {
		this.certificateType = certificateType;
	}
	/**
	 * @return the programDuration
	 */
	public Integer getProgramDuration() {
		return programDuration;
	}
	/**
	 * @param programDuration the programDuration to set
	 */
	public void setProgramDuration(Integer programDuration) {
		this.programDuration = programDuration;
	}
	/**
	 * @return the institution
	 */
	public Institution getInstitution() {
		return institution;
	}
	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "LearningProgram [name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description
				+ ", programType=" + programType + ", certificateType="
				+ certificateType + ", programDuration=" + programDuration
				+ "]";
	}

}
