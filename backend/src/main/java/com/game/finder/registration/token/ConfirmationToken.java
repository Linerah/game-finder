package com.game.finder.registration.token;

import com.game.finder.player.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name= "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    //Because a player can have many confirmation tokens.
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "player_id"
    )
    private Player player;

    public ConfirmationToken(String token, LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Player player) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.player = player;
    }
}
