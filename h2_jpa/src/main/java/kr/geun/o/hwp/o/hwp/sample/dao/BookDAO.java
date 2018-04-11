package kr.geun.o.hwp.o.hwp.sample.dao;

import kr.geun.o.hwp.o.hwp.sample.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 *
 * @author hyeonggeunkim
 */
public interface BookDAO extends CrudRepository<BookEntity, Long> {
}
