# Service Discovery
Service Discovery is an application working as a service discovery within the Community Workspace microservice architecture based modules.

Service Discovery module runs on 6969 port and can be reached from the link: http://localhost:6969/

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

- [Spring Boot 3.2.1][spring-boot-version]
- [JDK 21][java-version]
- [Gradle 8.5 or above][gradle-version]
- Eureka Server
- Spring Cloud Config Server
- Spring Boot Actuator

## Coding Standards

Below coding standards should be followed within the project;

- Javadoc should be written for each class & method. @author, @since annotations should be added while adding or updating the javadoc
- General code structure should be followed while adding or refactoring classes.

## Version Control Standards

Version control standards should be followed within the project according to the [main README][main-readme-file-location] file.

## Running the Application Locally

Application can be run with [ServiceDiscoveryApplication][service-discovery-main-class] class.

Alternatively you can use the [Spring Boot Gradle plugin][spring-boot-gradle-plugin] like so:

```shell
gradle clean build
gradle bootRun
```

Local & development configuration properties are stored under [Service Discovery Configuration Properties][service-discovery-configuration-properties]. For example, you can update your discovery server information from the related file.

## Running the Application in Docker

Application can be run in Docker. [Dockerfile](Dockerfile) in the project root folder is the configuration file for Docker build.

```shell
gradle build
docker build -t service-discovery:1.0.0 .
docker run -p 6969:6969 --name CommunityServiceDiscoveryService service-discovery:1.0.0
```

## Run Actuator

[Spring Boot Actuator][spring-boot-actuator] can be reached from [local url for Actuator][local-actuator].

Only health and caches endpoints are enabled by default. Configuration can be updated within the "actuator" section of the related application.properties file. 

## Extra Notes

* The module can be booted with Spring Cloud Config Server or directly within the application. In order to boot the project within itself, enable the properties in application.properties file and disable bootstrap.properties file.

## Copyright

GNU General Public License v3.0
Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.

[evren-tan-github]: https://github.com/evrentan
[spring-boot-version]: https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes
[java-version]: https://www.oracle.com/tr/java/technologies/downloads/
[gradle-version]: https://gradle.org/releases/
[contributor-covenant-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[community-workspace-github]: https://github.com/evrentan/community-workspace
[service-discovery-main-class]: src/main/java/evrentan/community/servicediscovery/spring/spring/ServiceDiscoveryApplication.java
[spring-boot-gradle-plugin]: https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
[spring-boot-actuator]: https://spring.io/guides/gs/actuator-service/
[local-actuator]: http://localhost:6970/actuator
[main-readme-file-location]: https://github.com/evrentan/community-workspace/blob/staging/README.md
[service-discovery-configuration-properties]: ../config-server-data/service-discovery