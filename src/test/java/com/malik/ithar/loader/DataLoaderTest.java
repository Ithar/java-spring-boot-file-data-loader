package com.malik.ithar.loader;

import com.malik.ithar.exception.BusinessException;
import com.malik.ithar.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DataLoaderTest {

    private final static String TEST_FILE_CSV = "sample_v1_test.csv";
    private final static String TEST_FILE_TSV = "sample_v2_test.tsv";

    @Mock
    private PersonService personService;

    private DataLoader loader;

    @BeforeEach
    void initLoader() {
        loader = new DataLoader(personService);
    }

    @Test
    void load_CSV() throws BusinessException {

        // Given
        char separator = ',';

        // When
        int actual = loader.load(TEST_FILE_CSV, separator);

        // Then
        assertEquals(2,  actual);

    }

    @Test
    void load_TSV() throws BusinessException {

        // Given
        char separator = '\t';

        // When
        int actual = loader.load(TEST_FILE_TSV, separator);

        // Then
        assertEquals(3,  actual);

    }
}