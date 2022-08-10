package com.stage.catalogue;

import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.service.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class CatalogueApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(CatalogueApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UtilisateurService utilisateurService) {
        return a -> {
            if (utilisateurService.getAll().isEmpty()) {
                utilisateurService.addUtilisateur(new Utilisateur(null, "admin", "admin123", Role.ADMIN, "Admin", "admin@example.com", true, false));
                utilisateurService.addUtilisateur(new Utilisateur(null, "user", "admin123", Role.USER, "User", "user@example.com", true, false));
            }
        };
    }

}
