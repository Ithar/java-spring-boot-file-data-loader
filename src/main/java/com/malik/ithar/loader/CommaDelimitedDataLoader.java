package com.malik.ithar.loader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.mapper.CSVToPersonMapper;
import com.malik.ithar.model.PersonEntity;
import com.malik.ithar.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CommaDelimitedDataLoader {

    private final String file;
    private final CSVToPersonMapper cSVToPersonMapper;
    private final PersonRepository personRepository;

    public CommaDelimitedDataLoader(
            @Value("${data-load-files.price-list-file:sample_v1.csv}") String file,
            CSVToPersonMapper cSVToPersonMapper,
            PersonRepository personRepository) {
        this.file = file;
        this.cSVToPersonMapper = cSVToPersonMapper;
        this.personRepository = personRepository;
    }

    public void load() {

        try {

            CsvSchema schema = new CsvMapper()
                    .schemaFor(PersonDTO.class);

            MappingIterator<PersonDTO>  persons = new CsvMapper()
                    .readerFor(PersonDTO.class)
                    .with(schema)
                    .readValues(new ClassPathResource(file).getInputStream());

            List<PersonEntity> entities = new ArrayList<>();
            for (PersonDTO person : persons.readAll()) {
                entities.add(cSVToPersonMapper.map(person));
            }

            personRepository.saveAll(entities);
        } catch (IOException e) {
            log.error("CVS loader failed due to: {}", e.getMessage(), e);
        }

    }
}
