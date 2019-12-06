package com.example.javatest.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_dob")
    private LocalDate empployeeDob;

    @Column(name = "country")
    private String employeeCountry;

    @Column(name = "salary")
    private float employeeSalary;

    @Column(name = "created")
    private LocalDateTime employeeCreated;

    // Setter and Getter
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeDOB(LocalDate employeeDOB) {
        this.empployeeDob = employeeDOB;
    }

    public void setEmployeeCountry(String employeeCountry) {
        this.employeeCountry = employeeCountry;
    }

    public void setEmployeeSalary(float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setCreatedDate(LocalDateTime createdDate) {

        this.employeeCreated = createdDate;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String getEmployeeDob() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.empployeeDob.format(formatter);
    }

    public String getEmployeeSalary() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        return String.valueOf(decimalFormat.format(this.employeeSalary));
    }

    public String getEmployeeCreated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return this.employeeCreated.format(formatter);
    }

    public String getEmployeeCountryCode() { return this.employeeCountry; }
}
