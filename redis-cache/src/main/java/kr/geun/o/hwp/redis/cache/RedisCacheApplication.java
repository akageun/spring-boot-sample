package kr.geun.o.hwp.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCacheApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RedisCacheApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		userRepository.save(new Book("Book no 1", 1));
		userRepository.save(new Book("Book no 2", 2));
		userRepository.save(new Book("Book no 3", 3));

		LOG.info("Done saving books.");
	}
}
