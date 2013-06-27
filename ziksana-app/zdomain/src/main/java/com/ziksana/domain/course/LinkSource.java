package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum LinkSource {

	ZIKSANA_INTERNAL(-1, "Ziksana Internal"), UNIVERSITY_INTERNAL(-2, "University Internal"), PRIVATE(-3, "Private"), PUBLIC(-4, "Public");

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LinkSource.class);


	private int id;
	private String name;

	private final static String CATEGORY = "Link Source";


	private LinkSource() {
	}

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		LinkSource[] linkSources = LinkSource.values();
		for (LinkSource linkSource : linkSources) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					linkSource.getName());
			linkSource.id = utlLookup.getLookupValueId();
		}
		initialized = true;
		LOGGER.debug("LinkSource initialized " );
	}

	private LinkSource(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static LinkSource getValueOf(String linkSourceString){
		initialize();
		return valueOf(linkSourceString);
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

	public static LinkSource getLinkSource(int ID) {
		if (!initialized) {
			initialize();
		}
		for (LinkSource t : LinkSource.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("LinkSource ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "LinkSource [" + getName() + "] ID [" + getID() + "]";
	}
}
