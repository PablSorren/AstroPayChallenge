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

  @GetMapping(value="/{postId}")
  public Post getPostById(@PathVariable("postId") Long id) {
    return postService.getPostById(id);
  }

  @GetMapping(value="/title", params = "word")
  public List<Post> getPostsWithWordInTitle(@RequestParam String word) {
    return postService.getPostsWithWordInTitle(word);
  }

  @GetMapping(value = "", params = {"pageNumber", "pageSize"})
  public List<Post> getPaginatedPosts(int pageNumber, int pageSize) {
    return postService.getPaginatedPosts(pageNumber, pageSize);
  }

  @GetMapping(value="")
  public List<Post> getPosts() {
    return postService.getPosts();
  }

}
