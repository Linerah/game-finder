package com.game.finder.post;

import com.game.finder.player.Player;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table
public class Post implements Serializable {

    @SequenceGenerator(
            name= "form_sequence",
            sequenceName = "form_sequence",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "form_sequence"
    )
    private Long id;
    private String ownerEmail;
    private String title;
    private String post;
    private String type;


    public Post(String email, String title, String post, String type) {
        this.ownerEmail = email;
        this.title = title;
        this.post = post;
        this.type = type;
    }
}
