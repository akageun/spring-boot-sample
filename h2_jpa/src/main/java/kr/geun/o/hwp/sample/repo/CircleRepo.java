package kr.geun.o.hwp.sample.repo;

import kr.geun.o.hwp.sample.entity.CircleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircleRepo extends JpaRepository<CircleEntity, Long> {
}
