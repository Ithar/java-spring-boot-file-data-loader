package com.malik.ithar.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class PersonEntity implements Serializable {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    @OneToOne
    private DepartmentEntity departmentEntity;

}
