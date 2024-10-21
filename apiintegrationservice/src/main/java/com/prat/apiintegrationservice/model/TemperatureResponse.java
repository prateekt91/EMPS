package com.prat.apiintegrationservice.model;

import java.util.List;

public class TemperatureResponse {

    // [{"parameter":"t_2m:C","coordinates":[{"lat":13.081568,"lon":77.625137,"dates":[{"date":"2024-10-21T00:00:00Z","value":22.2}]}]}]

    private String version;
    private String user;
    private String dateGenerated;
    private String status;
    private List<Data> data;

    public TemperatureResponse() {
    }

    public class Data {

        private String parameter;
        private List<Coordinate> coordinates;

        public Data() {
        }

        public class Coordinate {

            private String lat;
            private String lon;
            private List<PosData> dates;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public List<PosData> getDates() {
                return dates;
            }

            public void setDates(List<PosData> dates) {
                this.dates = dates;
            }
        }

        public class PosData {

            private String date;
            private String value;

            public PosData() {
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }


        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public List<Coordinate> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<Coordinate> coordinates) {
            this.coordinates = coordinates;
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
