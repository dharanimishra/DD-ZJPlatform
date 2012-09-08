package com.springs.domain;

import java.io.Serializable;

public class FileVO implements Serializable {

	private static final long serialVersionUID = 3647233284813657927L;

	private int videoId;
	private String name = null;
	private String description = null;
	private String time;
	private String bookmarkTitle = null;

	public String getVideoId() {
		return String.valueOf(videoId);
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookmarkTitle() {
		return bookmarkTitle;
	}

	public void setBookmarkTitle(String bookmarkTitle) {
		this.bookmarkTitle = bookmarkTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "[Status] " + "(" + videoId + ") " + name;
	}

}
