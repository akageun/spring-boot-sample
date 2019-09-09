package kr.geun.o.hwp.zkkfa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * KafkaProperties
 *
 * @author akageun
 * @since 2019-09-09
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "kafka.producer")
public class KafkaProducer {

    private String bootstrapServers;
    private int retries;
    private int batchSize;
    private int lingerMs;
    private int bufferMemory;


}
