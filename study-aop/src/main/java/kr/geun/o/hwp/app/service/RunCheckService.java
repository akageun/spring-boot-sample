package kr.geun.o.hwp.app.service;

import kr.geun.o.hwp.app.annotations.ExecTimeLog;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author akageun
 */
@Service
public class RunCheckService {

	@ExecTimeLog
	public void check() throws InterruptedException {
		Thread.sleep(1 * 1000);
	}
}
