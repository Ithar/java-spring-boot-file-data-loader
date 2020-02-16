package com.malik.ithar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1085567151391636239L;

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    @OneToOne
    @MapsId
    private DepartmentEntity departmentEntity;
}
