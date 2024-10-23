package com.prat.apiintegrationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("weatherdata")
public class WeatherData {

    @Id
    private String id;
    private String dateGenerated;

    private List<WeatherAPIResponse.Data> data;

    public WeatherData(String dateGenerated, List<WeatherAPIResponse.Data> data) {
        this.dateGenerated = dateGenerated;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public List<WeatherAPIResponse.Data> getData() {
        return data;
    }

    public void setData(List<WeatherAPIResponse.Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id='" + id + '\'' +
                ", dateGenerated='" + dateGenerated + '\'' +
                ", data=" + data +
                '}';
    }
}
