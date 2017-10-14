
# prototype-a

## Overview

Example app for trying out new Spring Boot features.

## Notable Libraries

* HikariCP database connection pool - configured using regular Spring Boot datasource properties

* Flyway Migrations - Y can use separate credentials for DDL/schema changes by using the spring.flyway.* properties (separate datasource)
  
* git-commit-id-plugin - Branch, commit ID and version baked into application properties and logged by banner.txt
