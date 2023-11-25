package com.project.NiralNetwork.NiralNetwork.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_mst")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String empName;

    private String companyName;

    private String role;

    private String teamName;

    private BigDecimal salary;

}
