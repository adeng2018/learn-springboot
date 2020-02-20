package com.adeng1024.controller;

import com.adeng1024.dao.ApartmentDao;
import com.adeng1024.dao.EmployeeDao;
import com.adeng1024.pojo.Apartment;
import com.adeng1024.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ApartmentDao apartmentDao;

    @GetMapping("/employee")
    public  String employeeIndex(Model model){
        model.addAttribute("employees", employeeDao.getEmployees());
        return "list";
    }
    @GetMapping("/add")
    public String addEmployeePage(Model model){
        Collection<Apartment> apartments = apartmentDao.getApartments();
        model.addAttribute("apartments", apartments);
        return "add";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/employee";
    }
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id")String id,Model model){
        Employee employee = employeeDao.queryEmployeeById(id);
        model.addAttribute("employee", employee);
        Collection<Apartment> apartments = apartmentDao.getApartments();
        model.addAttribute("apartments", apartments);
        return  "editor";
    }
    @PostMapping("/update")
    public String update(Employee employee){
        System.out.println(employee);
        employeeDao.updateEmployee(employee);
        return "redirect:employee";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")String id){
        employeeDao.removeEmployeeById(id);
        return "redirect:/employee";
    }
}
