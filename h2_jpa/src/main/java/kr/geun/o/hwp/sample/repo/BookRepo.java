package kr.geun.o.hwp.sample.repo;

import kr.geun.o.hwp.sample.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Long> {
}
