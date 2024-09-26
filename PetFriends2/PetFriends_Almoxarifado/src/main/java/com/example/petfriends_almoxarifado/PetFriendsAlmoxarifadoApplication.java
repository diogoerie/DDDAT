package com.example.petfriends_almoxarifado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.petfriends_almoxarifado.repository")
public class PetFriendsAlmoxarifadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetFriendsAlmoxarifadoApplication.class, args);
    }

}
