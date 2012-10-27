/**
 * 
 */
package com.ziksana.domain.common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author prabu
 * 
 */
public class Question {

	private ZID id;
	private String text;
	private String imageUrl;
	private String videoUrl;
	private Set<Choice> choices;
	

	Question(Integer id, String text) {

		super();
		this.id = new IntegerZID(id);
		this.text = text;
		this.choices = new HashSet<Choice>();
	}

	/**
	 * @param choices
	 *            the choices to set
	 */
	public void setChoices(List<Choice> choices) {
		this.choices.addAll(choices);
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @param videoUrl
	 *            the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @return the id
	 */
	public ZID getId() {
		return id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @return the choices
	 */
	public Set<Choice> getChoices() {
		return choices;
	}

}
