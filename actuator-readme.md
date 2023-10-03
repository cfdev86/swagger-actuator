The spring-boot-actuator module provides all of Spring Boot’s production-ready features. The recommended way to enable the features is to 
add the dependency - spring-boot-starter-actuator.

Actuator endpoints let you monitor and interact with your application. Spring Boot includes a number of built-in endpoints and lets you add 
your own. For example, the health endpoint provides basic application health information.

You can enable or disable each individual endpoint and expose them (make them remotely accessible) over HTTP or JMX. An endpoint is considered 
to be available when it is both enabled and exposed. The built-in endpoints are auto-configured only when they are available. Most applications 
choose exposure over HTTP, where the ID of the endpoint and a prefix of /actuator is mapped to a URL. For example, by default, the health 
endpoint is mapped to /actuator/health.

Important endpoints
1. env - Exposes properties from Spring’s ConfigurableEnvironment.
2. health - Shows application health information.
3. info - Displays arbitrary application info
4. liquibase - Shows any Liquibase database migrations that have been applied. Requires one or more Liquibase beans.
5. flyway - Shows any Flyway database migrations that have been applied. Requires one or more Flyway beans.
6. metrics - Shows “metrics” information for the current application.
7. scheduledtasks - Displays the scheduled tasks in your application.
8. shutdown - Lets the application be gracefully shutdown. Only works when using jar packaging. Disabled by default.
9. startup - Shows the startup steps data collected by the ApplicationStartup. Requires the SpringApplication to be configured with a BufferingApplicationStartup.
10. loggers - Shows and modifies the configuration of loggers in the application.
11. caches - Exposes available caches.
12. beans - Displays a complete list of all the Spring beans in your application.

By default, all endpoints except for shutdown are enabled. To configure the enablement of an endpoint, use its management.endpoint.<id>.enabled property. 
The following example enables the shutdown endpoint:

management.endpoint.shutdown.enabled=true

By default, only the health endpoint is exposed over HTTP and JMX. Since Endpoints may contain sensitive information, you should carefully consider when
to expose them.

management.endpoints.jmx.exposure.include=health,info
