/**
 * 
 */
package com.ziksana.service.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.utils.UTLLookup;
import com.ziksana.persistence.data.UTLLookupMapper;
import com.ziksana.service.data.UTLLookupService;

/**
 * @author Arvind
 * 
 */
@Service
public class UTLLookupServiceImpl implements UTLLookupService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UTLLookupServiceImpl.class);

	@Autowired
	UTLLookupMapper utlLookupMapper;

	public Map<String, List<UTLLookup>> getUTLLookupMap() {
		Map<String, List<UTLLookup>> map = new HashMap<String, List<UTLLookup>>();
		List<UTLLookup> utlLookupList = utlLookupMapper.getUTLLookupList();
		for (UTLLookup utlLookup : utlLookupList) {
			if(map.containsKey(utlLookup.getcName())){
				map.get(utlLookup.getcName()).add(utlLookup);
			}
			else{
				map.put(utlLookup.getcName(), new ArrayList<UTLLookup>());
			}
		}
		
		// TODO Auto-generated method stub
		return map;
	}

	public Map<String, Integer> getUTLLookupMap(String category) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<UTLLookup> utlLookupList = utlLookupMapper.getUTLLookupList(category);
		for (UTLLookup utlLookup : utlLookupList) {
			map.put(utlLookup.getLookupValue(), utlLookup.getLookupValueId());
		}
		return map;
	}

}
