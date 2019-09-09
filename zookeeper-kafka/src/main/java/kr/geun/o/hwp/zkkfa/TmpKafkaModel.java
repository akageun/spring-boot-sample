package kr.geun.o.hwp.zkkfa;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TmpKakfaModel
 *
 * @author akageun
 * @since 2019-09-09
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TmpKafkaModel {
    private String uuid;
    private Date now;

    @Builder
    public TmpKafkaModel(String uuid, Date now) {
        this.uuid = uuid;
        this.now = now;
    }
}
