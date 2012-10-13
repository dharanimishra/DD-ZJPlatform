package com.ziksana.domain.assessment;

import java.util.Date;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestPackage extends AuditHistory{
	
	public TestPackage(String status, String packageName,
			ProficiencyLevel proficiencyLevel, String competencyLevel) {
		this.status = status;
		this.packageName = packageName;
		this.proficiencyLevel = proficiencyLevel;
		this.competencyLevel = competencyLevel;
	}

	private ZID 				testPackageId;
	private String 				status 				= null;
	private Date 				creationDate 		= null;
	private String 				packageName 		= null;
	private PackageUsageType	packageUsageType	= null;
	private ProficiencyLevel 	proficiencyLevel 	= null;
	private String 				competencyLevel 	= null;

	/**
	 * @return the testPackageId
	 */
	public ZID getTestPackageId() {
		return testPackageId;
	}
	/**
	 * @param testPackageId the testPackageId to set
	 */
	public void setTestPackageId(ZID testPackageId) {
		this.testPackageId = testPackageId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}
	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	/**
	 * @return the packageUsageType
	 */
	public PackageUsageType getPackageUsageType() {
		return packageUsageType;
	}
	/**
	 * @param packageUsageType the packageUsageType to set
	 */
	public void setPackageUsageType(PackageUsageType packageUsageType) {
		this.packageUsageType = packageUsageType;
	}
	/**
	 * @return the proficiencyLevel
	 */
	public ProficiencyLevel getProficiencyLevel() {
		return proficiencyLevel;
	}
	/**
	 * @param proficiencyLevel the proficiencyLevel to set
	 */
	public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) {
		this.proficiencyLevel = proficiencyLevel;
	}
	/**
	 * @return the competencyLevel
	 */
	public String getCompetencyLevel() {
		return competencyLevel;
	}
	/**
	 * @param competencyLevel the competencyLevel to set
	 */
	public void setCompetencyLevel(String competencyLevel) {
		this.competencyLevel = competencyLevel;
	}
	
	@Override
	public String toString() {
		return "TestPackage [packageName=" + packageName
				+ ", proficiencyLevel=" + proficiencyLevel
				+ ", competencyLevel=" + competencyLevel + "]";
	}
	
}
