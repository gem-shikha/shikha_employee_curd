package com.spring.curd.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Employee Id")
    private Long empId;
    @ApiModelProperty(value = "Employee Name")
    private String name;
    @ApiModelProperty(value = "Employee Department")
    private String department;
    @ApiModelProperty(value = "Employee Grade")
    private String grade;

}
