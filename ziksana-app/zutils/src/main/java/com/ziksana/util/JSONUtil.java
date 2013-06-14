package com.ziksana.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class provides utility methods to convert java object to json string and vice versa
 * 
 * @author Arvind
 *
 */
public class JSONUtil {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(JSONUtil.class);
	
	/**
	 * Converts java object to json string
	 * @param object
	 * @return
	 */
	public static String objectToJSONString(Object object){
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
			//mapper.readValue(content, valueType)
		} catch (JsonGenerationException e) {
			// TODO throw zikasana specific exception
			e.printStackTrace();
			LOGGER.error(e.getMessage(),e);
		} catch (JsonMappingException e) {
			// TODO throw zikasana specific exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO throw zikasana specific exception
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	
}

