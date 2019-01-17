package kr.geun.o.hwp.redis.cache;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * Embedded Redis Configration
 *
 * @author akageun
 */
@Configuration
public class EmbeddedRedisConfiguration implements InitializingBean, DisposableBean {

	@Value("${spring.redis.port}")
	private int redisPort;

	private RedisServer redisServer;

	/**
	 * Redis Stop
	 *
	 */
	@Override
	public void destroy() {
		if (redisServer != null) {
			redisServer.stop(); //Redis Stop
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		redisServer = RedisServer.builder()
			.port(redisPort)
			.setting("maxmemory 128M") //maxheap 128M
			.build();
		redisServer.start(); //Redis Start
	}
}
