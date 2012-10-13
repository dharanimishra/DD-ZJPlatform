package com.ziksana.domain.assessment;

import com.ziksana.domain.common.AuditHistory;
import com.ziksana.id.ZID;

public class NextBestQuestion extends AuditHistory {
	

	public NextBestQuestion(TestModel testModel, Boolean active) {
		this.testModel = testModel;
		this.active = active;
	}

	
	private ZID 		nextBestQuestionId;
	private TestModel 	testModel 	= null;
	private Boolean 	active 		= null;
	
	
	public ZID getNextBestQuestionId() {
		return nextBestQuestionId;
	}
	public void setNextBestQuestionId(ZID nextBestQuestionId) {
		this.nextBestQuestionId = nextBestQuestionId;
	}
	public TestModel getTestModel() {
		return testModel;
	}
	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "NextBestQuestion [testModel=" + testModel + ", active="
				+ active + "]";
	}


}
