package com.ziksana.domain.course.subscription;


/**
 * @author bhashasp
 */
public enum SbnCoursePropertyName {

	// TODO: retrieve the ids from the static data service
	ADDNL_CREDIT			(1, "For additional Credit Indicator"), 
	SPREAD_OVER_DURATION	(2, "Spread over duration"),
	VIRTUAL					(3, "Virtual Indicator");

	private final int id;
	
	private final String name;

	private SbnCoursePropertyName(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static SbnCoursePropertyName getSubscriptionCoursePropertyName(int ID) throws NoSuchMethodException{
		for (SbnCoursePropertyName propertyName : SbnCoursePropertyName.values()) {
			if (propertyName.getID() == ID) {
				return propertyName;
			}
		}

		throw new NoSuchMethodException("SubscriptionCoursePropertyName ID [" + ID + "] not found");
	}

	public String toString() {
		return "SubscriptionCoursePropertyName [" + getName() + "] ID [" + getID() + "]";
	}

}
