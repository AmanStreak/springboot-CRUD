package com.example.springdi.demo.services;

import com.example.springdi.demo.DTO.Employee;
import com.example.springdi.demo.entities.EmployeeEntity;
import com.example.springdi.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Employee getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(id);
        return new Employee(employeeEntity.getId(), employeeEntity.getName(),
                employeeEntity.getDateOfJoining(), employeeEntity.isActive());
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), Employee.class);
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> allEmployees = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity employeeEntity: allEmployees) {
            employees.add(modelMapper.map(employeeEntity, Employee.class));
        }

        return employees;
    }

    public boolean deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
