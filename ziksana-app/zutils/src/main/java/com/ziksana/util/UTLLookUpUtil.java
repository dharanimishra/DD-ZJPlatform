package com.ziksana.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.persistence.data.UTLLookupMapper;
import com.ziksana.service.data.UTLLookupService;

public class UTLLookUpUtil {
	
	@Autowired
	UTLLookupService  utlLookupService;
	
	private static Map<String, List<UTLLookup>> utlLookupMap;
	
	public void init(){
		utlLookupMap = utlLookupService.getUTLLookupMap();
	}
	
	public static UTLLookup getUTLLookUp(String key, String lookUpValue){
		
		
		List<UTLLookup> list = utlLookupMap.get(key);
		UTLLookup utlLookupToReturn = null;
		for (UTLLookup utlLookup : list) {
			if(lookUpValue.equalsIgnoreCase(utlLookup.getLookupValue())){
				utlLookupToReturn =  utlLookup;
				break;
			}
		}
		return utlLookupToReturn;
	}

	public static List<UTLLookup> getUTLLookUpList(String key){
		
		return utlLookupMap.get(key);
	}
	public static Integer getUTLLookUpValueId(String key, String lookUpValue){
		Integer test = null;
		try {
			test = getUTLLookUp(key, lookUpValue).getLookupValueId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("" + lookUpValue);
			e.printStackTrace();
		}
		return test;
	}
}
