package com.ziksana.domain.assessment;
import com.ziksana.domain.common.AuditHistory;
import com.ziksana.domain.member.MemberPersona;
import com.ziksana.id.ZID;


/**
 * @author bhashasp
 */
public class QuestionTagcloud extends AuditHistory {
	

	public QuestionTagcloud(String tagName, TagType tagType,
			QuestionBank questionBank, MemberPersona creatorMember) {
		this.tagName = tagName;
		this.tagType = tagType;
		this.questionBank = questionBank;
		this.creatorMember = creatorMember;
	}

	private ZID 			tagId;
	private String 			tagName 		= null;
	private TagType 		tagType	 		= null;
	private Boolean 		active 			= null;
	private QuestionBank 	questionBank 	= null;
	private MemberPersona	creatorMember 	= null;

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
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * @return the tagType
	 */
	public TagType getTagType() {
		return tagType;
	}
	/**
	 * @param tagType the tagType to set
	 */
	public void setTagType(TagType tagType) {
		this.tagType = tagType;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
	/**
	 * @return the creatorMember
	 */
	public MemberPersona getCreatorMember() {
		return creatorMember;
	}
	/**
	 * @param creatorMember the creatorMember to set
	 */
	public void setCreatorMember(MemberPersona creatorMember) {
		this.creatorMember = creatorMember;
	}
	
	@Override
	public String toString() {
		return "QuestionTagcloud [tagName=" + tagName + ", tagType=" + tagType
				+ ", active=" + active + "]";
	}
	
	

}
