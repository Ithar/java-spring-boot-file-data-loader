package com.malik.ithar.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "firstName",
        "lastName",
        "age",
        "departmentCode",
        "departmentName",
        "departmentRegion"})
public class PersonDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private Double deptCode;
    private String deptName;
    private String deptRegion;

}
