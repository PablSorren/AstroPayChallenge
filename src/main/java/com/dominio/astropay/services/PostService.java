package com.dominio.astropay.services;

import com.dominio.astropay.api.ApiConsumer;
import com.dominio.astropay.domain.Post;

import java.util.List;

public interface PostService {

  List<Post> persistPosts(ApiConsumer apiConsumer);

  List<Post> getPosts();

  Post getPostById(Long id);

  List<Post> getPostsWithWordInTitle(String word);

  List<Post> getPaginatedPosts(int pageNumber, int pageSize);
}
