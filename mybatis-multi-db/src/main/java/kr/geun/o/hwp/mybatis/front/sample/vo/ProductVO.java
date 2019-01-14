package kr.geun.o.hwp.mybatis.front.sample.vo;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * VO
 *
 * @author akageun
 */
@Data
@Builder
public class ProductVO {
	private Long id;
	private String title;
	private Timestamp time;
}
