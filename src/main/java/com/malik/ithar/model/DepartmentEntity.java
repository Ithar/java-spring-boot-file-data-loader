package com.malik.ithar.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DepartmentEntity {

    @Id
    private Integer id;
    private Double code;
    private String name;
}
