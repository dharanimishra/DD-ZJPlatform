package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.EnumUtil;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum ComponentContentType {

	// TODO: retrieve the ids from the static data service
	PREVIEW_CONTENT(), PROMOTIONAL_CONTENT(), PRACTICE_CONTENT(), COURSE_CONTENT();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentContentType.class);


	private int id;

	private String name;
	
	private static boolean initialized;

	private final static String CATEGORY = "corLearningComponentContent_Content Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	private static synchronized void initialize(){
        if (initialized) { return; }
		ComponentContentType[] componentContentTypes = ComponentContentType.values();
		for (ComponentContentType componentContentType : componentContentTypes) {
			//System.out.println("contentType " + contentType.name());
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY, componentContentType.name());
			componentContentType.id=utlLookup.getLookupValueId();
			componentContentType.name=utlLookup.getLookupValue();
		}
        initialized = true;
		LOGGER.debug("Content Type initialized " + componentContentTypes);
	}

	private ComponentContentType() {

	}

	private void setID(int id) {
		this.id = id;

	}

	private ComponentContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ComponentContentType getComponentContentType(int ID) {
        if (!initialized) { initialize(); }
        for (ComponentContentType compContentType : ComponentContentType
				.values()) {
			if (compContentType.getID() == ID) {
				return compContentType;
			}
		}

		throw new NoSuchElementException("Component Content Type ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Component  Content Type [" + getName() + "] ID [" + getID()
				+ "]";
	}
}
