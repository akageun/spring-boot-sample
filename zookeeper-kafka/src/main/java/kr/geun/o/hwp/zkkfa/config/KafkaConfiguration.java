package kr.geun.o.hwp.zkkfa.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * KafkaConfiguration
 *
 * @author akageun
 * @since 2019-09-09
 */
@Configuration
@EnableKafka
@EnableConfigurationProperties(KafkaProducer.class)
public class KafkaConfiguration {

    @Autowired
    private KafkaProducer kafkaProducer;

    public Map<String, Object> producerConfigs() {

        Map<String, Object> props = new HashMap<>();

        // server host 및 port 지정
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducer.getBootstrapServers());

        // retries 횟수
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProducer.getRetries());

        // batch size 지정
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProducer.getBatchSize());

        // linger.ms
        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaProducer.getLingerMs());

        // buffer memory size 지정
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProducer.getBufferMemory());

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // key serialize 지정
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // value serialize 지정

        return props;
    }

    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory()); // Bean을 통하여 의존성 주입
    }
}
