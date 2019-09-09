package kr.geun.o.hwp.zkkfa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * HomeController
 *
 * @author akageun
 * @since 2019-09-09
 */
@Slf4j
@RestController
public class HomeController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC = "test";

    @PostMapping("/save")
    public String save() {
        kafkaTemplate.send(TOPIC, TmpKafkaModel.builder().uuid(UUID.randomUUID().toString()).now(new Date()).build());
        return "OK";
    }

    @KafkaListener(topics = TOPIC, groupId = TOPIC)
    public void log(
        @Payload TmpKafkaModel model
    ) {
        //log.info("model : {}", model);
        log.info("model : uuid: {}, now: {}", model.getUuid(), model.getNow());
    }

}
