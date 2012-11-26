package com.ziksana.domain.assessment.member;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

/**
 * @author bhashasp
 */
public class TestSubmissionKeyword {
	
	public TestSubmissionKeyword(){
		
	}
	
	public TestSubmissionKeyword(String weightedKeyword, Integer weightage) {
		super();
		this.weightedKeyword = weightedKeyword;
		this.weightage = weightage;
	}
	
	private ZID 			submissionKeywordId;
	private String 			weightedKeyword 	= null;
	private Integer 		weightage 			= null;
	private TestSubmission 	testSubmission 		= null;
	
	/**
	 * @return the submissionKeywordId
	 */
	public ZID getSubmissionKeywordId() {
		return submissionKeywordId;
	}
	/**
	 * @param submissionKeywordId the submissionKeywordId to set
	 */
	public void setSubmissionKeywordId(Integer submissionKeywordId) {
		this.submissionKeywordId = new IntegerZID(submissionKeywordId);
	}
	/**
	 * @return the weightedKeyword
	 */
	public String getWeightedKeyword() {
		return weightedKeyword;
	}
	/**
	 * @param weightedKeyword the weightedKeyword to set
	 */
	public void setWeightedKeyword(String weightedKeyword) {
		this.weightedKeyword = weightedKeyword;
	}
	/**
	 * @return the weightage
	 */
	public Integer getWeightage() {
		return weightage;
	}
	/**
	 * @param weightage the weightage to set
	 */
	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}
	/**
	 * @return the testSubmission
	 */
	public TestSubmission getTestSubmission() {
		return testSubmission;
	}
	/**
	 * @param testSubmission the testSubmission to set
	 */
	public void setTestSubmission(TestSubmission testSubmission) {
		this.testSubmission = testSubmission;
	}

}
