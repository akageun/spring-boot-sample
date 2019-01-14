package kr.geun.o.hwp.mybatis.front.sample.dao;

import kr.geun.o.hwp.mybatis.config.annotation.MainDB;
import kr.geun.o.hwp.mybatis.front.sample.vo.ProductVO;

import java.util.List;

/**
 *
 *
 * @author akageun
 */
@MainDB
public interface SampleDAO {

	String selectNow();

	List<ProductVO> selectProduct(ProductVO param);
}
