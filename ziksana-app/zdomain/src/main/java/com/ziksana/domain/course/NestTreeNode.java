package com.ziksana.domain.course;

import java.util.List;

public class NestTreeNode {

	private int courseId;
	private String coursename;
	private int id;
	private String title;
	private int parentLearningComponentId;
	private int nestLearningComponentId;
    
	private int duration;
	private String nodeDescription;
	private String thumbnailPicturePath; 
	
	private List<NestTreeNode> children = null;
	private List<NestContentNode> contents = null;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public List<NestTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<NestTreeNode> children) {
		this.children = children;
	}

	public List<NestContentNode> getContent() {
		return contents;
	}

	public void setContent(List<NestContentNode> contents) {
		this.contents = contents;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getParentLearningComponentId() {
		return parentLearningComponentId;
	}

	public void setParentLearningComponentId(Integer parentLearningComponentId) {
		this.parentLearningComponentId = parentLearningComponentId;
	}

	public int getNestLearningComponentId() {
		return nestLearningComponentId;
	}

	public void setNestLearningComponentId(Integer nestLearningComponentId) {
		this.nestLearningComponentId = nestLearningComponentId;
	}
   
	
	public String getNodeDescription() {
		return nodeDescription;
	}

	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription;
	}

	@Override
	public String toString() {
		return "NestTreeNode [courseId=" + courseId + ", coursename="
				+ coursename + ", id=" + id + ", title=" + title
				+ ", parentLearningComponentId=" + parentLearningComponentId
				+ ", nestLearningComponentId=" + nestLearningComponentId
				+ ", children=" + children + ", contents=" + contents + "]";
	}

	public static String debugTrace(List<NestTreeNode> list) {
		if (list == null) {
			return new String("LIST is null");
		}

		StringBuffer sb = new StringBuffer("LIST SZ : ");
		sb.append(list.size());
		int i = 0;
		for (NestTreeNode node : list) {
			sb.append("\nElement #");
			sb.append(i);
			sb.append(" -> ");
			sb.append(node.debugTrace());
			i++;
		}

		return sb.toString();
	}

	public String debugTrace() {
		StringBuffer sb = new StringBuffer("**");
		sb.append("CID=");
		sb.append(getCourseId());
		sb.append(", PLCID=");
		sb.append(getParentLearningComponentId());
		sb.append(", NLCID=");
		sb.append(getNestLearningComponentId());
		if (getChildren() != null) {
			sb.append(", CHSZ=");
			sb.append(getChildren().size());
			sb.append(", CHLS=[");
			for (NestTreeNode node : getChildren()) {
				sb.append(node.debugTrace());
			}
		} else {
			sb.append(", CHLS=[null");
		}

		if (getContent() != null) {
			sb.append("], CTSZ=[");
			sb.append(getContent().size());
			sb.append(", CNTS=[");
			for (NestContentNode node : getContent()) {
				sb.append(node.debugTrace());
			}
		} else {
			sb.append("], CNTS=[null");
		}
		sb.append("]**");

		return sb.toString();
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getThumbnailPicturePath() {
		return thumbnailPicturePath;
	}

	public void setThumbnailPicturePath(String thumbnailPicturePath) {
		this.thumbnailPicturePath = thumbnailPicturePath;
	}
	
}
