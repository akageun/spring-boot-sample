package kr.geun.o.hwp.app.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * aop 설정
 *
 * @author akageun
 */
@Aspect
@Component
public class ExecTimeAspect {
	private static final Logger LOG = LoggerFactory.getLogger(ExecTimeAspect.class);

	/**
	 * 커스텀 어노테이션 관련 소스
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(kr.geun.o.hwp.app.annotations.ExecTimeLog)")
	public Object execTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
		final long start = System.currentTimeMillis();
		try {
			return joinPoint.proceed(); //꼭 호출해야함.

		} finally {
			final long executionTime = System.currentTimeMillis() - start;
			LOG.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		}
	}
}
