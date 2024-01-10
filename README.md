# JobForgeWebService #

How to start the JobForgeWebService application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/JobForge-API-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

How to test the JobForgeWebService application
---
`mvn test`

How to run the linter on the JobForgeWebService application
---
`mvn checkstyle:check`

---
ENV Variables
--- 
To use JobForgeWebService application you will need to have the following environment variables

| Environment Variable         | Description                                      |
|------------------------------|--------------------------------------------------|
| DB_USERNAME                  | Database Account Password                        |
| DB_PASSWORD                  | Database Account Password                        |
| DB_HOST                      | Database Hostname                                |
| DB_NAME                      | Database Schema Name                             |

#### How to add ENV Variables

```shell
  export DB_USERNAME=<Add DB Username Here>  
  export DB_PASSWORD=<Add DB Password Here>  
  export DB_HOST=<Add DB Hostname Here>  
  export DB_NAME=<Add DB Schema Name Here>  
 
``` 
