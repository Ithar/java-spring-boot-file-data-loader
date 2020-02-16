package com.malik.ithar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 4966369808179876078L;

    @Id
    @GeneratedValue
    private Integer id;
    private Double code;
    private String name;
    private String region;

}
