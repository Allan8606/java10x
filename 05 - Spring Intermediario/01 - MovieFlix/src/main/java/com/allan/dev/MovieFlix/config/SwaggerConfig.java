package com.allan.dev.MovieFlix.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){

        Contact contact = new Contact();
        contact.name("Allan Isaac");
        contact.email("allanisaac.dev@gmail.com");
        contact.setUrl("https://github.com/Allan8606/java10x/tree/main/05%20-%20Spring%20Intermediario/MovieFlix");

        Info info = new Info();
        info.title("MovieFlix");
        info.version("v1");
        info.description("Aplicação para gerenciamento de catalago de filmes e series");
        info.contact(contact);

        return new OpenAPI().info(info);

    }
}
