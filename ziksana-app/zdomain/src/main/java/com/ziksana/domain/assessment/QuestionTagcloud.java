package com.ziksana.domain.assessment;

import com.ziksana.domain.common.TagCloud;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class QuestionTagcloud extends TagCloud {
	


	public QuestionTagcloud(String tagName, TagType tagType) {
		super(tagName, tagType);
	}
	private ZID 			tagId;
	private QuestionBank 	questionBank 	= null;

	/**
	 * @return the tagId
	 */
	public ZID getTagId() {
		return tagId;
	}
	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(ZID tagId) {
		this.tagId = tagId;
	}
	/**
	 * @return the questionBank
	 */
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	/**
	 * @param questionBank the questionBank to set
	 */
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}
}
