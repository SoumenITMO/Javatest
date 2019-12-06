package com.example.javatest.Helper;

import com.example.javatest.Repository.Countries;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Service
@Transactional
public class GetCountryTimeZone {

    private Countries countries;

    public GetCountryTimeZone(Countries countries) {
        this.countries = countries;
    }

    public LocalDateTime getTimeZoneByCountryCode(String countryCode) {
        Date date = new Date();
        String getCountryTimeZone = countries.getAllByCountryCode(countryCode).getCountryZone();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        df.setTimeZone(TimeZone.getTimeZone(getCountryTimeZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.from(LocalDateTime.parse(df.format(date), formatter));

        return dateTime;
    }
}
