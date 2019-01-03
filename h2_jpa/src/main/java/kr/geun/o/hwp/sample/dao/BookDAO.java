package kr.geun.o.hwp.sample.dao;

import kr.geun.o.hwp.sample.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author akageun
 */
public interface BookDAO extends JpaRepository<BookEntity, Long> {
}
