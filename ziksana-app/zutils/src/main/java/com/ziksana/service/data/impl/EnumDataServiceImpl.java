package com.ziksana.service.data.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.utils.NameValue;
import com.ziksana.persistence.data.EnumStaticDataMapper;
import com.ziksana.service.data.EnumDataService;

/**
 * @author Ratnesh Kumar
 * 
 */

@Service
public class EnumDataServiceImpl implements EnumDataService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EnumDataServiceImpl.class);

	@Autowired
	EnumStaticDataMapper enumStaticDataMapper;

	public Map<String, Integer> fetchData(String category) {
		LOGGER.info("Entering Class :" + getClass() + "Method :");
		List<NameValue> list = enumStaticDataMapper.fetchData(category);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (NameValue nameValue : list) {
			map.put(nameValue.getName(), nameValue.getValue());
		}
		LOGGER.info("Class :" + getClass() + "Method :list :" + list);
		LOGGER.info("Class :" + getClass() + "Method :map :" + map);

		LOGGER.info("Entering Class :" + getClass() + "Method :");

		return map;

	}
}
