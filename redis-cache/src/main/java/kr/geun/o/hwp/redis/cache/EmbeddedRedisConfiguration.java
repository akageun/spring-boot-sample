package kr.geun.o.hwp.redis.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * Embedded Redis Configration
 *
 * @author akageun
 */
@Component
public class EmbeddedRedisConfiguration {

	@Value("${spring.redis.port}")
	private int redisPort;

	private RedisServer redisServer;

	/**
	 * Redis Start
	 *
	 * @throws IOException
	 */
	@PostConstruct
	public void init() throws IOException {
		redisServer = new RedisServer(redisPort);
		redisServer.start(); //Redis Start
	}

	/**
	 * Redis Stop
	 *
	 */
	@PreDestroy
	public void destroy() {
		redisServer.stop(); //Redis Stop
	}

}
