countriesAPI is a project that showcases the integration of gradle,
spring boot and jaxb for producing SOAP web services.

# Requirements
Java 8
Gradle 4.1

# How to (Configure project)
Configure like a traditional Gradle project, take care of using Gradle 4.1 for development.

# Building
- Run with gradle task: build

# Running
- Run with java -jar build/libs/countries-api-0.1.0.jar (requires previous building step)
- Run with gradle task: bootRun (in dev, requires gradle 4.1 in PATH)

After issuing one of previous run commands, the SOAP server will be available
on http://localhost:8080/countriesapi
The WSDL will be available through: http://localhost:8080/ws/countries.wsdl

# Known issues
If the IDE you're using shows an error because it can't resolve the reference to the
WSDL classes(i.e. mx.grailscoder.countriesapi.Country) it will suffice to issue
`build` gradle task.