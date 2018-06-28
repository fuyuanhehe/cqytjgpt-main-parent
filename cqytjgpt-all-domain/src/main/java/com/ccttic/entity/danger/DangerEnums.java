package com.ccttic.entity.danger;

import org.apache.commons.lang3.StringUtils;

import com.ccttic.entity.enums.StringEnumInterface;

public enum DangerEnums implements StringEnumInterface {
	UNEXECUTED("-1", "未整改"), EXECUTING("1", "整改中"), NORMAL("0", "正常");

	private final String value;
	private final String text;

	private DangerEnums(String value, String text) {
		this.value = value;
		this.text = text;
	}

	@Override
	public StringEnumInterface toEnum(String input) {
		if (StringUtils.isBlank(StringUtils.trim(input))) {
			return null;
		}

		if ("-1".equals(input) || "未整改".equals(input)) {
			return UNEXECUTED;
		} else if ("1".equals(input) || "整改中".equals(input)) {
			return EXECUTING;
		} else if ("0".equals(input) || "正常".equals(input)) {
			return NORMAL;
		} else {
			return null;
		}
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getText() {
		return text;
	}

}
