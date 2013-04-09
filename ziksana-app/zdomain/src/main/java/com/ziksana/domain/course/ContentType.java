package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ContentType {

	// TODO: retrieve the ids from the static data service
	VIDEO(), ENHANCED_VIDEO(), AUDIO(), TEXTUAL(), PDF(), DOC(), PPT(), EXCEL(), IMAGE(), LINK();

	private int id;

	private String name;

	private final static String category = "corLearningContent_Content Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
	
		VIDEO.setID(mapUtil.get("Video").intValue());
		ENHANCED_VIDEO.setID(mapUtil.get("ENHANCED_VIDEO").intValue());
		AUDIO.setID(mapUtil.get("Audio").intValue());
		TEXTUAL.setID(mapUtil.get("Textual").intValue());
		PDF.setID(mapUtil.get("PDF").intValue());
		DOC.setID(mapUtil.get("DOC").intValue());
		PPT.setID(mapUtil.get("PPT").intValue());
		EXCEL.setID(mapUtil.get("EXCEL").intValue());
		IMAGE.setID(mapUtil.get("IMAGE").intValue());
		LINK.setID(mapUtil.get("LINK").intValue());

	}

	private ContentType() {

	}

	private void setID(int id) {
		this.id = id;

	}

	private ContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentType getContentType(int ID) {
		for (ContentType comntentType : ContentType.values()) {
			if (comntentType.getID() == ID) {
				return comntentType;
			}
		}

		throw new NoSuchElementException("Content Type ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
