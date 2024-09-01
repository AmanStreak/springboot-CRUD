package com.example.springdi.demo.controllers;

import com.example.springdi.demo.DTO.ApiResponse;
import com.example.springdi.demo.DTO.Employee;
import com.example.springdi.demo.entities.EmployeeEntity;
import com.example.springdi.demo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> deleteEmployee(@PathParam("id") Integer id) {
        boolean success = employeeService.deleteEmployee(id);
        if(success) {
            ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.OK.value(), "Employee Deleted Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.NOT_FOUND.value(), "Employee Not Found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);

    }

}
