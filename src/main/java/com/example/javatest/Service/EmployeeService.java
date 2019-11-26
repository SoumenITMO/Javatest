package com.example.javatest.Service;

import com.example.javatest.Helper.GetCountryIdByCode;
import com.example.javatest.Helper.GetCountryTimeZone;
import com.example.javatest.Models.Employee;
import com.example.javatest.Repository.Countries;
import com.example.javatest.Repository.Employees;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private Employees employees;
    private GetCountryTimeZone getCountryTimeZone;
    private GetCountryIdByCode getCountryIdByCode;

    public EmployeeService(Employees employees, GetCountryTimeZone getCountryTimeZone) {
        this.employees = employees;
        this.getCountryTimeZone = getCountryTimeZone;
    }

    public List<Employee> getEmployees() {
        return employees.getAllEmployee();
    }

    public void createNewEmployee(String countryCode, String employeeName, String employeeDOB,
                                  float employeeSalary) throws ParseException {
        Employee employee = new Employee();
        employee.setEmployeeSalary(employeeSalary);
        employee.setEmployeeCountry(countryCode);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeDOB(strToLocalDateTime(employeeDOB));
        employee.setCreatedDate(getCountryTimeZone.getTimeZoneByCountryCode(countryCode));
        employees.save(employee);
    }

    public LocalDate strToLocalDateTime(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate localDate = LocalDate.parse(stringDate, formatter);
        return localDate;
    }
}
