package com.malik.ithar.mapper;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.model.PersonEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonToEntityMapperTest {

    @Test
    void map() {

        // Given
        PersonDTO dto = new PersonDTO();
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setAge(18);
        dto.setDeptName("Test Department");
        dto.setDeptCode(1d);
        dto.setDeptRegion("Taiwan");

        // When
        PersonEntity entity = PersonToEntityMapper.INSTANCE.map(dto);

        // Then
        assertNotNull(entity);
        assertEquals("John", entity.getFirstName());
        assertEquals("Doe", entity.getLastName());
        assertEquals(18, entity.getAge());
        assertEquals("Test Department", entity.getDepartmentEntity().getName());
        assertEquals(1, entity.getDepartmentEntity().getCode());
        assertEquals("Taiwan", entity.getDepartmentEntity().getRegion());
    }
}