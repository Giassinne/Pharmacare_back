package com.demo.uMed;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permet à toutes les routes de gérer CORS
                .allowedOrigins("https://pharama-care.vercel.app/") // Autorise les demandes depuis le frontend (localhost:3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Autorise les méthodes HTTP
                .allowedHeaders("*"); // Autorise tous les en-têtes
    }
}
