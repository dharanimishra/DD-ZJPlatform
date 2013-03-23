package com.ziksana.util;

import java.util.Map;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			EnumUtil enumUtil = new EnumUtil();
			enumUtil.setCategory("Geography");
			System.out.println("Category :" + enumUtil.getCategory());
			Map<String, Integer> mapUtil = enumUtil.getMapUtil();
			enumUtil.setMapUtil(mapUtil);

			System.out.println(" Map :" + enumUtil.getMapUtil());
		} catch (Exception e) {
			System.out.println(" Map Exception :" + e);
		}
	}
}
