package com.ziksana.util;

import java.util.Map;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		try {
			EnumUtil enumUtil = new EnumUtil();
			enumUtil.setCategory("Geography");

			Map<String, Integer> mapUtil = enumUtil.getMapUtil();
			enumUtil.setMapUtil(mapUtil);

		} catch (Exception e) {

		}
	}
}
