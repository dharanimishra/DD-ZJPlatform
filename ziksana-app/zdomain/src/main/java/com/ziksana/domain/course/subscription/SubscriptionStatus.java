package com.ziksana.domain.course.subscription;


public enum SubscriptionStatus {

	// TODO: retrieve the ids from the static data service
	SUBSCRIBED			(1, "Subscribed"), 
	INPROGRESS			(2, "In Progress"),
	CERTIFIED			(3, "Certified"),
	DROPPED_OUT			(3, "Dropped out"),
	DEFERRED			(3, "Deferred");

	private final int id;
	
	private final String name;

	private SubscriptionStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SubscriptionStatus getSubscriptionStatus(int ID) throws NoSuchMethodException{
		for (SubscriptionStatus status : SubscriptionStatus.values()) {
			if (status.getID() == ID) {
				return status;
			}
		}

		throw new NoSuchMethodException("SubscriptionStatus ID [" + ID + "] not found");
	}

	public String toString() {
		return "SubscriptionStatus [" + getName() + "] ID [" + getID() + "]";
	}

}
