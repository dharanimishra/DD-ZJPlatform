/**
 * 
 */
package com.ziksana.domain.course;

/**
 * @author prabu
 *
 */
public class Node {
	
	private Integer id;
	
	private Integer type;
	
	private Node parent;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	

}
