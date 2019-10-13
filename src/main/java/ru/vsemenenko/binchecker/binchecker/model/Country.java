package ru.vsemenenko.binchecker.binchecker.model;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name="numeric")
//    private int numeric;

    @Column(name = "alpha2")
    private String alpha2;

    @Column(name = "name")
    private String name;

    @Column (name = "currency")
    private String currency;

    @Column (name = "latitude")
    private int latitude;

    @Column (name = "longitude")
    private int longitude;

    private Country(){}

    public Country( String alpha2, String name, String currency, int latitude, int longitude) {
        this.alpha2 = alpha2;
        this.name = name;
        this.currency = currency;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }


    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
