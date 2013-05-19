package com.ziksana.domain.course;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.util.UTLLookUpUtil;


public enum ContentType  {

/*		// TODO: retrieve the ids from the static data service
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
*/
	
	VIDEO(),ENHANCED_VIDEO(),AUDIO(),TEXTUAL(),PDF(),DOC(),PPT(),EXCEL(),IMAGE(),LINK();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContentType.class);
	
	private int id;
	
	private String name;

	private final static String CATEGORY = "corLearningContent_Content Type";
	
	
	private ContentType(){
	}

	private static boolean initialized = false;
    
    
	//Use following intitialize method as it is setting the values dynamically
	@Deprecated
	private static synchronized void initialize2() {
        if (initialized) { return; }
        
        //List<UTLLookup> utlLookUpList = UTLLookUpUtil.getUTLLookUpList(CATEGORY);

        VIDEO.setID(UTLLookUpUtil.getUTLLookUp(CATEGORY, VIDEO.name).getLookupValueId());

        initialized = true;
    }
	
	private static synchronized void initialize(){
        if (initialized) { return; }
		ContentType[] contentTypes = ContentType.values();
		Map<String, Integer> utlLookUpMap = UTLLookUpUtil.getUTLLookUpUtil().getUTLLookUpMapForCategory(CATEGORY);
		for (ContentType contentType : contentTypes) {
			contentType.id=utlLookUpMap.get(contentType.name());
		}
        initialized = true;
		LOGGER.debug("Content Type initialized " + contentTypes);
	}
	
	private ContentType(int id, String name) {
		this.id = id;
		this.name = name;
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
	 public static ContentType getContentType(int ID) {
         if (!initialized) { initialize(); }
         	for (ContentType t : ContentType.values()) {
         		if (t.getID() == ID) {
         			return t;
         		}
         	}

         throw new IndexOutOfBoundsException("ContentType ID [" + ID + "] not found");
	 }

	public static ContentType getContentType1(int ID) {
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
