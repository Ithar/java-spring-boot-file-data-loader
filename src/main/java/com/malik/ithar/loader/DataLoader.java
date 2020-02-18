package com.malik.ithar.loader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.malik.ithar.dto.PersonDTO;
import com.malik.ithar.exception.BusinessException;
import com.malik.ithar.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class DataLoader {

    private final PersonService personService;

    public DataLoader(
            PersonService personService) {
        this.personService = personService;
    }

    public int load(String file, char separator) throws BusinessException {

        try {

            CsvSchema schema = new CsvMapper()
                    .schemaFor(PersonDTO.class)
                    .withColumnSeparator(separator);

            MappingIterator<PersonDTO> personLines = new CsvMapper()
                    .readerFor(PersonDTO.class)
                    .with(schema)
                    .readValues(new ClassPathResource(file).getInputStream());

            List<PersonDTO> persons = personLines.readAll();

            personService.saveAll(persons);

            return persons.size();
        } catch (IOException e) {
            log.error("CVS loader failed due to: {}", e.getMessage(), e);
            throw new BusinessException("CVS loader failed due to:" + e.getMessage());
        }

    }

}
