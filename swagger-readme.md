Spring Doc library is a powerful tool which automates the generation of API documentation. 
Without writing any comments or documentation, Spring Doc library is able to generate API doc by examining an application at runtime.

It automatically generates documentation in JSON/YAML and HTML format APIs. This documentation can be completed by comments 
using swagger-api annotations.

It simplifies the generation and maintenance of API docs based on the OpenAPI 3 specification for Spring Boot 3.x applications.

This library supports:

1.OpenAPI 3 (it is a specification for documenting APIs)
2.Spring-boot v3 (Java 17 & Jakarta EE 9)
3.JSR-303, specifically for @NotNull, @Min, @Max, and @Size.
4.Swagger-ui (provides a visually appealing ui to interact with your APIs)
5.OAuth 2
6.GraalVM native images


After setting up the dependency correctly, we can run our application and find the OpenAPI descriptions at /v3/api-docs, which is the default path.

The OpenAPI definitions are in JSON format by default. For yaml format, we can obtain the definitions at: http://localhost:8080/api-docs.yaml

Besides generating the OpenAPI 3 specification, we can integrate springdoc-openapi with Swagger UI to interact with our API specification and 
exercise the endpoints. The springdoc-openapi dependency already includes Swagger UI, so we’re all set to access the API documentation 
at: http://localhost:8080/swagger-ui/index.html


The springdoc-openapi library also supports swagger-ui properties. These can be used as Spring Boot properties with the prefix springdoc.swagger-ui.