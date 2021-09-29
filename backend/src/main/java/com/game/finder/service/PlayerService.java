package com.game.finder.service;

import com.game.finder.domain.Player;
import com.game.finder.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // a class that has to be instantiated, it has to be a Spring Bean
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Currently, is a static list, but we want it to come from a Database.
    public List<Player> getPlayers(){
        return playerRepository.findAll(); //magic of Spring Data JPA
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository
                .findPlayerByEmail(player.getEmail());
        // we could validate the email here
        // add code later
        if(playerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
         if(!exists) {
            throw new
                    IllegalStateException("player with id " + playerId + "does not exists" );
         };
         playerRepository.deleteById(playerId);
    }

    // this annotation lets you change values of an entity using get and set, without needing queries.
    // The entity goes to a manage state.
    @Transactional
    public void updatePlayer(Long playerId, String email, String name){
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new
                    IllegalStateException("player with id " + playerId + "does not exists" );
        };
        Player player = playerRepository.getById(playerId);
        if(name != null && name.length() > 0 && !Objects.equals(name, player.getName())){
            player.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(name, player.getEmail())){
            Optional<Player> playerOptional = playerRepository.findPlayerByEmail(email);
            if(playerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            player.setEmail(email);
        }
    }
}
