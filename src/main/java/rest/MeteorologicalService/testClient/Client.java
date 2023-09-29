package rest.MeteorologicalService.testClient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        String sensorName = "work_sensor";
        registerSensor(sensorName);

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            addMeasurement(r.nextDouble() * 45, r.nextBoolean(), sensorName);
        }
    }

    public static void registerSensor(String sensorName) {
        final String url = "http://localhost:8080/sensor/registration";
        Map<String, Object> json = new HashMap<>();

        json.put("name", sensorName);

        makePosrtRequst(url, json);
    }

    public static void addMeasurement(double value, boolean raining, String sensorName) {
        final String url = "http://localhost:8080/measurements/add";
        Map<String, Object> json = new HashMap<>();

        json.put("value", value);
        json.put("raining", raining);
        json.put("sensor", Map.of("name", sensorName));

        makePosrtRequst(url, json);
    }

    public static void makePosrtRequst(String url, Map<String, Object> json) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<Object>(json, headers);

        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("Запрос УСПЕШЕН!");
        } catch (HttpClientErrorException e) {
            System.out.println("Запрос ПРОВАЛЕН");
            System.out.println(e.getMessage());
        }
    }
}
