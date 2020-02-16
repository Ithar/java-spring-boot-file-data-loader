package com.malik.ithar.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.mapper.PersonToEntityMapper;
import com.malik.ithar.model.PersonEntity;
import com.malik.ithar.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PersonService {

    private final PersonToEntityMapper personToEntityMapper;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonToEntityMapper personToEntityMapper, PersonRepository personRepository) {
        this.personToEntityMapper = personToEntityMapper;
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getAll() {
        return personRepository.findAll();
    }

    public void saveAll(MappingIterator<PersonDTO> persons) {

        List<PersonEntity> entities = new ArrayList<>();
        try {

            for (PersonDTO person : persons.readAll()) {
                entities.add(personToEntityMapper.map(person));
            }
        } catch (IOException e) {
            log.error("Failed to read persons list due to:{} ", e.getMessage(), e);
        }

        personRepository.saveAll(entities);
    }

}
