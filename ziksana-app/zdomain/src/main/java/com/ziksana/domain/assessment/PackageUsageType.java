package com.ziksana.domain.assessment;

import java.util.NoSuchElementException;

public enum PackageUsageType {

	//TODO: retrieve the ids from the static data service
	PRACTICE			(1, "Practice");

	private final int id;
	private final String name;

	private PackageUsageType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static PackageUsageType getPackageUsageType(int ID){
		for (PackageUsageType t : PackageUsageType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new NoSuchElementException("PackageUsageType ID [" + ID + "] not found");
	}

	public String toString() {
		return "PackageUsage Type [" + getName() + "] ID [" + getID() + "]";
	}
}
