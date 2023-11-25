package com.project.NiralNetwork.NiralNetwork.Services.Impl;

import com.project.NiralNetwork.NiralNetwork.DTOs.EmployeeDTO;
import com.project.NiralNetwork.NiralNetwork.Entities.Employee;
import com.project.NiralNetwork.NiralNetwork.Exceptions.EmployeeNotFoundException;
import com.project.NiralNetwork.NiralNetwork.Repositories.EmployeeRepository;
import com.project.NiralNetwork.NiralNetwork.Services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final NamedParameterJdbcTemplate npJdbcTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(NamedParameterJdbcTemplate npJdbcTemplate) {
        this.npJdbcTemplate = npJdbcTemplate;
    }


    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
         LOGGER.info("Request received in service of add Employee:{}",employeeDTO);
         Employee employee = modelMapper.map(employeeDTO, Employee.class);
         employeeRepository.save(employee);

    }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
        LOGGER.info("Request received in service of edit Employee:{}",employeeDTO);
        Employee employee = employeeRepository.findById(employeeDTO.getId())
                        .orElseThrow(() -> new EmployeeNotFoundException("Employee Not found by given Id"));
        employee.setEmpName(employeeDTO.getEmpName());
        employee.setRole(employeeDTO.getRole());
        employee.setSalary(employeeDTO.getSalary());
        employee.setCompanyName(employeeDTO.getCompanyName());
        employee.setTeamName(employeeDTO.getTeamName());

        employeeRepository.save(employee);
    }

    @Override
    public void editRole(String role, int emp_id) {
        LOGGER.info("Request received in service of edit Role:{}",role);
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not found by given Id"));
        employee.setRole(role);
        employeeRepository.save(employee);

    }

    @Override
    public void editSalary(BigDecimal salary, int emp_id) {
        LOGGER.info("Request received in service of edit salary:{}",salary);
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not found by given Id"));
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    @Override
    public void editTeamsName(String teamName, int emp_id) {
        LOGGER.info("Request received in service of edit teamName:{}",teamName);
        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not found by given Id"));
        employee.setTeamName(teamName);
        employeeRepository.save(employee);
    }

    @Override
    public List<Map<String, Object>> getAllEmployees() {
        LOGGER.info("Request received in service of getAllEmployees ");
        String sql= """
                select *from employee_mst
                """;
        Map<String, Object> params = new HashMap<>();
        return npJdbcTemplate.queryForList(sql, params);
    }

    @Override
    public List<Map<String, Object>> getEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        LOGGER.info("Request received in service of getEmployeesBySalaryRange ");

        String sql = "SELECT * FROM employee_mst WHERE salary BETWEEN :minSalary AND :maxSalary";

        Map<String, Object> params = new HashMap<>();
        params.put("minSalary", minSalary);
        params.put("maxSalary", maxSalary);

        return npJdbcTemplate.queryForList(sql, params);
    }

    @Override
    public EmployeeDTO getEmployeeByName(String name) {
        Employee employee = employeeRepository.findByEmpName(name).orElseThrow(() -> new EmployeeNotFoundException("employee not found with given name"));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<String> getUniqueTeams() {
        LOGGER.info("Request received in service of getUniqueTeams ");

        String sql = "SELECT DISTINCT team_name FROM employee_mst";

        Map<String, Object> params = new HashMap<>();

        return npJdbcTemplate.queryForList(sql, params, String.class);
    }


    @Override
    public void deleteEmployee(int emp_id) {
        LOGGER.info("Request received in service of deleteEmployee ");

        Employee employee = employeeRepository.findById(emp_id)
                .orElseThrow(()
                        -> new EmployeeNotFoundException("Employee Not found by given Id"));
        employeeRepository.delete(employee);

    }

    @Override
    public void deleteEmployeeByName(String empName) {
        LOGGER.info("Request received in service of deleteEmployeeByName ");

        Employee employee = employeeRepository.findByEmpName(empName).orElseThrow(()
                -> new EmployeeNotFoundException("employee not found with given name"));

        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll() {
        LOGGER.info("Request received in service of deleteAll ");
        employeeRepository.deleteAll();

    }
}
