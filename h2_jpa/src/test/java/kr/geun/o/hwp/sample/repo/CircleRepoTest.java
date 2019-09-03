package kr.geun.o.hwp.sample.repo;

import kr.geun.o.hwp.sample.entity.CircleEntity;
import kr.geun.o.hwp.sample.type.ColorType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CircleRepoTest {

    @Autowired
    private CircleRepo circleRepo;

    @Test
    public void initTest() {
        circleRepo.save(
            CircleEntity.builder()
                .colorType(ColorType.GREEN)
                .size(100)
                .build()
        );

        for (CircleEntity circleEntity : circleRepo.findAll()) {
            log.info("test : {}, {}, {}", circleEntity.getId(), circleEntity.getColorType(), circleEntity.getSize());
        }
    }
}
