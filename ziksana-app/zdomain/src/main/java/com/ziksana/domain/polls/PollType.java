package com.ziksana.domain.polls;



public enum PollType {

	// TODO: We may want to fetch the ids from the static data service
		GENERAL(1, "General"),
		VOTING (2, "Voting"),
		SURVEY (3, "Survey");
		
		private final int     id;
		private final String  name;
		
		private PollType(int id, String name) {
			this.id   = id;
			this.name = name;
		}
		
		public int getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public static PollType getType(int ID) {
			for (PollType t : PollType.values()) {
				if (t.getID() == ID) {
					return t;
				}
			}
			
			throw new IndexOutOfBoundsException("PollType ID [" + ID + "] not found");
		}
		
		public String toString() {
			return "Poll Type [" + getName() + "] ID [" + getID() + "]";
		}

}
