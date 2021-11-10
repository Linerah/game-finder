package com.game.finder.post;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    List<Post> findAllPosts(){
        return postRepository.findAll();
    }

    public String addPost(PostRequest request){
        postRepository.save(
                new Post(
                        request.getOwnerEmail(),
                        request.getTitle(),
                        request.getPost(),
                        request.getType()
                )
        );
        return "Post was added!";
    }

}
