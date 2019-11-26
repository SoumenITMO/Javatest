package com.example.javatest.Models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(columnNames = "country_code"),
        @UniqueConstraint(columnNames = "country_name")
})
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "country_time_zone")
    private String timezone_name;

    //Setter and Getter
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryZone(String countryTimeZoneName) {
        this.timezone_name = countryTimeZoneName;
    }

    public String getCountryZone() {
        return this.timezone_name;
    }

    public int getCountryId() {
        return this.id;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}
