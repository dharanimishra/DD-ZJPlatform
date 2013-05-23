package com.ziksana.domain.course;

public class NestContentNode {

	private int id;
	private String contentId;
	private String contentType;
	private String contentname;
	private String icon;
	private int parentLearningComponentId;

	private boolean expanded = true;

	public int getId() {
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
		
		String strValue = ContentType.getContentType(Integer.parseInt(contentType)).getName();
		this.contentType = strValue;
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

	public int getParentLearningComponentId() {
		return parentLearningComponentId;
	}

	public void setParentLearningComponentId(Integer parentLearningComponentId) {
		this.parentLearningComponentId = parentLearningComponentId;
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
				+ "]";
	}

	public String debugTrace() {
		StringBuffer sb = new StringBuffer("##");
		sb.append("CTID=");
		sb.append(getContentId());
		sb.append(", PLCID=");
		sb.append(getParentLearningComponentId());
		sb.append("##");

		return sb.toString();
	}
}
