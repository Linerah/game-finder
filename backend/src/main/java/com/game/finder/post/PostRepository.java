package com.game.finder.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository  extends JpaRepository<Post, Long> {
   
    Optional<Post> findByOwnerEmail(String email);
    
    
}
