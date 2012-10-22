/**
 * 
 */
package com.ziksana.domain.common;

import java.util.Set;

/**
 * @author prabu
 * 
 */
public class Question {

	private String text;
	private String imageUrl;
	private String videoUrl;
	private Set<Choice> choices;

	
	public static class Builder {

		// required parameters
		private String text;
		private Set<Choice> choices;

		// optional parameters
		private String imageUrl = null;
		private String videoUrl = null;

		public Builder(String text, Set<Choice> choices) {
			this.text = text;
			this.choices = choices;
		}

		public Builder imageUrl(String urlString) {
			imageUrl = urlString;
			return this;

		}

		public Builder videoUrl(String urlString) {
			videoUrl = urlString;
			return this;

		}

		public Question build() {
			return new Question(this);
		}
	}

	private Question(Builder builder) {

		text = builder.text;
		imageUrl = builder.imageUrl;
		videoUrl = builder.videoUrl;
		choices = builder.choices;

	}

}
