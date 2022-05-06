package com.terasofty.legiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(authorizationKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.terasofty.legiz.api.controllers"))
                .paths(PathSelectors.any())
                .build();

    }
    private ApiKey authorizationKey() {
        return new ApiKey("JSON Web Tokens (JWT)", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("JSON Web Tokens (JWT)", authorizationScopes));
    }
    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Legiz API",
                "API for legal advice",
                "1.0",
                "https://www.alessandro.sh/",
                new Contact("Alessandro", "https://www.alessandro.sh/", "par.214@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
