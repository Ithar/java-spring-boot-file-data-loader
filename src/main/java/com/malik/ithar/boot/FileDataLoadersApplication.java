package com.malik.ithar.boot;

import com.malik.ithar.loader.CommaDelimitedDataLoader;
import com.malik.ithar.loader.TabDelimitedDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileDataLoadersApplication implements ApplicationRunner {

    private final CommaDelimitedDataLoader cvsLoader;
    private final TabDelimitedDataLoader tabLoader;

    @Autowired
    public FileDataLoadersApplication(
            CommaDelimitedDataLoader cvsLoader,
            TabDelimitedDataLoader tabLoader) {
        this.cvsLoader = cvsLoader;
        this.tabLoader = tabLoader;
    }

    @Override
    public void run(ApplicationArguments args) {

        try {
            cvsLoader.load();
            tabLoader.load();
        } catch (Exception e) {
            log.error("Failed to load files due to:{}", e.getMessage(), e);
        }
    }
}
