package kr.geun.o.hwp.mybatis;

import kr.geun.o.hwp.mybatis.front.sample.dao.SampleDAO;
import kr.geun.o.hwp.mybatis.front.sample.vo.ProductVO;
import kr.geun.o.hwp.mybatis.front.temp.dao.TempDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * 쿼리실행 테스트
 *
 * @author akageun
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisSettingTest {
	private static final Logger LOG = LoggerFactory.getLogger(MybatisSettingTest.class);

	@Autowired
	private SampleDAO sampleDAO;

	@Autowired
	private TempDAO tempDAO;

	@Test
	public void 커넥션_확인() {
		String mainSelect = sampleDAO.selectNow();
		String subSelect = tempDAO.selectNow();

		LOG.info("mainDB : {}", mainSelect);
		LOG.info("subDB : {}", subSelect);

		assertNotNull(mainSelect);
		assertNotNull(subSelect);

	}

	@Test
	public void 쿼리실행해보기() {
		LOG.info("tt : {}", sampleDAO.selectProduct(ProductVO.builder().id(1L).build()));
		LOG.info("aa : {}", tempDAO.selectProductLog());
	}
}
