package com.ziksana.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.service.data.EnumDataService;

public class EnumUtil {

	@Autowired
	EnumDataService enumDataService;

	// private Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	public Map<String, Integer> getEnumData(String category) {
		System.out.println("geography :");
		Map<String, Integer> mapUtil = new HashMap<String, Integer>();
		try {
			mapUtil = enumDataService.fetchData(category);

		} catch (Exception e) {
			System.out.println("geography :Exception :" + e);
		}
		System.out.println("geography :mapUtil :" + mapUtil);
		return mapUtil;
	}

}
