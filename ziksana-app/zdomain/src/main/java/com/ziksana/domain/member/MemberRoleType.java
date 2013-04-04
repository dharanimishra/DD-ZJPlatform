package com.ziksana.domain.member;

import java.util.HashMap;
import java.util.Map;



public enum MemberRoleType {

	// TODO: We may want to retrieve the ids from the static data service
	LEARNER(1), EDUCATOR(2), TEACHING_ASSISTANT(3), PLATFORM_ADMIN(4), UNIVERSITY_ADMIN(5);

	private int id;
	

	private final static String category ="WorkFlowItemStatus";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
//		EnumUtil enumUtil = new EnumUtil();
//		mapUtil = enumUtil.getEnumData(category);
//		System.out.println("Getting static values :category :mapUtil :"
//				+ mapUtil.size());
	}

	
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
