
# prototype-a

## Overview

Example app for trying out new Spring Boot features.

# Prerequisites

## PostreSQL setup

Install https://www.postgresql.org

Default setup expects PostgreSQL to be running on localhost:5432 - see: `src/main/resources/application-dev.properties`

```
CREATE ROLE qermit_prototype_a_admin LOGIN PASSWORD 'admin';
CREATE ROLE qermit_prototype_a_application LOGIN PASSWORD 'application';
CREATE DATABASE qermit_prototype_a WITH OWNER 'qermit_prototype_a_admin' ENCODING 'UTF8'; 
```

# Running

## IntelliJ IDEA

Create a Spring Boot runner, then 'Edit Configurations...' and set the Active Profile to 'dev'.

Spring will then pick up the application-dev.properties 

# Notable Libraries

* Flyway Migrations - Separate credentials/datasource for schema changes by configuring spring.flyway.*
  
* git-commit-id-plugin - git.properties Maven filtered into banner.txt
