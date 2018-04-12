package kr.geun.o.hwp.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author akageun
 */
@RestController
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Cacheable(value = "users", key = "#userId")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Book getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID {}.", userId);
		return userRepository.findOne(Long.valueOf(userId));
	}

	@CachePut(value = "users", key = "#book.id")
	@PutMapping("/update")
	public Book updatePersonByID(@RequestBody Book book) {
		userRepository.save(book);
		return book;
	}

	@CacheEvict(value = "users", allEntries = true)
	@DeleteMapping("/{userId}")
	public void deleteUserByID(@PathVariable Long userId) {
		LOG.info("deleting person with id {}", userId);
		userRepository.delete(userId);
	}
}
