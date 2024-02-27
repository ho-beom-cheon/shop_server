package com.hobeom.shop.shop_server.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Shop server API 명세서",
                version = "1.0.0",
                description = "Shop server api 테스트"
        )
)
@Configuration
public class SwaagerConfig {
//    @Bean
//    public OpenAPI openAPI() {
//        return new OpenAPI()
//                .components(new Components())
//                .info(apiInfo());
//    }
//
//    private Info apiInfo() {
//        return new Info()
//                .title("Springdoc 테스트")
//                .description("Springdoc을 사용한 Swagger UI 테스트")
//                .version("1.0.0");
//    }
}