package com.ziksana.domain.polls;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.ziksana.domain.member.MemberPersona;

public class PollQuestion implements Comparable<PollQuestion> {

	private Integer ID = null;
	private Poll parent = null;
	private MemberPersona creatorMember = null;
	private Boolean active = null;
	private String questionText = null;
	private PollQuestionType questionType = null;
	private List<PollQuestionOption> options = null;
	private Long totalRespondents = -1L;

	public PollQuestion() {

	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Poll getPoll() {
		return parent;
	}

	public void setPoll(Poll parent) {
		this.parent = parent;
	}

	public MemberPersona getCreatorMember() {
		return creatorMember;
	}

	public void setCreatorMember(MemberPersona creator) {
		this.creatorMember = creator;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText == null ? null : questionText.trim();
	}

	public PollQuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(PollQuestionType type) {
		questionType = type;
	}

	public List<PollQuestionOption> getAllOptions() {
	
		return options;
	}

	public PollQuestionOption getOption(int index) {
		return options.get(index);
	}

	public void addOption(String option) {
		if (option == null) {
			throw new IllegalArgumentException(
					"Null option cannot be added to a PollQuestion");
		}

		if (options == null) {
			options = new ArrayList<PollQuestionOption>();
		}

		options.add(new PollQuestionOption(options.size(), option.trim()));
	}

	public void addOption(PollQuestionOption option) {
		if (option == null) {
			throw new IllegalArgumentException(
					"Null option cannot be added to a PollQuestion");
		}

		if (options == null) {
			options = new ArrayList<PollQuestionOption>();
		}

		option.setIndex(options.size());
		options.add(option);
	}

	public void setOptions(List<PollQuestionOption> options) {
		this.options = options;
	}

	public void updateTotals() {
		if (options == null) {
			throw new IllegalStateException("Options not set in Question ID ["
					+ getID() + "]");
		}

		Iterator<PollQuestionOption> itr = options.iterator();
		long total = 0;
		while (itr.hasNext()) {
			try {
				// total += itr.next().getOptionTotal();
			} catch (Exception exp) {
				// Ignore, as some options may not have any user response
			}
		}

		setTotalRespondents(total);
	}

	public void setTotalRespondents(long total) {

		totalRespondents = Long.valueOf(total);
	}

	public Long getTotalRespondents() {
		return totalRespondents;
	}

	/**
	 * TODO: Equality based on ID may not be complete
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		PollQuestion question = (PollQuestion) obj;
		if (getPoll().equals(question.getPoll())
				&& getID().intValue() == question.getID().intValue()) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getID();
	}

	/**
	 * Provided to facilitate sorting (UI Poll widget). Comparison is based on
	 * (parent) Poll. In case parents are same, the question ID is used
	 */
	@Override
	public int compareTo(PollQuestion question) {
		if (question == null) {
			return 1;
		}
		if (this.equals(question)) {
			return 0;
		}
		if (getPoll() == null) {
			return -1;
		}

		if (getPoll().equals(question.getPoll())) {
			return getID().compareTo(question.getID());
		}

		return getPoll().compareTo(question.getPoll());
	}

	public String toString() {
		// TODO: create a string and return
		return super.toString();
	}
}