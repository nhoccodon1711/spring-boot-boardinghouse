package com.chothuenhatro.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PriceEnum {

	P1("Dưới 1 triệu"),
    P2("1 triệu đến 2 triệu"),
    P3("2 triệu đến 3 triệu"),
    P5("3 triệu đến 5 triệu"),
    P7("5 triệu đến 7 triệu"),
    P10("7 triệu đến 10 triệu"),
    POTHERS("10 triệu trở lên");

    private final String priceValue;

    PriceEnum(String priceValue) {
        this.priceValue = priceValue;
    }

	public String getPriceValue() {
		return priceValue;
	}

    public static String getPriceName(String code) {

        Optional<PriceEnum> convertedCode = Arrays.stream(PriceEnum.values()).
                                                            filter(e -> e.name().equals(code)).
                                                            findFirst();

        return convertedCode.isPresent() ? convertedCode.get().getPriceValue() : null;
    }
}
