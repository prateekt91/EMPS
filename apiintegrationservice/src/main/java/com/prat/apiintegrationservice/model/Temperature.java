package com.prat.apiintegrationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Temperature {

    @Id
    private String id;
    private String dateGenerated;

    private List<TemperatureResponse.Data> data;

    public Temperature(String dateGenerated, List<TemperatureResponse.Data> data) {
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

    public List<TemperatureResponse.Data> getData() {
        return data;
    }

    public void setData(List<TemperatureResponse.Data> data) {
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
