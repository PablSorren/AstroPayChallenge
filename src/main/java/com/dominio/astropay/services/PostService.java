package com.dominio.astropay.services;

import com.dominio.astropay.domain.Post;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostService {

  void persistPosts();

  List<Post> getPosts();

  Post getPostById(Long id);

  List<Post> getPostsWithWordInTitle(String word);
}
