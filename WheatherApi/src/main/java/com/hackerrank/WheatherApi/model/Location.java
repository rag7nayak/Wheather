package com.hackerrank.WheatherApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private int id;
	//@Column(name="cityname")
    private String cityName;
	//@Column(name="statename")
    private String stateName;
	//@Column(name="latitude")
    private Float latitude;
	//@Column(name="longitude")
    private Float longitude;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "location")
private Weather weather;

    public Location() {
    }

    public Location(String cityName, String stateName, Float latitude, Float longitude) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
