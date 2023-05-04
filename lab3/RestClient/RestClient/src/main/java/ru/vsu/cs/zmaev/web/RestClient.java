package ru.vsu.cs.zmaev.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.vsu.cs.zmaev.dto.SubjectGroupDto;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;

public class RestClient {
    public static final String URL = "http://localhost:8080/subject-group/create";
    public final ObjectMapper objectMapper = new ObjectMapper();

    public final String[] subjectNames = {"Electrodinamika", "Kvati", "Programming", "Math", "TP", "ISIS", "MiSPIS", "TIPiS", "PE"};
    private CloseableHttpClient client;

    public RestClient() {
        objectMapper.registerModule(new JavaTimeModule());
        client = HttpClients.createDefault();
    }

    public void post() throws IOException {
        SubjectGroupDto dto = genDto();
        String dtoToJson = objectMapper.writeValueAsString(dto);
        HttpPost post = new HttpPost(URL);
        StringEntity entity = new StringEntity(dtoToJson);
        post.setEntity(entity);
        post.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = client.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public void closeClient() throws IOException {
        client.close();
    }

    private SubjectGroupDto genDto() {
        SubjectGroupDto dto = new SubjectGroupDto();
        Random random = new Random();
        dto.setSubjectName(subjectNames[random.nextInt(subjectNames.length)]);
        dto.setGroupNum(random.nextInt());
        Faker faker = new Faker(new Locale("en-US"));
        dto.setSubjectDesc(faker.random().toString());
        dto.setTimestamp(LocalTime.now());
        return dto;
    }
}
