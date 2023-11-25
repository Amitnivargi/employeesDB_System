package com.project.NiralNetwork.NiralNetwork.Repositories;

import com.project.NiralNetwork.NiralNetwork.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findById(int empId);

    Optional<Employee> findByEmpName(String empId);


}
