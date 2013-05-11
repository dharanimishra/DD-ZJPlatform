package com.ziksana.domain.assessment.engagement;

import java.util.Date;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class EngagementCriteria {
 
	public EngagementCriteria(PerformanceParameter performanceParameter,
			Operator operator, String paramValue) {
		super();
		this.performanceParameter = performanceParameter;
		this.operator = operator;
		this.paramValue = paramValue;
	}
	
	private ZID 					engagementCriteriaId;
	private Date 					creationDate 			= null;
	private PerformanceParameter 	performanceParameter 	= null;
	private Operator 				operator 				= null;
	private String 					paramValue 				= null;
	
	
	/**
	 * @return the engagementCriteriaId
	 */
	public ZID getEngagementCriteriaId() {
		return engagementCriteriaId;
	}
	/**
	 * @param engagementCriteriaId the engagementCriteriaId to set
	 */
	public void setEngagementCriteriaId(Integer engagementCriteriaId) {
		this.engagementCriteriaId = new IntegerZID(engagementCriteriaId);
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
	 * @return the performanceParameter
	 */
	public PerformanceParameter getPerformanceParameter() {
		return performanceParameter;
	}
	/**
	 * @param performanceParameter the performanceParameter to set
	 */
	public void setPerformanceParameter(PerformanceParameter performanceParameter) {
		this.performanceParameter = performanceParameter;
	}
	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	/**
	 * @return the paramValue
	 */
	public String getParamValue() {
		return paramValue;
	}
	/**
	 * @param paramValue the paramValue to set
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EngagementCriteria [creationDate=" + creationDate
				+ ", performanceParameter=" + performanceParameter
				+ ", operator=" + operator + ", paramValue=" + paramValue + "]";
	}
}
