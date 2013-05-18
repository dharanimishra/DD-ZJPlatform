package com.ziksana.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		Man m = new Man();
		Man m1 = new Man();
		Man m2 = new Man();
		
		m.setAge(11);
		m1.setAge(22);
		m2.setAge(33);
		
		m.setName("one");
		m1.setName("two");
		m2.setName("three");
		
		list.add(m);
		list.add(m1);
		list.add(m2);
		
		
		System.out.println(JSONUtil.objectToJSONString(list));
	}
}

class Man{
	
	int age;
	String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

