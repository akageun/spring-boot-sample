package kr.geun.o.hwp.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;

@EnableCaching
@SpringBootApplication
public class RedisCacheApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RedisCacheApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void run(String... strings) throws Exception {
		userRepository.save(new Book("Book no 1", 1));
		userRepository.save(new Book("Book no 2", 2));
		userRepository.save(new Book("Book no 3", 3));

		LOG.info("Done saving books.");

		redisTemplate.opsForList().leftPush("test-key", "안녕하세요 1");
		redisTemplate.opsForList().leftPush("test-key", "안녕하세요 2");
		redisTemplate.opsForList().leftPush("test-key", "안녕하세요 3");
		redisTemplate.opsForList().leftPush("test-key", "안녕하세요 4");

		LOG.info("t : {} ", redisTemplate.opsForList().rightPop("test-key"));
		LOG.info("t : {} ", redisTemplate.opsForList().rightPop("test-key"));
		LOG.info("t : {} ", redisTemplate.opsForList().rightPop("test-key"));
		LOG.info("t : {} ", redisTemplate.opsForList().rightPop("test-key"));
		LOG.info("t : {} ", redisTemplate.opsForList().rightPop("test-key")); //null
	}
}
