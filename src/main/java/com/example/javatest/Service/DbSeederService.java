package com.example.javatest.Service;

import com.example.javatest.Helper.GetCountryIdByCode;
import com.example.javatest.Helper.GetCountryTimeZone;
import com.example.javatest.Models.Country;
import com.example.javatest.Models.Employee;
import com.example.javatest.Repository.Countries;
import com.example.javatest.Repository.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class DbSeederService {
      private Employees employees;
      private Countries countries;
      private GetCountryTimeZone getCountryTimeZone;
      private GetCountryIdByCode getCountryIdByCode;

      @Autowired
      public DbSeederService(Employees employees, Countries countries,
                             GetCountryTimeZone getCountryTimeZone,
                             GetCountryIdByCode getCountryIdByCode) {
          this.employees = employees;
          this.countries = countries;
          this.getCountryTimeZone = getCountryTimeZone;
          this.getCountryIdByCode = getCountryIdByCode;
      }

      public void seedDB() throws ParseException {
          Country country;

          country = new Country();
          countries.save(fillCountryData(country, "DK", "Denmark",
                  "Europe/Oslo"));

          country = new Country();
          countries.save(fillCountryData(country, "ES", "Spain",
                  "Europe/Madrid"));

          country = new Country();
          countries.save(fillCountryData(country, "US", "United States of America",
                  "America/Grenada"));

          Employee employee;
          employee = new Employee();
          employees.save(fillEmployeeData(employee, "DK", "Soumen Banerjee",
                  "26/12/1987", (float)5478.21));

          employee = new Employee();
          employees.save(fillEmployeeData(employee, "US", "Alex Alex",
                  "02/10/1978", (float)15478.21));
      }

      public Country fillCountryData(Country country, String countryCode, String countryName, String countryTimeZone) {
          country.setCountryCode(countryCode);
          country.setCountryName(countryName);
          country.setCountryZone(countryTimeZone);
          return country;
      }

      public Employee fillEmployeeData(Employee employee, String countryCode, String employeeName, String employeeDOB,
                                       float employeeSalary) throws ParseException {

          employee.setEmployeeSalary(employeeSalary);
          employee.setEmployeeCountry(countryCode);
          employee.setEmployeeName(employeeName);
          employee.setEmployeeDOB(strToLocalDateTime(employeeDOB));
          employee.setCreatedDate(getCountryTimeZone.getTimeZoneByCountryCode(countryCode));
          return employee;
      }

      public LocalDate strToLocalDateTime(String stringDate) {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
          LocalDate localDate = LocalDate.parse(stringDate, formatter);
          return localDate;
      }
}
