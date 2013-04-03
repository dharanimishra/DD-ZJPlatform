package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.ziksana.util.EnumUtil;


/**
 * @author Ratnesh Kumar
 */

public enum WorkflowType {

	// TODO: retrieve the ids from the static data service
	CREATION      		(1, "Creation"),
	REVIEW      		(2, "Review"),
	ADMINISTRATION   	(3, "Administration"),
	PUBLISHING 			(4, "Publishing");
	

	private final int id;
	
	private final String name;
	
	private final static String category ="WorkFlowType";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category :mapUtil :"
				+ mapUtil.size());
	}


	private WorkflowType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static WorkflowType getWorkflowType(int ID) {
		for (WorkflowType wfType : WorkflowType.values()) {
			if (wfType.getID() == ID) {
				return wfType;
			}
		}

		throw new NoSuchElementException("Workflow Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Workflow Type [" + getName() + "] ID [" + getID() + "]";
	}
}
