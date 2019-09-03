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
    GREY(142, 142, 147),
    RED(255, 59, 48),
    GREEN(76, 217, 100),
    PURPLE(88, 86, 214),
    LIGHTBLUE(52, 170, 220);

    private int red;
    private int green;
    private int blue;

    ColorType(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
