package com.project.NiralNetwork.NiralNetwork.Services;

import com.project.NiralNetwork.NiralNetwork.DTOs.EmployeeDTO;
import com.project.NiralNetwork.NiralNetwork.Entities.Employee;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {

    //Create
    void addEmployee(EmployeeDTO employeeDTO);

    //Read
    List<Map<String, Object>> getAllEmployees();
    List<Map<String,Object>> getEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary);
    EmployeeDTO getEmployeeByName(String name);
    List<String> getUniqueTeams();

    //Update
    void editEmployee(EmployeeDTO employeeDTO);
    void editRole(String role,int emp_id);
    void editSalary(BigDecimal salary, int emp_id);
    void editTeamsName(String teamName,int emp_id);

    //Delete
    void deleteEmployee(int emp_id);
    void deleteEmployeeByName(String empName);
    void deleteAll();



}
