package com.ziksana.domain.course;

import java.util.NoSuchElementException;


public enum ContentFormat {

	// TODO: retrieve the ids from the static data service
	MSWORD97    	(1, "MSWORD97"),
	MSWORD2010  	(2, "MSWORD2010"),
	MSPPT2003   	(3, "MSPPT2003"),
	MSPPT2007   	(4, "MSPPT2007"),
	MSPPT2010   	(5, "MSPPT2010"),
	MP4H264MP3  	(6, "MP4H264MP3"),
	JPG         	(7, "JPG"),
	PNG         	(8, "PNG"),
	PDF				(9,"PDF"),
	ROYALTY			(10,"Royalty"),
	ROYALTY_FREE	(11,"Royalty free"),
	EXCEL			(12,"Spread sheet");
	

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
