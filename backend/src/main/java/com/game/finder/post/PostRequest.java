package com.game.finder.post;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PostRequest {
    private String ownerEmail;
    private String title;
    private String post;
    private String type;
}
