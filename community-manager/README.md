# Community Manager Service
A Community Manager Service within the Community Workspace for Small Communities with Spring Boot 3.0.0, JDK 17 & Gradle.
 
Service boots from 8081 port & Actuator Management is served from 8081 port with /actuator base path.

## Table of Contents

1. [How to Contribute](#how-to-contribute)
2. [Credits](#credits)
3. [Requirements](#requirements)
4. [Coding Standards](#coding-standards)
5. [Version Control Standards](#version-control-standards)
6. [Database](#database)
7. [Running the Application Locally](#running-the-application-locally)
8. [Running the Application in Docker](#running-the-application-in-docker)
9. [Run Actuator](#run-actuator)
10. [Extra Notes](#extra-notes)
11. [Copyright](#copyright)

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
- Eureka Client
- Spring Cloud Config Server
- Spring Boot Actuator

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Version control standards should be followed within the project according to the [main README][main-readme-file-location] file.

## Database

Please check the [Create DB and Schema Scripts][create-db-and-schema-scripts] file. After creating the DB & schema, all DDLs & DMLs will be executed with Flyway DB Migration functionality. 

So, these DDLs & DMLs should be stored within [Flyway DB Migration Resource folder][flyway-db-migration-resource-folder].

## Running the application locally

Application can be run with [CommunityManagerApplication][community-manager-main-class] class.

Alternatively you can use the [Spring Boot Gradle plugin][spring-boot-gradle-plugin] like so:

```shell
gradle clean build
gradle bootRun
```

Local & development configuration properties are stored under [Community Manager Configuration Properties][community-manager-configuration-properties]. For example, you can update your database information from the related file.

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
gradle build
docker build -t community-manager:1.0.0 .
docker run -p 8081:8081 --name CommunityCommunityManagerService community-manager:1.0.0
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
[contributor-covenant-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[community-workspace-github]: https://github.com/evrentan/community-workspace
[community-manager-main-class]: src/main/java/evrentan/community/communitymanager/spring/spring/CommunityManagerApplication.java
[spring-boot-gradle-plugin]: https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:8081/actuator
[main-readme-file-location]: https://github.com/evrentan/community-workspace/blob/staging/README.md
[community-manager-configuration-properties]: ../config-server-data/community-manager
[create-db-and-schema-scripts]: CREATE_DB_AND_SCHEMA_SCRIPTS.md
[flyway-db-migration-resource-folder]: src/main/resources/db/migration