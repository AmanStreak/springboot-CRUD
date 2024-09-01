package com.example.springdi.demo.controllers;

import com.example.springdi.demo.DTO.Employee;
import com.example.springdi.demo.entities.EmployeeEntity;
import com.example.springdi.demo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class Employees {

    final EmployeeService employeeService;

    Employees(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "{id}")
    public Employee getEmployees(@PathVariable("id") int employeeID) {
        return employeeService.getEmployeeById(employeeID);
//        return new Employee(007, "STARK", LocalDate.of(3030, 12, 23), false);
    }

    ///Optional Values in params
    @GetMapping
    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit) {
        return "Sort By value: " + sortBy + " Limit is: " + limit;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/deleteEmployee")
    public Map<String, Object> deleteEmployee(@PathParam("id") Integer id) {
        Map<String, Object> response = new HashMap<String, Object>();
        boolean success = employeeService.deleteEmployee(id);
        if(success) {
            response.put("success", true);
            response.put("message", "Employee Deleted Successfully");
            return response;
        }

        response.put("success", false);
        response.put("message", "Error! Try again");
        return response;

    }

}
