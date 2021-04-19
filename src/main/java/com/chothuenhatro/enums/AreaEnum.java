package com.chothuenhatro.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AreaEnum {

	A30("Dưới 30 m2"),
    A50("30m2 - 50m2"),
    A70("50m2 - 70m2"),
    A100("70m2 - 100m2"),
    AOTHERS("100m2 trở lên");

    private final String areaValue;

    AreaEnum(String areaValue) {
        this.areaValue = areaValue;
    }

	public String getAreaValue() {
		return areaValue;
	}

    public static String getAreaName(String code) {

        Optional<AreaEnum> convertedCode = Arrays.stream(AreaEnum.values()).
                                                            filter(e -> e.name().equals(code)).
                                                            findFirst();

        return convertedCode.isPresent() ? convertedCode.get().getAreaValue() : null;
    }
}
