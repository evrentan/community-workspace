# Community Workspace For Small  Communities
A Community Workspace Project for Small Communities with Spring Boot 2.6.6, JDK 17 & Gradle.

Services are developed in the following modules:
* **Community Manager** - Community Manager Service in order to manage community related functionalities.
* **Service Discovery** - Service Discovery Service in order to discover other services.
* **User Manager** - User Manager Service in order to manage user related functionalities.
* **DB Migration Manager** - DB Migration Manager Service in order to manage DB migrations.

## Table of Contents

1. [How to Contribute](#how-to-contribute)
2. [Requirements](#requirements)
3. [Copyright](#copyright)

## How to Contribute

For the contributor covenant to this project, please check the Code of Conduct file.

[![Contributor Covenant][contributor]](CODE_OF_CONDUCT.md)

## Requirements

For building and running the application belows are required;

- [Spring Boot 2.6.6][spring-boot-version]
- [JDK 17][java-version]
- [Gradle 7.3 or above][gradle-version]
- [PostgreSQL][postgresql-version]
- [Flyway Migration][flyway-migration]
- Eureka Client
- Spring Cloud Config Server
- Spring Boot Actuator

## Copyright

GNU General Public License v3.0
Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.
Please check the [LICENSE](LICENSE) file for more details.

[spring-boot-version]: https://spring.io/blog/2022/03/31/spring-boot-2-6-6-available-now
[java-version]: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
[gradle-version]: https://gradle.org/releases/
[postgresql-version]: https://www.postgresql.org/
[flyway-migration]: https://flywaydb.org/documentation/
[contributor]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg