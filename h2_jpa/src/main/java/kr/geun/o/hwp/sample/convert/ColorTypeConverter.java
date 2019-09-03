package kr.geun.o.hwp.sample.convert;

import kr.geun.o.hwp.sample.type.ColorType;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ColorTypeConverter
 *
 * @author akageun
 * @since 2019-09-04
 */
@Slf4j
@Converter
public class ColorTypeConverter implements AttributeConverter<ColorType, String> {
    @Override
    public String convertToDatabaseColumn(ColorType attribute) {
        return attribute.getRgb();
    }

    @Override
    public ColorType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            return ColorType.fromCode(dbData);
        } catch (IllegalArgumentException e) {
            log.error("failure to convert cause unexpected code [{}]", dbData, e);
            throw e;
        }
    }
}
