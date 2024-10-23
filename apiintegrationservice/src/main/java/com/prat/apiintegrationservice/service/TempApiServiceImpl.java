package com.prat.apiintegrationservice.service;

import com.prat.apiintegrationservice.model.WeatherAPIResponse;
import com.prat.apiintegrationservice.model.WeatherData;
import com.prat.apiintegrationservice.repository.CustomTempRepo;
import com.prat.apiintegrationservice.repository.TemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@Service
public class TempApiServiceImpl implements TempApiService {

    @Value("${api.air-quality.base-url}")
    private String baseUrl;

    @Value("${api.air-quality.username}")
    private String apiUserName;
    @Value("${api.air-quality.password}")
    private String apiPassword;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private CustomTempRepo customTempRepo;

    private static final Logger log = LoggerFactory.getLogger(TempApiServiceImpl.class);

    @Override
    public WeatherData getCurrentTempurature(double lat, double lon) {
        return customTempRepo.getLatestTemperature(lat, lon);
    }

    @Override
    public WeatherAPIResponse getTemperatureFromService(double lat, double lon) {

        String methodName = "TempApiServiceImpl.getTemperatureFromService";
        log.info("Inside method {} ", methodName);
        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(5))
                .setReadTimeout(Duration.ofSeconds(5))
                .basicAuthentication(apiUserName, apiPassword)
                .build();
        String temperatureUrl = baseUrl + "/" + Instant.now().toString()
                + "/t_2m:C,wind_speed_10m:ms,wind_dir_10m:d,wind_gusts_10m_1h:kmh,t_max_2m_24h:C,t_min_2m_24h:C,msl_pressure:hPa,precip_1h:mm,precip_24h:mm,uv:idx/"
                + lat + "," + lon + "/json";

        log.info("Calling temp api with url: {}", temperatureUrl);

        ResponseEntity<WeatherAPIResponse> response = restTemplate.exchange(temperatureUrl, HttpMethod.GET, null, WeatherAPIResponse.class);

        if (null != response.getBody()) {

            WeatherAPIResponse temperatureResponse = response.getBody();
           // WeatherData temperature = new WeatherData(temperatureResponse.getDateGenerated(), temperatureResponse.getData());
            //return temperatureRepository.save(temperature);
            return temperatureResponse;
        } else {
            return null;
        }
    }
}
