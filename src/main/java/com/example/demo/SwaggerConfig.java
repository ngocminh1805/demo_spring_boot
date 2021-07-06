package com.example.demo;

import java.util.function.Predicate;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
                .paths(postPaths()).build();

    }

    private Predicate<String> postPaths() {
        return null;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("JavaInUse API").description("JavaInUse API reference for developers")
                .termsOfServiceUrl("localhost:8080").license("JavaInUse License").licenseUrl("ngocminhmtp123@gmail.com")
                .version("1.0").build();
    }

}
