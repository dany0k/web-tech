package vsu.cs.tech.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb://user:pass@localhost:27018");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient client) throws Exception {
        return new MongoTemplate(client, "university");
    }
}
