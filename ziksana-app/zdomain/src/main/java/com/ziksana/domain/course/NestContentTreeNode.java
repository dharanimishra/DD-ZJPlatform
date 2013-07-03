package com.ziksana.domain.course;

import java.util.List;

public class NestContentTreeNode {

	private Integer id;
	private String contentId;
	private String contentType;
	private String contentname;
	private String icon;
	private Integer parentLearningComponentId;
	private Integer nestLearningComponentId;

	private boolean expanded = true;

	private List<NestContentTreeNode> contents = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentname() {
		return contentname;
	}

	public void setContentname(String contentname) {
		this.contentname = contentname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getParentLearningComponentId() {
		return parentLearningComponentId;
	}

	public void setParentLearningComponentId(Integer parentLearningComponentId) {
		this.parentLearningComponentId = parentLearningComponentId;
	}

	public Integer getNestLearningComponentId() {
		return nestLearningComponentId;
	}

	public void setNestLearningComponentId(Integer nestLearningComponentId) {
		this.nestLearningComponentId = nestLearningComponentId;
	}

	public List<NestContentTreeNode> getContents() {
		return contents;
	}

	public void setContents(List<NestContentTreeNode> contents) {
		this.contents = contents;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	@Override
	public String toString() {
		return "NestContentTreeNode [id=" + id + ", contentId=" + contentId
				+ ", contentType=" + contentType + ", contentname="
				+ contentname + ", icon=" + icon
				+ ", parentLearningComponentId=" + parentLearningComponentId
				+ ", nestLearningComponentId=" + nestLearningComponentId
				+ ", contents=" + contents + "]";
	}

}
