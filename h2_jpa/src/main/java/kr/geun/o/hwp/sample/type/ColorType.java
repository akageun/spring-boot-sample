package kr.geun.o.hwp.sample.type;

import lombok.Getter;

/**
 * ColorType
 *
 * @author akageun
 * @since 2019-09-03
 */
@Getter
public enum ColorType {
    GREY("142, 142, 147"),
    RED("255, 59, 48"),
    GREEN("76, 217, 100"),
    PURPLE("88, 86, 214"),
    LIGHTBLUE("52, 170, 220");

    private String rgb;

    ColorType(String rgb) {
        this.rgb = rgb;
    }

    public static ColorType fromCode(String dbData) {
        for (ColorType value : ColorType.values()) {
            if (value.getRgb().equals(dbData)) {
                return value;
            }
        }

        return null;
    }

}
