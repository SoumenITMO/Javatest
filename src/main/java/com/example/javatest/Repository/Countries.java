package com.example.javatest.Repository;

import com.example.javatest.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Countries extends JpaRepository<Country, Long> {
    Country getAllByCountryCode(String CountryCode);

    Country getAllById(int CountryId);

    @Query(value = "select id,country_code,country_name,country_time_zone from country ", nativeQuery = true)
    List<Country> getAllCountries();
}
