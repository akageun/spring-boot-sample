package kr.geun.o.hwp.redis.cache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author akageun
 */
@Repository
public interface UserRepository extends JpaRepository<Book, Long> {
}
