package com.ziksana.domain.course;

/**
 * @author bhashasp
 */
public class SearchReviewerCriteria {
	
	
	/**
	 * Advanced Search criteria
	 * @param firstName
	 * @param lastName
	 * @param circle
	 * @param deptName
	 */
	public SearchReviewerCriteria(String firstName, String lastName,
			Integer circle, String deptName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.circle = circle;
		this.deptName = deptName;
	}

	/**
	 * Basic Search Criteria
	 * @param name
	 */
	public SearchReviewerCriteria(String name) {
		this.name = name;
	}
	
	private String 		name 		= null;
	private String 		firstName 	= null;
	private String 		lastName 	= null;
	private Integer 	circle 		= null;
	private String 		deptName 	= null;
	
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the circle
	 */
	public Integer getCircle() {
		return circle;
	}
	/**
	 * @param circle the circle to set
	 */
	public void setCircle(Integer circle) {
		this.circle = circle;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
