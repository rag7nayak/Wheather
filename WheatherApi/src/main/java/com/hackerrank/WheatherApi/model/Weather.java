package com.hackerrank.WheatherApi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer;

@Entity

//@TypeDefs(@TypeDef(name ="float-array" ,typeClass = FloatArraySerializer.class))

public class Weather {
	@Id
	@GeneratedValue
    private Long id;
	@Column(name = "dater")
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dater;
	@OneToOne
    private Location location;

    private Float[] temperature;

    public Weather() {
    }

    public Weather(Long id, LocalDate dater, Location location, Float[] temperature) {
        this.id = id;
        this.dater = dater;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public LocalDate getDater() {
		return dater;
	}

	public void setDater(LocalDate dater) {
		this.dater = dater;
	}

	public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Float[] temperature) {
        this.temperature = temperature;
    }
}
