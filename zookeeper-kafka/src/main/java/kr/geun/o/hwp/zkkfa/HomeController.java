package kr.geun.o.hwp.zkkfa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
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

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            sb.append(UUID.randomUUID().toString());
        }

        kafkaTemplate.send(TOPIC, TmpKafkaModel.builder().uuid(sb.toString()).now(new Date()).build());

        return "OK";
    }

    @KafkaListener(topics = {TOPIC})
    public void log(
        @Payload TmpKafkaModel model,
//        @Header(KafkaHeaders.OFFSET) Long offset,
//        @Header(KafkaHeaders.CONSUMER) KafkaConsumer<String, String> consumer,
//        @Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
//        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
//        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
//        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp,
//        @Header("X-Custom-Header") String customHeader,
        @Headers MessageHeaders messageHeaders
    ) {
        log.info("model : uuid: {}, now: {}", model.getUuid(), model.getNow());

//        log.info("- - - - - - - - - - - - - - -");
//        log.info("received message='{}'", model);
//        log.info("consumer: {}", consumer);
//        log.info("topic: {}", topic);
//        log.info("message key: {}", messageKey);
//        log.info("partition id: {}", partitionId);
//        log.info("offset: {}", offset);
//        log.info("timestamp type: {}", timestampType);
//        log.info("timestamp: {}", timestamp);
//        log.info("custom header: {}", customHeader);

        log.info("- - - - - - - - - - - - - - -");
        messageHeaders.keySet().forEach(key -> {
            Object value = messageHeaders.get(key);
            if (key.equals("X-Custom-Header")) {
                log.info("{}: {}", key, new String((byte[]) value));
            } else {
                log.info("{}: {}", key, value);
            }
        });
    }

}
