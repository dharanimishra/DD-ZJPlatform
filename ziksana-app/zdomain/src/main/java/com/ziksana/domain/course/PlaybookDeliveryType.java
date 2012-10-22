package com.ziksana.domain.course;

import java.util.NoSuchElementException;

public enum PlaybookDeliveryType {

	// TODO: retrieve the ids from the static data service
	PDF      		(1, "PDF"),
	ONLINE      	(2, "Online"),
	MOBILE_APP   	(3, "Mobile App");
	

	private final int id;
	
	private final String name;

	private PlaybookDeliveryType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PlaybookDeliveryType getPlaybookDeliveryType(int ID) {
		for (PlaybookDeliveryType deliveryType : PlaybookDeliveryType.values()) {
			if (deliveryType.getID() == ID) {
				return deliveryType;
			}
		}

		throw new NoSuchElementException("PlaybookDelivery Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "PlaybookDelivery Type [" + getName() + "] ID [" + getID() + "]";
	}
}
