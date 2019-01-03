package kr.geun.o.hwp.app;

import kr.geun.o.hwp.app.service.RunCheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyAopApplicationTests {

	@Autowired
	private RunCheckService runCheckService;

	@Test
	public void annotationCheck() throws InterruptedException {
		runCheckService.check();
	}

}

