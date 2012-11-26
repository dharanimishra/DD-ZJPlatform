package com.ziksana.domain.assessment.member;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestSecurity {

	public TestSecurity(){
		
	}
	
	public TestSecurity(SecurityType securityType,
			SecurityDataContentType securityDataContentType, String dataLink) {
		super();
		this.securityType = securityType;
		this.securityDataContentType = securityDataContentType;
		this.dataLink = dataLink;
	}
	private ZID 					securityId;
	private SecurityType 			securityType 			= null;
	private SecurityDataContentType securityDataContentType = null;
	private String 					dataLink 				= null;
	private StudentTest				test					= null;
	
	/**
	 * @return the securityId
	 */
	public ZID getSecurityId() {
		return securityId;
	}
	/**
	 * @param securityId the securityId to set
	 */
	public void setSecurityId(Integer securityId) {
		this.securityId = new IntegerZID(securityId);
	}
	/**
	 * @return the securityType
	 */
	public SecurityType getSecurityType() {
		return securityType;
	}
	/**
	 * @param securityType the securityType to set
	 */
	public void setSecurityType(SecurityType securityType) {
		this.securityType = securityType;
	}
	/**
	 * @return the securityDataContentType
	 */
	public SecurityDataContentType getSecurityDataContentType() {
		return securityDataContentType;
	}
	/**
	 * @param securityDataContentType the securityDataContentType to set
	 */
	public void setSecurityDataContentType(
			SecurityDataContentType securityDataContentType) {
		this.securityDataContentType = securityDataContentType;
	}
	/**
	 * @return the dataLink
	 */
	public String getDataLink() {
		return dataLink;
	}
	/**
	 * @param dataLink the dataLink to set
	 */
	public void setDataLink(String dataLink) {
		this.dataLink = dataLink;
	}
	/**
	 * @return the test
	 */
	public StudentTest getTest() {
		return test;
	}
	/**
	 * @param test the test to set
	 */
	public void setTest(StudentTest test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "TestSecurity [securityType=" + securityType
				+ ", securityDataContentType=" + securityDataContentType
				+ ", dataLink=" + dataLink + "]";
	}
}
