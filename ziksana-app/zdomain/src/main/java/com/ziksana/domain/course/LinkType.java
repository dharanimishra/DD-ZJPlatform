package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum LinkType {

	// TODO: retrieve the ids from the static data service
	REFERENCE(-1, "Reference"), ADDITIONAL_INFO(-2, "Additional Information"), VARIATION_INFO(-3, "Variation Information"), LOCALIZATION_INFO(-4, "Localization Information"), EXAMPLE_INFO(-5, "Example Information"), TEST_INFO(-6, "Test Information");

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LinkType.class);

	private int id;
	private String name;

	private final static String CATEGORY = "Link Type";

	private LinkType() {
	}

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		for (LinkType linkType : LinkType.values()) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					linkType.getName());
			linkType.id = utlLookup.getLookupValueId();
		}
		initialized = true;
		LOGGER.debug("LinkType initialized "); 
	}

	private LinkType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static LinkType getValueOf(String linkTypeString){
		initialize();
		return valueOf(linkTypeString);
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

	public static LinkType getLinkType(int ID) {
		if (!initialized) {
			initialize();
		}
		for (LinkType t : LinkType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("LinkType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "LinkType [" + getName() + "] ID [" + getID() + "]";
	}
}
