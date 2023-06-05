# **This service is _Deprecated_ as all Flyway Migration Scripts are moved under the related services.**
** Do not make any development for this service !!!**

# DB Migration Manager Service
A DB Migration Manager Service within the Community Workspace for Small Communities with Spring Boot 2.6.6, JDK 17, Gradle & Flyway Migration.
 
Service boots from 8071 port & Actuator Management is served from 8072 port.

## Table of Contents

1. [How to Contribute](#how-to-contribute)
2. [Credits](#credits)
3. [Requirements](#requirements)
4. [Coding Standards](#coding-standards)
5. [Version Control Standards](#version-control-standards)
6. [Running the Application Locally](#running-the-application-locally)
7. [Running the Application in Docker](#running-the-application-in-docker)
8. [Run Actuator](#run-actuator)
9. [Extra Notes](#extra-notes)
10. [Copyright](#copyright)

## How to Contribute

For the contributor covenant to this project, please check the Code of Conduct file.

[![Contributor Covenant][contributor-covenant-badge]](CODE_OF_CONDUCT.md)

## Credits

Below you can find the names of the contributors to this project;

- [Evren Tan][evren-tan-github]

## Requirements

For building and running the application belows are required;

- [Spring Boot 3.0.0][spring-boot-version]
- [JDK 17][java-version]
- [Gradle 7.6 or above][gradle-version]
- [Flyway Migration][flyway-migration]
- Eureka Client
- Spring Cloud Config Server
- Spring Boot Actuator

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Version control standards should be followed within the project according to the [main README][main-readme-file-location] file.

## Running the application locally

Application can be run with [DBMigrationManagerApplication][db-migration-manager-main-class] class.

Alternatively you can use the [Spring Boot Gradle plugin][spring-boot-gradle-plugin] like so:

```shell
gradle clean build
gradle bootRun
```

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
gradle build
docker build -t db-migration-manager:1.0.0 .
docker run -p 8071:8071 --name CommunityDBMigrationManagerService db-migration-manager:1.0.0
```

## Run Actuator

[Spring Boot Actuator][spring-boot-actuator] can be reached from [local url for Actuator][local-actuator].

Only health and caches endpoints are enabled by default. Configuration can be updated within the "actuator" section of the related application.properties file.

## Extra Notes

* The module can be booted with Spring Cloud Config Server or directly within the application. In order to boot the project within itself, enable the properties in application.properties file and disable bootstrap.properties file.

## Copyright

GNU General Public License v3.0
Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.
Please check the [LICENSE](LICENSE) file for more details.

[evren-tan-github]: https://github.com/evrentan
[spring-boot-version]: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes
[java-version]: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
[gradle-version]: https://gradle.org/releases/
[flyway-migration]: https://flywaydb.org/documentation/
[contributor-covenant-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[community-workspace-github]: https://github.com/evrentan/community-workspace
[db-migration-manager-main-class]: src/main/java/evrentan/community/dbmigrationmanager/spring/spring/DbMigrationManagerApplication.java
[spring-boot-gradle-plugin]: https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:8082/actuator
[main-readme-file-location]: https://github.com/evrentan/community-workspace/blob/staging/README.md