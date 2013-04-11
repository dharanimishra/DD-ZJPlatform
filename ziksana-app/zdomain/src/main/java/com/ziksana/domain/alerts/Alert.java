/**
 * 
 */
package com.ziksana.domain.alerts;

import java.util.Date;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author prabu
 * 
 */
public class Alert implements Comparable<Alert> {

	private ZID id;
	private String description;
	private Date creationDate;
	private Date activationDate;
	private Integer status;
	private String category;
	private MemberPersona creatingMember;
	private MemberPersona forMember;
	private Date completeBy;
	private Integer priority;

	public ZID getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = new IntegerZID(id);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MemberPersona getCreatingMember() {
		return creatingMember;
	}

	public void setCreatingMember(MemberPersona creatingMember) {
		this.creatingMember = creatingMember;
	}

	public MemberPersona getForMember() {
		return forMember;
	}

	public void setForMember(MemberPersona forMember) {
		this.forMember = forMember;
	}

	public Date getCompleteBy() {
		return completeBy;
	}

	public void setCompleteBy(Date completeBy) {
		this.completeBy = completeBy;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int compareTo(Alert o) {
		// TODO Auto-generated method stub
		return this.completeBy.compareTo(o.completeBy);

	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
