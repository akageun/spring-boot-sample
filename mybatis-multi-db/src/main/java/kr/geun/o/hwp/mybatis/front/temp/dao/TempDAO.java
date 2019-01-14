package kr.geun.o.hwp.mybatis.front.temp.dao;

import kr.geun.o.hwp.mybatis.config.annotation.SubDB;
import kr.geun.o.hwp.mybatis.front.temp.vo.ProductLogVO;

import java.util.List;

/**
 * 서브 DB 테스트 Interface
 *
 * @author akageun
 */
@SubDB
public interface TempDAO {

	String selectNow();

	List<ProductLogVO> selectProductLog();
}
