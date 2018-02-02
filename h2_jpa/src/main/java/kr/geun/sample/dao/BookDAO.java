package kr.geun.sample.dao;

import kr.geun.sample.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 *
 * @author hyeonggeunkim
 */
public interface BookDAO extends CrudRepository<BookEntity, Long> {
}
