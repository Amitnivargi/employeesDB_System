package com.project.NiralNetwork.NiralNetwork.Controllers;


import com.project.NiralNetwork.NiralNetwork.DTOs.ApiResponseMessage;
import com.project.NiralNetwork.NiralNetwork.DTOs.EmployeeDTO;
import com.project.NiralNetwork.NiralNetwork.Services.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController  {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<ApiResponseMessage> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        LOGGER.info("Adding employee: {}", employeeDTO);
        employeeService.addEmployee(employeeDTO);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Employee added successfully", true, HttpStatus.CREATED);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);

    }

    // Read
    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllEmployees() {
        LOGGER.info("Request received for all employees");
        List<Map<String, Object>> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/salary-range")
    public ResponseEntity<List<Map<String, Object>>> getEmployeesBySalaryRange(
            @RequestParam("minSalary") BigDecimal minSalary,
            @RequestParam("maxSalary") BigDecimal maxSalary) {
        LOGGER.info("Request received for employees by salary range: {} - {}", minSalary, maxSalary);
        List<Map<String, Object>> employees = employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/by-name")
    public ResponseEntity<EmployeeDTO> getEmployeeByName(@RequestParam("name") String name) {
        LOGGER.info("Request received for employee by name: {}", name);
        EmployeeDTO employeeDTO = employeeService.getEmployeeByName(name);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping("/unique-teams")
    public ResponseEntity<List<String>> getUniqueTeams() {
        LOGGER.info("Request received for unique teams");
        List<String> teams = employeeService.getUniqueTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);

    }

    // Update
    @PutMapping("/edit")
    public ResponseEntity<ApiResponseMessage> editEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        LOGGER.info("Editing employee: {}", employeeDTO);
        employeeService.editEmployee(employeeDTO);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Employee edited successfully", true, HttpStatus.OK);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @PutMapping("/edit-role")
    public ResponseEntity<ApiResponseMessage> editRole(@RequestParam("role") String role, @RequestParam("emp_id") int empId) {
        LOGGER.info("Editing role for employee with ID {}: {}", empId, role);
        employeeService.editRole(role, empId);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Role edited successfully", true, HttpStatus.OK);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @PutMapping("/edit-salary")
    public ResponseEntity<ApiResponseMessage> editSalary(@RequestParam("salary") BigDecimal salary, @RequestParam("emp_id") int empId) {
        LOGGER.info("Editing salary for employee with ID {}: {}", empId, salary);
        employeeService.editSalary(salary, empId);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Salary edited successfully", true, HttpStatus.OK);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @PutMapping("/edit-teams-name")
    public ResponseEntity<ApiResponseMessage> editTeamsName(@RequestParam("teamName") String teamName, @RequestParam("emp_id") int empId) {
        LOGGER.info("Editing teams name for employee with ID {}: {}", empId, teamName);
        employeeService.editTeamsName(teamName, empId);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Team name edited successfully", true, HttpStatus.OK);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    // Delete
    @DeleteMapping("/delete/{emp_id}")
    public ResponseEntity<ApiResponseMessage> deleteEmployee(@PathVariable("emp_id") int empId) {
        LOGGER.info("Deleting employee with ID: {}", empId);
        employeeService.deleteEmployee(empId);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Employee deleted successfully", true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @DeleteMapping("/delete-by-name")
    public ResponseEntity<ApiResponseMessage> deleteEmployeeByName(@RequestParam("empName") String empName) {
        LOGGER.info("Deleting employee by name: {}", empName);
        employeeService.deleteEmployeeByName(empName);
        ApiResponseMessage responseMessage = new ApiResponseMessage("Employee deleted successfully", true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<ApiResponseMessage> deleteAll() {
        LOGGER.info("Deleting all employees");
        employeeService.deleteAll();
        ApiResponseMessage responseMessage = new ApiResponseMessage("All employees deleted successfully", true, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

}
