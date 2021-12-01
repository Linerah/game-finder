package com.game.finder.post;

import com.game.finder.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.findAllPosts();
    }

    @PostMapping("post")
    public String register(@RequestBody PostRequest request) {
        return postService.addPost(request);
    }


}
