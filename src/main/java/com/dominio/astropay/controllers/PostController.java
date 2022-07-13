package com.dominio.astropay.controllers;

import com.dominio.astropay.domain.Post;
import com.dominio.astropay.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping(value="")
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @GetMapping(value="/{postId}")
  public Post getUserById(@PathVariable("postId") Long id) {
    return postService.getPostById(id);
  }

  @GetMapping(value="/title")
  public List<Post> defaultTitleAnswer() {
    return this.getPosts();
  }

  @GetMapping(value="/title", params = "word")
  public List<Post> getPostsWithWordInTitle(@RequestParam String word) {
    return postService.getPostsWithWordInTitle(word);
  }

}
