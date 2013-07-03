package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ContentStatus {

	UNDER_CONSTRUCTION(), UNDER_REVIEW(), ACTIVE(), READY_FOR_RELEASE(), HOLD(), ARCHIVED();

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentStatus.class);

	private int id;

	private String name;

	private final static String CATEGORY = "Content Status";

	private ContentStatus() {
	}

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		ContentStatus[] contentStatus = ContentStatus.values();
		for (ContentStatus contentState : contentStatus) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					contentState.name());
			contentState.id = utlLookup.getLookupValueId();
			contentState.name = utlLookup.getLookupValue();
		}
		initialized = true;
		LOGGER.debug("Content Type initialized " + contentStatus);
	}

	private ContentStatus(int id, String name) {
		this.id = id;
		this.name = name;
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

	public static ContentStatus getContentStatus(int ID) {
		if (!initialized) {
			initialize();
		}
		for (ContentStatus t : ContentStatus.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("ContentStatus ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Content Status [" + getName() + "] ID [" + getID() + "]";
	}
}
