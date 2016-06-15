package com.bs.constant;

public enum GeneralEnum {
	DEFAULT_SHELF_NAME("YOUR SHELF");
	
	private String value;

	private GeneralEnum(String enumValue) {
		this.value = enumValue;
	}
	
	public String getValue() {
		return value;
	}	
}
