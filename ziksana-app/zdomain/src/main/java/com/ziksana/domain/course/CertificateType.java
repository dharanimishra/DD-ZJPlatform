package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CertificateType {
	
	// TODO: retrieve the ids from the static data service
	MASTER 				(1,"Masters"), 
	BACHELORS 			(2,"Bachelors"),
	EXECUTIVE 			(3,"Executive"), 
	DIPLOMA 			(4,"Diploma"),
	CERTIFICATE 		(5,"Certificate"),
	DOCTORATE 			(6,"Doctorate"),
	UNDERGRADUATE 		(7,"Undergraduate"),
	NONE 				(8,"None");

	private final int id;
	
	private final String name;

	
private final static String category ="Course Status";
	
	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();
	
	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		System.out.println("Getting static values :category :mapUtil :"
				+ mapUtil.size());
	}

	private CertificateType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CertificateType getCertificateType(int ID) throws NoSuchMethodException  {
		for (CertificateType certType : CertificateType.values()) {
			if (certType.getID() == ID) {
				return certType;
			}
		}

		throw new NoSuchMethodException("CertificateType ID [" + ID + "] not found");
	}

	public String toString() {
		return "Certificate Type [" + getName() + "] ID [" + getID() + "]";
	}

}

