package com.example.javatest.Controllers;

import com.example.javatest.Repository.Countries;
import com.example.javatest.Service.CountryService;
import com.example.javatest.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@Controller
public class javaTestTask {

    @Autowired
    private EmployeeService employeeService;
    private CountryService countryService;
    private Countries countries;

    public javaTestTask(EmployeeService employeeService, CountryService countryService
            , Countries countries) {
        this.employeeService = employeeService;
        this.countryService = countryService;
        this.countries = countries;
    }

    @GetMapping("/emp")
    @ResponseBody
    public ModelAndView getEmployees() {
        ModelAndView mv = new ModelAndView("employees");
        mv.addObject("employeeData", employeeService.getEmployees());
        mv.addObject("countries", countryService.getAllCountry());
        return mv;
    }

    @PostMapping("/newEmployee")
    public String createNewEmployee(@RequestParam("ename")String employeeName,
                                    @RequestParam("salary")String employeeSalary,
                                    @RequestParam("dob")String employeeDob,
                                    @RequestParam("country")String country,
                                    HttpServletResponse response) throws ParseException {

        employeeService.createNewEmployee(countries.getAllById(Integer.parseInt(country)).getCountryCode(),
                employeeName, employeeDob, Float.parseFloat(employeeSalary));
        return "redirect:emp";
    }
}
