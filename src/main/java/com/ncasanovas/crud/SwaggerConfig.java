package com.ncasanovas.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ncasanovas.crud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());

    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Crud Api",
                "Open Api Confluencia FTO",
                "1.0",
                "",
                new Contact("Name", "url", "email"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}
