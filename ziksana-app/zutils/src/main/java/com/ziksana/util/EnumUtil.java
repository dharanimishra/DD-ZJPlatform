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
		System.out.println("getMapUtil :");
		mapUtil = new HashMap<String, Integer>();
		System.out.println("getMapUtil 2:"+mapUtil);
		mapUtil = getEnumData(category);
		System.out.println("getMapUtil 3:"+mapUtil);
		return mapUtil;
	}

	public void setMapUtil(Map<String, Integer> mapUtil) {
		this.mapUtil = mapUtil;
	}

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
