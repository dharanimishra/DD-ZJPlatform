package com.ziksana.domain.polls;



public enum PollQuestionType {

	// TODO: We may want to fetch the ids from the static data service
		SINGLE_CHOICE(1, "Single Choice"),
		MULTI_CHOICE (2, "Multi Choice");
		
		private final int     id;
		private final String  name;
		
		private PollQuestionType(int id, String name) {
			this.id   = id;
			this.name = name;
		}
		
		public int getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public static PollQuestionType getType(int ID) {
			for (PollQuestionType t : PollQuestionType.values()) {
				if (t.getID() == ID) {
					return t;
				}
			}
			
			throw new IndexOutOfBoundsException("PollQuestionType ID [" + ID + "] not found");
		}
		
		public String toString() {
			return "Poll Question Type [" + getName() + "] ID [" + getID() + "]";
		}
}
