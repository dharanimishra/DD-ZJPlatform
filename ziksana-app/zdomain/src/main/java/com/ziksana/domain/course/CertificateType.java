package com.ziksana.domain.course;

import java.util.HashMap;
import java.util.Map;

import com.ziksana.util.EnumUtil;

/**
 * @author Ratnesh Kumar
 */

public enum CertificateType {

	// TODO: retrieve the ids from the static data service
	MASTER(), BACHELORS(), EXECUTIVE(), DIPLOMA(), CERTIFICATE(), DOCTORATE(), UNDERGRADUATE(), NONE();

	private int id;

	private String name;

	private final static String category = "Certificate Type";

	private static Map<String, Integer> mapUtil = new HashMap<String, Integer>();

	static {
		EnumUtil enumUtil = new EnumUtil();
		mapUtil = enumUtil.getEnumData(category);
		MASTER.setID(mapUtil.get("Masters").intValue());
		BACHELORS.setID(mapUtil.get("Bachelors").intValue());
		EXECUTIVE.setID(mapUtil.get("Executive").intValue());
		DIPLOMA.setID(mapUtil.get("Diploma").intValue());
		CERTIFICATE.setID(mapUtil.get("Certificate").intValue());
		DOCTORATE.setID(mapUtil.get("Doctorate").intValue());
		UNDERGRADUATE.setID(mapUtil.get("Undergraduate").intValue());
		NONE.setID(mapUtil.get("None").intValue());
	}

	private CertificateType() {

	}

	private CertificateType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private void setID(int id) {
		this.id = id;

	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static CertificateType getCertificateType(int ID)
			throws NoSuchMethodException {
		for (CertificateType certType : CertificateType.values()) {
			if (certType.getID() == ID) {
				return certType;
			}
		}

		throw new NoSuchMethodException("CertificateType ID [" + ID
				+ "] not found");
	}

	public String toString() {
		return "Certificate Type [" + getName() + "] ID [" + getID() + "]";
	}

}
