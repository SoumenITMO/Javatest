package com.example.javatest.Service;

import com.example.javatest.Models.Country;
import com.example.javatest.Repository.Countries;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    private Countries countries;

    public CountryService(Countries countries) {
        this.countries = countries;
    }

    public List<Country> getAllCountry() {
        return countries.getAllCountries();
    }
}
