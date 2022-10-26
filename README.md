# Getting Started

The tech stack for this POC is:
* Spring Boot 2.3.4
* Java 15
* Apache CXF 3.4
* REST Assured 4.3

## Software requirements
Workstation must be properly configured with next tools:
* Java 15 JDK - https://jdk.java.net/15/
* Maven - https://maven.apache.org/download.cgi

**Optional tools**
* Docker - https://www.docker.com/products/docker-desktop
* Docker hub account with token access enabled

## Installation

Make sure your computer is properly configured with the tools described in the requirements section.

In order to run the project type in root folder:
```bash
mvn spring-boot:run
```

You will see in the log console:
```windows
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.4.RELEASE)

## Usage
To get the available endpoints, write in the browser:
```html
http://localhost:8081/soap
```
To get the wsdl of the service, write in the browser:
```html
http://localhost:8081/soap/service/person?wsdl
```


We can test the application using an Http Client like PostMan or Jmeter using a POST call (the application uses for the test cases RestAssured library). But I am going to use the traditional SoapUI, the endpoint for the service is: `http://localhost:8081/soap/service/person`
