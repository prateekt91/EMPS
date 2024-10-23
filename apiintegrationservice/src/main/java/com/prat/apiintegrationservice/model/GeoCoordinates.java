package com.prat.apiintegrationservice.model;

import java.util.Objects;

public class GeoCoordinates {

    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoCoordinates that = (GeoCoordinates) o;
        return Double.compare(lat, that.lat) == 0 && Double.compare(lon, that.lon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }
}
