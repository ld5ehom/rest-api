package com.ld5ehom.restapi.global;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Swagger/OpenAPI configuration class.
// Provides API metadata for Swagger UI and OpenAPI specification.
// Swagger/OpenAPI 설정 클래스.
// Swagger UI 및 OpenAPI 명세에 표시될 API 메타데이터를 제공한다.
@Configuration
public class SwaggerConfig {

    // Configure OpenAPI bean with metadata.
    // OpenAPI 빈을 메타데이터와 함께 설정하는 메소드.
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    // Define API information (title, description, version).
    // API 정보(제목, 설명, 버전)를 정의하는 메소드.
    private Info apiInfo() {
        return new Info()
                .title("Online Bookstore REST API Demo")
                .description("Swagger UI test for Online Bookstore REST API Demo")
                .version("1.0.0");
    }
}
