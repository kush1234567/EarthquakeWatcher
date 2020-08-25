package com.bawp.firstmap.model;

public class Earthquake {
    private String place;
    private double magnitude;
    private long time;
    private String detailLink;
    private String type;
    private double lat;
    private double lon;

    public void setPlace(String place) {
        this.place = place;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }



    public Earthquake(String place, double magnitude, long time, String detailLink, String type, double lat, double lon) {
        this.place = place;
        this.magnitude = magnitude;
        this.time = time;
        this.detailLink = detailLink;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getTime() {
        return time;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public String getType() {
        return type;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Earthquake() {
    }


}
