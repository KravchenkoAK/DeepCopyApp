package com.alexkrav.deepcopy.models;

public class Address {
    private String country;
    private String region;
    private String home;

    public Address(String country, String region, String home) {
        this.country = country;
        this.region = region;
        this.home = home;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
