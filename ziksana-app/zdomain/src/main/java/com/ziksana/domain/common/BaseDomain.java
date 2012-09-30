/**
 * 
 */
package com.ziksana.domain.common;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;

/**
 * @author prabu
 *
 */
public class BaseDomain {
	
	 
	 private Integer   ID;
	 
	 private MemberPersona memberPersona;
	 
	 private Date creationDate;

	
   /**
	 * @return the identity 
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
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
	 
	 	
	

}
