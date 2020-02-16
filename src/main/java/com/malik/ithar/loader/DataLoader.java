package com.malik.ithar.loader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class DataLoader {

    private final PersonService personService;

    public DataLoader(
            PersonService personService) {
        this.personService = personService;
    }

    public void load(String file, char separator) {

        try {

            CsvSchema schema = new CsvMapper()
                    .schemaFor(PersonDTO.class)
                    .withColumnSeparator(separator);

            MappingIterator<PersonDTO> persons = new CsvMapper()
                    .readerFor(PersonDTO.class)
                    .with(schema)
                    .readValues(new ClassPathResource(file).getInputStream());

            personService.saveAll(persons);

        } catch (IOException e) {
            log.error("CVS loader failed due to: {}", e.getMessage(), e);
        }

    }

}
