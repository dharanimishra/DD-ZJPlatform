package com.ziksana.util;

import java.util.HashMap;
import java.util.Map;

public enum Geography {

	// TODO: retrieve the ids from the static data service

	ASIA(), AUSTRALIA(), EUROPE(), NORTH_AMERICA(), SOUTH_AMERICA(), REST_OF_WORLD();

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	private int id;

	private String name;

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData("Geography");
		mapUtil.put("Asia", 1);
		System.out.println("geography :mapUtil :" + mapUtil);
		setGeography();
	}

	private Geography() {

	}

	public static void setGeography() {

		// Dynamically Fetching data from Data Service
		System.out.println("geography :1");

		Geography.ASIA.setID(mapUtil.get("Asia").intValue());
		// Geography.AUSTRALIA.setID(mapUtil.get("Australia").intValue());
		// Geography.EUROPE.setID(mapUtil.get("Europe").intValue());
		// Geography.EUROPE.setID(mapUtil.get("Europe").intValue());
		// Geography.NORTH_AMERICA.setID(mapUtil.get("North America").intValue());
		// Geography.SOUTH_AMERICA.setID(mapUtil.get("South America").intValue());
		// Geography.REST_OF_WORLD.setID(mapUtil.get("Rest of the World")
		// .intValue());

		System.out.println("geography :2");
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public static Geography getGeography(int ID) throws NoSuchMethodException {
		for (Geography geography : Geography.values()) {
			if (geography.getID() == ID) {
				return geography;
			}
		}

		throw new NoSuchMethodException("Geography ID [" + ID + "] not found");
	}

	public String toString() {
		return "Geography Type [" + getName() + "] ID [" + getID() + "]";
	}

}
