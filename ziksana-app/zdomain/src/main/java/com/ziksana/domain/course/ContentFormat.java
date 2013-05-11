package com.ziksana.domain.course;

import java.util.NoSuchElementException;


/**
 * @author Ratnesh Kumar
 */

public enum ContentFormat {

	// TODO: retrieve the ids from the static data service
	PPT    			(1, "Powerpoint"),
	WORD  			(2, "MS Word"),
	SPREADSHEET   	(3, "Excel Spreadsheet"),
	JPG         	(4, "JPG"),
	PNG         	(5, "PNG"),
	PDF				(6,"PDF"),
	ROYALTY			(7,"Royalty"),
	ROYALTY_FREE	(8,"Royalty free");

	private final int id;
	
	private final String name;

	private ContentFormat(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentFormat getContentFormat(int ID){
		for (ContentFormat cotentFormat : ContentFormat.values()) {
			if (cotentFormat.getID() == ID) {
				return cotentFormat;
			}
		}

		throw new NoSuchElementException("Content Format ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Format [" + getName() + "] ID [" + getID() + "]";
	}
}
