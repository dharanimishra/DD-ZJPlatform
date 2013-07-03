package com.ziksana.domain.course;

public class Planner {
	
	private String nodeId;
	
	private Integer Id;
	
	private String nodeUniqueId;
	
	private Integer courseId;
	
	private Integer learningComponentId;
	
	private Integer learningContentId;
	
	private String startWeek;
	
	private String startDay;
	
	private String startsAt;
	
	private Integer duration;
	
	private String note;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getLearningComponentId() {
		return learningComponentId;
	}

	public void setLearningComponentId(Integer learningComponentId) {
		this.learningComponentId = learningComponentId;
	}

	public Integer getLearningContentId() {
		return learningContentId;
	}

	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(String startWeek) {
		this.startWeek = startWeek;
	}

	

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(String startsAt) {
		this.startsAt = startsAt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result
				+ ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime
				* result
				+ ((learningComponentId == null) ? 0 : learningComponentId
						.hashCode());
		result = prime
				* result
				+ ((learningContentId == null) ? 0 : learningContentId
						.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((startDay == null) ? 0 : startDay.hashCode());
		result = prime * result
				+ ((startWeek == null) ? 0 : startWeek.hashCode());
		result = prime * result
				+ ((startsAt == null) ? 0 : startsAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planner other = (Planner) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (learningComponentId == null) {
			if (other.learningComponentId != null)
				return false;
		} else if (!learningComponentId.equals(other.learningComponentId))
			return false;
		if (learningContentId == null) {
			if (other.learningContentId != null)
				return false;
		} else if (!learningContentId.equals(other.learningContentId))
			return false;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (startDay == null) {
			if (other.startDay != null)
				return false;
		} else if (!startDay.equals(other.startDay))
			return false;
		if (startWeek == null) {
			if (other.startWeek != null)
				return false;
		} else if (!startWeek.equals(other.startWeek))
			return false;
		if (startsAt == null) {
			if (other.startsAt != null)
				return false;
		} else if (!startsAt.equals(other.startsAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Planner [nodeId=" + nodeId + ", Id=" + Id + ", courseId="
				+ courseId + ", learningComponentId=" + learningComponentId
				+ ", learningContentId=" + learningContentId + ", startWeek="
				+ startWeek + ", startDay=" + startDay + ", startsAt="
				+ startsAt + ", duration=" + duration + ", note=" + note + "]";
	}

	public String getNodeUniqueId() {
		return nodeUniqueId;
	}

	public void setNodeUniqueId(String nodeUniqueId) {
		this.nodeUniqueId = nodeUniqueId;
	}
	
	
}
