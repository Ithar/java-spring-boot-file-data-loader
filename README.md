[![CircleCI](https://circleci.com/gh/Ithar/java-spring-boot-file-data-loader/tree/master.svg?style=svg)](https://circleci.com/gh/Ithar/java-spring-boot-file-data-loader/tree/master)

[![codecov](https://codecov.io/gh/Ithar/java-spring-boot-file-data-loader/branch/master/graph/badge.svg)](https://codecov.io/gh/Ithar/java-spring-boot-file-data-loader)

# java-spring-boot-file-data-loaders
Project loads cvs and tsv files, uses Map Struct to covert to entities  

#### Features 
- Jackson CsvMapper Data Formatter
- MapStruct
- Integrations Tests 

## 

## Application Stack

Stack  | version |
--- | --- |  
*Java* | 1.8
*SpringBoot* |  2.2.4.RELEASE
*Frontend* | n/a 
*DB* | h2-database (in memory)
*Server* | Tomcat (embedded)
*Build Tool* | Maven
*CI* | CircleCI 2.1 
*Code Coverage* | Codecov

## Application Run
Spring Boot Main:
 
`com.malik.ithar.Application`
  
## Application URL
http://localhost:8080/
 

## Application GIT branches
- master

## Application profile
-Dspring.profiles.active=unit-tests
-Dspring.profiles.active=integration-tests

## Further enhancements 
