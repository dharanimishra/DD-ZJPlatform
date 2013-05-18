package com.ziksana.domain.course;

import java.util.NoSuchElementException;

import com.ziksana.util.UTLLookUpUtil;


public enum ContentType {

		// TODO: retrieve the ids from the static data service
	VIDEO(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type","VIDEO"),"Video"), 
	ENHANCED_VIDEO(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "ENHANCED_VIDEO"), "ENHANCED_VIDEO"), 
	AUDIO(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "AUDIO"), "Audio"), 
	//TEXTUAL(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "TEXTUAL"), "TEXTUAL"), 
	PDF(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "PDF"), "PDF"), 
	DOC(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "DOC"), "DOC"), 
	PPT(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "PPT"), "PPT"), 
	//EXCEL(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "EXCEL"), "EXCEL"), 
	IMAGE(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "IMAGE"), "IMAGE") 
	//LINK(UTLLookUpUtil.getUTLLookUpValueId("corLearningContent_Content Type", "LINK"), "LINK")
	;

	

	private final int id;
	
	private final String name;

	private ContentType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ContentType getContentType(int ID) {
		for (ContentType comntentType : ContentType.values()) {
			if (comntentType.getID() == ID) {
				return comntentType;
			}
		}

		throw new NoSuchElementException("Content Type ID [" + ID + "] not found");
	}

	public String toString() {
		return "Content Type [" + getName() + "] ID [" + getID() + "]";
	}
}
