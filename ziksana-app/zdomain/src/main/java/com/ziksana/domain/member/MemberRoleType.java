package com.ziksana.domain.member;

public enum MemberRoleType {

	// TODO: We may want to retrieve the ids from the static data service
	LEARNER(1, "Learner"), EDUCATOR(2, "Educator"), TEACHING_ASSISTANT(3,
			"Teaching Assistant"), PLATFORM_ADMIN(4, "Platform Admin"), UNIVERSITY_ADMIN(
			5, "University Admin");

	private final int id;
	private final String name;

	private MemberRoleType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
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
		return "Member Role Type [" + getName() + "] ID [" + getID() + "]";
	}
}
