package com.ziksana.domain.polls;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.ziksana.domain.member.MemberRoleType;
import com.ziksana.domain.member.MemberPersona;

public class Poll implements Comparable<Poll> {

	private Integer        ID                     = null;
	private MemberPersona  creatorMember          = null;
	private Date           pollStartDate          = null;
	private Date           pollEndDate            = null;
	private Date           pollDisplayEndDate     = null;
	private Boolean        active                 = null;
	private Long           totalResponses         = null;
	private PollType       pollType               = null;
	private PollVisibility pollVisibility         = null;
	private MemberRoleType targetedMemberRoleType = null;

	private List<PollQuestion> pollQuestions      = null;
	
	public Poll() {
		pollType               = PollType.GENERAL;
		pollVisibility         = PollVisibility.ALL;
	}
	
	public Poll(Integer ID) {
		this.ID                = ID;
		pollType               = PollType.GENERAL;
		pollVisibility         = PollVisibility.ALL;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public MemberPersona getCreatorMember() {
		return creatorMember;
	}

	public void setCreatorMember(MemberPersona creatorMember) {
		this.creatorMember = creatorMember;
	}

	public PollType getPollType() {
		return pollType;
	}

	public void setPollType(PollType pollType) {
		this.pollType = pollType;
	}

	public Date getPollStartDate() {
		return pollStartDate;
	}

	public Date getPollEndDate() {
		return pollEndDate;
	}

	public Date getDisplayEndDate() {
		return pollDisplayEndDate;
	}

	public void setPollDates(Date pollStartDate, Date pollEndDate, 
			                 Date pollDisplayEndDate) {
		if (pollStartDate == null || pollEndDate == null || 
				pollDisplayEndDate == null) {
			throw new IllegalArgumentException("setPollDates() : Null date passed");
		}

		if (pollStartDate.before(pollEndDate)  && 
		    (pollEndDate.before(pollDisplayEndDate) || pollEndDate.equals(pollDisplayEndDate))) {
			this.pollStartDate  = pollStartDate;
			this.pollEndDate    = pollEndDate;
			this.pollDisplayEndDate = pollDisplayEndDate;
		} else {
			throw new IllegalArgumentException("Poll Start & End Dates, not in proper sequence.");
		}
	}

	public PollVisibility getPollVisibility() {
		return pollVisibility;
	}

	public void setPollVisibility(PollVisibility pollVisibility) {
		this.pollVisibility = pollVisibility;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getTotalResponses() {
		return totalResponses;
	}

	public void setTotalResponses(Long totalResponses) {
		this.totalResponses = totalResponses;
	}

	public MemberRoleType getTargetedMemberRoleType() {
		return targetedMemberRoleType;
	}

	public void setTargetedMemberRoleType(MemberRoleType targetedMemberRoleType) {
		this.targetedMemberRoleType = targetedMemberRoleType;
	}
	
	public PollQuestion getQuestion(int index) {
		
		if (pollQuestions == null) {
			throw new IllegalStateException("Poll Questions not set in the Poll ID [" + ID + "]");
		}
		
		return pollQuestions.get(index);	
	}
	
	public List<PollQuestion> getAllQuestions() {
		return pollQuestions;
	}
	
	public void addQuestion(PollQuestion question) {
		if (pollQuestions == null) {
			pollQuestions = new ArrayList<PollQuestion>();
		}
		
		question.setPoll(this);
		pollQuestions.add(question);
	}
	
	public void setQuestions(List<PollQuestion> list) {
		if (list == null) {
			throw new IllegalArgumentException("Cannot set PollQuestions as null in Poll ID [" + ID + "]");
		}
		
		pollQuestions = list;
		Iterator<PollQuestion> ir = pollQuestions.iterator();
		while (ir.hasNext()) {
			ir.next().setPoll(this);
		}
	}
	
	/**
	 * TODO: Equality based on ID may not be complete
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)                        { return true;  }
		if (obj == null)                        { return false; }
		if (obj.getClass() != this.getClass())  { return false; }
		
		Poll poll = (Poll) obj;
		if (getID() == poll.getID()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getID();
	}
	
	/**
	 * Provided to facilitate sorting (UI Poll widget).
	 * Comparison is based on the Poll End Date. 
	 * In case dates are same, the ID is used.
	 */
	@Override
	public int compareTo(Poll poll) {
		if (poll == null)       { return 1; }
		if (this.equals(poll))  { return 0; }
		
		if (getPollEndDate().equals(poll.getPollEndDate())) {
			return getID().compareTo(poll.getID());
		}
		
		return getPollEndDate().compareTo(poll.getPollEndDate());
	}
	
	public String toString() {
		// TODO: create a string for the whole object
		return super.toString();
	}
}