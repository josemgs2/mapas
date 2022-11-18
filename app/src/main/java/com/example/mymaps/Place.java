package com.example.mymaps;

public class Place {
    private String name;
    private String url;
    private Double latitud;
    private Double longitud;

    public Place() {
    }

    public Place(String name, String url, Double latitud, Double longitud) {
        this.name = name;
        this.url = url;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
