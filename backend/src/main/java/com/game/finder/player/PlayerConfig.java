package com.game.finder.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository){
        return args ->{
            Player kevin = new Player(
                    "Kevin",
                    "kevinlinera",
                    "kevin.linera@upr.edu",
                    LocalDate.of(1999, 12, 22)
            );

            Player john = new Player(
                    "John",
                    "john123",
                    "john@upr.edu",
                    LocalDate.of(1992, 10, 2)
            );

            repository.saveAll(
                    List.of(kevin, john)
            );
        };
    }
}
