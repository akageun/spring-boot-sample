package kr.geun.o.hwp.hellomongo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@DataMongoTest
public class HellomongoApplicationTests {

    @Autowired
    private TestCollectionsRepo testCollectionsRepo;

    @Test
    public void contextLoads() {
        testCollectionsRepo.save(TestCollections.builder()
            .email("asdf@ghjk.com")
            .username("asdf")
            .build());

        for (TestCollections testCollections : testCollectionsRepo.findAll()) {
            log.info("test : {}", testCollections);
        }
    }

}
