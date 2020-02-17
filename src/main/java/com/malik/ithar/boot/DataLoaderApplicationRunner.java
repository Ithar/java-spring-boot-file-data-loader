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

    private final boolean loadOnStartup;
    private final String commaFile;
    private final String tabFile;
    private final DataLoader dataLoader;

    @Autowired
    public DataLoaderApplicationRunner(
            @Value("#{new Boolean('${data-load.load-on-start-up:true}')}") boolean loadOnStartup,
            @Value("${data-load.persons-cvs-file:sample_v1.csv}") String commaFile,
            @Value("${data-load.persons-tvs-file:sample_v2.tsv}") String tabFile,
            DataLoader dataLoader) {
        this.loadOnStartup = loadOnStartup;
        this.commaFile = commaFile;
        this.tabFile = tabFile;
        this.dataLoader = dataLoader;
    }

    @Override
    public void run(ApplicationArguments args) {

        log.info("Application runner load data files on start-up:{}", loadOnStartup);

        if (loadOnStartup) {
            try {
                dataLoader.load(commaFile, ',');
                dataLoader.load(tabFile, '\t');
            } catch (Exception e) {
                log.error("Failed to load files due to:{}", e.getMessage(), e);
            }
        }
    }
}
