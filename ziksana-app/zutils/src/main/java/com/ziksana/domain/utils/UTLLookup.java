package com.ziksana.domain.utils;

public class UTLLookup {

	private String cName;

	private Integer lookupValueId;

	private String lookupValue;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getLookupValueId() {
		return lookupValueId;
	}

	public void setLookupValueId(Integer lookupValueId) {
		this.lookupValueId = lookupValueId;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	@Override
	public String toString() {
		return "UTLLookup [cName=" + cName + ", lookupValueId=" + lookupValueId
				+ ", lookupValue=" + lookupValue + "]";
	}

}
