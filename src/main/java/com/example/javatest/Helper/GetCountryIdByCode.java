package com.example.javatest.Helper;

import com.example.javatest.Repository.Countries;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GetCountryIdByCode {

    private Countries countries;

    public GetCountryIdByCode(Countries countries) {
        this.countries = countries;
    }

    public int countryId(String countryCode) {
        return countries.getAllByCountryCode(countryCode).getCountryId();
    }

    public String countryCodeById(String countryCode) {
        return countries.getAllByCountryCode(countryCode).getCountryCode();
    }
}
