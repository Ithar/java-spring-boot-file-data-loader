package com.malik.ithar.boot;

import com.malik.ithar.loader.DataLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoaderApplicationRunner implements ApplicationRunner {

    private final String commaFile;
    private final String tabFile;
    private final DataLoader dataLoader;

    @Autowired
    public DataLoaderApplicationRunner(
            @Value("${data-load-files.persons-cvs-file:sample_v1.csv}") String commaFile,
            @Value("${data-load-files.persons-tvs-file:sample_v2.tsv}") String tabFile,
            DataLoader dataLoader) {
        this.commaFile = commaFile;
        this.tabFile = tabFile;
        this.dataLoader = dataLoader;
    }

    @Override
    public void run(ApplicationArguments args) {

        try {
            dataLoader.load(commaFile,',');
            dataLoader.load(tabFile,'\t');
        } catch (Exception e) {
            log.error("Failed to load files due to:{}", e.getMessage(), e);
        }
    }
}
