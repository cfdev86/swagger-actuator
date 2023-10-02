package com.cfprac.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //To customize the title with description, define OpenAPI as a bean
    @Bean
    public OpenAPI userAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("User API")
                        .description("This is API can be used to find, add, update and delete a User")
                        .version("v0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("User API Github Repository")
                        .url("https://github.com/cfdev86/swagger-actuator"));
    }

}
