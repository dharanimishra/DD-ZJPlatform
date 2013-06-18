package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ContentFormat {

	// TODO: retrieve the ids from the static data service
	DOCUMENT(), IMAGE(), VIDEO(), AUDIO(), LINK();

	// static initialzer to initialize as it does not initialize on call of
	// valueOf method. valueOf
	static {

	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentFormat.class);

	private int id;

	private String name;

	private final static String CATEGORY = "Learning Content Format";

	private static boolean initialized = false;

	private ContentFormat() {
		// TODO Auto-generated constructor stub
	}

	private ContentFormat(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static ContentFormat getValueOf(String contentFormatString) {
		initialize();
		return valueOf(contentFormatString);
	}

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		ContentFormat[] contentFormats = ContentFormat.values();
		for (ContentFormat contentFormat : contentFormats) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					contentFormat.name());
			contentFormat.id = utlLookup.getLookupValueId();
			contentFormat.name = utlLookup.getLookupValue();
		}
		initialized = true;
		LOGGER.debug("Content Type initialized " + contentFormats);
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentFormat getContentFormat(int ID) {
		if (!initialized) {
			initialize();
		}
		for (ContentFormat t : ContentFormat.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("ContentType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Content Format [" + getName() + "] ID [" + getID() + "]";
	}
}
