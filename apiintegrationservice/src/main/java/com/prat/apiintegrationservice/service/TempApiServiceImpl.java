package com.prat.apiintegrationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prat.apiintegrationservice.model.TemperatureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class TempApiServiceImpl implements TempApiService{

    @Value("${api.air-quality.base-url}")
    private String baseUrl;

    @Value("${api.air-quality.username}")
    private String apiUserName;
    @Value("${api.air-quality.password}")
    private String apiPassword;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public String getCurrentTempurature(double lat, double lon) {

        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .basicAuthentication(apiUserName, apiPassword) // Replace with your credentials
                .build();
        String temperatureUrl = baseUrl + "/" + Instant.now().toString() + "/t_2m:C/" + lat + "," + lon + "/json";

        ResponseEntity<String> response = restTemplate.exchange(temperatureUrl, HttpMethod.GET, null, String.class);

        if (null != response.getBody() || !response.getBody().isBlank()) {
            return response.getBody();
        } else {
            return null;
        }



//        TemperatureResponse tmpResp = new TemperatureResponse();
//        tmpResp.setParameter("Test Completed!");
//        return tmpResp;
    }
}
