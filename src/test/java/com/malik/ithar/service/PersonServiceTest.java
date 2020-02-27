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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

//    @Test
//    void saveAll() {
//
//        // Given
//        List<PersonDTO> persons  = new ArrayList<>();
//        List<PersonEntity> entities = new ArrayList<>();
//
//        // When
//        doNothing().when(personRepository).saveAll(entities);
//        personService.saveAll(persons);
//
//        // Then
//        verify(personRepository, times(0)).saveAll(entities);
//    }
}