/**
 * 
 */
package com.ziksana.service.data.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.common.NameValue;
import com.ziksana.persistence.data.StaticDataMapper;
import com.ziksana.service.data.DataService;

/**
 * @author prabu
 *
 */
public class DataServiceImpl implements DataService {

	
	@Autowired
	StaticDataMapper staticDataMapper;
	
	
	@Override
	public Map<String, Integer> fetchData(String column) {
		// TODO Auto-generated method stub
		List<NameValue> list = staticDataMapper.fetchData(column);
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (NameValue nameValue : list) 
			map.put(nameValue.getName(),nameValue.getValue());
		
		
		return map;
		
	}

}
