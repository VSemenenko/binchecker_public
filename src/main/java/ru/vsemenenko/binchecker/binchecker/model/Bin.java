package ru.vsemenenko.binchecker.binchecker.model;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "bins")
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value", unique = true)
    private Integer value;

    @Column(name = "scheme")
    private String scheme;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @OneToOne (optional=false, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne (optional=false, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Bin(Integer value) {
        this.value = value;
    }

    public Bin(Integer value, String scheme, String type, String brand, Country country, Bank bank) {
        this.value = value;
        this.scheme = scheme;
        this.type = type;
        this.brand = brand;
        this.country = country;
        this.bank = bank;
    }

    public Bin (){}

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void compliteBin (Bin bin){
        this.setScheme(bin.getScheme());
        this.setBank(bin.getBank());
        this.setType(bin.getType());
        this.setBrand(bin.getBrand());
        this.setCountry(bin.getCountry());
    }
}
