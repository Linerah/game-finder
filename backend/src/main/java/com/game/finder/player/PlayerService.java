package com.game.finder.player;

import com.game.finder.registration.token.ConfirmationToken;
import com.game.finder.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service // a class that has to be instantiated, it has to be a Spring Bean
@AllArgsConstructor
public class PlayerService implements UserDetailsService {

    private final static String PLAYER_NOT_FOUND_MSG = "player with email %s not found";
    private final PlayerRepository playerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return playerRepository.findByEmail(email).orElseThrow( () ->
                                new UsernameNotFoundException(String.format(PLAYER_NOT_FOUND_MSG, email)));
    }

    public String singUpPlayer(Player player){
        boolean playerExists = playerRepository.findByEmail(player.getEmail()).isPresent();
        if(playerExists){
            if(!player.getEnabled()){
                String token = UUID.randomUUID().toString();
                ConfirmationToken confirmationToken = new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15), //15 mins, expires
                        player
                );
                confirmationTokenService.saveConfirmationToken(confirmationToken);
                return token;
            }
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(player.getPassword());
        player.setPassword(encodedPassword);

        playerRepository.save(player);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15), //15 mins, expires
                player
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enablePlayer(String email) {
        return playerRepository.enablePlayer(email);
    }
}
