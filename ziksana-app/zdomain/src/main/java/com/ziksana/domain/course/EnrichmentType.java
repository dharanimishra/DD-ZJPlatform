/**
 * 
 */
package com.ziksana.domain.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Arvind Rathod
 */

public enum EnrichmentType {

	NOTE(), REFERENCE(), HOTSPOT(), BOOKMARK(), TOC();

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnrichmentType.class);

	private int id;

	private String name;

	private final static String CATEGORY = "'Learning Content Enrichment Types";

	private EnrichmentType() {
	}

	private static boolean initialized = false;

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		EnrichmentType[] enrichmentTypes = EnrichmentType.values();
		for (EnrichmentType EnrichmentType : enrichmentTypes) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					EnrichmentType.name());
			EnrichmentType.id = utlLookup.getLookupValueId();
			EnrichmentType.name = utlLookup.getLookupValue();
		}
		initialized = true;
		LOGGER.debug("EnrichmentType initialized " + enrichmentTypes);
	}

	private EnrichmentType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static EnrichmentType getValueOf(String enrichmentTypeString){
		initialize();
		return valueOf(enrichmentTypeString);
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

	public static EnrichmentType getEnrichmentType(int ID) {
		if (!initialized) {
			initialize();
		}
		for (EnrichmentType t : EnrichmentType.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new IndexOutOfBoundsException("EnrichmentType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "EnrichmentType [" + getName() + "] ID [" + getID() + "]";
	}
}
