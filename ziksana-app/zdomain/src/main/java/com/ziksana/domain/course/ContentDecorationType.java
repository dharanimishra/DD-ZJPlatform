/**
 * 
 */
package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Arvind
 * 
 * This enum has the values of content decoration types while doing the enhancements. 
 *
 */
public enum ContentDecorationType {
	
	ANNOTATED(), RECORDED(), ENRICHED();
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ContentDecorationType.class);

	private int id;

	private String name;

	private final static String CATEGORY = "Learning Content Decoration Type";

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		try {
			ContentDecorationType[] contentDecorationTypesTypeArray = ContentDecorationType.values();
			for (ContentDecorationType contentDecorationTypeType : contentDecorationTypesTypeArray) {
				UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
						contentDecorationTypeType.name());
				contentDecorationTypeType.id = utlLookup.getLookupValueId();
				contentDecorationTypeType.name = utlLookup.getLookupValue();
			}
			initialized = true;
			LOGGER.debug("Content Type initialized " + contentDecorationTypesTypeArray);
		} catch (Exception e) {
			initialized = false;
			LOGGER.error("Content Decoration Type initialization failed ");
			//TODO remove this once tested
			//System.exit(0);
		}
	}

	public static ContentDecorationType getValueOf(String contentFormatString){
		initialize();
		return valueOf(contentFormatString);
	}
	
	/**
	 * Returns the {@link ContentDecorationType} for the provided id.
	 * If the object is not initialized then it first initializes it by calling,
	 * {@link UTLLookUpUtil}.getUTLLookUp(CATEGORY,	contentDecorationTypeType.name())
	 *  
	 * @param ID
	 * @return  {@link ContentDecorationType}
	 */
	public static ContentDecorationType getContentDecorationType(int ID) {
		if (!initialized) {
			initialize();
		}
		for (ContentDecorationType t : ContentDecorationType.values()) {
			if (t.getId() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("ContentType ID [" + ID
				+ "] not found");
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCategory() {
		return CATEGORY;
	}

}
