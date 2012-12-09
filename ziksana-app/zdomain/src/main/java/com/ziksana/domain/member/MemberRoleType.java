package com.ziksana.domain.member;

public enum MemberRoleType {

	// TODO: We may want to retrieve the ids from the static data service
	LEARNER(1), EDUCATOR(2), TEACHING_ASSISTANT(3), PLATFORM_ADMIN(4), UNIVERSITY_ADMIN(5);

	private int id;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 MemberRoleType(int id) {
		this.id = id;
		
	}

	public int getID() {
		return id;
	}

	
	public static MemberRoleType getMemberRoleType(int ID) {
		for (MemberRoleType t : MemberRoleType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		String msg = String.format("MemberRoleType ID %s not found", ID);
		throw new IllegalArgumentException(msg);

	}

	public String toString() {
		return "Member Role Type [" +  "] ID [" + getID() + "]";
	}
}
