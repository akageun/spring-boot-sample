package kr.geun.o.hwp.hellomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class HellomongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellomongoApplication.class, args);
    }

    @Autowired
    private MongoTemplate mongoTemplate;


    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            TestCollections account = new TestCollections();
            account.setEmail("aaa@bbb");
            account.setUsername("aaa");

            mongoTemplate.insert(account);
        };
    }
}
