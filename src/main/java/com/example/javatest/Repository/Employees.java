package com.example.javatest.Repository;

import com.example.javatest.Models.Country;
import com.example.javatest.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Repository
public interface Employees extends JpaRepository<Employee, Long> {

    @Query(value = "select id,country,created,employee_name,salary,employee_dob from employee ", nativeQuery = true)
    List<Employee> getAllEmployee();
}
