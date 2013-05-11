package com.ziksana.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.service.data.EnumDataService;

public class EnumUtil {

	@Autowired
	EnumDataService enumDataService;

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private Map<String, Integer> mapUtil = null;

	public Map<String, Integer> getMapUtil() {

		mapUtil = new HashMap<String, Integer>();

		mapUtil = getEnumData(category);

		return mapUtil;
	}

	public void setMapUtil(Map<String, Integer> mapUtil) {
		this.mapUtil = mapUtil;
	}

	public Map<String, Integer> getEnumData(String category) {

		Map<String, Integer> mapUtil = new HashMap<String, Integer>();
		try {
			mapUtil = enumDataService.fetchData(category);

		} catch (Exception e) {

		}

		return mapUtil;
	}

}
