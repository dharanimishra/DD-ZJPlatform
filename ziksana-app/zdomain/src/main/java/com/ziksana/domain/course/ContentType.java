package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

public enum ContentType {

	VIDEO(), ENHANCED_VIDEO(), AUDIO(), TEXTUAL(), PDF(), DOC(), PPT(), EXCEL(), IMAGE(), LINK();

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentType.class);

	private int id;

	private String name;

	private final static String CATEGORY = "corLearningContent_Content Type";

	private ContentType() {
	}

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		ContentType[] contentTypes = ContentType.values();
		for (ContentType contentType : contentTypes) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					contentType.name());
			contentType.id = utlLookup.getLookupValueId();
			contentType.name = utlLookup.getLookupValue();
		}
		initialized = true;
		LOGGER.debug("Content Type initialized " + contentTypes);
	}

	private ContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static ContentType getValueOf(String contentTypeString){
		initialize();
		return valueOf(contentTypeString);
	}


	public int getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public static ContentType getContentType(int ID) {
		if (!initialized) {
			initialize();
		}
		for (ContentType t : ContentType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("ContentType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
