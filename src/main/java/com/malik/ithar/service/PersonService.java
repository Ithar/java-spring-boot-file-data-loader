package com.malik.ithar.service;

import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.mapper.PersonToEntityMapper;
import com.malik.ithar.model.PersonEntity;
import com.malik.ithar.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveAll(List<PersonDTO> persons) {

        List<PersonEntity> entities = new ArrayList<>();

        for (PersonDTO person : persons) {
            entities.add(personToEntityMapper.map(person));
        }

        if (!entities.isEmpty()) {
            personRepository.saveAll(entities);
            log.info("Saved {} entities.", entities.size());
        }
    }

}