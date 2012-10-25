/**
 * 
 */
package com.ziksana.domain.common;

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

	
	public static class Builder {

		// required parameters
		private ZID id;
		private String text;
		private Set<Choice> choices;

		// optional parameters
		private String imageUrl = null;
		private String videoUrl = null;

		public Builder(Integer id, String text, Set<Choice> choices) {
			this.id = new IntegerZID(id);
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
        id=builder.id;
		text = builder.text;
		imageUrl = builder.imageUrl;
		videoUrl = builder.videoUrl;
		choices = builder.choices;

	}

}
