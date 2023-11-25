package com.project.NiralNetwork.NiralNetwork.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id;

    @NotBlank(message = "Employee name is required")
    @Size(min = 3,max = 100, message = "Employee name cannot be longer than 255 characters")
    private String empName;

    @NotBlank(message = "Company name is required")
    @Size(min = 2,max = 100, message = "Company name cannot be longer than 255 characters")
    private String companyName;

    @NotBlank(message = "Role is required")
    @Size(min = 2,max = 100, message = "Role cannot be longer than 50 characters")
    private String role;

    @NotBlank(message = "Team name is required")
    @Size(min = 2,max = 100, message = "Team name cannot be longer than 50 characters")
    private String teamName;

    @NotNull(message = "Salary is required")
    @PositiveOrZero(message = "Salary must be a positive or zero value")
    private BigDecimal salary;
}
