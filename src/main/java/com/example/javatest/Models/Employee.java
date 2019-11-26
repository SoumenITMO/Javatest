package com.example.javatest.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
    private LocalTime employeeCreated;

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

    public void setCreatedDate(LocalTime createdDate) {
        this.employeeCreated = createdDate;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public LocalDate getEmployeeDob() { return this.empployeeDob; }

    public String getEmployeeSalary() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(5);
        return String.valueOf(decimalFormat.format(this.employeeSalary));
    }

    public LocalTime getEmployeeCreated() {
        return this.employeeCreated;
    }

    public String getEmployeeCountryCode() { return this.employeeCountry; }
}
