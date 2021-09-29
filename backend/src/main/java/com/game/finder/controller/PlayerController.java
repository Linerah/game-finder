package com.game.finder.controller;

import com.game.finder.domain.Player;
import com.game.finder.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//added this to handle Rest API request
@RestController
@RequestMapping(path = "api/v1/player") // to access it go to localhost:8080/api/v1/player
public class PlayerController {

    private final PlayerService playerService;

    @Autowired //Gets instantiated aka. Dependency Injection
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // REST EndPoint
    // for the method to be a REST endpoint, it has to have an annotation. (Get or Set Mapping)
    // If the Method sends a List, it automatically gets changed to a JSON file ;)
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> registerNewPlayer(@RequestBody Player player){
        playerService.addNewPlayer(player);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/delete/{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long playerId){
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path = "/update/{playerId}")
    public ResponseEntity<?> updatePlayer(@PathVariable("playerId") Long playerId,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) String name){
        playerService.updatePlayer(playerId, email, name);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
