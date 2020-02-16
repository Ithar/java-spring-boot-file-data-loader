package com.malik.ithar.controller;

import com.malik.ithar.model.PersonEntity;
import com.malik.ithar.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @RequestMapping(value = "/person")
    public List<PersonEntity> getPeople() {
        return personService.getAll();
    }

}
