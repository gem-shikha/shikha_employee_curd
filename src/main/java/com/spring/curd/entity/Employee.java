package com.spring.curd.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Employee Id")
    private Long empId;
    @ApiModelProperty(value = "Employee Name")
    private String Name;
    @ApiModelProperty(value = "Employee Department")
    private String department;
    @ApiModelProperty(value = "Employee Grade")
    private String grade;

}
