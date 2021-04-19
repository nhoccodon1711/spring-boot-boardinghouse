package com.chothuenhatro.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum DistrictsEnum {
	
	D1("Hoàn Kiếm"),
    D3("Đống Đa"),
    D4("Ba Đình"),
    D5("Hai Bà Trưng"),
    D6("Hoàng Mai"),
    D7(" Thanh Xuân"),
    D8("Long Biên"),
    D10("Nam Từ Liêm"),
    D11("Bắc Từ Liêm"),
    D12("Tây Hồ"),
    TP_TD("Cầu Giấy"),
    D_BT("Hà Đông"),
    D_GV("Thị xã Sơn Tây"),
	D_TB("Huyện Ba Vì"),
    D_PN("Huyện Gia Lâm"),
    D_TP("Huyện Mê Linh"),
    D_BTAN("Huyện Thường Tín");


    private final String districtValue;

    DistrictsEnum(String districtValue) {
        this.districtValue = districtValue;
    }

	public String getDistrictValue() {
		return districtValue;
	}

    public static String getDistrictName(String code) {

        Optional<DistrictsEnum> convertedCode = Arrays.stream(DistrictsEnum.values()).filter(e -> e.name().equals(code)).findFirst();

        return convertedCode.isPresent() ? convertedCode.get().getDistrictValue() : null;
    }
}
