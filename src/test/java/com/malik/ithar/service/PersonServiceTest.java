package com.malik.ithar.service;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.mapper.PersonToEntityMapper;
import com.malik.ithar.model.PersonEntity;
import com.malik.ithar.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonToEntityMapper personToEntityMapper;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void getAll() {

        // Given
        List<PersonEntity> entities = new ArrayList<>();

        // When
        when(personRepository.findAll()).thenReturn(entities);
        personService.getAll();

        // Then
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void saveAll() {

        // Given
        PersonDTO person = new PersonDTO();
        person.setDeptRegion("Test Region");
        person.setDeptCode(11D);
        person.setAge(28);
        person.setDeptName("Test Dept");
        person.setFirstName("Jane");
        person.setLastName("Doe");

        List<PersonDTO> persons = new ArrayList<>();
        persons.add(person);

        List<PersonEntity> entities = new ArrayList<>();
        entities.add(new PersonEntity());

        // When
        when(personToEntityMapper.map(person)).thenReturn(new PersonEntity());
        when(personRepository.saveAll(anyList())).thenReturn(entities);
        personService.saveAll(persons);

        // Then
        verify(personRepository, times(1)).saveAll(anyList());
    }

    @Test
    void saveAll_Empty() {

        // Given
        List<PersonDTO> persons = new ArrayList<>();

        // When
        personService.saveAll(persons);

        // Then
        verify(personRepository, times(0)).saveAll(anyList());
    }


}