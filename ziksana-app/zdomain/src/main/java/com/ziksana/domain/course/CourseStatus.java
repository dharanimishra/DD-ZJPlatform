package com.ziksana.domain.course;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CourseStatus {

	DRAFT(), UNDER_REVIEW(), READY_FOR_RELEASE(), ACTIVE(), HOLD(), ARCHIVED();

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseStatus.class);

	private int id;
	private String name;
	private static boolean initialized = false;

	private final static String CATEGORY = "Course Status";

	private static synchronized void initialize() {
		if (initialized) {
			return;
		}
		CourseStatus[] courseStatuses = CourseStatus.values();
		for (CourseStatus courseStatus : courseStatuses) {
			UTLLookup utlLookup = UTLLookUpUtil.getUTLLookUp(CATEGORY,
					courseStatus.name());
			courseStatus.id = utlLookup.getLookupValueId();
			courseStatus.name = utlLookup.getLookupValue();
		}
		initialized = true;
		LOGGER.debug("Content Type initialized " + courseStatuses);
	}

	private CourseStatus() {

	}

	private CourseStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setID(Integer id) {
		this.id = id;

	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CourseStatus getCourseStatus(int ID) {
		if (!initialized) {
			initialize();
		}
		for (CourseStatus t : CourseStatus.values()) {
			if (t.getID() == ID) {
				return t;
			}
		}

		throw new NoSuchElementException("CourseStatus ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Course Status [" + getName() + "] ID [" + getID() + "]";
	}
}